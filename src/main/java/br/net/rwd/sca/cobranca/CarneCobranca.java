/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.cobranca;

import br.net.rwd.sca.dao.CarneDAO;
import br.net.rwd.sca.dao.CedenteDAO;
import br.net.rwd.sca.entidades.Carne;
import br.net.rwd.sca.entidades.CedenteCobranca;
import br.net.rwd.sca.entidades.Mensalidade;
import br.net.rwd.sca.util.Uteis;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.pdf.Files;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.Banco;
import org.jrimum.domkee.financeiro.banco.ParametrosBancariosMap;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.SacadorAvalista;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeCobranca;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;

/**
 *
 * @author Administrador
 */
public class CarneCobranca {

    private Carne carne;
    private Mensalidade mensalidadeBoleto;
    private List<Mensalidade> mensalidades;
    private final CarneDAO dao = new CarneDAO();
    private final CedenteDAO daoCedente = new CedenteDAO();

    public CarneCobranca() {
    }

    public CarneCobranca(Carne carne) {
        this.carne = carne;
    }

    public CarneCobranca(Mensalidade mensalidadeBoleto) {
        this.mensalidadeBoleto = mensalidadeBoleto;
    }
    
    public List<Boleto> bloquetos() {
        //dados do cedente
        CedenteCobranca cedenteCobranca = daoCedente.selecionaCedente();
        Cedente cedente = new Cedente(cedenteCobranca.getCeden_nome(), cedenteCobranca.getCeden_cpfcnpj());
        
        //dados do sacado
        Sacado sacado = new Sacado(carne.getContrato().getLocatario().getNome(), carne.getContrato().getLocatario().getCpf());
        Endereco enderecoSac = new Endereco();
        enderecoSac.setUF(UnidadeFederativa.valueOf(carne.getContrato().getLocatario().getUf()));
        enderecoSac.setLocalidade(carne.getContrato().getLocatario().getCidade());
        enderecoSac.setCep(carne.getContrato().getLocatario().getCep());
        enderecoSac.setBairro(carne.getContrato().getLocatario().getBairro());
        enderecoSac.setLogradouro(carne.getContrato().getLocatario().getEndereco());
        enderecoSac.setNumero(carne.getContrato().getLocatario().getNumEndereco());
        sacado.addEndereco(enderecoSac);

        //dados sacador avalista
        //SacadorAvalista sacadorAvalista = new SacadorAvalista(carne.getContrato().getLocador().getNome(), carne.getContrato().getLocador().getCpf());
        //Endereco enderecoSacAval = new Endereco();
        //enderecoSacAval.setUF(UnidadeFederativa.valueOf(carne.getContrato().getLocador().getUf()));
        //enderecoSacAval.setLocalidade(carne.getContrato().getLocador().getCidade());
        //enderecoSacAval.setCep(carne.getContrato().getLocador().getCep());
        //enderecoSacAval.setBairro(carne.getContrato().getLocador().getBairro());
        //enderecoSacAval.setLogradouro(carne.getContrato().getLocador().getEndereco());
        //enderecoSacAval.setNumero(carne.getContrato().getLocador().getNumEndereco());
        //sacadorAvalista.addEndereco(enderecoSacAval);

        //dados do titulo.
        String conta = String.format("%06d", Integer.valueOf(cedenteCobranca.getCeden_conta()));
        String dvConta = String.valueOf(CampoLivreCefSIGCB.calculeDVModulo11(conta));     
        
        Banco banco = BancosSuportados.CAIXA_ECONOMICA_FEDERAL.create();
        ContaBancaria contaBancaria = new ContaBancaria(banco);
        contaBancaria.setBanco(banco);
        contaBancaria.setAgencia(new Agencia(Integer.valueOf(cedenteCobranca.getCeden_agencia())));
        contaBancaria.setNumeroDaConta(new NumeroDaConta(Integer.valueOf(conta), dvConta));
        contaBancaria.setCarteira(new Carteira(Integer.valueOf(cedenteCobranca.getCeden_modalidade()), TipoDeCobranca.SEM_REGISTRO));
        //contaBancaria.setModalidade(new Modalidade(Integer.valueOf(cedenteCobranca.getCeden_modalidade())));
        
        List<Boleto> boletos = new ArrayList<Boleto>();
        mensalidades = dao.selecionaMensalidade(carne.getCodigo());
        
        Calendar calendar = Calendar.getInstance();
        int nossoNumero = Integer.valueOf(cedenteCobranca.getCeden_nossonumero());

        for (Mensalidade mensalidade : mensalidades) {
        nossoNumero = nossoNumero + 1;
        calendar.setTime(mensalidade.getVencimento());
        calendar.add(Calendar.DAY_OF_MONTH, -cedenteCobranca.getCeden_descontos_dia());

        Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
        titulo.setNumeroDoDocumento(Uteis.retornaNumeros(String.format("%06d", mensalidade.getCodigo())));
        titulo.setNossoNumero(contaBancaria.getCarteira().getCodigo().toString().concat(cedenteCobranca.getCeden_emissao_bloq()).concat(String.format("%015d", nossoNumero)));
        titulo.setDigitoDoNossoNumero(String.valueOf(CampoLivreCefSIGCB.calculeDVModulo11(String.valueOf(titulo.getNossoNumero()))));
        titulo.setValor(BigDecimal.valueOf(mensalidade.getValor()));
        titulo.setDataDoDocumento(new Date());
        titulo.setDataDoVencimento(mensalidade.getVencimento());
        //titulo.setAceite(Aceite.N);
        //titulo.setTipoDeDocumento(TipoDeTitulo.OUTROS);
        //titulo.setTipoDeMoeda(TipoDeMoeda.REAL);
        //titulo.setDesconto(new BigDecimal(0));
        //titulo.setDeducao(new BigDecimal(0));
        //titulo.setMora(new BigDecimal(0));
        //titulo.setAcrecimo(new BigDecimal(0));
        //titulo.setValorCobrado(new BigDecimal(0));
        titulo.setParametrosBancarios(new ParametrosBancariosMap("CodigoOperacao", new Integer(cedenteCobranca.getCeden_operacao())));

        CampoLivreCefSIGCB campoLivreCefSIGCB = new CampoLivreCefSIGCB(conta, dvConta, titulo.getNossoNumero()); 
        Boleto boleto = new Boleto(titulo, campoLivreCefSIGCB);
        
        boleto.setLocalPagamento("PREFERENCIALMENTE NAS CASAS LOTÉRICAS ATÉ O VALOR LIMITE");
        boleto.setInstrucaoAoSacado(mensalidade.getObservacao());
        boleto.setInstrucao1("Referente parcela "+mensalidade.getNumero()+" de aluguel.");
        boleto.setInstrucao2(cedenteCobranca.getCeden_msg1());
        boleto.setInstrucao3("Multa de "+ new DecimalFormat("#,##0.00'%'").format(cedenteCobranca.getCeden_multa()) +" ("+  new DecimalFormat("'R$' ###,##0.00").format(mensalidade.getValor()*cedenteCobranca.getCeden_multa()/100)+") e juros de "+new DecimalFormat("'R$' ###,##0.00").format(cedenteCobranca.getCeden_juros())+" ao dia.");
        boleto.setInstrucao4(cedenteCobranca.getCeden_msg2());
        boleto.setInstrucao5(cedenteCobranca.getCeden_descontos() <= 0 ? "" : "Desconto de "+ new DecimalFormat("#,##0.00'%'").format(cedenteCobranca.getCeden_descontos()) +" ("+  new DecimalFormat("'R$' ###,##0.00").format(mensalidade.getValor()*cedenteCobranca.getCeden_descontos()/100)+") pago até "+ new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()) + ".");
        boleto.setInstrucao6(cedenteCobranca.getCeden_msg3());
        boleto.setInstrucao7(cedenteCobranca.getCeden_msg4());
        boleto.setInstrucao8(mensalidade.getObservacao());

        // campos sobrescritos
        boleto.addImagensExtras("txtRsLogoBanco", new javax.swing.ImageIcon(getClass().getResource("/imagens/caixa_nome.gif")).getImage());
        boleto.addImagensExtras("txtFcLogoBanco", new javax.swing.ImageIcon(getClass().getResource("/imagens/caixa_nome.gif")).getImage());
        boleto.addTextosExtras("txtFcCpfCnpj", cedenteCobranca.getCeden_cpfcnpj());
        boleto.addTextosExtras("txtFcEspecieDocumento", cedenteCobranca.getCeden_especie());
        boleto.addTextosExtras("txtFcAceite", cedenteCobranca.getCeden_aceite());
        boleto.addTextosExtras("txtFcCarteira", cedenteCobranca.getCeden_tipo());
        boleto.addTextosExtras("txtFcEspecie", cedenteCobranca.getCeden_moeda());
        boleto.addTextosExtras("txtRsNumeroParcela", mensalidade.getNumero());
        boleto.addTextosExtras("txtFcSacadoL1", sacado.getNome());
        boleto.addTextosExtras("txtFcSacadoL2", enderecoSac.getLogradouro().concat(", "+enderecoSac.getNumero()).concat(" - "+enderecoSac.getBairro()+" ").concat(enderecoSac.getLocalidade()));
        boleto.addTextosExtras("txtFcSacadoL3", null);
        boleto.addTextosExtras("txtFcSacadoCpfCnpj", "CPF/CNPJ: ".concat(sacado.getCPRF().getCodigoFormatado()));
        boleto.addTextosExtras("txtFcSacadoUf", "UF: ".concat(enderecoSac.getUF().getSigla()));
        boleto.addTextosExtras("txtFcSacadoCep", "CEP: ".concat(enderecoSac.getCEP().getCep()));
        
        //dados sacador avalista
        if (cedenteCobranca.isCeden_avalista()) {
        SacadorAvalista sacadorAvalista = new SacadorAvalista(carne.getContrato().getLocador().getNome(), carne.getContrato().getLocador().getCpf());
        boleto.addTextosExtras("txtFcAvalista", sacadorAvalista.getNome());
        boleto.addTextosExtras("txtFcAvalistaCpfCnpj", "CPF/CNPJ: ".concat(sacadorAvalista.getCPRF().getCodigoFormatado()));
        }
 
        boletos.add(boleto);     
        }
        cedenteCobranca.setCeden_nossonumero(String.valueOf(nossoNumero));
        daoCedente.atualiza(cedenteCobranca);
        
        return boletos;
    }
    
    public Boleto bloqueto() {
        //dados do cedente
        CedenteCobranca cedenteCobranca = daoCedente.selecionaCedente();
        Cedente cedente = new Cedente(cedenteCobranca.getCeden_nome(), cedenteCobranca.getCeden_cpfcnpj());
        
        //dados do sacado
        Sacado sacado = new Sacado(mensalidadeBoleto.getCarne().getContrato().getLocatario().getNome(), mensalidadeBoleto.getCarne().getContrato().getLocatario().getCpf());
        Endereco enderecoSac = new Endereco();
        enderecoSac.setUF(UnidadeFederativa.valueOf(mensalidadeBoleto.getCarne().getContrato().getLocatario().getUf()));
        enderecoSac.setLocalidade(mensalidadeBoleto.getCarne().getContrato().getLocatario().getCidade());
        enderecoSac.setCep(mensalidadeBoleto.getCarne().getContrato().getLocatario().getCep());
        enderecoSac.setBairro(mensalidadeBoleto.getCarne().getContrato().getLocatario().getBairro());
        enderecoSac.setLogradouro(mensalidadeBoleto.getCarne().getContrato().getLocatario().getEndereco());
        enderecoSac.setNumero(mensalidadeBoleto.getCarne().getContrato().getLocatario().getNumEndereco());
        sacado.addEndereco(enderecoSac);

        //dados do titulo.
        String conta = String.format("%06d", Integer.valueOf(cedenteCobranca.getCeden_conta()));
        String dvConta = String.valueOf(CampoLivreCefSIGCB.calculeDVModulo11(conta));     
        
        Banco banco = BancosSuportados.CAIXA_ECONOMICA_FEDERAL.create();
        ContaBancaria contaBancaria = new ContaBancaria(banco);
        contaBancaria.setBanco(banco);
        contaBancaria.setAgencia(new Agencia(Integer.valueOf(cedenteCobranca.getCeden_agencia())));
        contaBancaria.setNumeroDaConta(new NumeroDaConta(Integer.valueOf(conta), dvConta));
        contaBancaria.setCarteira(new Carteira(Integer.valueOf(cedenteCobranca.getCeden_modalidade()), TipoDeCobranca.SEM_REGISTRO));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mensalidadeBoleto.getVencimento());
        Date dataVencimento = calendar.getTime();

        if (mensalidadeBoleto.getVencimento().getTime() < new Date().getTime()) {
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, 5);
            mensalidadeBoleto.setVencimento(calendar.getTime());
            // atualiza data de vencimento
            dao.atualizaMensalidade(mensalidadeBoleto);
            calendar.setTime(dataVencimento);
        } 
        calendar.add(Calendar.DAY_OF_MONTH, -cedenteCobranca.getCeden_descontos_dia());
        
        int nossoNumero = Integer.valueOf(cedenteCobranca.getCeden_nossonumero());
        nossoNumero = nossoNumero + 1;

        Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
        titulo.setNumeroDoDocumento(Uteis.retornaNumeros(String.format("%06d", mensalidadeBoleto.getCodigo())));
        titulo.setNossoNumero(contaBancaria.getCarteira().getCodigo().toString().concat(cedenteCobranca.getCeden_emissao_bloq()).concat(String.format("%015d", nossoNumero)));
        titulo.setDigitoDoNossoNumero(String.valueOf(CampoLivreCefSIGCB.calculeDVModulo11(String.valueOf(titulo.getNossoNumero()))));
        titulo.setValor(BigDecimal.valueOf(mensalidadeBoleto.getValor()));
        titulo.setDataDoDocumento(new Date());
        titulo.setDataDoVencimento(mensalidadeBoleto.getVencimento());
        titulo.setParametrosBancarios(new ParametrosBancariosMap("CodigoOperacao", new Integer(cedenteCobranca.getCeden_operacao())));

        CampoLivreCefSIGCB campoLivreCefSIGCB = new CampoLivreCefSIGCB(conta, dvConta, titulo.getNossoNumero()); 
        Boleto boleto = new Boleto(titulo, campoLivreCefSIGCB);
        
        boleto.setLocalPagamento("Preferencialmente nas casas lotéricas até o valor limite ou rede bancária até o vencimento.");
        boleto.setInstrucaoAoSacado(mensalidadeBoleto.getObservacao());
        boleto.setInstrucao1("Referente parcela "+mensalidadeBoleto.getNumero()+" de aluguel.");
        boleto.setInstrucao2(cedenteCobranca.getCeden_msg1());
        boleto.setInstrucao3("Multa de "+ new DecimalFormat("#,##0.00'%'").format(cedenteCobranca.getCeden_multa()) +" ("+  new DecimalFormat("'R$' ###,##0.00").format(mensalidadeBoleto.getValor()*cedenteCobranca.getCeden_multa()/100)+") e juros de "+new DecimalFormat("'R$' ###,##0.00").format(cedenteCobranca.getCeden_juros())+" ao dia.");
        boleto.setInstrucao4(cedenteCobranca.getCeden_msg2());
        boleto.setInstrucao5(cedenteCobranca.getCeden_descontos() <= 0 ? "" : "Desconto de "+ new DecimalFormat("#,##0.00'%'").format(cedenteCobranca.getCeden_descontos()) +" ("+  new DecimalFormat("'R$' ###,##0.00").format(mensalidadeBoleto.getValor()*cedenteCobranca.getCeden_descontos()/100)+") pago até "+ new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()) + ".");
        boleto.setInstrucao6(cedenteCobranca.getCeden_msg3());
        boleto.setInstrucao7(cedenteCobranca.getCeden_msg4());
        boleto.setInstrucao8(mensalidadeBoleto.getObservacao());

        // campos sobrescritos
        boleto.addImagensExtras("txtRsLogoBanco", new javax.swing.ImageIcon(getClass().getResource("/imagens/caixa_nome.gif")).getImage());
        boleto.addImagensExtras("txtFcLogoBanco", new javax.swing.ImageIcon(getClass().getResource("/imagens/caixa_nome.gif")).getImage());
        boleto.addTextosExtras("txtFcCpfCnpj", cedenteCobranca.getCeden_cpfcnpj());
        boleto.addTextosExtras("txtFcEspecieDocumento", cedenteCobranca.getCeden_especie());
        boleto.addTextosExtras("txtFcAceite", cedenteCobranca.getCeden_aceite());
        boleto.addTextosExtras("txtFcCarteira", cedenteCobranca.getCeden_tipo());
        boleto.addTextosExtras("txtFcEspecie", cedenteCobranca.getCeden_moeda());
        boleto.addTextosExtras("txtRsNumeroParcela", mensalidadeBoleto.getNumero());
        boleto.addTextosExtras("txtFcSacadoL1", sacado.getNome());
        boleto.addTextosExtras("txtFcSacadoL2", enderecoSac.getLogradouro().concat(", "+enderecoSac.getNumero()).concat(" - "+enderecoSac.getBairro()+ " ").concat(enderecoSac.getLocalidade()).concat("-"+enderecoSac.getUF().getSigla()).concat("CEP: "+enderecoSac.getCEP().getCep()));
        boleto.addTextosExtras("txtFcSacadoL3", null);
        boleto.addTextosExtras("txtFcSacadoCpfCnpj", "CPF/CNPJ: ".concat(sacado.getCPRF().getCodigoFormatado()));
        //boleto.addTextosExtras("txtFcSacadoUf", "UF: ".concat(enderecoSac.getUF().getSigla()));
        //boleto.addTextosExtras("txtFcSacadoCep", "CEP: ".concat(enderecoSac.getCEP().getCep()));
        
        //dados sacador avalista
        if (cedenteCobranca.isCeden_avalista()) {
        SacadorAvalista sacadorAvalista = new SacadorAvalista(mensalidadeBoleto.getCarne().getContrato().getLocador().getNome(), mensalidadeBoleto.getCarne().getContrato().getLocador().getCpf());
        boleto.addTextosExtras("txtFcSacadorAvalistaL1", sacadorAvalista.getNome());
        boleto.addTextosExtras("txtFcSacadorAvalistaL2", "CPF/CNPJ: ".concat(sacadorAvalista.getCPRF().getCodigoFormatado()));
        }

        // atualiza nosso numero
        cedenteCobranca.setCeden_nossonumero(String.valueOf(nossoNumero));
        daoCedente.atualiza(cedenteCobranca);
        
        return boleto;
    }

    public File groupInPages(List<Boleto> boletos, String filePath, File templatePersonalizado) {

        File arq = null;
        BoletoViewer boletoViewer = new BoletoViewer(boletos.get(0));
        boletoViewer.setTemplate(templatePersonalizado);

        List<byte[]> boletosEmBytes = new ArrayList<byte[]>(boletos.size());

        //Adicionando os PDF, em forma de array de bytes, na lista.
        for (Boleto bop : boletos) {
            boletosEmBytes.add(boletoViewer.setBoleto(bop).getPdfAsByteArray());
        }

        try {

            //Criando o arquivo com os boletos da lista
            arq = Files.bytesToFile(filePath, mergeFilesInPages(boletosEmBytes));

        } catch (Exception e) {
            throw new IllegalStateException("Erro durante geração do PDF! Causado por " + e.getLocalizedMessage(), e);
        }

        return arq;
    }

    private byte[] mergeFilesInPages(List<byte[]> pdfFilesAsByteArray) throws DocumentException, IOException {

        Document document = new Document();
        ByteArrayOutputStream byteOS = new ByteArrayOutputStream();

        PdfWriter writer = PdfWriter.getInstance(document, byteOS);

        document.open();

        PdfContentByte cb = writer.getDirectContent();
        float positionAnterior = 0;

        //Para cada arquivo da lista, cria-se um PdfReader, responsável por ler o arquivo PDF e recuperar informações dele.
        for (byte[] pdfFile : pdfFilesAsByteArray) {

            PdfReader reader = new PdfReader(pdfFile);

            //Faz o processo de mesclagem por página do arquivo, começando pela de número 1.
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {

                float documentHeight = cb.getPdfDocument().getPageSize().getHeight();

                //Importa a página do PDF de origem
                PdfImportedPage page = writer.getImportedPage(reader, i);
                float pagePosition = positionAnterior;

                /*
                 * Se a altura restante no documento de destino form menor que a altura do documento,
                 * cria-se uma nova página no documento de destino.
                 */
                if ((documentHeight - positionAnterior) <= page.getHeight()) {
                    document.newPage();
                    pagePosition = 0;
                    positionAnterior = 0;
                }

                //Adiciona a página ao PDF destino
                cb.addTemplate(page, 0, pagePosition);

                positionAnterior += page.getHeight();
            }
        }

        byteOS.flush();
        document.close();

        byte[] arquivoEmBytes = byteOS.toByteArray();
        byteOS.close();

        return arquivoEmBytes;
    }

}

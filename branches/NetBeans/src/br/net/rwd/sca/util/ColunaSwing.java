/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.rwd.sca.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Erivando
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ColunaSwing {

    String descricao();

    Class<? extends DefaultTableCellRenderer> renderizador() default DefaultTableCellRenderer.class;
    
    String corDeFundo() default "";
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectx;

/**
 * Clase Bueno
 *
 * @author Antonio Mejorado
 * @version 1.00 2008/6/13
 */
import java.awt.Image;
import java.awt.Toolkit;

public class Proyectil extends Base {

    final static String DESAPARECE = "Desaparece";
    final static String PAUSADO = "Pausado";

    /**
     * Metodo constructor que hereda los atributos de la clase
     * <code>Base</code>.
     *
     * @param posX es la <code>posiscion en x</code> del objeto bueno.
     * @param posY es el <code>posiscion en y</code> del objeto bueno.
     */
    public Proyectil(int posX, int posY) {
        super(posX, posY);
        //Se cargan las imágenes(cuadros) para la animación
        Image ham1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Hamsters/0.gif"));
        Image ham2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Hamsters/1.gif"));
        Image ham3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Hamsters/2.gif"));
        Image ham4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Hamsters/3.gif"));
        Image ham5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Hamsters/4.gif"));
        Image ham6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Hamsters/5.gif"));
        Image ham7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Hamsters/6.gif"));

        //Se crea la animación
        anim = new Animacion();
        anim.sumaCuadro(ham1, 200);
        anim.sumaCuadro(ham2, 200);
        anim.sumaCuadro(ham3, 200);
        anim.sumaCuadro(ham4, 200);
        anim.sumaCuadro(ham5, 200);
        anim.sumaCuadro(ham6, 200);
        anim.sumaCuadro(ham7, 200);
    }
    
    /**
     * Metodo de acceso que regresa la constante PAUSADO de la clase
     *
     * @return PAUSADO es la constante <code>PAUSADO</code> de la clase.
     */
    public String getPausado() {
        return PAUSADO;
    }
    
    /**
     * Metodo de acceso que regresa la constante DESAPARECE de la clase
     *
     * @return DESAPARECE es la constante <code>DESAPARECE</code> de la clase.
     */
    public String getDesaparece() {
        return DESAPARECE;
    }

}

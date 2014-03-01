/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectx;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 *
 * @author roelcastano
 */
public class Pajaro extends Base {

    private final String DESAPARECE = "DESAPARECE";
    private final String PAUSADO = "PAUSADO";
    protected Animacion animBabe; //animacion del pajaro
    private int posX;    //posicion en x.       
    private int posY;   //posicion en y.

    public Pajaro(int posX, int posY) {

        super(posX, posY);	//constructor

        //Se cargan las imágenes(cuadros) para la animación del malo
        Image bueno1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bird/0.gif"));
        Image bueno2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bird/1.gif"));
        Image bueno3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bird/2.gif"));
        Image bueno4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bird/3.gif"));
        Image bueno5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bird/4.gif"));
        Image bueno6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("bird/5.gif"));

        //Se crea una nueva animacion con la inizialicacion dada
        animBabe = new Animacion();
        animBabe.sumaCuadro(bueno1, 100);
        animBabe.sumaCuadro(bueno2, 100);
        animBabe.sumaCuadro(bueno3, 100);
        animBabe.sumaCuadro(bueno4, 100);
        animBabe.sumaCuadro(bueno5, 100);
        animBabe.sumaCuadro(bueno6, 100);

    }

    /**
     * Metodo de acceso que regresa el ancho del icono
     *
     * @return un objeto de la clase <code>ImageIcon</code> que es el ancho del
     * icono.
     */
    public int getAncho() {
        return (new ImageIcon(animBabe.getImagen())).getIconWidth();
    }

    /**
     * Metodo de acceso que regresa el alto del icono
     *
     * @return un objeto de la clase <code>ImageIcon</code> que es el alto del
     * icono.
     */
    public int getAlto() {
        return (new ImageIcon(animBabe.getImagen())).getIconHeight();
    }

    /**
     * Metodo de acceso que regresa la imagen del icono
     *
     * @return un objeto de la clase <code>Image</code> que es la imagen del
     * icono.
     */
    public Image getImagen() {
        return (new ImageIcon(animBabe.getImagen())).getImage();
    }

}

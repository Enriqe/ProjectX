/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectx;

/**
 * Clase Elefante
 *
 * @author Antonio Mejorado
 * @version 1.00 2008/6/13
 */
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Canasta extends Base{

        private final String DESAPARECE = "DESAPARECE";
        private final String PAUSADO = "PAUSADO";
        protected Animacion animBabe;
        private int posX;    //posicion en x.       
	private int posY;	//posicion en y.

	public Canasta(int posX,int posY){
            
		super(posX,posY);	//constructor

                //Se cargan las imágenes(cuadros) para la animación del malo
		Image bueno1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesCanasta/0.gif"));
		Image bueno2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesCanasta/1.gif"));
		Image bueno3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesCanasta/2.gif"));
		Image bueno4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesCanasta/3.gif"));
		Image bueno5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesCanasta/4.gif"));
		Image bueno6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesCanasta/5.gif"));
		Image bueno7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesCanasta/6.gif"));
		Image bueno8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesCanasta/7.gif"));
		Image bueno9 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesCanasta/8.gif"));
		Image bueno10 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesCanasta/9.gif"));                  
                
                //for (int i = 0; i < 10; i++)
                  //  animBabe.sumaCuadro(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesCanasta/" + i + ".gif")), 100);

                //Se crea una nueva animacion con la inizialicacion dada
                animBabe = new Animacion();
		animBabe.sumaCuadro(bueno1, 100);
		animBabe.sumaCuadro(bueno2, 100);
		animBabe.sumaCuadro(bueno3, 100);
		animBabe.sumaCuadro(bueno4, 100);
                animBabe.sumaCuadro(bueno5, 100);
                animBabe.sumaCuadro(bueno6, 100);
		animBabe.sumaCuadro(bueno7, 100);
                animBabe.sumaCuadro(bueno8, 100);
                animBabe.sumaCuadro(bueno9, 100);
		animBabe.sumaCuadro(bueno10, 100);
	}

        /**
	 * Metodo de acceso que regresa el ancho del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el ancho del icono.
	 */
	public int getAncho() {
		return (new ImageIcon(animBabe.getImagen())).getIconWidth();
	}
        
        /**
	 * Metodo de acceso que regresa el alto del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el alto del icono.
	 */
	public int getAlto() {
		return (new ImageIcon(animBabe.getImagen())).getIconHeight();
	}
        
        /**
	 * Metodo de acceso que regresa la imagen del icono 
	 * @return un objeto de la clase <code>Image</code> que es la imagen del icono.
	 */
	public Image getImagen() {
		return (new ImageIcon(animBabe.getImagen())).getImage();
	}
        
        /** 
         * Metodo de acceso que regresa la string pausada 
         * @return un string constante
         */
        public String getPausa() {
            return PAUSADO;
        }
        
        /** 
         * Metodo de acceso que regresa la string pausada 
         * @return un string constante
         */
        public String getDesaparece() {
            return DESAPARECE;
        }
        

}

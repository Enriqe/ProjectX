package projectx;

/**
 * Clase Raton
 *
 * @author Antonio Mejorado
 * @version 1.00 2008/6/13
 */
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Proyectil extends Base {
        private  static int CONTEO = 0; //score
        protected Animacion animVamp; //animacion que sera utilizada para animar al Proyectil
        private int velocidad; //velocidad que cada objeto de la clas Proyectil tendra

	public Proyectil(int posX,int posY, int vel){
		super(posX,posY); //constructor
                velocidad = vel;
                //Se cargan las imágenes(cuadros) para la animación del malo
		Image malo1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenesProyectil/birdPoop.gif"));
                
                //Se crea la animación
		animVamp = new Animacion();
		animVamp.sumaCuadro(malo1, 100);
	}
        
        
        /**
	 * Metodo de acceso que regresa el ancho del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el ancho del icono.
	 */
	public int getAncho() {
		return (new ImageIcon(animVamp.getImagen())).getIconWidth();
	}
        
        /**
	 * Metodo de acceso que regresa el alto del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el alto del icono.
	 */
	public int getAlto() {
		return (new ImageIcon(animVamp.getImagen()).getIconHeight());
	}
        
        /**
	 * Metodo de acceso que regresa la imagen del icono 
	 * @return un objeto de la clase <code>Image</code> que es la imagen del icono.
	 */
	public Image getImagen() {
		return (new ImageIcon(animVamp.getImagen())).getImage();
	}
        
        /**
         * Metodo de acceso que regresa la velocidad del objeto Proyectil
         * @return un int conteniendo la velocidad del objeto
         */
        public int getVelocidad() {
            return velocidad;
        }
        
        public int getConteo() { 
            return CONTEO;
        }
        
        public void setConteo(int c) {
            CONTEO = c;
        }
        
        
}

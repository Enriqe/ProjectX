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
        private boolean movimiento;
        private int velocidadY;
        private int velocidadX;


	public Proyectil(int posX,int posY, int velX, int velY){
		super(posX,posY); //constructor
                //Se cargan las imágenes(cuadros) para la animación del malo
		Image malo1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("birdPoop/birdPoop.gif"));
                
                velocidadX = velX;
                velocidadY = velY;
                movimiento = false;
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
	 * Metodo de acceso que regresa el ancho del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el ancho del icono.
	 */
	public boolean getMovimiento() {
		return movimiento;
	}
        
        /**
	 * Metodo de acceso que regresa el alto del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el alto del icono.
	 */
	public void setMovimiento(boolean t) {
		movimiento = t;
	}
        
        /**
	 * Metodo de acceso que regresa el ancho del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el ancho del icono.
	 */
	public int getVelocidadX() {
		return velocidadX;
	}
        
        /**
	 * Metodo de acceso que regresa el alto del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el alto del icono.
	 */
	public void setVelocidadX(int t) {
		velocidadX = t;
	}
        
        /**
	 * Metodo de acceso que regresa el ancho del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el ancho del icono.
	 */
	public int getVelocidadY() {
		return velocidadY;
	}
        
        /**
	 * Metodo de acceso que regresa el alto del icono 
	 * @return un objeto de la clase <code>ImageIcon</code> que es el alto del icono.
	 */
	public void setVelocidadY(int t) {
		velocidadY = t;
	}

        /**
	 * Metodo de acceso que regresa la imagen del icono 
	 * @return un objeto de la clase <code>Image</code> que es la imagen del icono.
	 */
	public Image getImagen() {
		return (new ImageIcon(animVamp.getImagen())).getImage();
	}
                
        public int getConteo() { 
            return CONTEO;
        }
        
        public void setConteo(int c) {
            CONTEO = c;
        }
        
        
}

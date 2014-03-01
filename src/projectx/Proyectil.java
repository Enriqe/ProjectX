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

    private static int CONTEO = 0; //score
    protected Animacion animVamp; //animacion que sera utilizada para animar al Proyectil
    private boolean movimiento;
    private int velocidadY;
    private int velocidadX;

    /**
     * Metodo constructor usado para crear el objeto
     *
     * @param posX es la <code>posicion en x</code> del objeto.
     * @param posY es la <code>posicion en y</code> del objeto.
     * @param velX es la <code>velocidad en x</code> del objeto.
     * @param velY es la <code>velocidad en Y</code> del objeto.
     */
    public Proyectil(int posX, int posY, int velX, int velY) {
        super(posX, posY); //constructor
        //Se cargan las imágenes(cuadros) para la animación del malo
        Image malo1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("birdPoop/birdPoop.gif"));

        //asigna valores de los parametros
        velocidadX = velX;
        velocidadY = velY;
        movimiento = false;

        //Se crea la animación
        animVamp = new Animacion();
        animVamp.sumaCuadro(malo1, 100);
    }

    /**
     * Metodo de acceso que regresa el ancho del icono
     *
     * @return un objeto de la clase <code>ImageIcon</code> que es el ancho del
     * icono.
     */
    public int getAncho() {
        return (new ImageIcon(animVamp.getImagen())).getIconWidth();
    }

    /**
     * Metodo de acceso que regresa el alto del icono
     *
     * @return un objeto de la clase <code>ImageIcon</code> que es el alto del
     * icono.
     */
    public int getAlto() {
        return (new ImageIcon(animVamp.getImagen()).getIconHeight());
    }

    /**
     * Metodo de acceso que regresa el booleano movimiento
     *
     * @return un boolean de la clase <code>Proyectil</code> que permite que el
     * proyectil se mueve.
     */
    public boolean getMovimiento() {
        return movimiento;
    }

    /**
     * Metodo de modificador usado para cambiar el booleano movimiento
     *
     * @param un boolean que permite que la variable <code>movimiento</code> sea
     * ajustada.
     */
    public void setMovimiento(boolean t) {
        movimiento = t;
    }

    /**
     * Metodo de acceso que regresa la velocidad en y del objeto
     *
     * @return velocidadX es la <code>velocidad en x</code> del objeto.
     */
    public int getVelocidadX() {
        return velocidadX;
    }

    /**
     * Metodo modificador usado para cambiar la velocidad en x del objeto
     *
     * @param t es la <code>velocidad en X</code> del objeto.
     */
    public void setVelocidadX(int t) {
        velocidadX = t;
    }

    /**
     * Metodo de acceso que regresa la velocidad en y del objeto
     *
     * @return velocidadY es la <code>velocidad en y</code> del objeto.
     */
    public int getVelocidadY() {
        return velocidadY;
    }

    /**
     * Metodo modificador usado para cambiar la velocidad en y del objeto
     *
     * @param t es la <code>velocidad en Y</code> del objeto.
     */
    public void setVelocidadY(int t) {
        velocidadY = t;
    }

    /**
     * Metodo de acceso que regresa la imagen del icono
     *
     * @return un objeto de la clase <code>Image</code> que es la imagen del
     * icono.
     */
    public Image getImagen() {
        return (new ImageIcon(animVamp.getImagen())).getImage();
    }
    
    /**
     * Metodo de acceso que regresa la variable CONTEO
     *
     * @return un objeto de la clase <code>Proyectil</code> que es el score
     */
    public int getConteo() {
        return CONTEO;
    }
    
    /**
     * Metodo modificador usado para cambiar la variable conteo
     *
     * @param c es el <code>puntuaje</code> del objeto.
     */
    public void setConteo(int c) {
        CONTEO = c;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectx;

/**
 * Clase Malo
 *
 * @author Antonio Mejorado
 * @version 1.00 2008/6/13
 */

import java.awt.Image;
import java.awt.Toolkit;

public class Canasta extends Base{
    private static int conteo;
    private long tiempoActual;
    private long tiempoInicial;
    private int velocidad;

    /**
     * Metodo constructor que hereda los atributos de la clase
     * <code>Base</code>.
     *
     * @param posX es la <code>posiscion en x</code> del objeto malo.
     * @param posY es el <code>posiscion en y</code> del objeto malo.
     */
    public Canasta(int posX, int posY) {
        super(posX, posY);
        //Se cargan las imágenes(cuadros) para la animación
        Image ham1 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/0.gif"));
        Image ham2 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/1.gif"));
        Image ham3 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/2.gif"));
        Image ham4 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/3.gif"));
        Image ham5 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/4.gif"));
        Image ham6 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/5.gif"));
        Image ham7 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/6.gif"));
        Image ham8 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/7.gif"));
        Image ham9 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/8.gif"));
        Image ham10 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/9.gif"));
        Image ham11 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/10.gif"));
        Image ham12 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/11.gif"));
        Image ham13 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/12.gif"));
        Image ham14 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/13.gif"));
        Image ham15 = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("imagenes/Monkeys/14.gif"));

        //Se crea la animación
        anim = new Animacion();
        anim.sumaCuadro(ham1, 200);
        anim.sumaCuadro(ham2, 200);
        anim.sumaCuadro(ham3, 200);
        anim.sumaCuadro(ham4, 200);
        anim.sumaCuadro(ham5, 200);
        anim.sumaCuadro(ham6, 200);
        anim.sumaCuadro(ham7, 200);
        anim.sumaCuadro(ham8, 200);
        anim.sumaCuadro(ham9, 200);
        anim.sumaCuadro(ham10, 200);
        anim.sumaCuadro(ham11, 200);
        anim.sumaCuadro(ham12, 200);
        anim.sumaCuadro(ham13, 200);
        anim.sumaCuadro(ham14, 200);
        anim.sumaCuadro(ham15, 200);
    }

    /**
     * Metodo modificador usado para cambiar la velocidad del objeto
     *
     * @param vel es la <code>velocidad</code> del objeto.
     */
    public void setVelocidad(int vel) {
        velocidad = vel;
    }

    /**
     * Metodo de acceso que regresa la velocidad del objeto
     *
     * @return velocidad es la <code>velocidad</code> del objeto.
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * Metodo modificador usado para cambiar el conteo de la clase Malo
     *
     * @param cont es el <code>score</code> de la clase.
     */
    public static void setConteo(int cont) {
        conteo = cont;
    }

    /**
     * Metodo de acceso que regresa el conteo de la clase Malo
     *
     * @return conteo es la variable <code>conteo</code> de la clase.
     */
    public static int getConteo() {
        return conteo;
    }

}

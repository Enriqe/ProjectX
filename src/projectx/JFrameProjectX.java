/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectx;

/**
 * Applicación JFrameProjectX
 *
 * Tutorial ¿Qué es un JFrame? - Jugando con JAVA
 *
 * @autor Jugando con JAVA
 * @version 1.0 13/08/2010
 */
import javax.swing.JFrame;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
//

public class JFrameProjectX extends JFrame implements Runnable, KeyListener, MouseListener, MouseMotionListener {

    private int posClicX; // posicion del mouse en x
    private int posClicY; // posicion del mouse en y
    private int aceleracion;
    private long tiempoActual;
    boolean colisiono;              //flag de que colisiono
    boolean sonidosActivados;
    boolean instrucciones;
    int tiempoColision;             //contador para dejar la imagen colisionada
    int posX, posY;
    private static final long serialVersionUID = 1L;
    // Se declaran las variables.
    private int direccion;    // Direccion del elefante
    private Image dbImage;	// Imagen a proyectar	
    private Graphics dbg;	// Objeto grafico
    private Canasta carro;    // Objeto de la clase Canasta
    private Proyectil popo;    //Objeto de la clase Proyectil
    private boolean choco;
    private Pajaro pajaro;
    private int velocidad;
    boolean pausa;   //booleana para ver si el usuario quiere pausar
    boolean guardar; //booleana para verificar si el usuario quiere guardar
    boolean cargado; // booleana para verificar si quiere cargar
    private int velocidadX;
    private int velocidadY;
    boolean desaparece;
    private SoundClip coin;	//Sonido de coin
    private SoundClip whip;	//Sonido de beep
    int score;
    int vidas;
    int perdidas;
    int numProyectils;
    private Vector vec;    // Objeto vector para agregar el puntaje.
    private String nombreArchivo;    //Nombre del archivo.
    private String[] arr;    //Arreglo del archivo divido.

    public JFrameProjectX() {
        setTitle("BEST GAME EVER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Carga los clips de sonido
        coin = new SoundClip("sounds/smw_coin.wav");
        whip = new SoundClip("sounds/whip-whoosh-02.wav");
        init();
        start();
    }

    public void init() {
        setSize(900, 700);
        choco = false;
        aceleracion = 1;
        score = 0;
        perdidas = 0;
        vidas = 5;
        sonidosActivados = true;
        instrucciones = false;
        nombreArchivo = "Puntaje.txt";
        vec = new Vector();
        colisiono = false;
        tiempoColision = 0;
        direccion = 0;
        int posX = (int) (getWidth() / 2 - 30);    // posicion en x del carro en medio del JFrame
        int posY = (int) (getHeight() - 60);    // posicion en y del carro
        carro = new Canasta(posX, posY);
        int posPajaroX = (int) (getWidth() / 8);    // posicion en x en medio de la applet
        int posPajaroY = (int) (getHeight() / 2);    // posicion en y enmedio de la applet
        pajaro = new Pajaro(posPajaroX, posPajaroY);
        pajaro.setPosX(pajaro.getPosX() - (pajaro.getAncho() / 2));
        pajaro.setPosY(pajaro.getPosY() - (pajaro.getAlto() / 2));
        setBackground(Color.yellow);
        pausa = false; // iniciliza la pausa como false
        guardar = false; // guardar inizializa como false
        cargado = false; // cargado empieza false
        desaparece = false;

        //int posrX = (int) (Math.random() * (getWidth()));    
        int posrY = (int) (Math.random() * (getHeight()));
                //velocidadX = (int) (Math.random()*3)+8;
        //velocidadY = (int) (-1*((Math.random()*10)+10));
        popo = new Proyectil(pajaro.getPosX(), pajaro.getPosY(), 0, 0);
        popo.setPosX(popo.getPosX() + pajaro.getAncho());
        popo.setPosY(popo.getPosY() + (pajaro.getAlto() / 2));

        //Pinta el fondo del Applet de color amarillo		
        setBackground(Color.white);
        addKeyListener(this);
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    /**
     * Metodo <I>start</I> sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se crea e inicializa el hilo para la animacion este metodo
     * es llamado despues del init o cuando el usuario visita otra pagina y
     * luego regresa a la pagina en donde esta este <code>Applet</code>
     *
     */
    public void start() {
        // Declaras un hilo
        Thread th = new Thread(this);
        // Empieza el hilo
        th.start();
    }

    /**
     * Metodo stop sobrescrito de la clase Applet. En este metodo se pueden
     * tomar acciones para cuando se termina de usar el Applet. Usualmente
     * cuando el usuario sale de la pagina en donde esta este Applet.
     */
    public void stop() {

    }

    /**
     * Metodo destroy sobrescrito de la clase Applet. En este metodo se toman
     * las acciones necesarias para cuando el Applet ya no va a ser usado.
     * Usualmente cuando el usuario cierra el navegador.
     */
    public void destroy() {

    }

    /**
     * Metodo <I>run</I> sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, es un ciclo indefinido donde se
     * incrementa la posicion en x o y dependiendo de la direccion, finalmente
     * se repinta el <code>Applet</code> y luego manda a dormir el hilo.
     *
     */
    public void run() {
            	//Guarda el tiempo actual del sistema

        tiempoActual = System.currentTimeMillis();
        /*vidas>0 && */
        while (true) {
            if (!pausa) {
                actualiza();
                checaColision();
            }

            if (guardar) {
                guardar = false;
                try {

                                          //leeArchivo();    //lee el contenido del archivo
                    //Agrega el contenido del nuevo puntaje al vector.
                    //guarda posX del carrodel carro, posX y posY y velX y velY popo
                    int sonActiv = (sonidosActivados ? 1 : 0);
                    int movActiv = (popo.getMovimiento() ? 1 : 0);
                    vec.removeAllElements();
                    vec.add(new Puntaje(popo.getConteo(), carro.getPosX(), popo.getPosX(), popo.getPosY(), popo.getVelocidadX(), popo.getVelocidadY(), vidas, perdidas, sonActiv, movActiv));
                    //Graba el vector en el archivo.
                    grabaArchivo();
                } catch (IOException ex) {

                    System.out.println("Error en " + ex.toString());
                }
            } else if (cargado) {
                try {
                    leeArchivo();
                } catch (IOException ex) {

                    System.out.println("Error en " + ex.toString());
                }
                popo.setConteo(Integer.parseInt(arr[0]));
                int carX = (Integer.parseInt(arr[1]));
                carro.setPosX(carX);
                int xpPopo = (Integer.parseInt(arr[2]));
                popo.setPosX(xpPopo);
                int ypPopo = (Integer.parseInt(arr[3]));
                popo.setPosY(ypPopo);
                int xvPopo = (Integer.parseInt(arr[4]));
                popo.setVelocidadX(xvPopo);
                int yvPopo = (Integer.parseInt(arr[5]));
                popo.setVelocidadY(yvPopo);
                int lif = (Integer.parseInt(arr[6]));
                vidas = lif;
                int loss = (Integer.parseInt(arr[7]));
                perdidas = loss;
                int son = (Integer.parseInt(arr[8]));
                sonidosActivados = (son == 1 ? true : false);
                int mov = (Integer.parseInt(arr[9]));
                if (mov == 1) {
                    popo.setMovimiento(true);
                } else {
                    popo.setMovimiento(false);
                }
                cargado = false;
            } else {

                repaint();    // Se actualiza el <code>Applet</code> repintando el contenido.

                try {
                    // El thread se duerme.
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    System.out.println("Error en " + ex.toString());
                }
            }
        }

    }

    /**
     * Metodo usado para actualizar la posicion de objetos elefante y popo.
     *
     */
    public void actualiza() {

        switch (direccion) {
            case 3: {
                carro.setPosX(carro.getPosX() - 5);
                break;    //se mueve hacia abajo izquierda
            }
            case 4: {
                carro.setPosX(carro.getPosX() + 5);
                break;    //se mueve hacia arriba izquierda	
            }
        }

        //Determina el tiempo que ha transcurrido desde que el Applet inicio su ejecución
        long tiempoTranscurrido
                = System.currentTimeMillis() - tiempoActual;

        //Guarda el tiempo actual
        tiempoActual += tiempoTranscurrido;
        //Actualiza la animación en base al tiempo transcurrido
        if (direccion != 0) {
            carro.animBabe.actualiza(tiempoTranscurrido);  //cuando el carro no se mueve, no se anima
        }
        pajaro.animBabe.actualiza(tiempoTranscurrido);
        popo.animVamp.actualiza(tiempoTranscurrido);
        if (popo.getMovimiento()) {
            popo.setPosX(popo.getPosX() + popo.getVelocidadX());
            popo.setPosY(popo.getPosY() + popo.getVelocidadY());
            popo.setVelocidadY(popo.getVelocidadY() + aceleracion);
        }

    }

    /**
     * Metodo usado para checar las colisiones del objeto elefante y popo con
     * las orillas del <code>Applet</code>.
     */
    public void checaColision() {
        //Colision del bueno con el Applet 
        if (carro.getPosX() + carro.getAncho() > getWidth()) {
            carro.setPosX(carro.getPosX() - 10);
        }
        if (carro.getPosX() < getWidth() / 2) {
            carro.setPosX(getWidth() / 2);
        }

        //Colision entre objetos
        if (carro.intersecta(popo)) {
            colisiono = true;
            if (sonidosActivados) {
                coin.play();
            }
            desaparece = true;
            popo.setConteo(popo.getConteo() + 2);
            popo.setPosX(pajaro.getPosX() + pajaro.getAncho());
            popo.setPosY(pajaro.getPosY() + (pajaro.getAlto() / 2));
            choco = true;
        }

        if (colisiono == true && tiempoColision <= 30) {
            tiempoColision++;
        } else {
            colisiono = false;
            tiempoColision = 0;
        }

        //colision entre paredes
        if (popo.getPosY() > getHeight()) {
            popo.setPosX(pajaro.getPosX() + pajaro.getAncho());
            popo.setPosY(pajaro.getPosY() + pajaro.getAlto() / 2);
            choco = true;
            if (sonidosActivados) {
                whip.play();
            }
            if (perdidas < 2) {
                perdidas++;
            } else {
                vidas--;
                perdidas = 0;
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {

        posClicX = e.getX();
        posClicY = e.getY();
        if (popo.intersecta(posClicX, posClicY)) {
            popo.setMovimiento(true);
            choco = false;
            velocidadX = (int) (Math.random() * 6) + 6;
            velocidadY = (int) -23;

            popo.setVelocidadX(velocidadX);
            popo.setVelocidadY(velocidadY);
        }
    }

    /**
     * Metodo <I>update</I> sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo lo que hace es actualizar el contenedor
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint(Graphics g) {
        // Inicializan el DoubleBuffer
        if (dbImage == null) {
            dbImage = createImage(this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics();
        }

        // Actualiza la imagen de fondo.
        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

        // Actualiza el Foreground.
        dbg.setColor(getForeground());
        paint1(dbg);

        // Dibuja la imagen actualizada
        g.drawImage(dbImage, 0, 0, this);
    }

    /**
     * Metodo <I>keyPressed</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar cualquier la
     * tecla.
     *
     * @param e es el <code>evento</code> generado al presionar las teclas.
     */
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {    //Presiono flecha izquierda
            direccion = 3;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {    //Presiono flecha derecha
            direccion = 4;
        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            if (pausa) {
                pausa = false;
                direccion = 0;
            } else {
                pausa = true;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_G) {
            if (!instrucciones) {
                guardar = true;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            sonidosActivados = !sonidosActivados;
        }

        if (e.getKeyCode() == KeyEvent.VK_I) {
            instrucciones = !instrucciones;
        }
        if (e.getKeyCode() == KeyEvent.VK_C) {
            cargado = true;
        }

    }

    /**
     * Metodo <I>keyTyped</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al presionar una tecla que
     * no es de accion.
     *
     * @param e es el <code>evento</code> que se genera en al presionar las
     * teclas.
     */
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Metodo <I>keyReleased</I> sobrescrito de la interface
     * <code>KeyListener</code>.<P>
     * En este metodo maneja el evento que se genera al soltar la tecla
     * presionada.
     *
     * @param e es el <code>evento</code> que se genera en al soltar las teclas.
     */
    public void keyReleased(KeyEvent e) {
        direccion = 0;
        cargado = false;
    }

    /**
     * Metodo <I>paint</I> sobrescrito de la clase <code>Applet</code>, heredado
     * de la clase Container.<P>
     * En este metodo se dibuja la imagen con la posicion actualizada, ademas
     * que cuando la imagen es cargada te despliega una advertencia.
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint1(Graphics g) {

        if (carro != null && popo != null) {
            g.drawImage(carro.getImagen(), carro.getPosX(), carro.getPosY(), this);
            if (choco) {
                popo.setMovimiento(false);
                choco = false;
            }
            g.drawImage(pajaro.getImagen(), pajaro.getPosX(), pajaro.getPosY(), this);
            g.drawImage(popo.getImagen(), popo.getPosX(),
                    popo.getPosY(), this);
            //pinta los popos en la lista
            g.drawImage(popo.getImagen(), popo.getPosX(), popo.getPosY(), this);
            //score = popo.getConteo();
            g.drawString("SCORE: " + popo.getConteo(), 20, 40);
            g.drawString("PERDIDAS: " + perdidas, 20, 60);
            g.drawString("VIDAS: " + vidas, 20, 80);
            if (instrucciones) {
                g.drawString("      INSTRUCCIONES       ", getWidth() / 2 - 80, getHeight() / 2);
                g.drawString("P - Pausar/Jugar", getWidth() / 2 - 80, getHeight() / 2 + 20);
                g.drawString("I - Instrucciones", getWidth() / 2 - 80, getHeight() / 2 + 40);
                g.drawString("G - Grabar juego", getWidth() / 2 - 80, getHeight() / 2 + 60);
                g.drawString("C - Cargar juego", getWidth() / 2 - 80, getHeight() / 2 + 80);
                g.drawString("S - Activar/Desactivar sonido", getWidth() / 2 - 80, getHeight() / 2 + 100);
            }
            if (pausa) {
                g.drawString("" + carro.getPausa(), carro.getPosX() + carro.getAncho(), carro.getPosY());
            }
            if (desaparece && colisiono && tiempoColision <= 30 && !pausa) {
                g.drawString("" + carro.getDesaparece(), carro.getPosX() + carro.getAncho(), carro.getPosY());
            }

        } else {
            //Da un mensaje mientras se carga el dibujo	
            g.drawString("No se cargo la imagen..", 20, 20);
        }

    }

    /**
     * Metodo que lee a informacion de un archivo y lo agrega a un vector.
     *
     * @throws IOException
     */
    public void leeArchivo() throws IOException {
        BufferedReader fileIn;
        try {
            fileIn = new BufferedReader(new FileReader(nombreArchivo));
        } catch (FileNotFoundException e) {
            File puntos = new File(nombreArchivo);
            PrintWriter fileOut = new PrintWriter(puntos);
            fileOut.println("100,300,400,200,12,9,3,0,1");
            fileOut.close();
            fileIn = new BufferedReader(new FileReader(nombreArchivo));
        }
        String dato = fileIn.readLine();

        while (dato != null) {
            arr = dato.split(",");
            int num = (Integer.parseInt(arr[0]));
            int pXCarro = (Integer.parseInt(arr[1]));
            int pXPopo = (Integer.parseInt(arr[2]));
            int pYPopo = (Integer.parseInt(arr[3]));
            int vXPopo = (Integer.parseInt(arr[4]));
            int vYPopo = (Integer.parseInt(arr[5]));
            int vid = (Integer.parseInt(arr[6]));
            int per = (Integer.parseInt(arr[7]));
            int actSon = (Integer.parseInt(arr[8]));
            int mov = (Integer.parseInt(arr[9]));
            vec.add(new Puntaje(num, pXCarro, pXPopo, pYPopo, vXPopo, vYPopo, vid, per, actSon, mov));
            dato = fileIn.readLine();

        }
        fileIn.close();
    }

    /**
     * Metodo que agrega la informacion del vector al archivo.
     *
     * @throws IOException
     */
    public void grabaArchivo() throws IOException {
        PrintWriter fileOut = new PrintWriter(new FileWriter(nombreArchivo));
        for (int i = 0; i < vec.size(); i++) {
            Puntaje x;
            x = (Puntaje) vec.get(i);
            fileOut.println(x.toString());
        }
        fileOut.close();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectx;

/**
 * Clase Puntaje
 *
 * @author Antonio Mejorado
 * @version 1.00 2008/6/13
 */
public class Puntaje {

	private int puntaje;
        private int posXCarro;
        private int posXPopo;
        private int posYPopo;
        private int velXPopo;
        private int velYPopo;
        private int vidas;

	/**
	 * Constructor vacio con darle valores iniciales al momento de
	 * crear el objeto Puntaje
	 */
	public Puntaje() {
		puntaje = 0;
                posXCarro = 0;
                posXPopo = 0;
                posYPopo = 0;
                velXPopo = 0;
                velYPopo = 0;
                vidas = 0;
	}

	/**
	 * Metodo constructor usado para crear el objeto
	 * @param nombre es el <code>nombre</code> del objeto.
	 * @param puntaje es el <code>puntaje</code> del objeto.
	 */
	public Puntaje(int puntaje, int posXCarro, int posXPopo, int posYPopo, int velXPopo, int velYPopo, int vidas) {
		this.puntaje = puntaje;
                this.posXCarro = posXCarro;
                this.posXPopo = posXPopo;
                this.posYPopo = posYPopo;
                this.velXPopo = velXPopo;
                this.velYPopo = velYPopo;
                this.vidas = vidas;
	}
        
                                        	/**
	 * Metodo modificador usado para cambiar el puntaje del objeto
	 * @param puntaje es el <code>puntaje</code> del objeto.
	 */
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	/**
	 * Metodo de acceso que regresa el puntaje del objeto 
	 * @return puntaje es el <code>puntaje</code> del objeto.
	 */
	public int getVidas() {
		return vidas;
	}
        
                                	/**
	 * Metodo modificador usado para cambiar el puntaje del objeto
	 * @param puntaje es el <code>puntaje</code> del objeto.
	 */
	public void setvelYPopo(int velYPopo) {
		this.velYPopo = velYPopo;
	}

	/**
	 * Metodo de acceso que regresa el puntaje del objeto 
	 * @return puntaje es el <code>puntaje</code> del objeto.
	 */
	public int getvelYPopo() {
		return velYPopo;
	}
        
                        	/**
	 * Metodo modificador usado para cambiar el puntaje del objeto
	 * @param puntaje es el <code>puntaje</code> del objeto.
	 */
	public void setvelXPopo(int velXPopo) {
		this.velXPopo = velXPopo;
	}

	/**
	 * Metodo de acceso que regresa el puntaje del objeto 
	 * @return puntaje es el <code>puntaje</code> del objeto.
	 */
	public int getvelXPopo() {
		return velXPopo;
	}
        
                	/**
	 * Metodo modificador usado para cambiar el puntaje del objeto
	 * @param puntaje es el <code>puntaje</code> del objeto.
	 */
	public void setposYPopo(int posYPopo) {
		this.posYPopo = posYPopo;
	}

	/**
	 * Metodo de acceso que regresa el puntaje del objeto 
	 * @return puntaje es el <code>puntaje</code> del objeto.
	 */
	public int getposYPopo() {
		return posYPopo;
	}
        
        	/**
	 * Metodo modificador usado para cambiar el puntaje del objeto
	 * @param puntaje es el <code>puntaje</code> del objeto.
	 */
	public void setposXPopo(int posXPopo) {
		this.posXPopo = posXPopo;
	}

	/**
	 * Metodo de acceso que regresa el puntaje del objeto 
	 * @return puntaje es el <code>puntaje</code> del objeto.
	 */
	public int getposXPopo() {
		return posXPopo;
	}

        	/**
	 * Metodo modificador usado para cambiar el puntaje del objeto
	 * @param puntaje es el <code>puntaje</code> del objeto.
	 */
	public void setposXCarro(int posXCarro) {
		this.posXCarro = posXCarro;
	}

	/**
	 * Metodo de acceso que regresa el puntaje del objeto 
	 * @return puntaje es el <code>puntaje</code> del objeto.
	 */
	public int getposXCarro() {
		return posXCarro;
	}



	/**
	 * Metodo modificador usado para cambiar el puntaje del objeto
	 * @param puntaje es el <code>puntaje</code> del objeto.
	 */
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	/**
	 * Metodo de acceso que regresa el puntaje del objeto 
	 * @return puntaje es el <code>puntaje</code> del objeto.
	 */
	public int getPuntaje() {
		return puntaje;
	}

	/**
	 * Metodo que regresa el objeto en formato String 
	 * @return un objeto de la clase <code>String</code>.
	 */
	public String toString(){
		return "" + getPuntaje() + "," + getposXCarro() + ","
                         + getposXPopo() + "," + getposYPopo() + "," 
                        + getvelXPopo() + "," + getvelYPopo() + ","
                        + getVidas();
	}
}
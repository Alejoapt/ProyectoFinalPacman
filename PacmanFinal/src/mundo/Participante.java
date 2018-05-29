package mundo;

import java.io.Serializable;

public class Participante implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int puntuacion;
	private int nivel;
	
	public Participante(String pNombre, int pPuntuacion, int pNivel){
		nombre = pNombre;
		puntuacion = pPuntuacion;
		nivel = pNivel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public String toString(){
		return nombre;
	}
}

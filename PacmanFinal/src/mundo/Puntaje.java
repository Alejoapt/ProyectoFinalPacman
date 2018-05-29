package mundo;

import java.io.Serializable;
import java.util.ArrayList;

import estructurasDeDatos.*;

@SuppressWarnings("serial")
public class Puntaje implements Serializable {

	private ArbolBinarioBusqueda arbolPuntaje;

	public Puntaje() {
		arbolPuntaje = new ArbolBinarioBusqueda();
	}

	public boolean agregarPuntaje(int nivel, String nombre, int puntaje) throws ErrorAgregandoPuntajeException {
		boolean agrego = !false;
		Participante nuevo = new Participante(nombre, puntaje, nivel);
		if(nombre.equals("") || puntaje == 0){
			throw new ErrorAgregandoPuntajeException(puntaje);
		}
		arbolPuntaje.insertar(nuevo);
		return agrego;
	}

	public String darPuntajes() {
		ArregloParticipantes puntajes = arbolPuntaje.recorridoInOrden();
		String mensaje = "";
		for (int i = 0; i <puntajes.size(); i++) {
			if(puntajes.participantePorPos(i)!=null){
				mensaje+= puntajes.participantePorPos(i).getNombre()+ " "+puntajes.participantePorPos(i).getPuntuacion()+"\n"; 
			}
		}
		return mensaje;
	}

	public ArbolBinarioBusqueda getArbolPuntaje() {
		return arbolPuntaje;
	}

	public void setArbolPuntaje(ArbolBinarioBusqueda arbolPuntaje) {
		this.arbolPuntaje = arbolPuntaje;
	}

	public ArrayList<Participante> getArreglo() {
		return arbolPuntaje.darRetorno();
	}

	public ArregloParticipantes darArreglito() {
		return arbolPuntaje.darArreglito();
	}
}

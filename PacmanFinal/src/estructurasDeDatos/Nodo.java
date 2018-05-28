package estructurasDeDatos;

import java.io.Serializable;

import mundo.Participante;

@SuppressWarnings("serial")
public class Nodo implements Serializable {

	private Nodo der;
	private Nodo izq;
	Participante participante;

	public Nodo(Participante par) {
		der = null;
		izq = null;
		participante = par;
	}

	public Nodo insertar(Participante a, Nodo nodoActual) {
		if (nodoActual == null) {
			nodoActual = new Nodo(a);
		} else {
			if (a.getPuntuacion() <= nodoActual.dato().getPuntuacion()) {
				nodoActual.cambiarIzq(insertar(a, nodoActual.izq()));
			} else if (a.getPuntuacion() > nodoActual.dato().getPuntuacion()) {
				nodoActual.cambiarDer(insertar(a, nodoActual.der()));
			}
		}
		return nodoActual;
	}

	public boolean isHoja() {
		boolean hoja = false;
		if (der == null && izq == null)
			hoja = true;

		return hoja;
	}

	public Nodo der() {
		return der;
	}

	public void cambiarIzq(Nodo nuevo) {
		izq = nuevo;
	}

	public void cambiarDer(Nodo nuevo) {
		der = nuevo;
	}

	public Nodo izq() {
		return izq;
	}

	public Participante dato() {
		return participante;
	}
}

package estructurasDeDatos;

import mundo.Enemigo;

public class NodoEnemigos {

	private NodoEnemigos der;
	private NodoEnemigos izq;
	Enemigo enemigo;

	public NodoEnemigos(Enemigo par) {
		der = null;
		izq = null;
		enemigo = par;
	}

	public NodoEnemigos insertar(Enemigo a, NodoEnemigos nodoActual) {
		if (nodoActual == null) {
			nodoActual = new NodoEnemigos(a);
		} else {
			if (a.getNombre().compareTo(nodoActual.dato().getNombre()) <= 0) {
				nodoActual.cambiarIzquierda(insertar(a, nodoActual.izq()));
			} else if (a.getNombre().compareTo(nodoActual.dato().getNombre()) >0) {
				nodoActual.cambiarDerecha(insertar(a, nodoActual.der()));
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

	public NodoEnemigos der() {
		return der;
	}

	public void cambiarIzquierda(NodoEnemigos nuevo) {
		izq = nuevo;
	}

	public void cambiarDerecha(NodoEnemigos nuevo) {
		der = nuevo;
	}

	public NodoEnemigos izq() {
		return izq;
	}

	public Enemigo dato() {
		return enemigo;
	}
}

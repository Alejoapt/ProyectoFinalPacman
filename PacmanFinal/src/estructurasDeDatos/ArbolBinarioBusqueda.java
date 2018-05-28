package estructurasDeDatos;

import java.io.Serializable;
import java.util.ArrayList;

import mundo.*;

@SuppressWarnings("serial")
public class ArbolBinarioBusqueda implements Serializable {

	public Nodo raiz;
	private ArrayList<Participante> retorno;
	private ArregloParticipantes arregloAux;

	public ArbolBinarioBusqueda() {
		raiz = null;
		retorno = new ArrayList<Participante>();
		arregloAux = new ArregloParticipantes();
	}

	public void insertar(Participante a) {
		if (raiz == null) {
			raiz = new Nodo(a);
			;
		} else {
			raiz.insertar(a, raiz);
		}
	}

	public ArrayList<Participante> recorridoInOrden() {
		retorno = InOrder(raiz);
		for (int i = 0; i < retorno.size(); i++) {
			arregloAux.agregarAlFinal(retorno.get(i));
		}
		return retorno;
	}

	public ArrayList<Participante> PostOrder(Nodo actual){
		if(actual !=  null) {
			PostOrder(actual.izq());
			PostOrder(actual.der());
			retorno.add(actual.dato());
		}
		return retorno;
		
	}
	
	public ArrayList<Participante> InOrder(Nodo actual) {
		if (actual != null) {
			InOrder(actual.izq());
			if (!buscarNodo(actual.dato())) {
				retorno.add(actual.dato());
			}
			InOrder(actual.der());
		}
		return retorno;
	}

	// TODO
	public boolean eliminarNodo(Nodo actual) {
		boolean elimino = false;
		if (actual != null) {
			if (buscarNodo(actual.dato())) {
				if (actual.isHoja()) {
					actual = null;
				} else {
					if (actual.izq() != null && actual.der() == null) {
						actual = actual.der();
						eliminarNodo(actual.der());

					}
					if (actual.der() != null && actual.izq() == null) {
						actual = actual.izq();
						eliminarNodo(actual.izq());
					}
					if (actual.der() != null && actual.izq() != null) {
						actual = actual.der().izq();
						eliminarNodo(actual.der().izq());
					}
				}
			}

		}
		return elimino;
	}

	private boolean buscarNodo(Participante pPersona) {
		boolean encontrado = false;
		for (int i = 0; i < retorno.size() && !encontrado; i++) {
			if (retorno.get(i) != null) {
				if (retorno.get(i).getNombre().equals(pPersona.getNombre())
						&& retorno.get(i).getPuntuacion() == pPersona.getPuntuacion()) {
					encontrado = true;
				}
			}
		}
		return encontrado;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public ArrayList<Participante> darRetorno() {
		return retorno;
	}

	public ArregloParticipantes darArreglito() {
		return arregloAux;
	}
}

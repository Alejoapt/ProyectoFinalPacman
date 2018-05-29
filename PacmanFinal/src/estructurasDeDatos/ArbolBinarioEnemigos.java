package estructurasDeDatos;

import java.io.Serializable;
import java.util.ArrayList;

import mundo.Enemigo;

@SuppressWarnings("serial")
public class ArbolBinarioEnemigos implements Serializable{
	


	public NodoEnemigos raiz;
	private ArrayList<Enemigo> retorno;
	private ArregloEnemigos arregloAux;

	public ArbolBinarioEnemigos() {
		
		raiz = null;
		retorno = new ArrayList<Enemigo>();
		arregloAux = new ArregloEnemigos();
	}
 
	public void insertar(Enemigo a) {
		if (raiz == null) {
			raiz = new NodoEnemigos(a);
			;
		} else {
			raiz.insertar(a, raiz);
		}
	}

	public ArrayList<Enemigo> recorridoInOrden() {
		retorno = InOrder(raiz);
		for (int i = 0; i < retorno.size(); i++) {
			arregloAux.agregarAlFinal(retorno.get(i));
		}
		return retorno;
	}

	public ArrayList<Enemigo> PostOrder(NodoEnemigos actual){
		if(actual !=  null) {
			PostOrder(actual.izq());
			PostOrder(actual.der());
			retorno.add(actual.dato());
		}
		return retorno;
		
	}
	
	public ArrayList<Enemigo> InOrder(NodoEnemigos actual) {
		if (actual != null) {
			InOrder(actual.izq());
			if (!buscarNodoEnemigo(actual.dato())) {
				retorno.add(actual.dato());
			}
			InOrder(actual.der());
		}
		return retorno;
	}

	public boolean eliminarNodo(NodoEnemigos actual) {
		boolean elimino = false;
		if (actual != null) {
			if (buscarNodoEnemigo(actual.dato())) {
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

	private boolean buscarNodoEnemigo(Enemigo eEnemigo) {
		boolean encontrado = false;
		for (int i = 0; i < retorno.size() && !encontrado; i++) {
			if (retorno.get(i) != null) {
				if (retorno.get(i).getNombre().equals(eEnemigo.getNombre())
						&& retorno.get(i).getNombre().equals(eEnemigo.getNombre())) {
					encontrado = true;
				}
			}
		}
		return encontrado;
	}

	public NodoEnemigos getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoEnemigos raiz) {
		this.raiz = raiz;
	}

	public ArrayList<Enemigo> darRetorno() {
		return retorno;
	}

	public ArregloEnemigos darArreglito() {
		return arregloAux;
	}


}

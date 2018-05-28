package estructurasDeDatos;

import java.io.Serializable;

import mundo.Enemigo;


public class ArregloEnemigos implements Serializable{

	private static final long serialVersionUID = 1L;
	private Enemigo[] enemigo;
	private int tamanioInicial;

	public ArregloEnemigos(int pTamanioInicial) {
		tamanioInicial = pTamanioInicial;
		enemigo = new Enemigo[tamanioInicial];
	}

	public ArregloEnemigos() {
		tamanioInicial = 10;
		enemigo = new Enemigo[tamanioInicial];
	}

	public void agregarEnPos(int pos, Enemigo nuevo) {
		enemigo[pos] = nuevo;
		ordenarArreglo();
	}

	public void agregarAlFinal(Enemigo nuevo) {
		if (enemigo[enemigo.length - 1] != null) {
			aumentarTamanio();
			enemigo[enemigo.length - 1] = nuevo;
			ordenarArreglo();
		} else {
			enemigo[enemigo.length - 1] = nuevo;
			eliminarNulos();
			ordenarArreglo();
		}
	}

	private void aumentarTamanio() {
		Enemigo[] tmp = new Enemigo[tamanioInicial];
		for (int i = 0; i < enemigo.length; i++) {
			tmp[i] = enemigo[i];
		}
		enemigo = new Enemigo[tamanioInicial + 1];
		tamanioInicial++;
		for (int i = 0; i < tmp.length; i++) {
			enemigo[i] = tmp[i];
		}
	}

	public Enemigo participantePorPos(int pos) {
		return enemigo[pos];
	}

	public void eliminarEnPos(int pos) {
		enemigo[pos] = null;
		eliminarNulos();
	}

	private void eliminarNulos() {
		for (int i = 0; i < enemigo.length; i++) {
			if (enemigo[i] == null)
				correrElementos(i);
		}
	}

	private void correrElementos(int i) {
		for (int j = i; j < enemigo.length - 1; j++) {
			enemigo[j] = enemigo[j + 1];
		}
		enemigo[enemigo.length - 1] = null;
	}


	public Enemigo buscarParticipante(Enemigo dato) {
		int pos = -1;
		int inicio = 0;
		Enemigo retornado = null;
		int fin = enemigo.length - 1;
		while (inicio <= fin && pos == -1) {
			int medio = (inicio + fin) / 2;
			Enemigo mitad = (Enemigo) enemigo[medio];
			if (mitad != null) {
				if (mitad.getNombre().compareTo(dato.getNombre()) == 0) {
					pos = medio;
					retornado = enemigo[0];
				} else if (mitad.getNombre().compareTo(dato.getNombre()) > 0) {
					fin = medio - 1;
				} else {
					inicio = medio + 1;
				}
			}
		}

		return retornado;
	}

	// TODO
	public int buscarPorNombre(String nombre) {
		int retorno = -1;
		boolean encontrado = false;
		for (int i = 0; i < enemigo.length && !encontrado; i++) {
			if (enemigo[i] != null) {
				if (enemigo[i].getNombre().equals(nombre)) {
					retorno = i;
					encontrado = true;
				}
			}
		}
		return retorno;
	}

	public void ordenarArreglo() {
		for (int i = 0; i < enemigo.length - 1; i++) {
			for (int j = i; j < enemigo.length; j++) {
				if (enemigo[j] != null && enemigo[j + 1] != null) {
					if (enemigo[j].getNombre().compareTo(enemigo[j + 1].getNombre())>0) {
						Enemigo tmp = enemigo[j];
						enemigo[j] = enemigo[j + 1];
						enemigo[j + 1] = tmp;
					}
				}
			}
		}
	}
	
	public void ordenarArregloSeleccionDificultad(){
        int i, j, menor, pos;
        Enemigo tmp;
        for (i = 0; i < enemigo.length - 1; i++) { 
              menor = enemigo[i].getDificultad();
              pos = i; 
              for (j = i + 1; j < enemigo.length; j++){
                    if (enemigo[j].getDificultad() < menor) {
                        menor = enemigo[j].getDificultad(); 
                        pos = j;
                    }
              }
              if (pos != i){ 
                  tmp = enemigo[i];
                  enemigo[i]= enemigo[pos];
                  enemigo[pos] = tmp;
              }
        }
	}
	
	public void ordenarArregloNombre() {
		for (int i = 0; i < enemigo.length - 1; i++) {
			for (int j = i; j < enemigo.length; j++) {
				if (enemigo[j] != null && enemigo[j + 1] != null) {
					if (enemigo[j].getNombre().compareTo(enemigo[j + 1].getNombre()) > 0) {
						Enemigo tmp = enemigo[j];
						enemigo[j] = enemigo[j + 1];
						enemigo[j + 1] = tmp;
					}
				}
			}
		}
	}

	public int size() {
		return tamanioInicial;
	}
}

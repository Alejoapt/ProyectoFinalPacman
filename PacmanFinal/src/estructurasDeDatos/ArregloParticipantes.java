package estructurasDeDatos;

import java.io.Serializable;

import mundo.Participante;

@SuppressWarnings("serial")
public class ArregloParticipantes implements Serializable {

	private Participante[] participantes;
	private int tamanioInicial;

	public ArregloParticipantes(int pTamanioInicial) {
		tamanioInicial = pTamanioInicial;
		participantes = new Participante[tamanioInicial];
	}

	public ArregloParticipantes() {
		tamanioInicial = 20;
		participantes = new Participante[tamanioInicial];
	}

	public void agregarEnPos(int pos, Participante nuevo) {
		participantes[pos] = nuevo;
		ordenarArregloPuntos();
	}

	public void agregarAlFinal(Participante nuevo) {
		if (participantes[participantes.length - 1] != null) {
			aumentarTamanio();
			participantes[participantes.length - 1] = nuevo;
			ordenarArregloNombre();
		} else {
			participantes[participantes.length - 1] = nuevo;
			eliminarNulos();
			ordenarArregloNombre();
		}
	}

	private void aumentarTamanio() {
		Participante[] tmp = new Participante[tamanioInicial];
		for (int i = 0; i < participantes.length; i++) {
			tmp[i] = participantes[i];
		}
		participantes = new Participante[tamanioInicial + 1];
		tamanioInicial++;
		for (int i = 0; i < tmp.length; i++) {
			participantes[i] = tmp[i];
		}
	}

	public Participante participantePorPos(int pos) {
		return participantes[pos];
	}

	public void eliminarEnPos(int pos) {
		participantes[pos] = null;
		eliminarNulos();
	}

	private void eliminarNulos() {
		for (int i = 0; i < participantes.length; i++) {
			if (participantes[i] == null)
				correrElementos(i);
		}
	}

	private void correrElementos(int i) {
		for (int j = i; j < participantes.length - 1; j++) {
			participantes[j] = participantes[j + 1];
		}
		participantes[participantes.length - 1] = null;
	}


	public Participante buscarParticipanteNombre(String Nombre) {
		int pos = -1;
		int inicio = 0;
		Participante retornado = null;
		int fin = participantes.length - 1;
		listar();
		ordenarArregloNombre();
		while (inicio <= fin && pos == -1) {
			int medio = (inicio + fin) / 2;
			Participante mitad = (Participante) participantes[medio];
			if (mitad != null) {
				if (mitad.getNombre().compareTo(Nombre) == 0) {
					pos = medio;
					retornado = mitad;
				} else if (mitad.getNombre().compareTo(Nombre) > 0) {
					fin = medio - 1;
				} else {
					inicio = medio + 1;
				}
			}
		}
		deslistar();
		return retornado;
	}

	public Participante buscarParticipanteCodigo(int codigo) {
		int pos = -1;
		int inicio = 0;
		Participante retornado = null;
		int fin = participantes.length - 1;
		listar();
		ordenarArregloPuntos();
		while (inicio <= fin && pos == -1) {
			int medio = (inicio + fin) / 2;
			Participante mitad = (Participante) participantes[medio];
			if (mitad != null) {
				if (mitad.getPuntuacion()-codigo == 0) {
					pos = medio;
					retornado = mitad;
				} else if (mitad.getPuntuacion()-codigo > 0) {
					fin = medio - 1;
				} else {
					inicio = medio + 1;
				}
			}
		}
		deslistar();
		return retornado;
	}
	
	private void deslistar() {
		for (int i = 0; i < participantes.length; i++) {
			if(participantes[i]!=null && participantes[i].getNombre().equals(""))
				participantes[i]=null;
		}
	}

	private void listar() {
		for (int i = 0; i < participantes.length; i++) {
			if(participantes[i]==null)
				participantes[i]=new Participante("",0,0);
		}
	}

	public int buscarPorNombre(String nombre) {
		int retorno = -1;
		boolean encontrado = false;
		for (int i = 0; i < participantes.length && !encontrado; i++) {
			if (participantes[i] != null) {
				if (participantes[i].getNombre().equals(nombre)) {
					retorno = i;
					encontrado = true;
				}
			}
		}
		return retorno;
	}
	
	public int buscarPorPuntuacion(int puntuacion) {
		int retorno = -1;
		boolean encontrado = false;
		for (int i = 0; i < participantes.length && !encontrado; i++) {
			if (participantes[i] != null) {
				if (participantes[i].getPuntuacion() == (puntuacion)) {
					retorno = i;
					encontrado = true;
				}
			}
		}
		return retorno;
	}

	public void ordenarArregloNombre() {
		for (int i = 0; i < participantes.length - 1; i++) {
			for (int j = i; j < participantes.length-1; j++) {
				if (participantes[j] != null && participantes[j + 1] != null) {
					if (participantes[j].getNombre().compareTo(participantes[j + 1].getNombre())>0) {
						Participante tmp = participantes[j];
						participantes[j] = participantes[j + 1];
						participantes[j + 1] = tmp;
					}
				}
			}
		}
	}
	
	public void ordenarArregloPuntos() {
		for (int i = 0; i < participantes.length - 1; i++) {
			for (int j = i; j < participantes.length-1; j++) {
				if (participantes[j] != null && participantes[j + 1] != null) {
					if (participantes[j].getPuntuacion()-participantes[j + 1].getPuntuacion()>0) {
						Participante tmp = participantes[j];
						participantes[j] = participantes[j + 1];
						participantes[j + 1] = tmp;
					}
				}
			}
		}
	}
	
	public void ordenarArregloS(){
        int i, j, menor, pos;
        Participante tmp;
        for (i = 0; i < participantes.length - 1; i++) { 
              menor = participantes[i].getNivel();
              pos = i; 
              for (j = i + 1; j < participantes.length; j++){
                    if (participantes[j].getNivel() < menor) {
                        menor = participantes[j].getNivel(); 
                        pos = j;
                    }
              }
              if (pos != i){ 
                  tmp = participantes[i];
                  participantes[i]= participantes[pos];
                  participantes[pos] = tmp;
              }
        }
	}
	
	public void ordenarArregloPunt() {
		for (int i = 0; i < participantes.length - 1; i++) {
			for (int j = i; j < participantes.length; j++) {
				if (participantes[j] != null && participantes[j + 1] != null) {
					if (participantes[j].getPuntuacion() > (participantes[j + 1].getPuntuacion())) {
						Participante tmp = participantes[j];
						participantes[j] = participantes[j + 1];
						participantes[j + 1] = tmp;
					}
				}
			}
		}
	}

	public int size() {
		return participantes.length;
	}
}

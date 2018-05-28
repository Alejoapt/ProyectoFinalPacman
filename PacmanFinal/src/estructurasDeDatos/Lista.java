package estructurasDeDatos;

public class Lista {
	private NodoLista primero;

	public Lista() {
		primero = null;
	}

	public void agregar(String pRuta) {
		if (primero == null) {
			primero = new NodoLista(pRuta);
		} else {
			NodoLista tmp = primero;
			while (tmp.getSiguiente() != null) {
				tmp = tmp.getSiguiente();
			}
			tmp.setSiguiente(new NodoLista(pRuta));
		}
	}

	public NodoLista buscar(int numero) {

		NodoLista tmp = primero;
		for (int i = 0; i < numero; i++) {
			tmp = tmp.getSiguiente();
		}
		return tmp;
	}
}

package estructurasDeDatos;

public class NodoLista {
	    
	    private String ruta;
	    private NodoLista siguiente;
	    private Lista enemigos;
	 
	    public Lista getEnemigos() {
			return enemigos;
		}

		public void setEnemigos(Lista enemigos) {
			this.enemigos = enemigos;
		}

		public NodoLista(String t){
	        siguiente = null;
	        enemigos=null;
	        ruta = t;
	    }
	     
	    public String getDato() {
	        return ruta;
	    }
	 
	    public void setDato(String dato) {
	        this.ruta = dato;
	    }
	 
	    public NodoLista getSiguiente() {
	        return siguiente;
	    }
	 
	    public void setSiguiente(NodoLista siguiente) {
	        this.siguiente = siguiente;
	    }
	     
	}

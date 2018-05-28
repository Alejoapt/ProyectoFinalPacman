package mundo;

public class MapaIncorrectoException extends Exception {

	private static final long serialVersionUID = 1L;

	public MapaIncorrectoException(){
		super("El mapa cargado es invalido");
	}

}

package mundo;

@SuppressWarnings("serial")
public class LaRutaMusicalEsInvalidaException extends Exception{
	
	public LaRutaMusicalEsInvalidaException() {
		super("La ruta musical actual no puede ser reproducida por favor asegurese de usar una ruta valida");
	}

}

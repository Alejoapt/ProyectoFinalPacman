package mundo;

@SuppressWarnings("serial")
public class ErrorAgregandoPuntajeException extends Exception{

	public ErrorAgregandoPuntajeException(int puntaje) {
		super("Error al intentar agregar el jugador con un puntaje de: " + puntaje + "" + "\n" + "debido a que no digito su nombre");
	}
}

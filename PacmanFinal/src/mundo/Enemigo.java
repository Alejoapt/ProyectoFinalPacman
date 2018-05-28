package mundo;

public class Enemigo {

	public static final String FANTASMA = "./data/imagenes/fantasma";

	public static final String KOOPA = "./data/imagenes/Koopa";

	public static final String BOMBAS = "./data/imagenes/Bomber";
	
	private String nombre;

	private String imagen;

	private int dificultad;

	public Enemigo(String nombre, String imagen, int dificultad) {
		this.nombre = nombre;
		this.imagen = imagen;
		this.dificultad = dificultad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	

}

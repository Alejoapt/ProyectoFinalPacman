package mundo;

public class Personaje {

	public static final String PACMAN = "./data/imagenes/personaje.gif";

	public static final String MARIO = "./data/imagenes/Mario.png";

	public static final String BOMBER_MAN = "./data/imagenes/Bomber.jpg";

	private String nombre;

	private String imagen;

	public Personaje(String nombre, String imagen) {
		this.nombre = nombre;
		this.imagen = imagen;
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

}

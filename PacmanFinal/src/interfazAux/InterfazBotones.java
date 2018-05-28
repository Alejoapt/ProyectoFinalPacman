package interfazAux;

import javax.swing.*;

import estructurasDeDatos.Lista;
import interfaz.InterfazLaberinto;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import mundo.Enemigo;
import mundo.ErrorAgregandoPuntajeException;
import mundo.LaRutaMusicalEsInvalidaException;
import mundo.ManejoMundo;
import mundo.Participante;
import mundo.Personaje;
import mundo.Puntaje;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@SuppressWarnings("serial")
public class InterfazBotones extends JFrame {

	private static final String RUTA_MENU = "data/musica/pacman_musica.wav";

	private static final String RUTA_JUEGO = "data/musica/pacman_chomp.wav";

	public final static String RUTA_PUNTAJE = "./data/puntaje.laberinto";

	private Lista listaPersonajes;

	private Lista listaFantasmas;

	private Lista listaKoopas;

	private File file;

	private Puntaje puntaje;

	private Lista listaBombas;

	private PanelCambiarPersonaje personajes;

	private PanelBackground background;

	private BasicPlayer player;

	private InterfazLaberinto interfazPrincipal;

	private PanelAux panelAux;

	public InterfazBotones() throws IOException, LaRutaMusicalEsInvalidaException {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		player = new BasicPlayer();
		sonidoMenu();
		crearPuntaje();
		personajes = new PanelCambiarPersonaje(this);
		background = new PanelBackground(this);
		panelAux = new PanelAux(this);
		setLayout(new BorderLayout());
		setResizable(false);
		listaPersonajes = new Lista();
		listaKoopas = new Lista();
		listaFantasmas = new Lista();
		listaBombas = new Lista();
		llenarLista();
		add(background, BorderLayout.CENTER);
		add(panelAux, BorderLayout.SOUTH);
		pack();
	}

	private void llenarLista() {
		for (int i = 1; i <= 4; i++) {
			listaKoopas.agregar(Enemigo.KOOPA + i + ".png");
			listaFantasmas.agregar(Enemigo.FANTASMA + i + ".jpg");
			listaBombas.agregar(Enemigo.BOMBAS + i + ".jpg");
		}
		listaPersonajes.agregar(Personaje.PACMAN);
		listaPersonajes.buscar(0).setEnemigos(listaFantasmas);
		listaPersonajes.agregar(Personaje.MARIO);
		listaPersonajes.buscar(1).setEnemigos(listaKoopas);
		listaPersonajes.agregar(Personaje.BOMBER_MAN);
		listaPersonajes.buscar(2).setEnemigos(listaBombas);
	}

	public void sonidoMenu() throws LaRutaMusicalEsInvalidaException {
		File file = new File(RUTA_MENU);
		if (!file.canExecute()) {
			throw new LaRutaMusicalEsInvalidaException();
		} else {
			try {
				player.open(file);
				player.play();
			} catch (BasicPlayerException pExcepcion) {

			}
		}

	}

	public void stopMenu() {
		try {
			player.stop();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	public void stopJuego() {
		try {
			player.stop();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	public Lista getLista() {
		return listaPersonajes;
	}

	public void setLista(Lista lista) {
		this.listaPersonajes = lista;
	}

	public void nuevo() throws IOException {
		setVisible(false);
		File archivo = new File(ManejoMundo.RUTA_DEFAULT);
		file = new File(RUTA_JUEGO);
		interfazPrincipal = new InterfazLaberinto(this, archivo, personajes.getEnemigoActual(),
				personajes.getPersonajeActual(), "./data/imagenes/personajeCome.gif", file, puntaje);
		interfazPrincipal.setVisible(true);
	}

	public void cargar() throws IOException {
		setVisible(false);
		File f = null;
		JFileChooser fileCh = new JFileChooser("./data/niveles");
		int opcion = fileCh.showOpenDialog(this);
		switch (opcion) {
		case JFileChooser.APPROVE_OPTION:
			f = fileCh.getSelectedFile();
			break;
		case JFileChooser.CANCEL_OPTION:
			break;
		case JFileChooser.ERROR_OPTION:
			break;
		}
		file = new File(RUTA_JUEGO);
		interfazPrincipal = new InterfazLaberinto(this, f, personajes.getEnemigoActual(),
				personajes.getPersonajeActual(), "./data/imagenes/personajeCome.gif", file, puntaje);
		interfazPrincipal.setVisible(true);
	}

	public void cambiarPersonaje() {
		add(personajes, BorderLayout.EAST);
		pack();
	}
	
//	public void abrir

	public void crearPuntaje() {
		File file = new File(RUTA_PUNTAJE);
		if (file.exists()) {
			try {
				ObjectInputStream is = new ObjectInputStream(new FileInputStream(RUTA_PUNTAJE));
				puntaje = (Puntaje) is.readObject();
				is.close();
			} catch (Exception e) {
				e.getMessage();
			}
		} else {
			puntaje = new Puntaje();
		}
	}

	public void guardarPuntaje() throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_PUNTAJE));
		oos.writeObject(puntaje);
		oos.close();
	}

	public void mostrarPuntajes() throws Exception {
		try {
			String puntajes = "";
			if (puntaje.getArreglo() != null) {
				puntajes = "Puntajes\n" + puntaje.darPuntajes();
			}
			JOptionPane.showMessageDialog(this, puntajes);
		} catch (Exception e) {
		}

	}

	public void aiuda() {
		this.setVisible(true);
		try {
			player.play();
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException, LaRutaMusicalEsInvalidaException {
		InterfazBotones interfaz = new InterfazBotones();
		interfaz.setVisible(true);
	}

	public void guardar(int puntajeActual, String nombre, int i) throws ErrorAgregandoPuntajeException {
		puntaje.agregarPuntaje(0, nombre, puntajeActual);
	}

	public void dispose() {
		try {
			guardarPuntaje();
			super.dispose();
		} catch (Exception e) {
			setVisible(true);
			int respuesta = JOptionPane.showConfirmDialog(this, "Problemas salvando la informacion:\n" + e.getMessage()
					+ "\n¿Quiere cerrar el programa sin salvar?", "Error", JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
				super.dispose();
			}
		}

	}

	public void buscar() {
		String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del jugador a buscar");
		if (nombre != null && !nombre.equals("")) {
			int tmp = puntaje.darArreglito().buscarPorNombre(nombre);
			if (tmp >= 0) {
				Participante buscado = puntaje.darArreglito().participantePorPos(tmp);
				JOptionPane.showMessageDialog(this,
						("El jugador: " + nombre + "\n" + "Tiene una puntuacion de: " + buscado.getPuntuacion()));
			} else {
				JOptionPane.showMessageDialog(this, "El jugador solicitado no existe");
			}
		} else {
			JOptionPane.showMessageDialog(this, "El nombre del jugador no esta correctamente escrito");
		}
	}
}

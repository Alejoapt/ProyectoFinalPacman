package interfaz;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hilos.*;
import interfazAux.*;
import mundo.*;

@SuppressWarnings("serial")
public class InterfazLaberinto extends JFrame implements KeyListener {

	private PanelMatriz matriz;

	private String rutaEnemigo;

	private String rutaPersonaje;

	private PanelInformacion info;

	private HiloEnemigo1 hiloEnemigo;

	private HiloEnemigo2 hiloEnemigo2;

	private HiloRefrescar refrescar;

	private File archivo;

	private HiloCronometro cronometro;

	private HiloMusica hiloMusica;

	private ManejoMundo manejoMundo;

	private HiloAnimacion anima;

	private InterfazBotones interfazBotones;

	private String rutaPersonajeCome;

	private HiloEnemigo3 hiloEnemigo3;

	private int hizo;

	public InterfazLaberinto(InterfazBotones p, File ruta, String pRutaEnemigo, String pRutaPersonaje,
			String pRutaPersonajeCome, File archivito, Puntaje puntaje) throws IOException {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		interfazBotones = p;
		rutaEnemigo = pRutaEnemigo;
		rutaPersonaje = pRutaPersonaje;
		rutaPersonajeCome = pRutaPersonajeCome;
		archivo = archivito;
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		manejoMundo = new ManejoMundo(ruta, pRutaEnemigo, pRutaEnemigo);
		matriz = new PanelMatriz(manejoMundo.getMatriz(), this, rutaEnemigo, rutaPersonaje, rutaPersonajeCome);
		info = new PanelInformacion(this);
		add(info, BorderLayout.NORTH);
		add(matriz, BorderLayout.CENTER);
		iniciarHilos();
		addKeyListener(this);
		pack();

	}
	
	public void dispose() {
		try {
			salir();
		} catch (Exception e) {
			setVisible(true);
			int respuesta = JOptionPane.showConfirmDialog(this, "Problemas salvando la información:\n" + e.getMessage()
					+ "\n¿Quiere cerrar el programa sin salvar?", "Error", JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
				super.dispose();
				interfazBotones.setVisible(true);
			}
		}
	}

	public void salir() {
		int opcion;
			opcion = JOptionPane.showConfirmDialog(this, "¿Desea guardar el juego actual antes de salir?");
			if (opcion == JOptionPane.YES_OPTION) {
				manejoMundo.setEnJuego(false);
				manejoMundo.setGano(false);
				guardarArchivo();
				setVisible(false);
				interfazBotones.aiuda();
			}else if(opcion == JOptionPane.NO_OPTION) {
				setVisible(false);
				interfazBotones.aiuda();
			}
	}

	public boolean guardarArchivo() {
		boolean guardoArchivo = false;
		JFileChooser fileCh = new JFileChooser("./data/niveles");
		fileCh.setSelectedFile(new File("Pacman_Guardado" + ".txt"));
		int opcion = fileCh.showSaveDialog(this);

		switch (opcion) {
		case JFileChooser.APPROVE_OPTION:
			File f = fileCh.getSelectedFile();
			try {				
				manejoMundo.guardarJuego(f);
				guardoArchivo = true;
			} catch (Exception ioexc) {
				JOptionPane.showMessageDialog(this,
						"Problemas guardando el archivo\nEs probable que no tenga permisos de escritura o\nel archivo puede estar bloqueado por otro programa.");
			}
			break;
		case JFileChooser.CANCEL_OPTION:
			break;
		case JFileChooser.ERROR_OPTION:
			break;
		}
		return guardoArchivo;
	}

	public void iniciarHilos() {
		refrescar = new HiloRefrescar(this, manejoMundo);
		refrescar.start();
		// Crea e inicia el hilo encargado de mover el enemigo
		// if(matriz.getPosIenemigo1()!=0 && matriz.getPosIenemigo2()!=0){
		hiloEnemigo = new HiloEnemigo1(manejoMundo, matriz.getPosIenemigo1(), matriz.getPosJenemigo1(), this,
				manejoMundo.getDificultad());
		hiloEnemigo2 = new HiloEnemigo2(manejoMundo, matriz.getPosIenemigo2(), matriz.getPosJenemigo2(), this,
				manejoMundo.getDificultad());
		hiloEnemigo3 = new HiloEnemigo3(manejoMundo, matriz.getPosIenemigo3(), matriz.getPosJenemigo3(),
				matriz.getPosIenemigo4(), matriz.getPosJenemigo4(), this, manejoMundo.getDificultad());
		hiloEnemigo.start();
		hiloEnemigo2.start();
		hiloEnemigo3.start();

		anima = new HiloAnimacion(manejoMundo, matriz.getPosI(), matriz.getPosJ(), this);
		anima.start();

		hiloMusica = new HiloMusica(archivo, manejoMundo);
		hiloMusica.start();
		// }
		// Crea e inicia el hilo encargado de administrar el cronometro
		cronometro = new HiloCronometro(this, manejoMundo);
		cronometro.start();

		// Crea e inicia el hilo encargado de refrescar el movimiento de los
		// personajes
	}

	public int darTotal() {
		return info.darTotal();
	}

	public void timer() {
		info.timer();
	}

	public void repaintInfo() {
		info.repaint();
	}

	public void setPosMundo(String pos) {
		manejoMundo.setPosicion(pos);
	}

	public void refrescar() {
		matriz.llenarMatriz();
		matriz.pintarMatriz();

		pack();
		validate();
	}

	public void perdio() {
		JOptionPane.showMessageDialog(this, "GAME OVER");
		interfazBotones.stopJuego();
		guardarPuntaje();
		setVisible(false);
		interfazBotones.aiuda();
	}

	public void gano() {
		JOptionPane.showMessageDialog(this, "Â¡GANASTE!");
		interfazBotones.stopJuego();
		guardarPuntaje();
		setVisible(false);
		interfazBotones.aiuda();
	}

	public void guardarPuntaje() {
		int puntajeActual = darPuntaje();
		String nombre;

		nombre = JOptionPane.showInputDialog(
				"Su puntaje es de de: " + puntajeActual + " \nPor favor digite su nombre para guardarlo:");

		if (nombre != null) {
			try {
				interfazBotones.guardar(puntajeActual, nombre, 1);
			} catch (ErrorAgregandoPuntajeException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		}
	}

	public int darPuntaje() {
		return manejoMundo.calcularPuntaje();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		hizo = e.getKeyCode();
		int[] manejo = manejoMundo.moverPersonaje(e.getKeyCode(), matriz.getPosI(), matriz.getPosJ());
		if (manejo[0] != 0 && manejo[1] != 0) {
			matriz.setPosI(manejo[0]);
			matriz.setPosJ(manejo[1]);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public void moverEnemigo1Abajo(int posInicialI, int posInicialJ) {
		if (posInicialI < manejoMundo.getMatriz().length - 1) {
			int pos = manejoMundo.moverEnemigo1Abajo(posInicialI, posInicialJ);
			hiloEnemigo.setPosInicialI1(pos);
		}
	}

	public void moverEnemigo1Arriba(int posInicialI, int posInicialJ) {
		if (posInicialI > 0) {
			int pos = manejoMundo.moverEnemigo1Arriba(posInicialI, posInicialJ);
			hiloEnemigo.setPosInicialI1(pos);
		}
	}

	public void moverEnemigo2Arriba(int posInicialI1, int posInicialJ1) {
		if (posInicialI1 > 0) {
			int pos = manejoMundo.moverEnemigo2Arriba(posInicialI1, posInicialJ1);
			hiloEnemigo2.setPosInicialI2(pos);
		}
	}

	public void moverEnemigo2Abajo(int posInicialI2, int posInicialJ2) {
		if (posInicialI2 < manejoMundo.getMatriz().length - 1) {
			int pos = manejoMundo.moverEnemigo2Abajo(posInicialI2, posInicialJ2);
			hiloEnemigo2.setPosInicialI2(pos);
		}
	}

	public void moverEnemigo3Der(int posInicialI1, int posInicialJ1, int posInicialI2, int posInicialJ2) {
		if (posInicialJ1 < manejoMundo.getMatriz()[0].length - 4) {
			int pos = manejoMundo.moverEnemigo3Derecha(posInicialI1, posInicialJ1);
			hiloEnemigo3.setPosInicialJ1(pos);
			int pos2 = manejoMundo.moverEnemigo4Izq(posInicialI2, posInicialJ2);
			hiloEnemigo3.setPosInicialJ2(pos2);
		}
	}

	public void moverEnemigo3Izq(int posInicialI1, int posInicialJ1, int posInicialI2, int posInicialJ2) {
		if (posInicialJ1 > 4) {
			int pos = manejoMundo.moverEnemigo3Izq(posInicialI1, posInicialJ1);
			int pos2 = manejoMundo.moverEnemigo4Derecha(posInicialI2, posInicialJ2);
			hiloEnemigo3.setPosInicialJ1(pos);
			hiloEnemigo3.setPosInicialJ2(pos2);
		}
	}

	public void animar1() {
		manejoMundo.animar2(matriz.getPosI(), matriz.getPosJ(), hizo);
	}

	public void animar2() {
		manejoMundo.animar1(matriz.getPosI(), matriz.getPosJ(), hizo);
	}

	public void terminar() {
		interfazBotones.setVisible(true);
		setVisible(false);
		interfazBotones.aiuda();
	}

	public String getRutaPersonaje() {
		return rutaPersonaje;
	}

	public void setRutaPersonaje(String rutaPersonaje) {
		this.rutaPersonaje = rutaPersonaje;
	}

}

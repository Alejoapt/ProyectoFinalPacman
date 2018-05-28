package interfazAux;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import mundo.Personaje;

@SuppressWarnings("serial")
public class PanelCambiarPersonaje extends JPanel implements ActionListener {

	public static final String INCOGNITO = "./data/imagenes/interrogacion.png";

	public static final String SIGUIENTE_PERSONAJE = "--->";

	public static final String ANTERIOR_PERSONAJE = "<---";

	public static final String SIGUIENTE_ENEMIGO = "-->";

	public static final String ANTERIOR_ENEMIGO = "<--";

	private String enemigoActual, personajeActual;

	private JLabel personaje;

	private JLabel enemigo;

	private JButton butSiguientePersonaje;

	private JButton butAnteriorPersonaje;

	private JButton butSiguienteEnemigo;

	private JButton butAnteriorEnemigo;

	private InterfazBotones interfaz;

	private int actual;

	private int eneActual;

	public PanelCambiarPersonaje(InterfazBotones p) throws IOException {
		setLayout(new GridLayout(2, 1));
		setPreferredSize(new Dimension(400, 400));
		interfaz = p;
		enemigoActual = "./data/imagenes/enemigo.gif";
		personajeActual = Personaje.PACMAN;
		eneActual = -1;

		personaje = new JLabel("");
		personaje.setIcon(new ImageIcon(INCOGNITO));

		enemigo = new JLabel();
		enemigo.setIcon(new ImageIcon(INCOGNITO));

		butSiguientePersonaje = new JButton(SIGUIENTE_PERSONAJE);
		butSiguientePersonaje.setActionCommand(SIGUIENTE_PERSONAJE);
		butSiguientePersonaje.addActionListener(this);

		butAnteriorPersonaje = new JButton(ANTERIOR_PERSONAJE);
		butAnteriorPersonaje.setActionCommand(ANTERIOR_PERSONAJE);
		butAnteriorPersonaje.addActionListener(this);

		butSiguienteEnemigo = new JButton(SIGUIENTE_ENEMIGO);
		butSiguienteEnemigo.setActionCommand(SIGUIENTE_ENEMIGO);
		butSiguienteEnemigo.addActionListener(this);
		butSiguienteEnemigo.setEnabled(false);

		butAnteriorEnemigo = new JButton(ANTERIOR_ENEMIGO);
		butAnteriorEnemigo.setActionCommand(ANTERIOR_ENEMIGO);
		butAnteriorEnemigo.addActionListener(this);
		butAnteriorEnemigo.setEnabled(false);

		actual = -1;

		// Definicion del borde
		TitledBorder border = BorderFactory.createTitledBorder("Selecciona tu personaje");
		border.setTitleColor(Color.BLACK);
		JPanel aux = new JPanel();
		aux.setLayout(new FlowLayout());
		aux.setBorder(border);

		
		aux.add(butAnteriorPersonaje, BorderLayout.WEST);
		aux.add(personaje, BorderLayout.CENTER);
		aux.add(butSiguientePersonaje, BorderLayout.EAST);

		// Definicion del borde
		TitledBorder border1 = BorderFactory.createTitledBorder("Selecciona tu enemigo");
		border1.setTitleColor(Color.BLACK);
		JPanel aux1 = new JPanel();
		aux1.setLayout(new FlowLayout());
		aux1.setBorder(border1);

		aux1.add(butAnteriorEnemigo, BorderLayout.WEST);
		aux1.add(enemigo, BorderLayout.CENTER);
		aux1.add(butSiguienteEnemigo, BorderLayout.EAST);

		add(aux);
		add(aux1);

	}

	public void activarEnemigos() {
		butAnteriorEnemigo.setEnabled(true);
		butSiguienteEnemigo.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(ANTERIOR_PERSONAJE)) {
			activarEnemigos();
			if (actual > 0) {
				actual--;
			} else {
				actual = 2;
			}
			setearPersonaje(interfaz.getLista().buscar(actual).getDato());
			enemigo.setIcon(new ImageIcon(INCOGNITO));

		}
		if (comando.equals(SIGUIENTE_PERSONAJE)) {
			activarEnemigos();
			if (actual < 2) {
				actual++;
			} else {
				actual = 0;
			}
			setearPersonaje(interfaz.getLista().buscar(actual).getDato());
			enemigo.setIcon(new ImageIcon(INCOGNITO));
		}
		if (comando.equals(ANTERIOR_ENEMIGO)) {
			if (eneActual > 0) {
				eneActual--;
			} else {
				eneActual = 3;
			}
			setearEnemigo(interfaz.getLista().buscar(actual).getEnemigos().buscar(eneActual).getDato());
		}
		if (comando.equals(SIGUIENTE_ENEMIGO)) {
			if (eneActual < 3) {
				eneActual++;
			} else {
				eneActual = 0;
			}
			setearEnemigo(interfaz.getLista().buscar(actual).getEnemigos().buscar(eneActual).getDato());
		}
	}

	private void setearEnemigo(String imagen) {
		enemigo.setIcon(new ImageIcon(imagen));
		enemigoActual = imagen;
		repaint();
		validate();
	}

	public String getEnemigoActual() {
		return enemigoActual;
	}

	public void setEnemigoActual(String enemigoActual) {
		this.enemigoActual = enemigoActual;
	}

	public String getPersonajeActual() {
		return personajeActual;
	}

	public void setPersonajeActual(String personajeActual) {
		this.personajeActual = personajeActual;
	}

	private void setearPersonaje(String imagen) {
		personaje.setIcon(new ImageIcon(imagen));
		personajeActual = imagen;
		repaint();
		validate();
	}
}

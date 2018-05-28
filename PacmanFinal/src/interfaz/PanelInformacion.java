package interfaz;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class PanelInformacion extends JPanel {

	private int segundos;
	
	private int total;
	
	private InterfazLaberinto ventana;

	public PanelInformacion(InterfazLaberinto v) {
		// minutos = 0;
		ventana = v;
		segundos = 301;
		total = 0;
		setBackground(Color.BLACK);
		setPreferredSize((new Dimension(100, 30)));

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		agregarCronometro(g);
	}

	private void agregarCronometro(Graphics g) {
		Font font2 = new Font("Helvetica", Font.ITALIC, 16);
		g.setFont(font2);
		g.setColor(Color.WHITE);

		g.drawString("Tiempo: " + segundos, 0, 20);
		g.drawString("Puntaje: " + ventana.darPuntaje(), 130, 20);

	}

	public void timer() {
		segundos--;
		total++;
	}

	public void resetTimer() {
		this.segundos = 0;
	}

	public int darTotal() {
		return total;
	}

}

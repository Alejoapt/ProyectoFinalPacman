package interfazAux;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

@SuppressWarnings("serial")
public class PanelBackground extends JPanel implements MouseListener {

	private static final String RUTA_IMAGEN = "data/imagenes/BackGround.jpeg";
	private InterfazBotones interfaz;

	public PanelBackground(InterfazBotones p) {
		interfaz = p;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(785, 600));
		addMouseListener(this);
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image i = Toolkit.getDefaultToolkit().getImage(RUTA_IMAGEN);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.drawImage(i, 0, 0, this);

		// Jig2dg2dlyPuff

		g2d.setColor(Color.black);
		g2d.drawOval(210, 45, 68, 65);
		g2d.setColor(Color.pink);
		g2d.fillOval(210, 45, 68, 65);

		/**
		 * Ojos
		 */
		g2d.setColor(Color.white);
		g2d.fillOval(220, 67, 7, 7);
		g2d.setColor(Color.black);
		g2d.drawOval(215, 64, 20, 20);
		g2d.drawOval(218, (int) 66.5, 15, 15);
		g2d.drawOval(220, 67, 7, 7);
		g2d.setColor(Color.white);
		g2d.fillOval(218, (int) 66.5, 15, 15);
		g2d.setColor(Color.BLACK);
		g2d.fillOval(220, 67, 7, 7);

		g2d.setColor(Color.white);
		g2d.fillOval(249, 67, 7, 7);
		g2d.setColor(Color.black);
		g2d.drawOval(245, 64, 20, 20);
		g2d.drawOval(248, (int) 66.5, 15, 15);
		g2d.drawOval(249, 67, 7, 7);
		g2d.setColor(Color.WHITE);
		g2d.fillOval(248, (int) 66.5, 15, 15);
		g2d.setColor(Color.black);
		g2d.fillOval(249, 67, 7, 7);

		/**
		 * Orejas de m...
		 */

		// Oreja iz
		g2d.setColor(Color.MAGENTA);
		int orejasx[] = { 215, 229, 218 };
		int orejasy[] = { 57, 48, 40 };
		g2d.drawPolyline(orejasx, orejasy, 3);
		g2d.fillPolygon(orejasx, orejasy, 3);

		g2d.setColor(Color.pink);
		int orejas2x[] = { 216, 227, 219 };
		int orejas2y[] = { (int) 55.5, 48, 42 };
		g2d.drawPolyline(orejas2x, orejas2y, 3);
		g2d.fillPolygon(orejas2x, orejas2y, 3);

		g2d.setColor(Color.black);
		int orejas4x[] = { 218, 227, 220 };
		int orejas4y[] = { 54, 50, 45 };
		g2d.drawPolyline(orejas4x, orejas4y, 3);
		g2d.fillPolygon(orejas4x, orejas4y, 3);

		// Oreja der

		g2d.setColor(Color.MAGENTA);
		int orejas1x[] = { 260, 273, 274 };
		int orejas1y[] = { 50, 59, 43 };
		g2d.drawPolyline(orejas1x, orejas1y, 3);
		g2d.fillPolygon(orejas1x, orejas1y, 3);

		g2d.setColor(Color.pink);
		int orejas3x[] = { 262, 272, 273 };
		int orejas3y[] = { 50, 58, 45 };
		g2d.drawPolyline(orejas3x, orejas3y, 3);
		g2d.fillPolygon(orejas3x, orejas3y, 3);

		g2d.setColor(Color.black);
		int orejas5x[] = { 264, 270, 272 };
		int orejas5y[] = { 51, 58, 47 };
		g2d.drawPolyline(orejas5x, orejas5y, 3);
		g2d.fillPolygon(orejas5x, orejas5y, 3);

		/**
		 * Manitos
		 */
		g2d.setColor(Color.black);
		g2d.drawArc(220, 82, 10, 20, -170, 170);
		g2d.setColor(Color.pink);
		g2d.drawOval(222, 85, 12, 12);
		g2d.fillOval(222, 85, 12, 12);

		g2d.setColor(Color.black);
		g2d.drawArc(250, 89, 10, 15, -250, 250);
		g2d.setColor(Color.pink);
		g2d.drawOval(250, 88, 7, 7);
		g2d.fillOval(250, 88, 7, 7);

		/**
		 * Boquita
		 */

		g2d.setColor(Color.black);
		int boca[] = { 236, 238, 240 };
		int bocay[] = { 88, 90, 88 };
		g2d.drawPolyline(boca, bocay, 3);

		/**
		 * Paticas de m...
		 */
		g2d.setColor(Color.MAGENTA);
		g2d.drawArc(220, 105, 23, 9, -240, 240);
		g2d.drawArc(250, 105, 23, 9, -170, 240);
		g2d.setColor(Color.black);
		g2d.drawArc(230, 48, 23, 19, -280, 260);

		g2d.setColor(Color.pink);
		g2d.fillArc(220, 105, 23, 9, -240, 240);
		g2d.fillArc(250, 105, 23, 9, -170, 240);
		g2d.fillArc(230, 48, 23, 19, -280, 260);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		int but = arg0.getButton();

		if ((x > 0 && x < 170) && (y > 0 && y < 170)) {
			
			
			try {
				interfaz.nuevo();
				interfaz.stopMenu();
			} catch (IOException e) {
				System.out.println("holi");
				e.printStackTrace();
			}

		}

		if ((x > 600 && x < 785) && (y > 0 && y < 170)) {
			try {
				interfaz.cargar();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if ((x > 0 && x < 170) && (y > 430 && y < 600)) {
				try {
					interfaz.mostrarPuntajes();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

		if (((x > 600 && x < 785) && (y > 430 && y < 600)) && (but == 1)) {
			interfaz.cambiarPersonaje();
		}
		if (((x > 350 && x < 450) && (y > 250 && y < 350))) {
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}

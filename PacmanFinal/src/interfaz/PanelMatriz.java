package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelMatriz extends JPanel {
		
	public static final int ENEMIGO = 0;

	public static final int ENEMIGO2 = 1;

	public static final int ENEMIGO3 = 2;

	public static final int ENEMIGO4 = 3;

	public static final int DER = 4;

	public static final int CAMINO = 5;

	public static final int MURO = 6;

	public static final int META = 7;

	public static final int VICTORIA = 8;

	public static final int CAMINO_COMIDA = 9;

	public static final int DER_ABRE = 10;
	public static final int IZQ = 11;
	public static final int IZQ_ABRE = 12;
	public static final int ARR = 13;
	public static final int ARR_ABRE = 14;
	public static final int ABJ = 15;
	public static final int ABJ_ABRE = 16;

	public static final String IMG_ENEMIGO = "./data/imagenes/enemigo.gif";

	public static final String IZQUIERDA = "./data/imagenes/Izquierda.jpeg";
	public static final String IZQUIERDA_ABRE = "./data/imagenes/IzquierdaCome.gif";
	public static final String DERECHA = "./data/imagenes/Derecha.gif";
	public static final String DERECHA_ABRE = "./data/imagenes/DerechaCome.gif";
	public static final String ARRIBA = "./data/imagenes/Arribita.jpeg";
	public static final String ARRIBA_ABRE = "./data/imagenes/ArribaAbre.jpg";
	public static final String ABAJO = "./data/imagenes/Abajito.jpeg";
	public static final String ABAJO_ABRE = "./data/imagenes/AbajoAbre.jpg";

	public static final String IMG_CAMINO = "./data/imagenes/camino.gif";

	public static final String IMG_MURO = "./data/imagenes/muro.gif";

	public static final String IMG_META = "./data/imagenes/meta.gif";

	public static final String IMG_CAMINO_COMIDA = "./data/imagenes/camino_comida.gif";

	private JLabel[][] matriz;

	private int posI;

	private int posJ;
	
	private boolean primera;

	private int posIenemigo1;

	private int posJenemigo1;

	private int posIenemigo2;

	private int posJenemigo2;

	private int posIenemigo3;

	private int posJenemigo3;

	private int posIenemigo4;

	private int posJenemigo4;

	private String personaje;

	private String enemigo;

	private int[][] numeros;


	public PanelMatriz(int pMatriz[][], InterfazLaberinto p, String rutaEnemigo, String rutaPersonaje,
			String rutaPersonajeCome) {
		setLayout(new BorderLayout());
		enemigo = rutaEnemigo;
		personaje = rutaPersonaje;
		numeros = pMatriz;
		posJenemigo1 = 0;
		posIenemigo1 = 0;
		posJenemigo2 = 0;
		posIenemigo2 = 0;
		posJenemigo3 = 0;
		posIenemigo3 = 0;
		posJenemigo4 = 0;
		posIenemigo4 = 0;
		primera = true;
		matriz = new JLabel[numeros.length][numeros[0].length];
		llenarMatriz();
		pintarMatriz();
		repaint();
	}

	public void llenarMatriz() {
		matriz = new JLabel[numeros.length][numeros[0].length];
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros[0].length; j++) {
				if (numeros[i][j] == ENEMIGO) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(enemigo);
					tmp.setIcon(image);
					posIenemigo1 = i;
					posJenemigo1 = j;
					matriz[i][j] = tmp;
				} else if (numeros[i][j] == 1) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(enemigo);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
					posIenemigo2 = i;
					posJenemigo2 = j;
				} else if (numeros[i][j] == 2) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(enemigo);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
					posIenemigo3 = i;
					posJenemigo3 = j;
				} else if (numeros[i][j] == 3) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(enemigo);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
					posIenemigo4 = i;
					posJenemigo4 = j;
				} else if (numeros[i][j] == 4) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(DERECHA);
					tmp.setIcon(image);
					if(primera){
					setPosI(i);
					setPosJ(j);
					primera = false;
					}
					matriz[i][j] = tmp;
				} else if (numeros[i][j] == 5) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(IMG_CAMINO);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
				} else if (numeros[i][j] == 6) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(IMG_MURO);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
				} else if (numeros[i][j] == 7) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(IMG_META);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
				} 
				else if (numeros[i][j] == 9) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(IMG_CAMINO_COMIDA);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
				} else if (numeros[i][j] == 10) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(DERECHA_ABRE);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
				} else if (numeros[i][j] == 11) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(IZQUIERDA);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
				}
				else if (numeros[i][j] == 12) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(IZQUIERDA_ABRE);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
				} else if (numeros[i][j] == 13) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(ARRIBA);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
				} else if (numeros[i][j] == 14) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(ARRIBA_ABRE);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
				} else if (numeros[i][j] == 15) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(ABAJO);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
				} else if (numeros[i][j] == 16) {
					JLabel tmp = new JLabel();
					ImageIcon image = new ImageIcon(ABAJO_ABRE);
					tmp.setIcon(image);
					matriz[i][j] = tmp;
				}
			}
		}
	}

	public void pintarMatriz() {
		removeAll();
		JPanel aux = new JPanel(new GridLayout(numeros.length, numeros[0].length));
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros[0].length; j++) {
				aux.add(matriz[i][j]);
			}
		}
		add(aux, BorderLayout.CENTER);
		repaint();
		validate();
	}

	public int getPosIenemigo1() {
		return posIenemigo1;
	}

	public void setPosIenemigo1(int posIenemigo1) {
		this.posIenemigo1 = posIenemigo1;
	}

	public int getPosJenemigo1() {
		return posJenemigo1;
	}

	public void setPosJenemigo1(int posJenemigo1) {
		this.posJenemigo1 = posJenemigo1;
	}

	public int getPosIenemigo2() {
		return posIenemigo2;
	}

	public void setPosIenemigo2(int posIenemigo2) {
		this.posIenemigo2 = posIenemigo2;
	}

	public int getPosJenemigo2() {
		return posJenemigo2;
	}

	public void setPosJenemigo2(int posJenemigo2) {
		this.posJenemigo2 = posJenemigo2;
	}

	public int getPosIenemigo3() {
		return posIenemigo3;
	}

	public void setPosIenemigo3(int posIenemigo3) {
		this.posIenemigo3 = posIenemigo3;
	}

	public int getPosJenemigo3() {
		return posJenemigo3;
	}

	public void setPosJenemigo3(int posJenemigo3) {
		this.posJenemigo3 = posJenemigo3;
	}

	public int getPosIenemigo4() {
		return posIenemigo4;
	}

	public void setPosIenemigo4(int posIenemigo4) {
		this.posIenemigo4 = posIenemigo4;
	}

	public int getPosJenemigo4() {
		return posJenemigo4;
	}

	public void setPosJenemigo4(int posJenemigo4) {
		this.posJenemigo4 = posJenemigo4;
	}

	public int getPosI() {
		return posI;
	}

	public void setPosI(int posI) {
		this.posI = posI;
	}

	public int getPosJ() {
		return posJ;
	}

	public void setPosJ(int posJ) {
		this.posJ = posJ;
	}

	public int[][] getNumeros() {
		return numeros;
	}

	public void setNumeros(int[][] numeros) {
		this.numeros = numeros;
	}

	public String getPersonaje() {
		return personaje;
	}

	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}

	public String getEnemigo() {
		return personaje;
	}

	public void setEnemigo(String enemigo) {
		this.personaje = enemigo;
	}

}

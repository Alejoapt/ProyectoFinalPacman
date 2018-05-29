package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import interfaz.PanelMatriz;

public class ManejoMundo {

	public static final String RUTA_DEFAULT = "./data/niveles/mundo3.txt";

	public final static String RUTA_PUNTAJE = "./data/puntaje.laberinto";
	
	private int esferasDefault;

	private int esferas;

	private boolean gano;

	private int[][] matriz;

	private boolean enJuego;

	private boolean perdio;

	private String posIniPersonaje;

	private String posActual;

	private boolean seguir;

	private int dificultad;

	private Enemigo1 enemigo1;

	private Enemigo2 enemigo2;

	private Enemigo3y4 enemigo3;

	private Enemigo3y4 enemigo4;

	public ManejoMundo(File ruta, String ene, String img) throws IOException {
		enJuego = true;
		perdio = false;
		posIniPersonaje = "";
		posActual = "";
		setSeguir(true);
		try {
			cargarJuego(ruta);
		} catch (MapaIncorrectoException e) {
			e.printStackTrace();
		}
		contarEsferas();
		gano = false;
		enemigo1 = new Enemigo1(ene, img, dificultad, this);
		enemigo2 = new Enemigo2(ene, img, dificultad, this);
		enemigo3 = new Enemigo3y4(ene, img, dificultad, this, 1);
		enemigo4 = new Enemigo3y4(ene, img, dificultad, this, 4);
	}

	public void contarEsferas() {
		esferas = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] == 9) {
					esferas++;
				}
			}
		}
		esferas += 4;
		esferasDefault = esferas;
	}
	
	public void guardarJuego(File f) throws IOException {
		PrintWriter escritor = new PrintWriter(f);
		escritor.println(0);
		escritor.println(dificultad);
		escritor.println(matriz.length);
		escritor.println(matriz[0].length);
		String contenido = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == PanelMatriz.DER || matriz[i][j] == PanelMatriz.DER_ABRE) {
					contenido = i + "," + j + "," + PanelMatriz.DER;
				} else if (matriz[i][j] == PanelMatriz.ABJ || matriz[i][j] == PanelMatriz.ABJ_ABRE) {
					contenido = i + "," + j + "," + PanelMatriz.ABJ;
				} else if (matriz[i][j] == PanelMatriz.ARR || matriz[i][j] == PanelMatriz.ARR_ABRE) {
					contenido = i + "," + j + "," + PanelMatriz.ARR;
				} else if (matriz[i][j] == PanelMatriz.IZQ || matriz[i][j] == PanelMatriz.IZQ_ABRE) {
					contenido = i + "," + j + "," + PanelMatriz.IZQ;
				}
				else {
					contenido = i + "," + j + "," + matriz[i][j];
				}
				escritor.println(contenido);
			}
		}

		escritor.close();
	}

	public void cargarJuego(File archivo) throws MapaIncorrectoException {

		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			@SuppressWarnings("unused")
			int nivel = Integer.parseInt(linea);
			linea = br.readLine();
			dificultad = Integer.parseInt(linea);
			linea = br.readLine();
			int maxI = Integer.parseInt(linea);
			linea = br.readLine();
			int maxJ = Integer.parseInt(linea);
			matriz = new int[maxI][maxJ];

			while ((linea = br.readLine()) != null) {
				if (linea.equals("")) {
					break;
				}
				String[] tramos = linea.split(",");
				if(tramos[2].equals("4")|| tramos[2].equals("10")|| tramos[2].equals("11")|| tramos[2].equals("12")|| tramos[2].equals("13")|| tramos[2].equals("14")|| tramos[2].equals("15")|| tramos[2].equals("16")){
					matriz[Integer.parseInt(tramos[0])][Integer.parseInt(tramos[1])] = 4;
				}else{
					matriz[Integer.parseInt(tramos[0])][Integer.parseInt(tramos[1])] = Integer.parseInt(tramos[2]);
				}			}
			br.close();
		} catch (IOException e) {
			throw new MapaIncorrectoException();
		}

	}

	// izquierda, arriba, derecha, abajo
	public int[] moverPersonaje(int e, int posI, int posJ) {
		int[] doce = new int[2];
		if (enJuego && !perdio) {
			if (e == 37) {
				int posi = posJ - 1;
				if (matriz[posI][posi] ==9) {
					matriz[posI][posJ] = 5;
					matriz[posI][posi] = 11;
					doce[0]=posI;
					doce[1]=posi;
					mirarVictoria();
					
				}else if(matriz[posI][posi]==5){
					matriz[posI][posJ] = 5;
					matriz[posI][posi] = 11;
					doce[0]=posI;
					doce[1]=posi;
				}else if(matriz[posI][posi]==0||matriz[posI][posi]==1||matriz[posI][posi]==2||
						matriz[posI][posi]==3){
					matriz[posI][posJ] = 5;
					matriz[posI][posi] = 0;
					setPerdio(true);
					setEnJuego(false);
				}
			}else if (e == 40) {
				int posi = posI + 1;
				if (matriz[posi][posJ]==9) {
					matriz[posI][posJ] = 5;
					matriz[posi][posJ] = 15;
					doce[0]=posi;
					doce[1]=posJ;
					mirarVictoria();
				}else if(matriz[posi][posJ]==5){
					matriz[posI][posJ] = 5;
					matriz[posi][posJ] = 15;
					doce[0]=posi;
					doce[1]=posJ;
				}else if(matriz[posi][posJ]==0||matriz[posi][posJ]==1||matriz[posi][posJ]==2||
						matriz[posi][posJ]==3){
					matriz[posI][posJ] = 5;
					matriz[posi][posJ] = 0;
					setPerdio(true);
					setEnJuego(false);
				}
			}else if (e == 38) {
				int posi = posI - 1;
				if (matriz[posi][posJ]==9) {
					matriz[posI][posJ] = 5;
					matriz[posi][posJ] = 13;
					doce[0]=posi;
					doce[1]=posJ;
					mirarVictoria();
				}else if(matriz[posi][posJ]==5){
					matriz[posI][posJ] = 5;
					matriz[posi][posJ] = 13;
					doce[0]=posi;
					doce[1]=posJ;
				}else if(matriz[posi][posJ]==0||matriz[posi][posJ]==1||matriz[posi][posJ]==2||
						matriz[posi][posJ]==3){
					matriz[posI][posJ] = 5;
					matriz[posi][posJ] = 0;
					setPerdio(true);
					setEnJuego(false);
				}
			}else if (e == 39) {
				int posi = posJ + 1;
				if (matriz[posI][posi]==9) {
					matriz[posI][posJ] = 5;
					matriz[posI][posi] = 4;
					doce[0]=posI;
					doce[1]=posi;
					mirarVictoria();
				}else if(matriz[posI][posi]==5){
					matriz[posI][posJ] = 5;
					matriz[posI][posi] = 4;
					doce[0]=posI;
					doce[1]=posi;
				}else if(matriz[posI][posi]==0||matriz[posI][posi]==1||matriz[posI][posi]==2||
						matriz[posI][posi]==3){
					matriz[posI][posJ] = 5;
					matriz[posI][posi] = 0;
					setPerdio(true);
					setEnJuego(false);
				}
			}
		} else if (!enJuego && posIniPersonaje.equals(posActual)) {
			enJuego = true;
		}
		return doce;
	}

	public void mirarVictoria() {
		if (esferas == 1)
			gano = true;
		else
			esferas--;
	}

	public int calcularPuntaje() {
		int base = esferas-esferasDefault;
		base *= 170;
		return -base;
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}

	public boolean estaEnJuego() {
		return enJuego;
	}

	public void setEnJuego(boolean enJuego) {
		this.enJuego = enJuego;
	}

	public boolean getPerdio() {
		return perdio;
	}

	public void setPerdio(boolean perdio) {
		this.perdio = perdio;
	}

	public String getPosIniPersonaje() {
		return posIniPersonaje;
	}

	public String getPosActual() {
		return posActual;
	}

	public void setPosActual(String posActual) {
		this.posActual = posActual;
	}

	public boolean isSeguir() {
		return seguir;
	}

	public void setSeguir(boolean seguir) {
		this.seguir = seguir;
	}

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	public void setPosicion(String pos) {
		posIniPersonaje = pos;
	}

	public int moverEnemigo1Abajo(int posInicialI, int posInicialJ) {
		return enemigo1.moverAbajo(posInicialI, posInicialJ);
	}

	public void moverEnemigo2(int posInicialI2, int posInicialJ2) {
		int pos = posInicialI2 - 1;
		if (matriz[pos][posInicialJ2] == PanelMatriz.CAMINO) {
			matriz[pos][posInicialJ2] = PanelMatriz.ENEMIGO;
			matriz[posInicialI2][posInicialJ2] = PanelMatriz.CAMINO;

		}
	}

	public int moverEnemigo1Arriba(int posInicialI1, int posInicialJ1) {
		return enemigo1.moverArriba(posInicialI1, posInicialJ1);
	}

	public boolean isGano() {
		return gano;
	}

	public void setGano(boolean gano) {
		this.gano = gano;
	}
	
	public int getEsferas() {
		return esferas;
	}
	public void setEsferas(int esferas) {
		this.esferas = esferas;
	}
	public void animar2(int pos1, int pos2, int dire) {
		//Izq
		if(dire == 37) {
			matriz[pos1][pos2] = 11;
		}
		//Abj
		if (dire == 40) {
			matriz[pos1][pos2] = 15;
		}
		//Arriba
		if (dire == 38) {
			matriz[pos1][pos2] = 13;
		}
		//Der
		if (dire == 39) {
			matriz[pos1][pos2] = 4;
		}
		
		
	}

	public void animar1(int pos1, int pos2, int dire) {
		if (dire == 37) {
			matriz[pos1][pos2] = 12;
		}
		if (dire == 38) {
			matriz[pos1][pos2] = 14;
		}
		if (dire == 39) {
			matriz[pos1][pos2] = 10;
		}
		if (dire == 40) {
			matriz[pos1][pos2] = 16;
		}
		}
	
	public int moverEnemigo2Arriba(int posInicialI, int posInicialJ) {
		return enemigo2.moverArriba(posInicialI, posInicialJ);
	}

	public int moverEnemigo2Abajo(int posInicialI2, int posInicialJ2) {
		return enemigo2.moverAbajo(posInicialI2, posInicialJ2);
	}

	public int moverEnemigo3Izq(int posInicialI, int posInicialJ) {
		return enemigo3.moverIzquierda(posInicialI, posInicialJ, 2);
	}

	public int moverEnemigo3Derecha(int posInicialI2, int posInicialJ2) {
		return enemigo3.moverDerecha(posInicialI2, posInicialJ2, 2);
	}

	public int moverEnemigo4Izq(int posInicialI, int posInicialJ) {
		return enemigo4.moverIzquierda(posInicialI, posInicialJ, 3);
	}

	public int moverEnemigo4Derecha(int posInicialI2, int posInicialJ2) {
		return enemigo4.moverDerecha(posInicialI2, posInicialJ2, 3);
	}
}

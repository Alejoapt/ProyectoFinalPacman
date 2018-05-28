package hilos;

import interfaz.InterfazLaberinto;
import mundo.ManejoMundo;

public class HiloEnemigo3 extends Thread {

	private double dificultad;

	private ManejoMundo manejoMundo;

	public int getPosInicialI1() {
		return posInicialI1;
	}

	public void setPosInicialI1(int posInicialI) {
		this.posInicialI1 = posInicialI;
	}

	public int getPosInicialJ1() {
		return posInicialJ1;
	}

	public void setPosInicialJ1(int posInicialJ) {
		this.posInicialJ1 = posInicialJ;
	}

	private InterfazLaberinto interfaz;

	private int posInicialI1;

	private int posInicialJ1;

	private int posInicialI2;

	private int posInicialJ2;

	public HiloEnemigo3(ManejoMundo pManejoMundo, int pPosInicialI1, int pPosInicialJ1, int pPosInicialI2,
			int pPosInicialJ2, InterfazLaberinto i, double dif) {
		interfaz = i;
		manejoMundo = pManejoMundo;
		posInicialJ1 = pPosInicialJ1;
		posInicialI1 = pPosInicialI1;
		posInicialJ2 = pPosInicialJ2;
		posInicialI2 = pPosInicialI2;
		dificultad = dif;
	}

	@Override
	public void run() {
		while (manejoMundo.estaEnJuego()) {
			if (!manejoMundo.getPerdio()) {
				for (int i = 0; i < manejoMundo.getMatriz().length - 1; i++) {
					if (interfaz != null) {
						interfaz.moverEnemigo3Izq(posInicialI1, posInicialJ1, posInicialI2, posInicialJ2);
						if (manejoMundo.isGano()) {
							manejoMundo.setEnJuego(false);
							interfaz.gano();
							break;
						}
						if (manejoMundo.isGano()) {
							break;
						}
						try {
							sleep((long) dificultad);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				for (int i = 0; i < manejoMundo.getMatriz().length - 1; i++) {
					if (interfaz != null) {
						interfaz.moverEnemigo3Der(posInicialI1, posInicialJ1, posInicialI2, posInicialJ2);
						if (manejoMundo.isGano()) {
							break;
						}
						try {
							sleep((long) dificultad);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	public void setPosInicialJ2(int pos) {
		posInicialJ2 = pos;
	}

	public void setPosInicialI2(int pos) {
		posInicialI2 = pos;
	}

	public int getPosInicialI2() {
		return posInicialI2;
	}

	public int getPosInicialJ2() {
		return posInicialJ2;
	}

}

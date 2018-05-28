package hilos;

import interfaz.InterfazLaberinto;
import mundo.ManejoMundo;

public class HiloEnemigo2 extends Thread {

	private double dificultad;

	private ManejoMundo manejoMundo;

	private InterfazLaberinto interfaz;

	private int posInicialI2;

	private int posInicialJ2;

	public int getPosInicialI2() {
		return posInicialI2;
	}

	public void setPosInicialI2(int posInicialI) {
		this.posInicialI2 = posInicialI;
	}

	public int getPosInicialJ2() {
		return posInicialJ2;
	}

	public void setPosInicialJ2(int posInicialJ) {
		this.posInicialJ2 = posInicialJ;
	}

	public HiloEnemigo2(ManejoMundo pManejoMundo, int pPosInicialI2, int pPosInicialJ2, InterfazLaberinto i,
			double dif) {
		interfaz = i;
		manejoMundo = pManejoMundo;
		posInicialJ2 = pPosInicialJ2;
		posInicialI2 = pPosInicialI2;
		dificultad = dif;
	}

	@Override
	public void run() {
		while (manejoMundo.estaEnJuego()) {
			if (!manejoMundo.getPerdio()) {
				for (int i = 0; i < manejoMundo.getMatriz().length - 1; i++) {
					interfaz.moverEnemigo2Arriba(posInicialI2, posInicialJ2);
					if (manejoMundo.isGano()) {
						break;
					}
					try {
						sleep((long) dificultad);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int i = 0; i < manejoMundo.getMatriz().length - 1; i++) {
					if (interfaz != null) {
						interfaz.moverEnemigo2Abajo(posInicialI2, posInicialJ2);
						if (manejoMundo.isGano()) {
							manejoMundo.setEnJuego(false);
						}
						try {
							sleep((long) dificultad);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				if (manejoMundo.isGano()) {
					break;
				}
			}
		}
	}

}

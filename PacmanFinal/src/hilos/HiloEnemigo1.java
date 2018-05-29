package hilos;

import interfaz.InterfazLaberinto;
import mundo.ManejoMundo;

public class HiloEnemigo1 extends Thread {

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

	public HiloEnemigo1(ManejoMundo pManejoMundo, int pPosInicialI1, int pPosInicialJ1, InterfazLaberinto i,
			double dif) {
		interfaz = i;
		manejoMundo = pManejoMundo;
		posInicialJ1 = pPosInicialJ1;
		posInicialI1 = pPosInicialI1;
		dificultad = dif;
	}

	@Override
	public void run() {
		while (manejoMundo.estaEnJuego()) {
			if (!manejoMundo.getPerdio()) {
				for (int i = 0; i < manejoMundo.getMatriz().length -1; i++) {
					interfaz.moverEnemigo1Abajo(posInicialI1, posInicialJ1);
					if (manejoMundo.isGano()) {
						break;
					}
					try {
						sleep((long) dificultad);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for (int i = 0; i < manejoMundo.getMatriz().length-1; i++) {
					interfaz.moverEnemigo1Arriba(posInicialI1, posInicialJ1);
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

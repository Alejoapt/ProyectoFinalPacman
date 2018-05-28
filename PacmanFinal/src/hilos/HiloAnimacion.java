package hilos;

import interfaz.InterfazLaberinto;
import mundo.ManejoMundo;

public class HiloAnimacion extends Thread {

	private ManejoMundo manejoMundo;

	private InterfazLaberinto interfaz;

	public HiloAnimacion(ManejoMundo pManejoMundo, int posi, int posj, InterfazLaberinto in) {
		manejoMundo = pManejoMundo;
		interfaz = in;
	}

	@Override
	public void run() {
		while (manejoMundo.estaEnJuego()) {
			interfaz.animar1();

			try {
				Thread.sleep(200);
			} catch (Exception e) {
				
			}
			interfaz.animar2();
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				
			}
		}
	}

}

package hilos;

import interfaz.InterfazLaberinto;
import mundo.ManejoMundo;

public class HiloRefrescar extends Thread {

	private ManejoMundo manejoMundo;

	private InterfazLaberinto interfaz;

	public HiloRefrescar(InterfazLaberinto i, ManejoMundo m) {
		interfaz = i;
		manejoMundo = m;
	}

	@Override
	public void run() {
		while (manejoMundo.estaEnJuego()) {
			if (!manejoMundo.getPerdio()) {
				interfaz.refrescar();
				try {
					sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (manejoMundo.getPerdio()) {
					manejoMundo.setEnJuego(false);
					interfaz.refrescar();
					interfaz.perdio();
				} else if (!manejoMundo.isSeguir()) {
					manejoMundo.setEnJuego(false);
					interfaz.refrescar();
					interfaz.gano();
					break;
				}

			}
		}

	}

}

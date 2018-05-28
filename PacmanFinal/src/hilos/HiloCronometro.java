package hilos;

import interfaz.InterfazLaberinto;
import mundo.ManejoMundo;

public class HiloCronometro extends Thread {

	private InterfazLaberinto ventana;

	private ManejoMundo manejoMundo;

	public HiloCronometro(InterfazLaberinto v, ManejoMundo m) {
		ventana = v;
		manejoMundo = m;
	}

	public void run() {
		while (manejoMundo.estaEnJuego()) {
			ventana.timer();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				
			}
			ventana.repaintInfo();
			
		}
	}

}

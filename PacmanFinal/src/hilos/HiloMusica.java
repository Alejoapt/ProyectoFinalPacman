package hilos;

import java.io.File;

import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import mundo.ManejoMundo;

public class HiloMusica extends Thread{
		
	private BasicPlayer player;
	
	private ManejoMundo manejoMundo;
	
	public HiloMusica(File ruta, ManejoMundo manejo) {
		player = new BasicPlayer();
		manejoMundo = manejo;
		try {
			player.open(ruta);
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (manejoMundo.estaEnJuego()) {
			try {
				player.play();
			} catch (BasicPlayerException e1) {
				e1.printStackTrace();
			}
			try {
				Thread.sleep(0);
			} catch (Exception e) {
			}
		}
	}

}

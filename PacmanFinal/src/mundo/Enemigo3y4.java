package mundo;

import interfaz.PanelMatriz;

public class Enemigo3y4 extends Enemigo {

	private ManejoMundo mundo;

	private boolean primero1;

	private boolean primero2;

	private int actualito;

	public Enemigo3y4(String nombre, String imagen, int dificultad, ManejoMundo mundito, int tipo) {
		super(nombre, imagen, dificultad);
		actualito = 0;
		mundo = mundito;
		if(tipo == 1){
			primero1 = true;
			primero2 = false;
		}else{
			primero1 = false;
			primero2 = true;
		}
		
	}

	public int moverIzquierda(int posInicialI1, int posInicialJ1, int pj) {
		int pos = posInicialJ1 - 1;
		if (pos >= 2) {
			if (mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.DER
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.DER_ABRE
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.ARR
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.ARR_ABRE
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.ABJ
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.ABJ_ABRE
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.IZQ
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.IZQ_ABRE) {
				mundo.setPerdio(true);
				mundo.setEnJuego(false);
				mundo.getMatriz()[posInicialI1][posInicialJ1] = actualito;
				actualito = mundo.getMatriz()[posInicialI1][pos];
				mundo.getMatriz()[posInicialI1][pos] = pj;
			}else if (mundo.getMatriz()[posInicialI1][pos] != 6) {
				if (primero1) {
					mundo.getMatriz()[posInicialI1][posInicialJ1] = 9;
					actualito = mundo.getMatriz()[posInicialI1][pos];
					mundo.getMatriz()[posInicialI1][pos] = pj;
					primero1 = false;
				} else {
					mundo.getMatriz()[posInicialI1][posInicialJ1] = actualito;
					actualito = mundo.getMatriz()[posInicialI1][pos];
					mundo.getMatriz()[posInicialI1][pos] = pj;
				}
			}
		}
		return pos;
	}

	public int moverDerecha(int posInicialI1, int posInicialJ1, int pj) {
		int pos = posInicialJ1 + 1;
		if (pos <= 15) {
			//posInicialI1
			if (mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.DER
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.DER_ABRE
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.ARR
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.ARR_ABRE
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.ABJ
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.ABJ_ABRE
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.IZQ
					|| mundo.getMatriz()[posInicialI1][pos] == PanelMatriz.IZQ_ABRE) {
				mundo.setPerdio(true);
				mundo.setEnJuego(false);
				mundo.getMatriz()[posInicialI1][posInicialJ1] = actualito;
				actualito = mundo.getMatriz()[posInicialI1][pos];
				mundo.getMatriz()[posInicialI1][pos] = pj;
			}else if (mundo.getMatriz()[posInicialI1][pos] != 6) {
				if (primero2) {
					mundo.getMatriz()[posInicialI1][posInicialJ1] = 9;
					actualito = mundo.getMatriz()[posInicialI1][pos];
					mundo.getMatriz()[posInicialI1][pos] = pj;
					primero2 = false;
				}else {
					mundo.getMatriz()[posInicialI1][posInicialJ1] = actualito;
					actualito = mundo.getMatriz()[posInicialI1][pos];
					mundo.getMatriz()[posInicialI1][pos] = pj;
				}
			} 
		}
		return pos;
	}
}

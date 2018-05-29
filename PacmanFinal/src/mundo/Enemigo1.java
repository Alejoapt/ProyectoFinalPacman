package mundo;

import interfaz.PanelMatriz;

public class Enemigo1 extends Enemigo{

	private ManejoMundo mundo;
	
	private boolean primero;

	private int actualito;

	public Enemigo1(String nombre, String imagen, int dificultad, ManejoMundo mundito) {
		super(nombre, imagen, dificultad);
		actualito = 0;
		mundo = mundito;
		primero = true;
	}	

	public int moverArriba(int posInicialI1, int posInicialJ1) {
		int pos = posInicialI1 - 1;
		if (mundo.getMatriz()[pos][posInicialJ1] == 9 || mundo.getMatriz()[pos][posInicialJ1] == 5) {
			mundo.getMatriz()[posInicialI1][posInicialJ1] = actualito;
			actualito = mundo.getMatriz()[pos][posInicialJ1];
			mundo.getMatriz()[pos][posInicialJ1] = 0;
			if (mundo.getMatriz()[pos][posInicialJ1] == 6) {
				System.out.println("holi");
			}
			
			
		} else if (mundo.getMatriz()[pos][posInicialJ1] == PanelMatriz.DER
				|| mundo.getMatriz()[pos][posInicialJ1] == PanelMatriz.DER_ABRE
				|| mundo.getMatriz()[pos][posInicialJ1] == PanelMatriz.ARR
				|| mundo.getMatriz()[pos][posInicialJ1] == PanelMatriz.ARR_ABRE
				|| mundo.getMatriz()[pos][posInicialJ1] == PanelMatriz.ABJ
				|| mundo.getMatriz()[pos][posInicialJ1] == PanelMatriz.ABJ_ABRE
				|| mundo.getMatriz()[pos][posInicialJ1] == PanelMatriz.IZQ
				|| mundo.getMatriz()[pos][posInicialJ1] == PanelMatriz.IZQ_ABRE) {
			mundo.setPerdio(true);
			mundo.setEnJuego(false);
			mundo.getMatriz()[posInicialI1][posInicialJ1] = actualito;
			actualito = mundo.getMatriz()[pos][posInicialJ1];
			mundo.getMatriz()[pos][posInicialJ1] = 0;
		}
		return pos;
	}

	public int moverAbajo(int posInicialI, int posInicialJ) {
		int pos = posInicialI + 1;
		if (mundo.getMatriz()[pos][posInicialJ] == 9 || mundo.getMatriz()[pos][posInicialJ] == 5) {
			if (primero) {
				mundo.getMatriz()[posInicialI][posInicialJ] = 9;
				actualito = mundo.getMatriz()[pos][posInicialJ];
				mundo.getMatriz()[pos][posInicialJ] = 0;
				primero = false;
			} else {
				mundo.getMatriz()[posInicialI][posInicialJ] = actualito;
				actualito = mundo.getMatriz()[pos][posInicialJ];
				mundo.getMatriz()[pos][posInicialJ] = 0;
			}
		} else if (mundo.getMatriz()[pos][posInicialJ] == PanelMatriz.DER
				|| mundo.getMatriz()[pos][posInicialJ] == PanelMatriz.DER_ABRE
				|| mundo.getMatriz()[pos][posInicialJ] == PanelMatriz.ARR
				|| mundo.getMatriz()[pos][posInicialJ] == PanelMatriz.ARR_ABRE
				|| mundo.getMatriz()[pos][posInicialJ] == PanelMatriz.ABJ
				|| mundo.getMatriz()[pos][posInicialJ] == PanelMatriz.ABJ_ABRE
				|| mundo.getMatriz()[pos][posInicialJ] == PanelMatriz.IZQ
				|| mundo.getMatriz()[pos][posInicialJ] == PanelMatriz.IZQ_ABRE) {
			mundo.setPerdio(true);
			mundo.setEnJuego(false);
			mundo.getMatriz()[posInicialI][posInicialJ] = actualito;
			actualito = mundo.getMatriz()[pos][posInicialJ];
			mundo.getMatriz()[pos][posInicialJ] = 0;
		}
		return pos;
	}
}

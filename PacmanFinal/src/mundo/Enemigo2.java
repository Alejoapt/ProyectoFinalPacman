package mundo;

import interfaz.PanelMatriz;

public class Enemigo2 extends Enemigo{

	private ManejoMundo mundo;
	
	private boolean primero;

	private int actualito;
	
	public Enemigo2(String nombre, String imagen, int dificultad, ManejoMundo mundito) {
		super(nombre, imagen, dificultad);
			actualito = 0;
			mundo = mundito;
			primero = true;
	}

	public int moverArriba(int posInicialI1, int posInicialJ1) {
		int pos = posInicialI1 - 1;
		if (mundo.getMatriz()[pos][posInicialJ1] == 9 || mundo.getMatriz()[pos][posInicialJ1] == 5) {
			if (primero) {
				mundo.getMatriz()[posInicialI1][posInicialJ1] = 9;
				actualito = mundo.getMatriz()[pos][posInicialJ1];
				mundo.getMatriz()[pos][posInicialJ1] = 0;
				primero = false;
			}else{
			mundo.getMatriz()[posInicialI1][posInicialJ1] = actualito;
			actualito = mundo.getMatriz()[pos][posInicialJ1];
			mundo.getMatriz()[pos][posInicialJ1] = 0;
			}
		} else if (mundo.getMatriz()[pos][posInicialI1] == PanelMatriz.DER
				|| mundo.getMatriz()[pos][posInicialI1] == PanelMatriz.DER_ABRE
				|| mundo.getMatriz()[pos][posInicialI1] == PanelMatriz.ARR
				|| mundo.getMatriz()[pos][posInicialI1] == PanelMatriz.ARR_ABRE
				|| mundo.getMatriz()[pos][posInicialI1] == PanelMatriz.ABJ
				|| mundo.getMatriz()[pos][posInicialI1] == PanelMatriz.ABJ_ABRE
				|| mundo.getMatriz()[pos][posInicialI1] == PanelMatriz.IZQ
				|| mundo.getMatriz()[pos][posInicialI1] == PanelMatriz.IZQ_ABRE) {
			mundo.setPerdio(true);
			mundo.setEnJuego(false);
			mundo.getMatriz()[posInicialI1][posInicialJ1] = actualito;
			actualito = mundo.getMatriz()[pos][posInicialJ1];
			mundo.getMatriz()[pos][posInicialJ1] = 0;
		}
		return pos;
	}

	public int moverAbajo(int posInicialI1, int posInicialJ1) {
		int pos = posInicialI1 + 1;
		if (mundo.getMatriz()[pos][posInicialJ1] == 9 || mundo.getMatriz()[pos][posInicialJ1] == 5) {
			mundo.getMatriz()[posInicialI1][posInicialJ1] = actualito;
			actualito = mundo.getMatriz()[pos][posInicialJ1];
			mundo.getMatriz()[pos][posInicialJ1] = 0;
		} else if (mundo.getMatriz()[posInicialI1][posInicialJ1] == PanelMatriz.DER
				|| mundo.getMatriz()[posInicialI1][posInicialJ1] == PanelMatriz.DER_ABRE
				|| mundo.getMatriz()[posInicialI1][posInicialJ1] == PanelMatriz.ARR
				|| mundo.getMatriz()[posInicialI1][posInicialJ1] == PanelMatriz.ARR_ABRE
				|| mundo.getMatriz()[posInicialI1][posInicialJ1] == PanelMatriz.ABJ
				|| mundo.getMatriz()[posInicialI1][posInicialJ1] == PanelMatriz.ABJ_ABRE
				|| mundo.getMatriz()[posInicialI1][posInicialJ1] == PanelMatriz.IZQ
				|| mundo.getMatriz()[posInicialI1][posInicialJ1] == PanelMatriz.IZQ_ABRE) {
			mundo.setPerdio(true);
			mundo.setEnJuego(false);
			mundo.getMatriz()[posInicialI1][posInicialJ1] = actualito;
			actualito = mundo.getMatriz()[pos][posInicialJ1];
			mundo.getMatriz()[pos][posInicialJ1] = 0;
		}
		return pos;
	}
	
}

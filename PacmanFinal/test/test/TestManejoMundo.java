package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import mundo.ManejoMundo;

public class TestManejoMundo {

	private ManejoMundo mundo;

	public void setupEscenario() throws IOException {
		mundo = new ManejoMundo(new File("./data/niveles/mundo.txt"), "./data/imagenes/enemigo.gif",
				"./data/imagenes/enemigo.gif");
	}

	public void setupEscenario0() throws IOException {
		mundo = new ManejoMundo(new File("./data/niveles/mundo0.txt"), "./data/imagenes/enemigo.gif",
				"./data/imagenes/enemigo.gif");
	}

	public void setupEscenario1() throws IOException {
		mundo = new ManejoMundo(new File("./data/niveles/mundo1.txt"), "./data/imagenes/enemigo.gif",
				"./data/imagenes/enemigo.gif");
	}

	public void setupEscenario2() throws IOException {
		mundo = new ManejoMundo(new File("./data/niveles/mundo2.txt"), "./data/imagenes/enemigo.gif",
				"./data/imagenes/enemigo.gif");
	}

	public void setupEscenario3() throws IOException {
		mundo = new ManejoMundo(new File("./data/niveles/mundo3.txt"), "./data/imagenes/enemigo.gif",
				"./data/imagenes/enemigo.gif");
	}

	@Test
	public void cargarJuegoTest() throws IOException {
		setupEscenario();
		int[][] matriz = mundo.getMatriz();
		assertEquals(mundo.getDificultad(), 1000);
		assertEquals(matriz.length, 3);
		assertEquals(matriz[0].length, 15);
	}

	@Test
	public void cargarJuegoTest0() throws IOException {
		setupEscenario0();
		int[][] matriz = mundo.getMatriz();
		assertEquals(mundo.getDificultad(), 1000);
		assertEquals(matriz.length, 3);
		assertEquals(matriz[0].length, 15);
	}

	@Test
	public void cargarJuegoTest1() throws IOException {
		setupEscenario1();
		int[][] matriz = mundo.getMatriz();
		assertEquals(mundo.getDificultad(), 500);
		assertEquals(matriz.length, 8);
		assertEquals(matriz[0].length, 8);
	}

	@Test
	public void cargarJuegoTest2() throws IOException {
		setupEscenario2();
		int[][] matriz = mundo.getMatriz();
		assertEquals(mundo.getDificultad(), 150);
		assertEquals(matriz.length, 14);
		assertEquals(matriz[0].length, 18);
	}

	@Test
	public void cargarJuegoTest3() throws IOException {
		setupEscenario3();
		int[][] matriz = mundo.getMatriz();
		assertEquals(mundo.getDificultad(), 150);
		assertEquals(matriz.length, 14);
		assertEquals(matriz[0].length, 19);
	}

	@Test
	public void contarEsferasTest() throws IOException {
		setupEscenario();
		mundo.contarEsferas();
		assertEquals(mundo.getEsferas(), 4);
	}

	@Test
	public void contarEsferasTest0() throws IOException {
		setupEscenario0();
		mundo.contarEsferas();
		assertEquals(mundo.getEsferas(), 4);
	}

	@Test
	public void contarEsferasTest1() throws IOException {
		setupEscenario1();
		mundo.contarEsferas();
		assertEquals(mundo.getEsferas(), 4);
	}

	@Test
	public void contarEsferasTest2() throws IOException {
		setupEscenario2();
		mundo.contarEsferas();
		assertEquals(mundo.getEsferas(), 4);
	}

	@Test
	public void contarEsferasTest3() throws IOException {
		setupEscenario3();
		mundo.contarEsferas();
		assertEquals(mundo.getEsferas(), 137);
	}

	@Test
	public void mirarVictoriarTest() throws IOException {
		setupEscenario();
		int num = mundo.getEsferas();
		for (int i = 0; i < num; i++) {
			mundo.mirarVictoria();
		}
		assertTrue(mundo.isGano());
	}

	@Test
	public void mirarVictoriarTest0() throws IOException {
		setupEscenario0();
		int num = mundo.getEsferas();
		for (int i = 0; i < num; i++) {
			mundo.mirarVictoria();
		}
		assertTrue(mundo.isGano());
	}

	@Test
	public void mirarVictoriarTest1() throws IOException {
		setupEscenario1();
		int num = mundo.getEsferas();
		for (int i = 0; i < num; i++) {
			mundo.mirarVictoria();
		}
		assertTrue(mundo.isGano());
	}

	@Test
	public void mirarVictoriarTest2() throws IOException {
		setupEscenario2();
		int num = mundo.getEsferas();
		for (int i = 0; i < num; i++) {
			mundo.mirarVictoria();
		}
		assertTrue(mundo.isGano());
	}

	@Test
	public void mirarVictoriarTest3() throws IOException {
		setupEscenario3();
		int num = mundo.getEsferas();
		for (int i = 0; i < num; i++) {
			mundo.mirarVictoria();
		}
		assertTrue(mundo.isGano());
	}
	
	@Test
	public void mirarVictoriarDerrotaTest() throws IOException {
		setupEscenario();
		assertFalse(mundo.isGano());
	}
	
	@Test
	public void mirarVictoriarDerrotaTest0() throws IOException {
		setupEscenario0();
		assertFalse(mundo.isGano());
	}
	
	@Test
	public void mirarVictoriarDerrotaTest1() throws IOException {
		setupEscenario1();
		assertFalse(mundo.isGano());
	}
	
	@Test
	public void mirarVictoriarDerrotaTest2() throws IOException {
		setupEscenario2();
		assertFalse(mundo.isGano());
	}
	
	@Test
	public void mirarVictoriarDerrotaTest3() throws IOException {
		setupEscenario3();
		assertFalse(mundo.isGano());
	}
	
	@Test
	public void calcularPuntajeTest() throws IOException {
		setupEscenario();
		int num = mundo.getEsferas();
		for (int i = 0; i < num; i++) {
			mundo.setEsferas(i);
			assertEquals(mundo.calcularPuntaje(), (num-i)*170);
		}		
	}
	
	@Test
	public void calcularPuntajeTest0() throws IOException {
		setupEscenario0();
		int num = mundo.getEsferas();
		for (int i = 0; i < num; i++) {
			mundo.setEsferas(i);
			assertEquals(mundo.calcularPuntaje(), (num-i)*170);
		}		
	}
	
	@Test
	public void calcularPuntajeTest1() throws IOException {
		setupEscenario1();
		int num = mundo.getEsferas();
		for (int i = 0; i < num; i++) {
			mundo.setEsferas(i);
			assertEquals(mundo.calcularPuntaje(), (num-i)*170);
		}		
	}
	
	@Test
	public void calcularPuntajeTest2() throws IOException {
		setupEscenario2();
		int num = mundo.getEsferas();
		for (int i = 0; i < num; i++) {
			mundo.setEsferas(i);
			assertEquals(mundo.calcularPuntaje(), (num-i)*170);
		}		
	}
	
	@Test
	public void calcularPuntajeTest3() throws IOException {
		setupEscenario3();
		int num = mundo.getEsferas();
		for (int i = 0; i < num; i++) {
			mundo.setEsferas(i);
			assertEquals(mundo.calcularPuntaje(), (num-i)*170);
		}		
	}

	@Test 
	public void moverEnemigo1Test() throws IOException {
		setupEscenario();
		for (int i = 1; i < mundo.getMatriz().length-1; i++) {
			for (int j = 0; j < mundo.getMatriz()[0].length; j++) {
				assertEquals(mundo.moverEnemigo1Abajo(i, j), i+1);
				assertEquals(mundo.moverEnemigo1Arriba(i, j),i-1);
			}
		} 
	}
	
	@Test 
	public void moverEnemigo1Test0() throws IOException {
		setupEscenario0();
		for (int i = 1; i < mundo.getMatriz().length-1; i++) {
			for (int j = 0; j < mundo.getMatriz()[0].length; j++) {
				assertEquals(mundo.moverEnemigo1Abajo(i, j), i+1);
				assertEquals(mundo.moverEnemigo1Arriba(i, j),i-1);
			}
		} 
	}
	
	@Test 
	public void moverEnemigo1Test1() throws IOException {
		setupEscenario1();
		for (int i = 1; i < mundo.getMatriz().length-1; i++) {
			for (int j = 0; j < mundo.getMatriz()[0].length; j++) {
				assertEquals(mundo.moverEnemigo1Abajo(i, j), i+1);
				assertEquals(mundo.moverEnemigo1Arriba(i, j),i-1);
			}
		} 
	}
	
	@Test 
	public void moverEnemigo1Test2() throws IOException {
		setupEscenario2();
		for (int i = 1; i < mundo.getMatriz().length-1; i++) {
			for (int j = 0; j < mundo.getMatriz()[0].length; j++) {
				assertEquals(mundo.moverEnemigo1Abajo(i, j), i+1);
				assertEquals(mundo.moverEnemigo1Arriba(i, j),i-1);
			}
		} 
	}
	
	@Test 
	public void moverEnemigo1Test3() throws IOException {
		setupEscenario3();
		for (int i = 1; i < mundo.getMatriz().length-1; i++) {
			for (int j = 0; j < mundo.getMatriz()[0].length; j++) {
				assertEquals(mundo.moverEnemigo1Abajo(i, j), i+1);
				assertEquals(mundo.moverEnemigo1Arriba(i, j),i-1);
			}
		} 
	}
	
	@Test 
	public void moverEnemigo2Test() throws IOException {
		setupEscenario();
		for (int i = 1; i < mundo.getMatriz().length-1; i++) {
			for (int j = 0; j < mundo.getMatriz()[0].length; j++) {
				assertEquals(mundo.moverEnemigo2Abajo(i, j), i+1);
				assertEquals(mundo.moverEnemigo2Arriba(i, j),i-1);
			}
		} 
	}
	
	@Test 
	public void moverEnemigo2Test0() throws IOException {
		setupEscenario0();
		for (int i = 1; i < mundo.getMatriz().length-1; i++) {
			for (int j = 0; j < mundo.getMatriz()[0].length; j++) {
				assertEquals(mundo.moverEnemigo2Abajo(i, j), i+1);
				assertEquals(mundo.moverEnemigo2Arriba(i, j),i-1);
			}
		} 
	}
	
	@Test 
	public void moverEnemigo2Test1() throws IOException {
		setupEscenario1();
		for (int i = 1; i < mundo.getMatriz().length-1; i++) {
			for (int j = 0; j < mundo.getMatriz()[0].length; j++) {
				assertEquals(mundo.moverEnemigo2Abajo(i, j), i+1);
				assertEquals(mundo.moverEnemigo2Arriba(i, j),i-1);
			}
		} 
	}
	
	@Test 
	public void moverEnemigo2Test2() throws IOException {
		setupEscenario2();
		for (int i = 1; i < mundo.getMatriz().length-1; i++) {
			for (int j = 0; j < mundo.getMatriz()[0].length; j++) {
				assertEquals(mundo.moverEnemigo2Abajo(i, j), i+1);
				assertEquals(mundo.moverEnemigo2Arriba(i, j),i-1);
			}
		} 
	}
	
	@Test 
	public void moverEnemigo2Test3() throws IOException {
		setupEscenario3();
		for (int i = 1; i < mundo.getMatriz().length-1; i++) {
			for (int j = 0; j < mundo.getMatriz()[0].length; j++) {
				assertEquals(mundo.moverEnemigo2Abajo(i, j), i+1);
				assertEquals(mundo.moverEnemigo2Arriba(i, j),i-1);
			}
		} 
	}	
	
	@Test 
	public void moverEnemigo3Test() throws IOException {
		setupEscenario();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 1; j < mundo.getMatriz()[0].length-1; j++) {
				assertEquals(mundo.moverEnemigo3Izq(i, j), j-1);
				assertEquals(mundo.moverEnemigo3Derecha(i, j),j+1);
			}
		} 
	}
	
	@Test 
	public void moverEnemigo3Test0() throws IOException {
		setupEscenario0();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 1; j < mundo.getMatriz()[0].length-1; j++) {
				assertEquals(mundo.moverEnemigo3Izq(i, j), j-1);
				assertEquals(mundo.moverEnemigo3Derecha(i, j),j+1);
			}
		}
	}
	
	@Test 
	public void moverEnemigo3Test1() throws IOException {
		setupEscenario1();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 1; j < mundo.getMatriz()[0].length-1; j++) {
				assertEquals(mundo.moverEnemigo3Izq(i, j), j-1);
				assertEquals(mundo.moverEnemigo3Derecha(i, j),j+1);
			}
		}
	}
	
	@Test 
	public void moverEnemigo3Test2() throws IOException {
		setupEscenario2();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 1; j < mundo.getMatriz()[0].length-1; j++) {
				assertEquals(mundo.moverEnemigo3Izq(i, j), j-1);
				assertEquals(mundo.moverEnemigo3Derecha(i, j),j+1);
			}
		}
	}
	
	@Test 
	public void moverEnemigo3Test3() throws IOException {
		setupEscenario3();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 1; j < mundo.getMatriz()[0].length-1; j++) {
				assertEquals(mundo.moverEnemigo3Izq(i, j), j-1);
				assertEquals(mundo.moverEnemigo3Derecha(i, j),j+1);
			}
		}
	}
	
	@Test 
	public void moverEnemigo4Test() throws IOException {
		setupEscenario();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 1; j < mundo.getMatriz()[0].length-1; j++) {
				assertEquals(mundo.moverEnemigo4Izq(i, j), j-1);
				assertEquals(mundo.moverEnemigo4Derecha(i, j),j+1);
			}
		} 
	}
	
	@Test 
	public void moverEnemigo4Test0() throws IOException {
		setupEscenario0();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 1; j < mundo.getMatriz()[0].length-1; j++) {
				assertEquals(mundo.moverEnemigo4Izq(i, j), j-1);
				assertEquals(mundo.moverEnemigo4Derecha(i, j),j+1);
			}
		}
	}
	
	@Test 
	public void moverEnemigo4Test1() throws IOException {
		setupEscenario1();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 1; j < mundo.getMatriz()[0].length-1; j++) {
				assertEquals(mundo.moverEnemigo4Izq(i, j), j-1);
				assertEquals(mundo.moverEnemigo4Derecha(i, j),j+1);
			}
		}
	}
	
	@Test 
	public void moverEnemigo4Test2() throws IOException {
		setupEscenario2();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 1; j < mundo.getMatriz()[0].length-1; j++) {
				assertEquals(mundo.moverEnemigo4Izq(i, j), j-1);
				assertEquals(mundo.moverEnemigo4Derecha(i, j),j+1);
			}
		}
	}
	
	@Test 
	public void moverEnemigo4Test3() throws IOException {
		setupEscenario3();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 1; j < mundo.getMatriz()[0].length-1; j++) {
				assertEquals(mundo.moverEnemigo4Izq(i, j), j-1);
				assertEquals(mundo.moverEnemigo4Derecha(i, j),j+1);
			}
		}
	}
	
	@Test
	public void animar1Test() throws IOException {
		setupEscenario();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 0; j < mundo.getMatriz().length; j++) {
				mundo.animar1(i, j, 37);
				assertEquals(mundo.getMatriz()[i][j], 12);
				mundo.animar1(i, j, 38);
				assertEquals(mundo.getMatriz()[i][j], 14);
				mundo.animar1(i, j, 39);
				assertEquals(mundo.getMatriz()[i][j], 10);
				mundo.animar1(i, j, 40);
				assertEquals(mundo.getMatriz()[i][j], 16);
			}
		}
	}
	
	@Test
	public void animar1Test0() throws IOException {
		setupEscenario0();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 0; j < mundo.getMatriz().length; j++) {
				mundo.animar1(i, j, 37);
				assertEquals(mundo.getMatriz()[i][j], 12);
				mundo.animar1(i, j, 38);
				assertEquals(mundo.getMatriz()[i][j], 14);
				mundo.animar1(i, j, 39);
				assertEquals(mundo.getMatriz()[i][j], 10);
				mundo.animar1(i, j, 40);
				assertEquals(mundo.getMatriz()[i][j], 16);
			}
		}
	}
	
	@Test
	public void animar1Test1() throws IOException {
		setupEscenario1();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 0; j < mundo.getMatriz().length; j++) {
				mundo.animar1(i, j, 37);
				assertEquals(mundo.getMatriz()[i][j], 12);
				mundo.animar1(i, j, 38);
				assertEquals(mundo.getMatriz()[i][j], 14);
				mundo.animar1(i, j, 39);
				assertEquals(mundo.getMatriz()[i][j], 10);
				mundo.animar1(i, j, 40);
				assertEquals(mundo.getMatriz()[i][j], 16);
			}
		}
	}
	
	@Test
	public void animar1Test2() throws IOException {
		setupEscenario2();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 0; j < mundo.getMatriz().length; j++) {
				mundo.animar1(i, j, 37);
				assertEquals(mundo.getMatriz()[i][j], 12);
				mundo.animar1(i, j, 38);
				assertEquals(mundo.getMatriz()[i][j], 14);
				mundo.animar1(i, j, 39);
				assertEquals(mundo.getMatriz()[i][j], 10);
				mundo.animar1(i, j, 40);
				assertEquals(mundo.getMatriz()[i][j], 16);
			}
		}
	}
	@Test
	public void animar1Test3() throws IOException {
		setupEscenario3();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 0; j < mundo.getMatriz().length; j++) {
				mundo.animar1(i, j, 37);
				assertEquals(mundo.getMatriz()[i][j], 12);
				mundo.animar1(i, j, 38);
				assertEquals(mundo.getMatriz()[i][j], 14);
				mundo.animar1(i, j, 39);
				assertEquals(mundo.getMatriz()[i][j], 10);
				mundo.animar1(i, j, 40);
				assertEquals(mundo.getMatriz()[i][j], 16);
			}
		}
	}
	
	@Test
	public void animar2Test() throws IOException {
		setupEscenario();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 0; j < mundo.getMatriz().length; j++) {
				mundo.animar2(i, j, 37);
				assertEquals(mundo.getMatriz()[i][j], 11);
				mundo.animar2(i, j, 38);
				assertEquals(mundo.getMatriz()[i][j], 13);
				mundo.animar2(i, j, 39);
				assertEquals(mundo.getMatriz()[i][j], 4);
				mundo.animar2(i, j, 40);
				assertEquals(mundo.getMatriz()[i][j], 15);
			}
		}
	}
	
	@Test
	public void animar2Test0() throws IOException {
		setupEscenario0();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 0; j < mundo.getMatriz().length; j++) {
				mundo.animar2(i, j, 37);
				assertEquals(mundo.getMatriz()[i][j], 11);
				mundo.animar2(i, j, 38);
				assertEquals(mundo.getMatriz()[i][j], 13);
				mundo.animar2(i, j, 39);
				assertEquals(mundo.getMatriz()[i][j], 4);
				mundo.animar2(i, j, 40);
				assertEquals(mundo.getMatriz()[i][j], 15);
			}
		}
	}
	
	@Test
	public void animar2Test1() throws IOException {
		setupEscenario1();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 0; j < mundo.getMatriz().length; j++) {
				mundo.animar2(i, j, 37);
				assertEquals(mundo.getMatriz()[i][j], 11);
				mundo.animar2(i, j, 38);
				assertEquals(mundo.getMatriz()[i][j], 13);
				mundo.animar2(i, j, 39);
				assertEquals(mundo.getMatriz()[i][j], 4);
				mundo.animar2(i, j, 40);
				assertEquals(mundo.getMatriz()[i][j], 15);
			}
		}
	}
	
	@Test
	public void animar2Test2() throws IOException {
		setupEscenario2();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 0; j < mundo.getMatriz().length; j++) {
				mundo.animar2(i, j, 37);
				assertEquals(mundo.getMatriz()[i][j], 11);
				mundo.animar2(i, j, 38);
				assertEquals(mundo.getMatriz()[i][j], 13);
				mundo.animar2(i, j, 39);
				assertEquals(mundo.getMatriz()[i][j], 4);
				mundo.animar2(i, j, 40);
				assertEquals(mundo.getMatriz()[i][j], 15);
			}
		}
	}
	@Test
	public void animar2Test3() throws IOException {
		setupEscenario3();
		for (int i = 0; i < mundo.getMatriz().length; i++) {
			for (int j = 0; j < mundo.getMatriz().length; j++) {
				mundo.animar2(i, j, 37);
				assertEquals(mundo.getMatriz()[i][j], 11);
				mundo.animar2(i, j, 38);
				assertEquals(mundo.getMatriz()[i][j], 13);
				mundo.animar2(i, j, 39);
				assertEquals(mundo.getMatriz()[i][j], 4);
				mundo.animar2(i, j, 40);
				assertEquals(mundo.getMatriz()[i][j], 15);
			}
		}
	}
	
}
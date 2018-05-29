package interfazPrincipal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelAux extends JPanel implements ActionListener{
	
	public static final String BUSCAR_JUGADOR_POR_NOMBRE = "Buscar jugador por nombre";
	public static final String BUSCAR_JUGADOR_POR_PUNTUACION = "Buscar jugador por puntuacion";

	private JButton boton;
	private JButton boton2;
	
	private InterfazBotones interfaz;
	
	public PanelAux(InterfazBotones interfazBotones) {
		setLayout(new GridLayout(1,2));
		boton = new JButton(BUSCAR_JUGADOR_POR_NOMBRE);
		boton.addActionListener(this);
		boton.setActionCommand(BUSCAR_JUGADOR_POR_NOMBRE);
		interfaz = interfazBotones;
		add(boton);
		
		boton2 = new JButton(BUSCAR_JUGADOR_POR_PUNTUACION);
		boton2.addActionListener(this);
		boton2.setActionCommand(BUSCAR_JUGADOR_POR_PUNTUACION);
		interfaz = interfazBotones;
		add(boton2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals(BUSCAR_JUGADOR_POR_NOMBRE)){
			interfaz.buscarNombre();
		}
		if (comando.equals(BUSCAR_JUGADOR_POR_PUNTUACION)) {
			interfaz.buscarPuntuacion();
		}
	}

}

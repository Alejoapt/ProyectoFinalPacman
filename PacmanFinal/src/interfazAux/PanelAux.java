package interfazAux;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelAux extends JPanel implements ActionListener{
	
	public static final String BUSCAR_JUGADOR_POR_PUNTUACION = "Buscar jugador por puntuacion";

	private JButton boton;
	
	private InterfazBotones interfaz;
	
	public PanelAux(InterfazBotones interfazBotones) {
		setLayout(new GridLayout(1,1));
		boton = new JButton(BUSCAR_JUGADOR_POR_PUNTUACION);
		boton.addActionListener(this);
		boton.setActionCommand(BUSCAR_JUGADOR_POR_PUNTUACION);
		interfaz = interfazBotones;
		add(boton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals(BUSCAR_JUGADOR_POR_PUNTUACION)){
			interfaz.buscar();
		}
	}

}

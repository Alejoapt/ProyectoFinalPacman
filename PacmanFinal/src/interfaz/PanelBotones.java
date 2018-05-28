package interfaz;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class PanelBotones extends JFrame implements	ActionListener{
	private JButton boton;
	private InterfazLaberinto interfaz;

	private JLabel img;
	
	public PanelBotones(InterfazLaberinto inte){
		boton = new JButton("Continuar");
		boton.setActionCommand("UNO");
		boton.addActionListener(this);
		setLayout(new BorderLayout());
		interfaz = inte;
		JPanel panelAux = new JPanel(new GridLayout(1,1));
		JPanel panelAux2 = new JPanel(new GridLayout(1,1));
		panelAux.add(boton);
		panelAux2.add(img);
		add(panelAux, BorderLayout.SOUTH);
		add(panelAux2, BorderLayout.CENTER);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent comand) {
		String comando = comand.getActionCommand();
		if(comando.equals("UNO")){
			setVisible(false);
			interfaz.terminar();
		}
	}
}

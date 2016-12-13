package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import metro.AEstrella;

public class Seleccion {
	
	protected JFrame frameSeleccion;
	private AEstrella servicios;
	private final Inicio inicio;
	private JButton btnAtrasMapa;

	public Seleccion(Inicio seleccion2, AEstrella servicios) {
		frameSeleccion = new JFrame();
		this.inicio = seleccion2;
		//this.ruta = seleccion.getRuta();
		this.servicios = servicios;
		inicialize();	
	}
	
	private void inicialize() {
		frameSeleccion.getContentPane().setLayout(null);
		frameSeleccion.setBounds(100, 100, 980, 514);						// La ventana sale desde el principio
		frameSeleccion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel labelOrigen = new JLabel("Origen");
		labelOrigen.setFont(new Font("Lucida Sans", Font.PLAIN, 17));
		labelOrigen.setBounds(43, 68, 211, 21);
		labelOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		frameSeleccion.getContentPane().add(labelOrigen);
		
		JLabel labelDestino = new JLabel("Destino");
		labelDestino.setFont(new Font("Lucida Sans", Font.PLAIN, 17));
		labelDestino.setBounds(356, 68, 211, 21);
		labelDestino.setHorizontalAlignment(SwingConstants.CENTER);
		frameSeleccion.getContentPane().add(labelDestino);
		
		
		
	}
		

}

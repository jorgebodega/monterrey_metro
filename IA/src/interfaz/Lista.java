package interfaz;

import metro.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class Lista {

	protected JFrame frameLinea;
	private JPanel contentPaneMapa;
	private AEstrella servicios;
	//private Ruta ruta;
	private final Inicio inicio;
	private JButton btnAtrasMapa;

	public Lista(Inicio seleccion2) {
		frameLinea = new JFrame();
		this.inicio = seleccion2;
		//this.ruta = seleccion.getRuta();
		inicialize();	
	}
	
	public void inicialize(){
		frameLinea.setBounds(800, 100, 894, 663);						// ventana del mapa 894, 663)
		
		contentPaneMapa = new JPanel();
		contentPaneMapa.setBorder(new EmptyBorder(5, 5, 5, 5));			// bordes del mapa
		contentPaneMapa.setLayout(null);
		
		frameLinea.setContentPane(contentPaneMapa);
		frameLinea.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.out.println("Hola2");
				frameLinea.setVisible(false);
				inicio.frameSeleccion.setVisible(true);
			}
		});
		
		btnAtrasMapa = new JButton("Atr\u00E1s");
		btnAtrasMapa.setBackground(Color.green);
		btnAtrasMapa.setBounds(393, 550, 100, 39);						// boton de atras
		contentPaneMapa.add(btnAtrasMapa);
		btnAtrasMapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameLinea.setVisible(false);
				if (inicio.frameSeleccion.isVisible())
					inicio.frameSeleccion.setVisible(true);

			}
		});
				
		JLabel ImagenMapa = new JLabel("");
		ImagenMapa.setIcon(new ImageIcon(Plano.class.getResource("/resources/LISTA.png")));
		ImagenMapa.setBounds(0, 0, 894, 663);						// mapa del metro
		contentPaneMapa.add(ImagenMapa);
	}

}
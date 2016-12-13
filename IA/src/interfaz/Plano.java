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

public class Plano {

	protected JFrame framePlano;
	private JPanel contentPaneMapa;
	private AEstrella servicios;
	//private Ruta ruta;
	private final Inicio inicio;
	private JButton btnAtrasMapa;

	public Plano(Inicio seleccion2, AEstrella servicios) {
		framePlano = new JFrame();
		this.inicio = seleccion2;
		//this.ruta = seleccion.getRuta();
		this.servicios = servicios;
		inicialize();	
	}
	
	public void inicialize(){
		framePlano.setBounds(800, 100, 798, 556);						// ventana del mapa
		
		contentPaneMapa = new JPanel();
		contentPaneMapa.setBorder(new EmptyBorder(5, 5, 5, 5));			// bordes del mapa
		contentPaneMapa.setLayout(null);
		
		framePlano.setContentPane(contentPaneMapa);
		framePlano.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.out.println("Hola2");
				framePlano.setVisible(false);
				inicio.frameSeleccion.setVisible(true);
			}
		});
		
		btnAtrasMapa = new JButton(new ImageIcon("/resources/descarga.jpg"));
		//btnAtrasMapa.setBackground(Color.green);
		btnAtrasMapa.setBounds(598, 35, 100, 39);						// boton de atras
		contentPaneMapa.add(btnAtrasMapa);
		btnAtrasMapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				framePlano.setVisible(false);
				if (inicio.frameSeleccion.isVisible())
					inicio.frameSeleccion.setVisible(true);

			}
		});
				
		JLabel ImagenMapa = new JLabel("");
		ImagenMapa.setIcon(new ImageIcon(Plano.class.getResource("/resources/monterrey-map.png")));
		ImagenMapa.setBounds(0, 0, 798, 556);						// mapa del metro
		contentPaneMapa.add(ImagenMapa);
	}

}
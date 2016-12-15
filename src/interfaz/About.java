package interfaz;

import metro.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class About {

	protected JFrame frameLinea;
	private JPanel contentPaneMapa;
	private final MenuInicio inicio;

	public About(MenuInicio seleccion2) {
		frameLinea = new JFrame();
		this.inicio = seleccion2;
		//this.ruta = seleccion.getRuta();
		inicialize();	
	}
	
	public void inicialize(){
		frameLinea.setBounds(400, 100, 580, 514);						// ventana del mapa 894, 663)
		
		contentPaneMapa = new JPanel();
		contentPaneMapa.setBorder(new EmptyBorder(5, 5, 5, 5));			// bordes del mapa
		contentPaneMapa.setLayout(null);
		
		frameLinea.setContentPane(contentPaneMapa);
		frameLinea.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				frameLinea.setVisible(false);
				inicio.frameSeleccion.setVisible(true);
			}
		});
		
		JButton atras = new JButton("Atrás");

		atras.setBounds(430, 20, 90, 30);
		contentPaneMapa.add(atras);
		atras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameLinea.setVisible(false);
				if (frameLinea.isVisible())
					frameLinea.setVisible(true);
			}
		});
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(150, 120, 310, 279);
		textArea.setText("AUTORES: \n\n  Miguel Alfaro Coronado \n\n  Jorge Bodega Fernanz \n\n"
				+ "  Husamdin El-Bouchakradi Nhili \n\n  Jersson Gonzales Altamirano \n\n"
				+ "  David Garcia Castaño");
		textArea.setBackground(Color.white);
		textArea.setForeground(Color.black);
		contentPaneMapa.add(textArea);
		textArea.setFont(new Font("ARIAL", Font.CENTER_BASELINE, 20));
		textArea.setAlignmentX(textArea.CENTER_ALIGNMENT);
		textArea.setAlignmentY(textArea.CENTER_ALIGNMENT);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(MenuInicio.class.getResource("/resources/images.png")));
		logo.setBounds(0,0,280,144);							// Imagen de Fondo
		frameLinea.getContentPane().add(logo);
		
		JLabel labelIndicaciones = new JLabel("");
		labelIndicaciones.setIcon(new ImageIcon(Trayecto.class.getResource("/resources/monterrey.jpg")));
		labelIndicaciones.setBounds(0, 0, 798, 556);
		contentPaneMapa.add(labelIndicaciones);
		

	}

}
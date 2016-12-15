package interfaz;

import metro.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFrame;



import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class Informacion {

	private Plano plano;
	public JFrame frameInfo;
	private JPanel contentInfo;
	private AEstrella servicios;
	private final Inicio seleccion;
	private JButton btnAtrasMapa;

	public Informacion(Inicio seleccion2) {
		frameInfo = new JFrame();
		this.seleccion = seleccion2;
		inicialize();	
	}

	public void inicialize(){
		frameInfo.setBounds(400, 100, 580, 514);

		contentInfo = new JPanel();
		contentInfo.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentInfo.setLayout(null);

		frameInfo.setContentPane(contentInfo);
		

		btnAtrasMapa = new JButton("Atrás");

		btnAtrasMapa.setBounds(400, 50, 103, 43);
		contentInfo.add(btnAtrasMapa);
		btnAtrasMapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameInfo.setVisible(false);
				if (seleccion.frameSeleccion.isVisible())
					seleccion.frameSeleccion.setVisible(true);
			}
		});
		
		
		String info = "<html><body>HORARIOS <br>  Todos los días <br>  05:00 - 00:00 <br>"
				+ "<br>TARIFAS <br> 1 viaje - $4.50 <br> 2 viajes - $8.50 <br> 6 viajes - $24.00  </body></html> ";
		
		JLabel lblSeleccioneUnOrigen = new JLabel(info);
		lblSeleccioneUnOrigen.setForeground(Color.white); 
		lblSeleccioneUnOrigen.setFont(new Font("Arial", Font.BOLD, 20));
		lblSeleccioneUnOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneUnOrigen.setBounds(150, 60, 350, 350);					// Seleccione un origen y destino
		frameInfo.getContentPane().add(lblSeleccioneUnOrigen);
		
		JLabel ImagenFondo = new JLabel("");
		ImagenFondo.setIcon(new ImageIcon(Inicio.class.getResource("/resources/monterrey.jpg")));
		ImagenFondo.setBounds(0, 0, 980, 514);								// Imagen de Fondo
		frameInfo.getContentPane().add(ImagenFondo);
		
		

		
		
		

	
		
		

	}
}
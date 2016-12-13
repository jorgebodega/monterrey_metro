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
		frameInfo.setBounds(100, 100, 680, 380);

		contentInfo = new JPanel();
		contentInfo.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentInfo.setLayout(null);

		frameInfo.setContentPane(contentInfo);
		frameInfo.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.out.println("Hola2");
				frameInfo.setVisible(false);
				seleccion.frameSeleccion.setVisible(true);
			}
		});

		btnAtrasMapa = new JButton("Atr\u00E1s");
		btnAtrasMapa.setBackground(new Color(0, 0, 0));
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


		String isab = "\nHORARIOS \n Todos los días \n 05:00 - 00:00 \n\n "
				+ "TARIFAS \n (en pesos mexicanos)\n 1 viaje - $4.50 \n 2 viajes - $8.50\n"
				+ " 6 viajes - $24.00 ";


		JTextArea jtextarea = new JTextArea();
		jtextarea.setBounds(50, 65, 200, 230);	
		jtextarea.setForeground(Color.white); 
		jtextarea.setText(isab);
		jtextarea.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
		jtextarea.setEditable(false);
		jtextarea.setBackground(Color.black);
		frameInfo.getContentPane().add(jtextarea);



		JLabel ImagenFondo = new JLabel("");
		ImagenFondo.setIcon(new ImageIcon(Inicio.class.getResource("/resources/images.png")));
		ImagenFondo.setBounds(280, 80, 320, 240);								// Imagen de Fondo
		frameInfo.getContentPane().add(ImagenFondo);
	}
}
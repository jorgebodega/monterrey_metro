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
import javax.swing.text.StyleConstants;
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

public class Info {

	public JFrame frameInfo;
	private JPanel contentInfo;
	private final MenuInicio seleccion;


	public Info(MenuInicio seleccion2) {
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


		JButton atras = new JButton("Atrás");

		atras.setBounds(400, 50, 103, 43);
		contentInfo.add(atras);
		atras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameInfo.setVisible(false);
				if (seleccion.frameSeleccion.isVisible())
					seleccion.frameSeleccion.setVisible(true);
			}
		});




		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(180, 150, 220, 250);
		textArea.setText("\n   TARIFAS \n   1 viaje - $4.50 \n   2 viajes - $8.50 "
				+ "\n   6 viajes - $24.00  \n\n"+ 
				"\n   HORARIOS \n  Todos los días \n  05:00 - 00:00 \n");
		textArea.setBackground(Color.white);
		textArea.setForeground(Color.black);
		contentInfo.add(textArea);
		textArea.setFont(new Font("ARIAL", Font.CENTER_BASELINE, 20));
		textArea.setAlignmentX( StyleConstants.ALIGN_CENTER);
		textArea.setAlignmentY( StyleConstants.ALIGN_CENTER);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(MenuInicio.class.getResource("/resources/images.png")));
		logo.setBounds(0,0,280,144);							// Imagen de Fondo
		frameInfo.getContentPane().add(logo);

		JLabel ImagenFondo = new JLabel("");
		ImagenFondo.setIcon(new ImageIcon(MenuInicio.class.getResource("/resources/monterrey.jpg")));
		ImagenFondo.setBounds(0, 0, 980, 514);								// Imagen de Fondo
		frameInfo.getContentPane().add(ImagenFondo);











	}
}
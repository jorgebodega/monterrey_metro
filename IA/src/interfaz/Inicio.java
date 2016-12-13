package interfaz;

import metro.AEstrella;
import metro.Construccion;
import metro.Estacion;
import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Inicio {
	
	public JFrame frameSeleccion;
	public JFrame frameSeleccion2;
	private AEstrella servicios;
	private Seleccion seleccion;
	private Plano plano;
	private Informacion info;
	private Trayecto ruta;
	private Construccion construccion;
	private DefaultListModel<String> listaOrigenD;
	private DefaultListModel<String> listaDestinoD;
	private List<String> estaciones;
	private JList listaOrigen;
	private JList listaDestino;
	protected String origen;
	protected String destino;
	Color color;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frameSeleccion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicio() {
		frameSeleccion = new JFrame();
		plano = new Plano(this,servicios);
		info = new Informacion(this);
		seleccion = new Seleccion(this,servicios);
		
		initialize();
	}
	
	private void initialize() {
		frameSeleccion.getContentPane().setLayout(null);
		frameSeleccion.setBounds(400, 100, 580, 514);						// La ventana sale desde el principio
		frameSeleccion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton buttonMapa = new JButton("MAPA");
		buttonMapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				plano.framePlano.setVisible(true);
			}
		});
		
		buttonMapa.setFont(new Font("Arial", Font.BOLD, 12));
		//buttonMapa.setBackground(Color.TRANSLUCENT);
		buttonMapa.setBounds(200, 300, 200, 39);					// boton ver mapa
		frameSeleccion.getContentPane().add(buttonMapa);
		
		
		/////////////
		
		JButton buttonLE = new JButton("ESTACIONES/LINEAS");
		buttonLE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				info.frameInfo.setVisible(true);
			}
		});
		
		buttonLE.setFont(new Font("Arial", Font.BOLD, 12));
		
		buttonLE.setBounds(200, 100, 200, 39);					// boton ver mapa
		frameSeleccion.getContentPane().add(buttonLE);
		
		
		//////
		
		JButton buttonTray = new JButton("TRAYECTOS");
		buttonTray.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccion.frameSeleccion.setVisible(true);
			}
		});
		
		buttonTray.setFont(new Font("Arial", Font.BOLD, 12));
		
		buttonTray.setBounds(200, 200, 200, 39);					// boton ver mapa
		frameSeleccion.getContentPane().add(buttonTray);
		
		
		
		JButton buttonInfo = new JButton("INFORMACI\u00d3N");
		buttonInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				info.frameInfo.setVisible(true);
			}
		});
		
		buttonInfo.setFont(new Font("Arial", Font.BOLD, 12));
		buttonInfo.setBounds(400, 420, 120, 39);					// boton ver mapa
		frameSeleccion.getContentPane().add(buttonInfo);
		//buttonInfo.setBackground(Color.);
		
		/*String nameMetro="METRO \n MONTERREY";
		JLabel lmetro = new JLabel(nameMetro);
		lmetro.setForeground(Color.white); 
		lmetro.setFont(new Font("Arial", Font.BOLD, 30));
		lmetro.setHorizontalAlignment(SwingConstants.CENTER);
		lmetro.setBounds(80, 31, 300, 36);					// Seleccione un origen y destino
		frameSeleccion.getContentPane().add(lmetro);
		
				
		JLabel lblSeleccioneUnOrigen = new JLabel("MONTERREY");
		lblSeleccioneUnOrigen.setForeground(Color.red); 
		lblSeleccioneUnOrigen.setFont(new Font("Lucida Calligraphy", Font.BOLD, 40));
		lblSeleccioneUnOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneUnOrigen.setBounds(80, 69, 300, 36);					// Seleccione un origen y destino
		frameSeleccion.getContentPane().add(lblSeleccioneUnOrigen);*/
		
		
		JPanel panelFondoBlanco = new JPanel();
		frameSeleccion.getContentPane().add(panelFondoBlanco);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Inicio.class.getResource("/resources/images.png")));
		logo.setBounds(0,0,280,144);							// Imagen de Fondo
		frameSeleccion.getContentPane().add(logo);
		
		JPanel panelFondoBlancoTitulo = new JPanel();
		frameSeleccion.getContentPane().add(panelFondoBlancoTitulo);
		
		JLabel ImagenFondo = new JLabel("");
		ImagenFondo.setIcon(new ImageIcon(Inicio.class.getResource("/resources/monterrey.jpg")));
		ImagenFondo.setBounds(0, 0, 980, 514);								// Imagen de Fondo
		frameSeleccion.getContentPane().add(ImagenFondo);

		
		
		
	}
}


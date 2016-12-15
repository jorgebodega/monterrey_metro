package interfaz;

import metro.AEstrella;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuInicio {
	
	public JFrame frameSeleccion;
	public JFrame frameSeleccion2;
	private AEstrella servicios;
	protected OrigenDestino seleccion;
	private Mapa plano;
	private Info info;
	
	private About lista;

	protected String origen;
	protected String destino;
	Color color;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					MenuInicio window = new MenuInicio();
					window.frameSeleccion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
	}

	public MenuInicio() {
		frameSeleccion = new JFrame();
		plano = new Mapa(this,servicios);
		info = new Info(this);
		seleccion = new OrigenDestino(this);
		lista = new About(this);

		initialize();
	}
	
	private void initialize() {
		frameSeleccion.getContentPane().setLayout(null);
		frameSeleccion.setBounds(400, 100, 580, 514);			
		frameSeleccion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton buttonMapa = new JButton("MAPA");
		buttonMapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				plano.framePlano.setVisible(true);
			}
		});
		
		buttonMapa.setFont(new Font("Arial", Font.BOLD, 12));
		buttonMapa.setBounds(200, 100, 200, 39);				// boton ver mapa
		frameSeleccion.getContentPane().add(buttonMapa);
		
		
		/////////////
		
		
		
		
		//////
		
		JButton buttonTray = new JButton("TRAYECTOS");
		buttonTray.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccion.frameSeleccion.setVisible(true);
			}
		});
		
		buttonTray.setFont(new Font("Arial", Font.BOLD, 12));
		
		buttonTray.setBounds(200, 200, 200, 39);					// boton ver Trayectos
		frameSeleccion.getContentPane().add(buttonTray);
		
		
		
		
		JButton buttonInfo = new JButton("INFORMACIÓN");
		buttonInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				info.frameInfo.setVisible(true);
			}
		});
		
		
		
		buttonInfo.setFont(new Font("Arial", Font.BOLD, 12));
		buttonInfo.setBounds(200, 300, 200, 39);			// boton ver Info
		frameSeleccion.getContentPane().add(buttonInfo);
		
		JButton buttonLE = new JButton("About");
		buttonLE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lista.frameLinea.setVisible(true);
				
			}
		});
		
		buttonLE.setFont(new Font("Arial", Font.BOLD, 12));
		
		buttonLE.setBounds(400, 420, 80, 30);					// boton ver About
		frameSeleccion.getContentPane().add(buttonLE);
		
		
		JPanel panelFondoBlanco = new JPanel();
		frameSeleccion.getContentPane().add(panelFondoBlanco);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(MenuInicio.class.getResource("/resources/images.png")));
		logo.setBounds(0,0,280,144);							// Imagen Logo
		frameSeleccion.getContentPane().add(logo);
		
		JPanel panelFondoBlancoTitulo = new JPanel();
		frameSeleccion.getContentPane().add(panelFondoBlancoTitulo);
		
		JLabel ImagenFondo = new JLabel("");
		ImagenFondo.setIcon(new ImageIcon(MenuInicio.class.getResource("/resources/monterrey.jpg")));
		ImagenFondo.setBounds(0, 0, 980, 514);								// Imagen de Fondo
		frameSeleccion.getContentPane().add(ImagenFondo);

		
		
		
	}
}


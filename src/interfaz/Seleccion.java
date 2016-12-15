package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import metro.AEstrella;

public class Seleccion {

	private JPanel contentSeleccion;
	protected JFrame frameSeleccion;
	private Trayecto ruta;
	private AEstrella servicios;
	private final Inicio inicio;
	private JButton btnAtrasMapa;
	private JPanel panel;
	private JPanel panel2;
	public Object origen;
	public Object destino;
	

	public Seleccion(Inicio seleccion2, AEstrella servicios) {
		frameSeleccion = new JFrame();
		this.inicio = seleccion2;
		//this.ruta = seleccion.getRuta();
		this.servicios = servicios;
		ruta=new Trayecto(this.inicio, this.servicios);

		inicialize();	
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	private void inicialize() {
		frameSeleccion.getContentPane().setLayout(null);
		frameSeleccion.setBounds(400, 100, 580, 514);						// La ventana sale desde el principio

		contentSeleccion = new JPanel();
		contentSeleccion.setBorder(new EmptyBorder(100, 100, 980, 514));
		contentSeleccion.setLayout(null);

		frameSeleccion.setContentPane(contentSeleccion);


		btnAtrasMapa = new JButton("Atrás");

		btnAtrasMapa.setBounds(430, 20, 90, 30);
		contentSeleccion.add(btnAtrasMapa);
		btnAtrasMapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameSeleccion.setVisible(false);
				if (frameSeleccion.isVisible())
					frameSeleccion.setVisible(true);
			}
		});


		JLabel labelOrigen = new JLabel("Origen");
		labelOrigen.setFont(new Font("ARIAL", Font.PLAIN, 17));
		labelOrigen.setBounds(43, 68, 211, 21);
		labelOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		frameSeleccion.getContentPane().add(labelOrigen);


		//Creación del panel, que contendra JList 
		panel = new JPanel(); 
		panel.setBounds(100, 80, 200, 340);
		panel.setLayout(null); 

		//creación de los elememtos que componen la lista 
		String[] nombres = {"AdolfoPrieto", "Alameda", "Alfonso Reyes",
				"Anahuac", "Aztlan", "Central", "Conchello", "Cuauhtemoc", "Cuauhtemoc", 
				"Del Golfo", "Edison", "Eloy Cavazos", "Exposicion", "Felix U Gomez",
				"Felix U Gomez", "Fundadores", "GeneralAnaya", "GeneralIZaragoza",
				"GeneralIZaragoza", "Hospital", "HospitalMetropolitano", "Lendo De Tejada",
				"LosAngeles", "Mitras", "NignosHeroes", "PadreMier", "Parque Fundidora",
				"Penitenciaria", "Regina", "Ruiz","San Bernabe", "SanNicolas", "SantaLucia",
				"SantiagoTapia", "Sendero", "Simon Bolivar","Tallares", "Unidad Modelo",
				"Universidad", "Violeta", "Y Griega"}; 

		//creación del objeto lista 
		JList lista = new JList(nombres); 

		//se cambia la orientación de presentación y el ajuste 
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 

		//selecciona un elemento de la lista 
		origen = lista.getSelectedValue(); 
		
		//recoge el indice de los seleccionados 
		int[] indices = lista.getSelectedIndices(); 

		// aquí se crea el objeto, es decir la barra de desplazamiento 
		JScrollPane barraDesplazamiento = new JScrollPane(lista); 
		barraDesplazamiento.setBounds(10,20,150,310); 

		//Agrega la barra de desplazamiento al panel 
		panel.add(barraDesplazamiento); 


		frameSeleccion.setVisible(true); 
		frameSeleccion.add(panel); 

		JLabel labelDestino = new JLabel("Destino");
		labelDestino.setFont(new Font("ARIAL", Font.PLAIN, 17));
		labelDestino.setBounds(300, 68, 211, 21);
		labelDestino.setHorizontalAlignment(SwingConstants.CENTER);
		frameSeleccion.getContentPane().add(labelDestino);

		

		//Creación del panel, que contendra JList 
		panel2 = new JPanel(); 
		panel2.setBounds(230, 0, 250, 410);
		panel2.setLayout(null); 

		//creación del objeto lista 
		JList lista2 = new JList(nombres); 

		//se cambia la orientación de presentación y el ajuste 
		lista2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 

		//selecciona un elemento de la lista 
		 destino = lista2.getSelectedValue(); 
		
		//recoge el indice de los seleccionados 
		int[] indices2 = lista2.getSelectedIndices(); 

		// aquí se crea el objeto, es decir la barra de desplazamiento 
		JScrollPane barraDesplazamiento2 = new JScrollPane(lista2); 
		barraDesplazamiento2.setBounds(100,100,150,310); 

		//Agrega la barra de desplazamiento al panel 
		panel2.add(barraDesplazamiento2); 

		frameSeleccion.add(panel2); 
		frameSeleccion.setVisible(true); 
		
		
		
		JButton buttonSig = new JButton("SIGUIENTE");
		buttonSig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ruta.frameTrayecto.setVisible(true);
			}
		});
		
		buttonSig.setFont(new Font("Arial", Font.BOLD, 12));
		buttonSig.setBounds(250, 420, 100, 30);					// boton ver mapa
		frameSeleccion.getContentPane().add(buttonSig);
		
		
	}




}

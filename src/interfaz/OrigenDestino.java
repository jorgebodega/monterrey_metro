package interfaz;

import metro.AEstrella;
import metro.Construccion;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class OrigenDestino {
	
	protected JFrame frameSeleccion;
	private JPanel contentSeleccion;
	private AEstrella servicios;
	private Trayecto ruta;
	private Construccion construccion;
	protected String origen;
	protected String destino;
	private List<String> estaciones;
	private JList<String> listaOrigen;
	private JList<String> listaDestino;
	

	public OrigenDestino(MenuInicio seleccion2) {
		frameSeleccion = new JFrame();
		construccion = new Construccion();
		servicios = new AEstrella();
		ruta = new Trayecto(this,servicios);
		origen = "";
		destino = "";
		initialize();
	}
	
	public Trayecto getRuta(){
		return ruta;
	}

	private void initialize() {
		frameSeleccion.getContentPane().setLayout(null);
		frameSeleccion.setBounds(400, 100, 580, 514);						// La ventana sale desde el principio

		contentSeleccion = new JPanel();
		contentSeleccion.setBorder(new EmptyBorder(100, 100, 980, 514));
		contentSeleccion.setLayout(null);

		frameSeleccion.setContentPane(contentSeleccion);


		JButton btnAtrasMapa = new JButton("Atrás");

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
		labelOrigen.setFont(new Font("ARIAL", Font.CENTER_BASELINE, 20));
		labelOrigen.setBounds(43, 68, 211, 21);
		labelOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		frameSeleccion.getContentPane().add(labelOrigen);
		
		
		JScrollPane scrollPaneOrigen = new JScrollPane();
		scrollPaneOrigen.setBounds(100,100,150,310);
		frameSeleccion.getContentPane().add(scrollPaneOrigen);
		
		DefaultListModel<String>listaOrigenD = new DefaultListModel<String>();
		DefaultListModel<String>listaDestinoD = new DefaultListModel<String>();
		
		listaOrigen = new JList<String>(listaOrigenD);
		scrollPaneOrigen.setViewportView(listaOrigen);
		estaciones = new ArrayList<String>();
		estaciones = construccion.estacionesOrdenadas();
		final int longitud = estaciones.size();
		for(int i = 0; i < longitud ; ++i){
			listaOrigenD.addElement(estaciones.get(i));
		}
		listaOrigen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				origen = listaOrigen.getSelectedValue().toString();
				listaDestinoD.clear();
				estaciones = construccion.estacionesOrdenadas();
				estaciones.remove(listaOrigen.getSelectedValue());
				final int longitud = estaciones.size();
				for(int i = 0; i < longitud ; ++i){
					listaDestinoD.addElement(estaciones.get(i));
				}
			}
		});
		
		JLabel labelDestino = new JLabel("Destino");
		labelDestino.setFont(new Font("ARIAL", Font.CENTER_BASELINE, 20));
		labelDestino.setForeground(Color.white);
		labelDestino.setBounds(300, 68, 211, 21);
		labelDestino.setHorizontalAlignment(SwingConstants.CENTER);
		frameSeleccion.getContentPane().add(labelDestino);
		
		JScrollPane scrollPaneDestino = new JScrollPane();
		scrollPaneDestino.setBounds(350,100,150,310); 
		frameSeleccion.getContentPane().add(scrollPaneDestino);
		
		listaDestino = new JList<String>(listaDestinoD);
		listaDestino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				destino = listaDestino.getSelectedValue().toString();
			}
		});
		scrollPaneDestino.setViewportView(listaDestino);
		
		JButton buttonSig = new JButton("SIGUIENTE");
		buttonSig.addMouseListener(new MouseAdapter() {
			@Override
		public void mouseClicked(MouseEvent arg0) {
			if((!origen.equals(""))&&((!destino.equals("")))){
				ruta.hacerRecorrido();
				frameSeleccion.setVisible(false);
				ruta.frameTrayecto.setVisible(true);
			}
			}
		});
		
		buttonSig.setFont(new Font("Arial", Font.BOLD, 12));
		buttonSig.setBounds(250, 420, 100, 30);					// boton ver mapa
		frameSeleccion.getContentPane().add(buttonSig);
		
		
		JLabel ImagenFondo = new JLabel("");
		ImagenFondo.setIcon(new ImageIcon(OrigenDestino.class.getResource("/resources/monterrey.jpg")));
		ImagenFondo.setBounds(0, 0, 798, 556);
		frameSeleccion.getContentPane().add(ImagenFondo);
		
	}
}
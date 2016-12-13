package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import metro.AEstrella;
import metro.Construccion;
import metro.Estacion;

public class Trayecto {
	protected JFrame frameTrayecto;
	private final Inicio inicio;
	private AEstrella aEstre;
	private Construccion construccion;
	private ArrayList<String> trasbordos;
	private JPanel contentPaneMapa;
	private JTextArea textArea;
	private JTextArea nodos;
	private JLabel labelIndicaciones;
	private JPanel panelIndicaciones;
	private JButton btnVerMapaRuta;
	private JPanel panel_2;
	private JPanel contentPaneRuta;
	private Plano mapa;
	
	public Trayecto(Inicio inicio, AEstrella aEstre){
		frameTrayecto = new JFrame();
		this.inicio = inicio;
		this.aEstre = aEstre;
		this.trasbordos = new ArrayList<String>();
		this.trasbordos.add("Cuauhtemoc");
		this.trasbordos.add("GeneralIZaragoza");
		this.trasbordos.add("Felix U Gomez");
		construccion = new Construccion();
		inicialize();
	}
	
	public List<Estacion> verificarDestino(Estacion origen, String destino)
	{
		int linea = 0;
		Estacion trasbordoB = construccion.getEstacion(destino);
		List<Estacion> comparar = aEstre.recorrido(origen, trasbordoB), resultado = null;
		if(trasbordoB.getNumEnlaces()){
			linea = trasbordoB.getConexionA();
			resultado =  aEstre.recorrido(origen, construccion.getLineas()[linea-1].get(destino));
			comparar = aEstre.getUltimoTiempo() > comparar.get(0).getPesoRecorrido() ? comparar : resultado;
		}
		return comparar;
	}
	
	
	public void hacerRecorrido(){
		double tiempo = 0;
		List<Estacion> recorrido = new ArrayList<Estacion>();
		if(!this.trasbordos.contains(inicio.origen) && !this.trasbordos.contains(inicio.destino))
		{
			recorrido = aEstre.recorrido(construccion.getEstacion(inicio.origen), construccion.getEstacion(inicio.destino));
			tiempo = aEstre.getUltimoTiempo();
		}
		else if(this.trasbordos.contains(inicio.origen) && !this.trasbordos.contains(inicio.destino))
		{
			int linea = 0;
			Estacion trasbordoA = construccion.getEstacion(inicio.origen);
			recorrido = aEstre.recorrido(trasbordoA, construccion.getEstacion(inicio.destino));
			tiempo = aEstre.getUltimoTiempo();
			List<Estacion> comparar = null;
			if(trasbordoA.getNumEnlaces())
			{

				linea = trasbordoA.getConexionA();
				comparar = aEstre.recorrido(construccion.getLineas()[linea-1].get(inicio.origen), construccion.getEstacion(inicio.destino));
				recorrido = tiempo > aEstre.getUltimoTiempo() ? comparar : recorrido;
				tiempo = tiempo > aEstre.getUltimoTiempo() ? aEstre.getUltimoTiempo() : tiempo;
			}
		}
		else if(!this.trasbordos.contains(inicio.origen) && this.trasbordos.contains(inicio.destino))
		{
			recorrido = verificarDestino(construccion.getEstacion(inicio.origen), inicio.destino);
			tiempo = recorrido.get(0).getPesoRecorrido();
		}
		else
		{
			List<Estacion> comparar = null;
			Estacion origen = construccion.getEstacion(inicio.origen);
			recorrido = verificarDestino(origen, inicio.destino);
			tiempo = recorrido.get(0).getPesoRecorrido();
			int conexiones[] = {origen.getConexionA()/*, origen.getConexionB()*/};
			for(int i = 0; i <1 /*2*/; i++)
				if(conexiones[i] > 0)
				{
					origen = construccion.getLineas()[conexiones[i]-1].get(inicio.origen);
					comparar = verificarDestino(origen, inicio.destino);
					recorrido = tiempo > comparar.get(0).getPesoRecorrido() ? comparar : recorrido;
					tiempo = tiempo > comparar.get(0).getPesoRecorrido() ? comparar.get(0).getPesoRecorrido() : tiempo;
				}
		}
		inicio.origen = "";
		inicio.destino = "";
		String ruta = "";
		String nodo = "";
		String nombre = "";
		int linea = 0;
		boolean trasbordo = false;
		int size = recorrido.size();
		for(int i = size-1; i>-1 ; i--){
			if(i == size-1){
				nombre = recorrido.get(i).getNombre();
				linea = recorrido.get(i).getLinea();
				ruta = ruta + "Usted est· en ";
				ruta = ruta + nombre + "\n";
				ruta = ruta + "Tome la linea " + linea + " hasta la estacion ";	
			}
			else if (i == 0){
				ruta = ruta + recorrido.get(i).getNombre();
			}
			else if(recorrido.get(i).getLinea()!= linea){
				ruta = ruta + nombre + "\nHaga un trasbordo:\n";
				linea = recorrido.get(i).getLinea();
				ruta = ruta + "Tome la linea " + linea + " hasta la estacion ";	
			}
			else
				nombre = recorrido.get(i).getNombre();

			nodo = nodo + recorrido.get(i).getNombre() +" (linea " + recorrido.get(i).getLinea() + ")\n";
		}
		ruta = ruta + "\n\nTiempo estimado: " + (int)tiempo + " minutos";
		textArea.setText(ruta);
		nodos.setText(nodo);
	}
	
	public void inicialize(){

		frameTrayecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTrayecto.setBounds(100, 100, 685, 514);
		frameTrayecto.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				frameTrayecto.setVisible(false);
				inicio.frameSeleccion.setVisible(true);
			}
		});

		contentPaneRuta = new JPanel();
		contentPaneRuta.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneRuta.setLayout(null);

		frameTrayecto.setContentPane(contentPaneRuta);

		JButton btnAtrasRuta = new JButton("Atr\u00E1s");
		btnAtrasRuta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameTrayecto.setVisible(false);
				inicio.frameSeleccion.setVisible(true);
			}
		});
		btnAtrasRuta.setBounds(47, 395, 103, 43);
		contentPaneRuta.add(btnAtrasRuta);

		btnVerMapaRuta = new JButton("Ver Mapa");
		btnVerMapaRuta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mapa.framePlano.setVisible(true);

			}
		});
		btnVerMapaRuta.setBounds(464, 395, 103, 43);
		contentPaneRuta.add(btnVerMapaRuta);

		JLabel lblIndicacionesRutaObtenida = new JLabel("Indicaciones de la ruta obtenida");
		lblIndicacionesRutaObtenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndicacionesRutaObtenida.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		lblIndicacionesRutaObtenida.setBounds(10, 11, 649, 36);
		contentPaneRuta.add(lblIndicacionesRutaObtenida);

		panelIndicaciones = new JPanel();
		panelIndicaciones.setBackground(Color.WHITE);
		panelIndicaciones.setBounds(10, 61, 649, 323);
		contentPaneRuta.add(panelIndicaciones);
		panelIndicaciones.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 223, 301);
		panelIndicaciones.add(panel);
		panel.setLayout(null);

		nodos = new JTextArea();
		nodos.setEditable(false);
		nodos.setBounds(10, 11, 203, 279);
		panel.add(nodos);
		nodos.setFont(new Font("Lucida Sans", Font.PLAIN, 13));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(243, 11, 406, 301);
		panelIndicaciones.add(panel_1);
		panel_1.setLayout(null);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 11, 386, 279);
		panel_1.add(textArea);
		textArea.setFont(new Font("Lucida Sans", Font.PLAIN, 13));

		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 11, 659, 36);
		contentPaneRuta.add(panel_2);

		labelIndicaciones = new JLabel("");
		labelIndicaciones.setIcon(new ImageIcon(Trayecto.class.getResource("/resources/Seleccion.png")));
		labelIndicaciones.setBounds(0, 0, 669, 476);
		contentPaneRuta.add(labelIndicaciones);
	}
	

}

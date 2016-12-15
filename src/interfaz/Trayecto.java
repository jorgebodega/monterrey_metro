package interfaz;
import metro.Construccion;
import metro.Coordenada;
import metro.Estacion;
import metro.AEstrella;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Trayecto{

	protected JFrame frameTrayecto;
	private JPanel contentPaneRuta;
	private AEstrella servicios;
	private OrigenDestino seleccion;
	private List<String> trasbordos;
	private JLabel labelIndicaciones;
	private JTextArea textArea;
	private JTextArea textArea2;
	private Construccion construccion;

	public Trayecto(OrigenDestino seleccion, AEstrella servicios) {
		frameTrayecto = new JFrame();
		this.seleccion = seleccion;
		this.servicios = servicios;
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
		List<Estacion> comparar = servicios.recorrido(origen, trasbordoB), resultado = null;
		if(trasbordoB.getNumEnlaces())
		{

			linea = trasbordoB.getConexionA();
			resultado =  servicios.recorrido(origen, construccion.getLineas()[linea-1].get(destino));
			comparar = servicios.getUltimoTiempo() > comparar.get(0).getPesoRecorrido() ? comparar : resultado;
		}
		return comparar;
	}

	public void hacerRecorrido(){
		double tiempo = 0;
		List<Estacion> recorrido = new ArrayList<Estacion>();
		if(!this.trasbordos.contains(seleccion.origen) && !this.trasbordos.contains(seleccion.destino))
		{
			recorrido = servicios.recorrido(construccion.getEstacion(seleccion.origen), construccion.getEstacion(seleccion.destino));
			tiempo = servicios.getUltimoTiempo();
		}
		else if(this.trasbordos.contains(seleccion.origen) && !this.trasbordos.contains(seleccion.destino))
		{
			int linea = 0;
			Estacion trasbordoA = construccion.getEstacion(seleccion.origen);
			recorrido = servicios.recorrido(trasbordoA, construccion.getEstacion(seleccion.destino));
			tiempo = servicios.getUltimoTiempo();
			List<Estacion> comparar = null;
			if(trasbordoA.getNumEnlaces())
			{

				linea = trasbordoA.getConexionA();
				comparar = servicios.recorrido(construccion.getLineas()[linea-1].get(seleccion.origen), construccion.getEstacion(seleccion.destino));
				recorrido = tiempo > servicios.getUltimoTiempo() ? comparar : recorrido;
				tiempo = tiempo > servicios.getUltimoTiempo() ? servicios.getUltimoTiempo() : tiempo;
			}
		}
		else if(!this.trasbordos.contains(seleccion.origen) && this.trasbordos.contains(seleccion.destino))
		{
			recorrido = verificarDestino(construccion.getEstacion(seleccion.origen), seleccion.destino);
			tiempo = recorrido.get(0).getPesoRecorrido();
		}
		else
		{
			List<Estacion> comparar = null;
			Estacion origen = construccion.getEstacion(seleccion.origen);
			recorrido = verificarDestino(origen, seleccion.destino);
			tiempo = recorrido.get(0).getPesoRecorrido();
			int conexiones[] = {origen.getConexionA()/*, origen.getConexionB()*/};
			for(int i = 0; i <1 /*2*/; i++)
				if(conexiones[i] > 0)
				{
					origen = construccion.getLineas()[conexiones[i]-1].get(seleccion.origen);
					comparar = verificarDestino(origen, seleccion.destino);
					recorrido = tiempo > comparar.get(0).getPesoRecorrido() ? comparar : recorrido;
					tiempo = tiempo > comparar.get(0).getPesoRecorrido() ? comparar.get(0).getPesoRecorrido() : tiempo;
				}
		}
		seleccion.origen = "";
		seleccion.destino = "";
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
				ruta = ruta + "Se encuentra en ";
				ruta = ruta + nombre + "\n";
				ruta = ruta + "Debe tomar la linea " + linea + "\n hasta la estacion ";	
			}
			else if (i == 0){
				ruta = ruta + recorrido.get(i).getNombre();
			}
			else if(recorrido.get(i).getLinea()!= linea){
				ruta = ruta + nombre + "\nHaga transbordo \n";
				linea = recorrido.get(i).getLinea();
				ruta = ruta + "Debe tomar la linea " + linea + " hasta la estacion ";	
			}
			else
				nombre = recorrido.get(i).getNombre();

			nodo =nodo + recorrido.get(i).getNombre() +" (linea " + recorrido.get(i).getLinea() + ")\n";
		}
		ruta = ruta + "\n\nTiempo estimado: " + (int)tiempo + " minutos";
		textArea.setText(nodo);
		textArea2.setText(ruta);
		


	}

	public void inicialize(){

		frameTrayecto.setBounds(400, 100, 580, 514);	
		frameTrayecto.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				frameTrayecto.setVisible(false);
				seleccion.frameSeleccion.setVisible(true);
			}
		});

		contentPaneRuta = new JPanel();
		contentPaneRuta.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPaneRuta.setLayout(null);

		frameTrayecto.setContentPane(contentPaneRuta);
		
		JButton btnAtrasMapa = new JButton("MENÚ PRINCIPAL");

		btnAtrasMapa.setBounds(250, 420, 150, 30);
		contentPaneRuta.add(btnAtrasMapa);
		btnAtrasMapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameTrayecto.setVisible(false);
				if (frameTrayecto.isVisible())
					frameTrayecto.setVisible(true);
			}
		});
		

		JLabel lblSeleccioneUnOrigen = new JLabel("RUTA OBTENIDA");
		lblSeleccioneUnOrigen.setForeground(Color.BLACK); 
		lblSeleccioneUnOrigen.setFont(new Font("ARIAL", Font.BOLD, 25));
		lblSeleccioneUnOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneUnOrigen.setBounds(10, 10, 300, 56);					// Seleccione un origen y destino
		frameTrayecto.getContentPane().add(lblSeleccioneUnOrigen);



		textArea = new JTextArea();
		textArea.setBackground(Color.white);
		textArea.setEditable(false);
		textArea.setBounds(350, 100, 203, 279);
		contentPaneRuta.add(textArea);
		textArea.setFont(new Font("ARIAL", Font.CENTER_BASELINE, 12));
		textArea.setAlignmentX(SwingConstants.CENTER);
		textArea.setAlignmentX(SwingConstants.CENTER);
		textArea.setAlignmentY(SwingConstants.CENTER);


		textArea2 = new JTextArea();
		textArea2.setEditable(false);
		textArea2.setBounds(10, 100, 330, 280);
		contentPaneRuta.add(textArea2);
		textArea2.setFont(new Font("ARIAL", Font.CENTER_BASELINE, 12));
		textArea2.setAlignmentX(SwingConstants.CENTER);
		textArea2.setAlignmentY(SwingConstants.CENTER);

		labelIndicaciones = new JLabel("");
		labelIndicaciones.setIcon(new ImageIcon(Trayecto.class.getResource("/resources/monterrey.jpg")));
		labelIndicaciones.setBounds(0, 0, 798, 556);
		contentPaneRuta.add(labelIndicaciones);
	}
}
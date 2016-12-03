package Grafica;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JScrollPane;


public class ChoiceLle extends Applet implements ItemListener {
	/* Declaration */
	private LayoutManager Layout;
	String [] Estaciones = new String [55];;
	List Selector = new List(30,false);
	private Font Times;
	Ventana llegada;

	public ChoiceLle (Ventana llegada, JScrollPane panel, Container contentpane) {
		/* Declaration */
		this.llegada = llegada;
		int i;

		/* Instantiation */
		Times = new Font("Arial", 15, 25);
		Layout = new FlowLayout ();
		Selector.setFont (Times);
		Selector.setBounds(75, 200, 335, 90);


		/* Decoration */
		Estaciones [0] = "Estacion de llegada ...";
		Estaciones [1]= "Andel";
		Estaciones [2]= "Budejovicka";
		Estaciones [3]= "Cerny Most";
		Estaciones [4]= "Ceskomoravska";
		Estaciones [5]= "Chodov";
		Estaciones [6]= "Dejvicka";
		Estaciones [7]= "Depo Hostivar";
		Estaciones [8]= "Flora";
		Estaciones [9]= "Florenc";
		Estaciones [10]= "Haje";
		Estaciones [11]= "Hlavni Nadrazi";
		Estaciones [12]= "Hloubetin";
		Estaciones [13]= "Hradcanska";
		Estaciones [14]= "Hurka";
		Estaciones [15]= "I.P.Pavlova";
		Estaciones [16]= "Invalidovna";
		Estaciones [17]= "Jinonice";
		Estaciones [18]= "Jiriho z Podebrad";
		Estaciones [19]= "Kacerov";
		Estaciones [20]= "Karlovo Namesti";
		Estaciones [21]= "Kobylisy";
		Estaciones [22]= "Kolbenova";
		Estaciones [23]= "Krizikova";
		Estaciones [24]= "Ladvi";
		Estaciones [25]= "Letnany";
		Estaciones [26]= "Luka";
		Estaciones [27]= "Luziny";
		Estaciones [28]= "Malostranska";
		Estaciones [29]= "Mustek";
		Estaciones [30]= "Muzeum";
		Estaciones [31]= "Nadrazi Holesovice";
		Estaciones [32]= "Namesti Miru";
		Estaciones [33]= "Namesti Republiky";
		Estaciones [34]= "Narodni Trida";
		Estaciones [35]= "Nove Butovice";
		Estaciones [36]= "Opatov";
		Estaciones [37]= "Palmovka";
		Estaciones [38]= "Pankrac";
		Estaciones [39]= "Prazskeho Povstani";
		Estaciones [40]= "Prosek";
		Estaciones [41]= "Radlicka";
		Estaciones [42]= "Rajska Zahrada";
		Estaciones [43]= "Roztyly";
		Estaciones [44]= "Skalka";
		Estaciones [45]= "Smichovske Nadrazi";
		Estaciones [46]= "Staromestska";
		Estaciones [47]= "Stodulky";
		Estaciones [48]= "Strasnicka";
		Estaciones [49]= "Strizkov";
		Estaciones [50]= "Vltavska";
		Estaciones [51]= "Vysehrad";
		Estaciones [52]= "Vysocanska";
		Estaciones [53]= "Zelivskeho";
		Estaciones [54]= "Zlicin";
	
		for (i = 0; i < Estaciones.length; ++i) {
			Selector.addItem(Estaciones[i],i);
		}

		setLayout (Layout);
		Selector.setBounds(525, 200, 335, 400);
		panel.add(Selector);
		contentpane.add(Selector);
		Selector.addItemListener (this);
		Selector.select (0);
	}

	public void itemStateChanged(ItemEvent e) {
		int Selection;
		Selection = Selector.getSelectedIndex();
		llegada.setllegada(Estaciones[Selection]);
	} 

}
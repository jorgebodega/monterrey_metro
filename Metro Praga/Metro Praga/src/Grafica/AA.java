
package Grafica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jdd.graph.Edge;

import Arbol.Arbol;
import Grafo.*;

public class AA {

	private Grafo grafo;
	Nodo salida;
	Nodo llegada;

	public AA(String salida, String llegada){


		grafo = new Grafo(true);

		// Creacion de la linea de metro

		//Estaciones
		Nodo Dejvicka, Hradcanska, Malostranska, Staromestska, Mustek, Muzeum, Namesti_Miru, Jiriho_z_Podebrad, 
		Flora, Zelivskeho,Strasnicka, Skalka, Depo_Hostivar, Zlicin, Stodulky, Luka, Luziny, Hurka, Nove_Butovice, 
		Jinonice, Radlicka, Smichovske_nadrazi, Andel, Karlovo_namesti, Narodni_trida, Namesti_Republiky, 
		Florenc, Krizikova, Invalidovna, Palmovka, Ceskomoravska, Vysocanska, Kolbenova, Hloubetin, Rajska_zahrada, 
		Cerny_most, Letnany, Prosek, Strizkov, Ladvi, Kobylisy, Nadrazi_Holesovice, Vltavska, Hlavni_nadrazi,
		I_P_Pavlova, Vysehrad, Prazskeho_povstani, Pankrac, Budejovicka, Kacerov, Roztyly, Chodov, Opatov, Haje;


		Dejvicka = grafo.addNode("Dejvicka", 0,0);
		Hradcanska = grafo.addNode("Hradcanska", 1,-1);
		Malostranska = grafo.addNode("Malostranska", 1,-2);
		Staromestska = grafo.addNode("Staromestska", 2,-3);
		Mustek = grafo.addNode("Mustek", 3,-4);
		Muzeum = grafo.addNode("Muzeum", 4,-5);
		Namesti_Miru = grafo.addNode("Namesti Miru", 5,-5);
		Jiriho_z_Podebrad = grafo.addNode("Jiriho z Podebrad", 6,-5);
		Flora = grafo.addNode("Flora", 7,-8);
		Zelivskeho = grafo.addNode("Zelivskeho", 8,-5);
		Strasnicka = grafo.addNode("Strasnicka", 10,-6);
		Skalka = grafo.addNode("Skalka", 11,-6);
		Depo_Hostivar = grafo.addNode("Depo Hostivar", 12,-5);
		Zlicin = grafo.addNode("Zlicin", -10,-10);
		Stodulky = grafo.addNode("Stodulky", -9,-11);
		Luka = grafo.addNode("Luka", -7,-11);
		Luziny = grafo.addNode("Luziny", -6,-12);
		Hurka = grafo.addNode("Hurka", -5,-10);
		Nove_Butovice = grafo.addNode("Nove Butovice", -4,-10);
		Jinonice = grafo.addNode("Jinonice", -3,-10);
		Radlicka = grafo.addNode("Radlicka", -1,-9);
		Smichovske_nadrazi = grafo.addNode("Smichovske Nadrazi", 1,-8);
		Andel = grafo.addNode("Andel", 1,-7);
		Karlovo_namesti = grafo.addNode("Karlovo Namesti", 2,-6);
		Narodni_trida = grafo.addNode("Narodni Trida", 3,-4);
		Namesti_Republiky = grafo.addNode("Namesti Republiky", 4,-3);
		Krizikova = grafo.addNode("Krizikova", 6,-2);
		Invalidovna = grafo.addNode("Invalidovna", 7,-1);
		Palmovka = grafo.addNode("Palmovka", 8,0);
		Ceskomoravska = grafo.addNode("Ceskomoravska", 10,1);
		Vysocanska = grafo.addNode("Vysocanska", 11,2);
		Kolbenova = grafo.addNode("Kolbenova", 12,2);
		Hloubetin = grafo.addNode("Hloubetin", 14,1);
		Rajska_zahrada = grafo.addNode("Rajska Zahrada", 17,1);
		Cerny_most = grafo.addNode("Cerny Most", 18,1);
		Letnany = grafo.addNode("Letnany", 12,5);
		Prosek = grafo.addNode("Prosek", 10,3);
		Strizkov = grafo.addNode("Strizkov", 9,5);
		Ladvi = grafo.addNode("Ladvi", 7,5);
		Kobylisy = grafo.addNode("Kobylisy", 6,4);
		Nadrazi_Holesovice = grafo.addNode("Nadrazi Holesovice", 5,1);
		Vltavska = grafo.addNode("Vltavska", 5,0);
		Florenc = grafo.addNode("Florenc", 4,-2);
		Hlavni_nadrazi = grafo.addNode("Hlavni Nadrazi", 4,-4);
		I_P_Pavlova = grafo.addNode("I.P.Pavlova", 4,-6);
		Vysehrad = grafo.addNode("Vysehrad", 4,-8);
		Prazskeho_povstani = grafo.addNode("Prazskeho Povstani", 4,-9);
		Pankrac = grafo.addNode("Pankrac", 4,-10);
		Budejovicka = grafo.addNode("Budejovicka", 5,-12);
		Kacerov = grafo.addNode("Kacerov", 6,-12);
		Roztyly = grafo.addNode("Roztyly", 8,-13);
		Chodov = grafo.addNode("Chodov", 10,-14);
		Opatov = grafo.addNode("Opatov", 11,-15);
		Haje = grafo.addNode("Haje", 13,-14);

		//Trayectos
		// Linea A
		grafo.addEdge (Dejvicka, Hradcanska, 0.81, "lineaA");
		grafo.addEdge (Hradcanska, Malostranska, 0.80,"lineaA");
		grafo.addEdge (Malostranska, Staromestska, 0.77, "lineaA");
		grafo.addEdge (Staromestska, Mustek, 0.73, "lineaA");
		grafo.addEdge (Mustek, Muzeum, 0.67, "lineaA");
		grafo.addEdge (Muzeum, Namesti_Miru, 0.80, "lineaA");
		grafo.addEdge (Namesti_Miru, Jiriho_z_Podebrad, 0.88, "lineaA");
		grafo.addEdge (Jiriho_z_Podebrad, Flora, 0.85, "lineaA");
		grafo.addEdge (Flora, Zelivskeho, 0.93, "lineaA");
		grafo.addEdge (Zelivskeho, Strasnicka, 1.22, "lineaA");
		grafo.addEdge (Strasnicka, Skalka, 1.36, "lineaA");
		grafo.addEdge (Skalka, Depo_Hostivar, 1.11, "lineaA");
		
		// Linea B
		grafo.addEdge (Zlicin, Stodulky, 1.44, "lineaB");
		grafo.addEdge (Stodulky, Luka, 1.12, "lineaB");
		grafo.addEdge (Luka, Luziny, 0.70, "lineaB");
		grafo.addEdge (Luziny, Hurka, 1.15, "lineaB");
		grafo.addEdge (Hurka, Nove_Butovice, 0.68, "lineaB");
		grafo.addEdge (Nove_Butovice, Jinonice, 1.33, "lineaB");
		grafo.addEdge (Jinonice, Radlicka, 1.41, "lineaB");
		grafo.addEdge (Radlicka, Smichovske_nadrazi, 1.92, "lineaB");
		grafo.addEdge (Smichovske_nadrazi, Andel, 1.14, "lineaB");
		grafo.addEdge (Andel, Karlovo_namesti, 1.13, "lineaB");
		grafo.addEdge (Karlovo_namesti, Narodni_trida, 1.15, "lineaB");
		grafo.addEdge (Narodni_trida, Mustek, 0.08, "lineaB");
		grafo.addEdge (Mustek, Namesti_Republiky, 0.81, "lineaB");
		grafo.addEdge (Namesti_Republiky, Florenc, 0.55, "lineaB");
		grafo.addEdge (Florenc, Krizikova, 1.02, "lineaB");
		grafo.addEdge (Krizikova, Invalidovna, 0.99, "lineaB");
		grafo.addEdge (Invalidovna, Palmovka, 1.20, "lineaB");
		grafo.addEdge (Palmovka, Ceskomoravska, 1.25, "lineaB");
		grafo.addEdge (Ceskomoravska, Vysocanska, 0.81, "lineaB");
		grafo.addEdge (Vysocanska, Kolbenova, 1.11, "lineaB");
		grafo.addEdge (Kolbenova, Hloubetin, 1.53, "lineaB");
		grafo.addEdge (Hloubetin, Rajska_zahrada, 1.74, "lineaB");
		grafo.addEdge (Rajska_zahrada, Cerny_most, 1.19, "lineaB");
		// Linea C
		grafo.addEdge (Letnany, Prosek, 2.05, "lineaC");
		grafo.addEdge (Prosek, Strizkov, 1.15, "lineaC");
		grafo.addEdge (Strizkov, Ladvi, 1.49, "lineaC");
		grafo.addEdge (Ladvi, Kobylisy, 1.14, "lineaC");
		grafo.addEdge (Kobylisy, Nadrazi_Holesovice, 2.77, "lineaC");
		grafo.addEdge (Nadrazi_Holesovice, Vltavska, 0.97, "lineaC");
		grafo.addEdge (Vltavska, Florenc, 1.15, "lineaC");
		grafo.addEdge (Florenc, Hlavni_nadrazi, 0.82, "lineaC");
		grafo.addEdge (Hlavni_nadrazi, Muzeum, 0.42, "lineaC");
		grafo.addEdge (Muzeum, I_P_Pavlova, 0.67, "lineaC");
		grafo.addEdge (I_P_Pavlova, Vysehrad, 1.24, "lineaC");
		grafo.addEdge (Vysehrad, Prazskeho_povstani, 0.75, "lineaC");
		grafo.addEdge (Prazskeho_povstani, Pankrac, 0.80, "lineaC");
		grafo.addEdge (Pankrac, Budejovicka, 1.00, "lineaC");
		grafo.addEdge (Budejovicka, Kacerov, 0.82, "lineaC");
		grafo.addEdge (Kacerov, Roztyly, 1.34, "lineaC");
		grafo.addEdge (Roztyly, Chodov, 1.22, "lineaC");
		grafo.addEdge (Chodov, Opatov, 1.43, "lineaC");
		grafo.addEdge (Opatov,Haje, 1.32, "lineaC");
		

		Iterator<Edge> l = grafo.getMap().get(salida).iterator();
		boolean cond = true;
		Edge tramo;
		while(l.hasNext() && cond){
			tramo = l.next();
			if(((Nodo)tramo.n1).getNombre() == salida){
				this.salida = (Nodo)tramo.n1;
				cond = false;
			}
		} //while
		

		Iterator<Edge> s = grafo.getMap().get(llegada).iterator();
		cond = true;
		while(s.hasNext() && cond){
			tramo = s.next();
			if(((Nodo)tramo.n1).getNombre() == llegada){
				this.llegada = (Nodo)tramo.n1;
				cond = false;
			}
		}
	}

	public List<Pixel> recorridoOptimo(){
		String linea = "";
		String lineaA = "Linea0";
		Arbol arbol = new Arbol(salida, llegada, grafo);
		List<Nodo> camino = arbol.recorridoObtimo(arbol.CalcularRecorrido());
		List<Pixel> recorrido = new ArrayList<Pixel>();
		Iterator<Nodo> iterador = camino.iterator();
		Iterator<Nodo> iterador2 = camino.iterator();
		iterador2.next();
		while(iterador.hasNext()){
			Nodo nodo = iterador.next();
			Nodo nodo2;
			if (iterador2.hasNext()){
				nodo2 = iterador2.next();
				Iterator<Edge> l = grafo.getMap().get(nodo.getNombre()).iterator();
				boolean cond = true;
				Edge tramo;
				while(l.hasNext() && cond){
					tramo = l.next();
					if(((Nodo)tramo.n2).getNombre() == nodo2.getNombre()){
						if (cond && linea == lineaA){
							linea = tramo.getLabel();
							cond = false;
						}
						else linea = tramo.getLabel();
					}
				}
				lineaA=linea;
			}
			else linea = "";
			Pixel pixel = new Pixel(nodo.getX(),nodo.getY(),nodo.getNombre(),linea);
			recorrido.add(pixel);
		}
		return recorrido;
	}



}
package metro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Construccion {

	private HashMap<String,Estacion> m1, m2, m3;

	public Construccion() {
		
		m1 = new HashMap<String, Estacion>();
		m2 = new HashMap<String,Estacion>();
		m3 = new HashMap<String,Estacion>();
		
		m1.put("Tallares", new Estacion(1, "Tallares", "San Bernabe", 2, null, 0, 0, "25 45 15.1 N", "100 21 55.2 W"));
		m1.put("San Bernabe", new Estacion(1, "San Bernabe", "Tallares", 2, "Unidad Modelo", 2, 0, "25 44 54.5 N", "100 21 42.1 W"));
		m1.put("Unidad Modelo" , new Estacion(1, "Unidad Modelo", "San Bernabe", 2, "Aztlan", 3, 0, "25 44 31.5 N", "100 21 16.5 W"));
		m1.put("Aztlan", new Estacion(1, "Aztlan", "Unidad Modelo", 3, "Penitenciaria", 3, 0, "25 43 56.6 N", "100 20 50.5 W"));
		m1.put("Penitenciaria", new Estacion(1, "Penitenciaria", "Aztlan", 3, "Alfonso Reyes", 2, 0, "25 43 23.8 N", "100 20 33.2 W"));
		m1.put("Alfonso Reyes",  new Estacion(1, "Alfonso Reyes", "Penitenciaria", 2, "Mitras", 3, 0, "25 42 57.7 N", "100 20 32.8 W"));
		m1.put("Mitras", new Estacion (1, "Mitras", "Alfonso Reyes", 3, "Simon Bolivar", 2, 0, "25 42 21.6 N", "100 20 33.0 W"));
		m1.put("Simon Bolivar", new Estacion (1, "Simon Bolivar", "Mitras", 2, "Hospital", 2, 0, "25 41 56.6 N", "100 20 35.3 W"));
		m1.put("Hospital",  new Estacion (1, "Hospital", "Simon Bolivar", 2, "Edison", 3, 0, "25 41 31.8 N", "100 20 38.8 W"));
		m1.put("Edison",  new Estacion (1, "Edison", "Hospital", 3, "Central", 2, 0, "25 41 13.8 N", "100 20 00.4 W"));
		m1.put("Central", new Estacion (1, "Central", "Edison", 2, "Cuauhtemoc", 2, 0, "45 41 14.0 N", "100 19 26.7 W"));
		m1.put("Cuauhtemoc", new Estacion (1, "Cuauhtemoc", "Central", 2, "Del Golfo", 2, 2, "25 41 10.9 N", "100 19 01.2 W"));
		m1.put("Del Golfo", new Estacion (1, "Del Golfo", "Cuauhtemoc", 2, "Felix U Gomez", 2, 0, "25 41 06.6 N", "100 18 21.9 W"));
		m1.put("Felix U Gomez", new Estacion (1, "Felix U Gomez", "Del Golfo", 2, "Parque Fundidora", 2, 3, "25 41 02.2 N", "100 17 46.5 W"));
		m1.put("Parque Fundidora", new Estacion (1, "Parque Fundidora", "Felix U Gomez", 2, "Y Griega", 2, 0, "25 41 01.6 N", "100 17 16.8 W"));
		m1.put("Y Griega", new Estacion (1, "Y Griega", "Parque Fundidora", 2, "Eloy Cavazos", 3, 0, "25 41 00.1 N", "100 16 45.3 W"));
		m1.put("Eloy Cavazos", new Estacion (1, "Eloy Cavazos", "Y Griega", 3, "Lendo De Tejada", 2, 0, "25 40 48.3 N", "100 15 50.2 W"));
		m1.put("Lendo De Tejada", new Estacion (1, "Lendo De Tejada", "Eloy Cavazos", 2, "Exposicion", 1, 0, "25 40 47.4 N", "100 15 07.3 W"));
		m1.put("Exposicion", new Estacion (1, "Exposicion", "Lendo De Tejada", 1, null, 0, 0, "25 40 46.3 N", "100 14 43.0 W"));

		//Linea m2

		m2.put("Sendero", new Estacion(2, "Sendero", "SantiagoTapia", 2, null, 0, 0, "25 46 07.3 N", "100 17 30.1 W"));
		m2.put("SantiagoTapia", new Estacion(2, "SantiagoTapia", "Sendero", 2, "SanNicolas", 2, 0, "25 45 33.1 N", "100 17 44.5 W"));
		m2.put("SanNicolas", new Estacion(2, "SanNicolas", "SantiagoTapia", 2, "Anahuac", 3, 0, "25 45 09.8 N", "100 17 52.1 W"));
		m2.put("Anahuac", new Estacion(2, "Anahuac", "SanNicolas", 3, "Universidad", 4, 0, "25 44 23.2 N", "100 18 09.3 W"));
		m2.put("Universidad", new Estacion(2, "Universidad", "Anahuac", 4, "NignosHeroes", 2, 0, "25 43 27.8 N", "100 18 29.2 W"));
		m2.put("NignosHeroes", new Estacion(2, "NignosHeroes", "Universidad", 2, "Regina", 2, 0, "25 43 01.3 N", "100 18 38.7 W"));
		m2.put("Regina", new Estacion(2, "Regina", "NignosHeroes", 2, "GeneralAnaya", 3, 0, "25 42 29.8 N", "100 18 50.6 W"));
		m2.put("GeneralAnaya", new Estacion(2, "GeneralAnaya", "Regina", 3, "Cuauhtemoc", 2, 0, "25 41 49.9 N", "100 18 59.9 W"));
		m2.put("Cuauhtemoc", new Estacion (2, "Cuauhtemoc", "GeneralAnaya", 2, "Alameda", 2, 1, "25 41 10.9 N", "100 19 01.2 W"));
		m2.put("Alameda", new Estacion(2, "Alameda", "Cuauhtemoc",2, "Fundadores", 1, 0, "25 40 37.4 N", "100 19 04.8 W"));
		m2.put("Fundadores", new Estacion(2, "Fundadores", "Alameda", 1, "PadreMier", 2, 0, "25 40 20.9 N", "100 19 08.7 W"));
		m2.put("PadreMier", new Estacion(2, "PadreMier", "Fundadores", 2, "GeneralIZaragoza", 1, 0, "25 40 07.0 N", "100 18 54.5 W"));
		m2.put("GeneralIZaragoza", new Estacion(2, "GeneralIZaragoza", "PadreMier", 1, null, 0, 3, "25 40 04.0 N", "100 18 35.2 W"));
		
		// Linea 3
		
		m3.put("GeneralIZaragoza", new Estacion(3, "GeneralIZaragoza", "SantaLucia", 3, null, 0, 1, "25 40 04.0 N", "100 18 35.2 W"));
		m3.put("SantaLucia", new Estacion(3, "SantaLucia", "SantaLucia", 3, "AdolfoPrieto", 1, 0, "25 40 16.7 N", "100 17 54.9 W"));
		m3.put("AdolfoPrieto", new Estacion(3, "AdolfoPrieto", "SantaLucia", 1, "Felix U Gomez", 1, 0, "25 40 40.3 N", "100 17 51.7 W"));
		m3.put("Felix U Gomez", new Estacion (3, "Felix U Gomez", "AdolfoPrieto", 1, "Conchello", 1, 1, "25 41 02.2 N", "100 17 46.5 W"));
		m3.put("Conchello", new Estacion(3, "Conchello", "Felix U Gomez", 1, "Violeta", 3, 0, "25 41 23.3 N", "100 17 45.6 W"));
		m3.put("Violeta", new Estacion(3, "Violeta", "Conchello", 3, "Ruiz", 1, 0, "25 42 01.1 N", "100 17 34.3 W"));
		m3.put("Ruiz", new Estacion(3, "Ruiz", "Violeta", 1, "LosAngeles", 1, 0, "25 42 11.7 N", "100 17 19.1 W"));
		m3.put("LosAngeles", new Estacion(3, "LosAngeles", "Ruiz", 1, "HospitalMetropolitano", 2, 0, "25 42 25.8 N", "100 16 59.4 W"));
		m3.put("HospitalMetropolitano", new Estacion(3, "HospitalMetropolitano", "LosAngeles", 2, null, 0, 0, "25 42 50.5 N", "100 16 23.4 W"));
		
	}
	
	public List<String> estacionesOrdenadas(){
		List<String> toReturn = new ArrayList<String>();
		@SuppressWarnings("unchecked")
		HashMap<String,Estacion>[] hashMap = new HashMap[3];
		hashMap = getLineas();
		for(int i=0; i<3 ; i++){
			for(Map.Entry<String,Estacion> entry : hashMap[i].entrySet()){
				if(!toReturn.contains(entry.getValue().getNombre()))
					toReturn.add(entry.getValue().getNombre());
			}
		}
		Collections.sort(toReturn);
		
		return toReturn;
	}
	
	public Estacion getEstacion(String origen){
		@SuppressWarnings("unchecked")
		HashMap<String,Estacion>[] hashMap = new HashMap[3];
		hashMap = this.getLineas();
		for(int i=0; i<3 ; i++){
			if (hashMap[i].containsKey(origen))
				return hashMap[i].get(origen);
		}
		return null;
		
	}
	
	public HashMap<String,Estacion>[] getLineas(){
		@SuppressWarnings("unchecked")
		HashMap<String,Estacion>[] hashMap = new HashMap[3];
		hashMap[0] = m1;
		hashMap[1] = m2;
		hashMap[2] = m3;
		
		return hashMap;
	}

	
}

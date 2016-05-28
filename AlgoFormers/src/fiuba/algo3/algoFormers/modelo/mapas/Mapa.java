package fiuba.algo3.algoFormers.modelo.mapas;

import java.util.HashMap;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class Mapa {
	
	private HashMap<Posicion, Casillero> tablero;
	//Tamanio por defecto del mapa
	private int TAMANIO = 40;

	public Mapa(){
		
		tablero = new HashMap<Posicion, Casillero>();
		this.llenarTablero(tablero);
		
	}

	private void llenarTablero(HashMap<Posicion, Casillero> tablero) {
		
		for(int i = 0; i < TAMANIO; i++){
			for(int j = 0; j < TAMANIO; j++){
				tablero.put(new Posicion (i,j), new Casillero());
			}
		}
		
	}

	public void ubicar(Ubicable ubicable, Posicion posicion) {
		// TODO Auto-generated method stub
		
	}

	
	//Metodos para puebas
	
	public Object getUbicable(Posicion posicion) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTamanio() {
		return TAMANIO;
	}

	public Casillero getCasillero(Posicion posicion) {
		return tablero.get(posicion); 
	}

}
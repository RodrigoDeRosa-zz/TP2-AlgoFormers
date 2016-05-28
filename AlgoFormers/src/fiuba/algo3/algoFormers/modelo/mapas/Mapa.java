package fiuba.algo3.algoFormers.modelo.mapas;

import java.util.HashMap;

import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;

public class Mapa {
	
	private HashMap<Posicion, Casillero> tablero;
	//Tamanio por defecto del mapa
	private int TAMANIO = 40;

	public Mapa(){
		
		tablero = new HashMap<Posicion, Casillero>();
		this.llenarTablero(tablero);
		
	}

	public void ubicar(Ubicable ubicable, Posicion posicion) {
		
		Casillero casillero = tablero.get(posicion);
		this.verificarCasilleroEstaVacio(casillero, posicion);
		casillero.setUbicable(ubicable);
		
	}
	
	
	//Metodos privados.
	
	private void verificarCasilleroEstaVacio(Casillero casillero, Posicion posicion) {
		if (casillero.estaOcupado()){
			throw new CasilleroOcupadoException("el casillero de la posicion (" + posicion.getX() + posicion.getY() + ") esta ocupado");
		}
		
	}

	private void llenarTablero(HashMap<Posicion, Casillero> tablero) {
		
		for(int i = 0; i < TAMANIO; i++){
			for(int j = 0; j < TAMANIO; j++){
				tablero.put(new Posicion (i,j), new Casillero());
			}
		}
		
	}
	
	
	//Metodos para puebas
	
	public Ubicable getUbicable(Posicion posicion) {
		
		Casillero casillero = tablero.get(posicion);
		return casillero.getUbicable();
		
	}

	public int getTamanio() {
		return TAMANIO;
	}

	public Casillero getCasillero(Posicion posicion) {
		return tablero.get(posicion); 
	}

}

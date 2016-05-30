package fiuba.algo3.algoFormers.modelo.mapas;

import java.util.HashMap;
import java.util.Random;

import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.excepciones.PosicionFueraDelMapaException;
import fiuba.algo3.algoFormers.modelo.excepciones.UbicableNoPertenceAlMapaException;
import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;
import fiuba.algo3.algoFormers.modelo.personajes.Chispa;

public class Mapa {
	
	private HashMap<Posicion, Casillero> tablero;
	//Tamanio por defecto del mapa
	private int TAMANIO = 40;

	
	public Mapa(){
		tablero = new HashMap<Posicion, Casillero>();
		llenarTablero(tablero);
	}
	
	private void llenarTablero(HashMap<Posicion, Casillero> tablero) {	
		for(int fila = 1; fila <= TAMANIO; fila++){
			for(int columna = 1; columna <= TAMANIO; columna++){
				tablero.put(new Posicion (fila,columna), new Casillero());
			}
		}
	}

	private void verificarCasilleroEstaVacio(Casillero casillero, Posicion posicion) {
		if (casillero.estaOcupado()){
			throw new CasilleroOcupadoException("el casillero de la posicion (" + posicion.getX() + posicion.getY() + ") esta ocupado");
		}
	}
	
	private void verificarCasilleroExiste(Posicion posicion) {
		
		Casillero cas = tablero.get(posicion);
		if (cas == null) {
			
			throw new PosicionFueraDelMapaException();
		}
		
	}
	
	private Posicion obtenerPosicion(Ubicable ubicable) {
		for(int fila = 1; fila <= TAMANIO; fila++){
			for(int columna = 1; columna <= TAMANIO; columna++){
				Posicion posicion = new Posicion(fila,columna);
				Ubicable ubicableActual = this.getUbicable(posicion);
				if((ubicableActual != null) && (ubicableActual.getClass() == ubicable.getClass())){
					return posicion;
				}
			}
		}
		throw new UbicableNoPertenceAlMapaException("El ubicable no pertence al mapa");
	}
	
	public void ubicar(Ubicable ubicable, Posicion posicion) {
		
		verificarCasilleroExiste(posicion);
		Casillero casillero = tablero.get(posicion);		
		verificarCasilleroEstaVacio(casillero, posicion);
		casillero.ocupar(ubicable);
		ubicable.setPosicion(posicion);
	}	

	public void desocupar(Posicion posicion) {
		
		Casillero casillero = tablero.get(posicion);
		casillero.desocupar();
	}
	
	public Ubicable getUbicable(Posicion posicion) {
		Casillero casillero = tablero.get(posicion);
		return casillero.getUbicable();	
	}
	
	//Metodos para puebas
	
	public int getTamanio() {
		return TAMANIO;
	}

	
	public Casillero getCasillero(Posicion posicion) {
		return tablero.get(posicion); 
	}

	public Posicion getPosicionChispa(Chispa laChispa) {
		
		return obtenerPosicion(laChispa);
	}

	public void ubicarChispa(Chispa laChispa) {
		
		int medio = TAMANIO / 2;
		int desplazamiento = 2;
		int max = medio + desplazamiento;
		int min = medio - desplazamiento;
		
		Random generador = new Random();
		int resultadoX = generador.nextInt(max - min + 1) + min;
		int resultadoY = generador.nextInt(max - min + 1) + min;
		
		Posicion pos = new Posicion(resultadoX, resultadoY);
		
		this.ubicar(laChispa, pos);
		
		
	}



	

}

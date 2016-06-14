package fiuba.algo3.algoFormers.modelo.mapa;

import java.util.HashMap;
import java.util.Random;

import fiuba.algo3.algoFormers.modelo.capturables.Chispa;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.UbicableNoPertenceAlMapaException;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.interfaces.Capturable;
import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.Superficie;

public class Mapa {
	
	private HashMap<Posicion, Casillero> tablero;
	//Tamanio por defecto del mapa
	private int TAMANIO = 40;

	
	public Mapa(){
		tablero = new HashMap<Posicion, Casillero>();
		this.llenarTablero(tablero);
	}

	
	public void ubicar(Atacable atacable, Posicion posicion) {
		Casillero casillero = tablero.get(posicion);
		casillero.ubicar(atacable);
	}
	
	public void ubicar(Capturable capturable, Posicion posicion) {		
		Casillero casillero = tablero.get(posicion);
		casillero.ubicar(capturable);
	}
	
	public void ubicar(Superficie superficie, Posicion posicion) {
		Casillero casillero = tablero.get(posicion);
		casillero.ubicar(superficie);
	}
	
	public void ubicarChispa(Chispa chispa){
		int medio = TAMANIO / 2;
		int desplazamiento = 2;
		int max = medio + desplazamiento;
		int min = medio - desplazamiento;
		
		Random generador = new Random();
		int resultadoX = generador.nextInt(max - min + 1) + min;
		int resultadoY = generador.nextInt(max - min + 1) + min;
		
		Posicion posicion = new Posicion(resultadoX, resultadoY);
		
		this.ubicar(chispa, posicion);
	}

	public void moverAtacableEnDireccion(Atacable atacable, Direccion direccion) {
		Posicion posicion = this.obtenerPosicion(atacable);
		Posicion nuevaPosicion = posicion.sumarDireccion(direccion);
		Casillero casillero = tablero.get(posicion);
		Casillero nuevoCasillero = tablero.get(nuevaPosicion);
		//Se agrega el atacable a la nueva posicion
		nuevoCasillero.ubicar(atacable);
		//Se borra de la posicion vieja
		casillero.desocuparAtacable();
	}
	
	private Capturable getCapturable(Posicion posicion) {
		Casillero casillero = tablero.get(posicion);
		return casillero.getCapturable();	
	}
	
	public Atacable getAtacable(Posicion posicion) {
		Casillero casillero = tablero.get(posicion);
		return casillero.getAtacable();	
	}	
	
	public Posicion obtenerPosicion(Ubicable ubicable) {
		for(int fila = 0; fila < TAMANIO; fila++){
			for(int columna = 0; columna < TAMANIO; columna++){
				Posicion posicion = new Posicion(fila,columna);
				Atacable atacableActual = this.getAtacable(posicion);
				if((atacableActual != null) && (atacableActual.getClass() == ubicable.getClass())){
					return posicion;
				}
			}
		}
		throw new UbicableNoPertenceAlMapaException("El ubicable no pertence al mapa");
	}
	
	public int obtenerDistancia(Posicion posicionUbicable, Posicion posicionAtacable) {
		int distanciaFila = posicionUbicable.obtenerDistanciaFila(posicionAtacable);
		int distanciaColumna = posicionUbicable.obtenerDistanciaColumna(posicionAtacable);
		return Math.max(distanciaFila, distanciaColumna);
	}
	
	//Metodos privados.
	
	private void llenarTablero(HashMap<Posicion, Casillero> tablero) {	
		for(int fila = 0; fila < TAMANIO; fila++){
			for(int columna = 0; columna < TAMANIO; columna++){
				tablero.put(new Posicion (fila,columna), new Casillero());
			}
		}
	}
	
	//Metodos para puebas
	
	public int getTamanio() {
		return TAMANIO;
	}

	public Casillero getCasillero(Posicion posicion) {
		return tablero.get(posicion); 
	}
	
	public Posicion getPosicionChispa(Chispa chispa){
		for(int fila = 0; fila < TAMANIO; fila++){
			for(int columna = 0; columna < TAMANIO; columna++){
				Posicion posicion = new Posicion(fila,columna);
				Capturable capturableActual = this.getCapturable(posicion);
				if((capturableActual != null) && (capturableActual.getClass() == chispa.getClass())){
					return posicion;
				}
			}
		}
		throw new UbicableNoPertenceAlMapaException("La chispa no esta en el mapa");
	}

}

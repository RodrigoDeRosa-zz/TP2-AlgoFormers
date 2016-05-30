package fiuba.algo3.algoFormers.modelo.mapas;

import java.util.HashMap;
import java.util.Random;

import fiuba.algo3.algoFormers.modelo.capturables.Chispa;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueEspacioVacioException;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.excepciones.UbicableNoPertenceAlMapaException;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
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

	public void ubicarChispa(Chispa laChispa) {
		
		int medio = TAMANIO / 2;
		int desplazamiento = 2;
		int max = medio + desplazamiento;
		int min = medio - desplazamiento;
		
		Random generador = new Random();
		int resultadoX = generador.nextInt(max - min + 1) + min;
		int resultadoY = generador.nextInt(max - min + 1) + min;
		
		Posicion pos = new Posicion(resultadoX, resultadoY);
		
		this.ubicar((Ubicable) laChispa, pos);
	}
	
	public void moverUbicableEnDireccion(Ubicable ubicable, Direccion direccion) {
		Posicion posicion = this.obtenerPosicion(ubicable);
		Posicion nuevaPosicion = posicion.sumarDireccion(direccion);
		Casillero casillero = tablero.get(posicion);
		Casillero nuevoCasillero = tablero.get(nuevaPosicion);
		this.verificarCasilleroEstaVacio(nuevoCasillero, nuevaPosicion);
		
		//Se agrega el ubicable a la nueva posicion
		nuevoCasillero.ocuparConUbicable(ubicable);
		
		//Se borra la posicion vieja
		casillero.desocuparUbicable();
	}

	public Ubicable getUbicable(Posicion posicion) {
		Casillero casillero = tablero.get(posicion);
		return casillero.getUbicable();	
	}
	
	public Atacable getAtacable(Posicion posicion) {
		Casillero casillero = tablero.get(posicion);
		this.verificarCasilleroNoEstaVacio(casillero, posicion);
		return (Atacable) casillero.getUbicable();	
	}	
	
	public Posicion obtenerPosicion(Ubicable ubicable) {
		for(int fila = 0; fila < TAMANIO; fila++){
			for(int columna = 0; columna < TAMANIO; columna++){
				Posicion posicion = new Posicion(fila,columna);
				Ubicable ubicableActual = this.getUbicable(posicion);
				if((ubicableActual != null) && (ubicableActual.getClass() == ubicable.getClass())){
					return posicion;
				}
			}
		}
		throw new UbicableNoPertenceAlMapaException("El ubicable no pertence al mapa");
	}
	
	//Metodos privados.
	
	private void verificarCasilleroEstaVacio(Casillero casillero, Posicion posicion) {
		if (casillero.estaOcupado()){
			throw new CasilleroOcupadoException("el casillero de la posicion (" + posicion.getX() + posicion.getY() + ") esta ocupado");
		}
	}
	
	private void verificarCasilleroNoEstaVacio(Casillero casillero, Posicion posicion) {
		if (!casillero.estaOcupado()){
			throw new AtaqueEspacioVacioException();
		}
	}

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
		return this.obtenerPosicion((Ubicable)chispa);
	}

}

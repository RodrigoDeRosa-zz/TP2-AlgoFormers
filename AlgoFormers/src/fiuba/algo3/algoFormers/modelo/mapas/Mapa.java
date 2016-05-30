package fiuba.algo3.algoFormers.modelo.mapas;

import java.util.HashMap;
import java.util.Random;

import fiuba.algo3.algoFormers.modelo.capturables.Chispa;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueEspacioVacioException;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.excepciones.UbicableNoPertenceAlMapaException;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.interfaces.Capturable;
import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;

public class Mapa {
	
	private HashMap<Posicion, Casillero> tablero;
	//Tamanio por defecto del mapa
	private int TAMANIO = 40;

	
	public Mapa(){
		tablero = new HashMap<Posicion, Casillero>();
		this.llenarTablero(tablero);
	}

	
	public void ubicarAtacable(Atacable atacable, Posicion posicion) {
		Casillero casillero = tablero.get(posicion);
		this.verificarCasilleroEstaVacio(casillero, posicion);
		casillero.setAtacable(atacable);
	}
	
	public void ubicarCapturable(Capturable capturable, Posicion posicion) {		
		Casillero casillero = tablero.get(posicion);
		this.verificarCasilleroCapturableEstaVacio(casillero, posicion);
		this.verificarCasilleroEstaVacio(casillero, posicion);
		casillero.setCapturable(capturable);
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
		
		this.ubicarCapturable(chispa, posicion);
	}

	public void moverAtacableEnDireccion(Atacable atacable, Direccion direccion) {
		Posicion posicion = this.obtenerPosicion(atacable);
		Posicion nuevaPosicion = posicion.sumarDireccion(direccion);
		Casillero casillero = tablero.get(posicion);
		Casillero nuevoCasillero = tablero.get(nuevaPosicion);
		this.verificarCasilleroEstaVacio(nuevoCasillero, nuevaPosicion);
		
		//Se agrega el ubicable a la nueva posicion
		nuevoCasillero.setAtacable(atacable);
		
		//Se borra la posicion vieja
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
	
	//Metodos privados.
	
	private void verificarCasilleroCapturableEstaVacio(Casillero casillero, Posicion posicion) {
		if (casillero.estaOcupadoCapturable()){
			throw new CasilleroOcupadoException("el casillero de la posicion (" + posicion.getX() + posicion.getY() + ") esta ocupado");
		}
	}
	
	private void verificarCasilleroEstaVacio(Casillero casillero, Posicion posicion) {
		if (casillero.estaOcupado()){
			throw new CasilleroOcupadoException("el casillero de la posicion (" + posicion.getX() + posicion.getY() + ") esta ocupado");
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

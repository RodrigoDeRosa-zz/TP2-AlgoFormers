package fiuba.algo3.algoFormers.modelo.mapas;

import java.util.HashMap;

import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueEspacioVacioException;
import fiuba.algo3.algoFormers.modelo.excepciones.AtaqueFueraDeRangoException;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.excepciones.UbicableNoPertenceAlMapaException;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class Mapa {
	
	private HashMap<Posicion, Casillero> tablero;
	//Tamanio por defecto del mapa
	private int TAMANIO = 40;

	
	public Mapa(){
		tablero = new HashMap<Posicion, Casillero>();
		llenarTablero(tablero);
	}

	
	public void ubicar(Ubicable ubicable, Posicion posicion) {
		Casillero casillero = tablero.get(posicion);
		verificarCasilleroEstaVacio(casillero, posicion);
		casillero.ocupar(ubicable);
	}
	
	public Atacable getAtacable(Posicion posicion) {
		
		Casillero casillero = tablero.get(posicion);
		
		
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
	
	//Metodos privados.
	
	private void verificarDistancia(Posicion posicionUbicable, Posicion posicionAtacable,int distanciaAtaque) {
		int diferenciaX = posicionUbicable.obtenerDiferenciaX(posicionUbicable);
		int diferenciaY = posicionUbicable.obtenerDiferenciaY(posicionUbicable);
		if (diferenciaX > distanciaAtaque || diferenciaY > distanciaAtaque){
			throw new AtaqueFueraDeRangoException();
		};
		
	}
	
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
		for(int fila = 1; fila <= TAMANIO; fila++){
			for(int columna = 1; columna <= TAMANIO; columna++){
				tablero.put(new Posicion (fila,columna), new Casillero());
			}
		}
	}
	
	private Posicion obtenerPosicion(Ubicable ubicable) {
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
	
	//Metodos para puebas
	
	public int getTamanio() {
		return TAMANIO;
	}

	
	public Casillero getCasillero(Posicion posicion) {
		return tablero.get(posicion); 
	}


	

}

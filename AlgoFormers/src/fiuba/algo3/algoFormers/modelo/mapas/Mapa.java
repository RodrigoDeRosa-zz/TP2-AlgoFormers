package fiuba.algo3.algoFormers.modelo.mapas;

import java.util.HashMap;

import fiuba.algo3.algoFormers.entrega1.UbicableNoPertenceAlMapaException;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

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

	public void atacarPosicion(Ubicable ubicable, int poderAtaque, int distanciaAtaque, Posicion posicion) {
		// TODO Auto-generated method stub	
	}
	
	public Ubicable getUbicable(Posicion posicion) {
		Casillero casillero = tablero.get(posicion);
		return casillero.getUbicable();	
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
	
	private Posicion obtenerPosicion(Ubicable ubicable) {
		for(int i = 0; i < TAMANIO; i++){
			for(int j = 0; j < TAMANIO; j++){
				Posicion posicion = new Posicion(i,j);
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

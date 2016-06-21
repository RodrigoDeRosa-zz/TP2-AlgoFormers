package fiuba.algo3.algoFormers.modelo.mapa;

import java.util.HashMap;
import java.util.Random;

import fiuba.algo3.algoFormers.modelo.capturables.Chispa;
import fiuba.algo3.algoFormers.modelo.direcciones.Direccion;
import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
import fiuba.algo3.algoFormers.modelo.excepciones.HumanoideNoPuedeAtravesarException;
import fiuba.algo3.algoFormers.modelo.excepciones.UbicableNoPertenceAlMapaException;
import fiuba.algo3.algoFormers.modelo.fabricas.superficies.SuperficiesFactory;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.interfaces.Capturable;
import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.Superficie;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

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
	
	public Capturable getCapturable(Posicion posicion) {
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
	
	public void borrarPersonaje(AlgoFormer personaje) {
		Posicion posicion = this.obtenerPosicion(personaje);
		Casillero casillero = this.tablero.get(posicion);
		casillero.desocuparAtacable();
	}
	
	public void ubicarEnAlrededores(Atacable personaje, Posicion posOriginal){
		Casillero casilleroOriginal = this.tablero.get(posOriginal);
		try{casilleroOriginal.ubicar(personaje);} catch (CasilleroOcupadoException | HumanoideNoPuedeAtravesarException e){}
		for (int i = 0; i < 3; i++){
			Posicion posicion = new Posicion(posOriginal.getX() + i, posOriginal.getY() + i);
			Casillero casillero = this.tablero.get(posicion);
			try{casillero.ubicar(personaje);} catch (CasilleroOcupadoException | HumanoideNoPuedeAtravesarException e){continue;}
			return;
		}
	}
	
	public SuperficieTerrestre getSuperficieTerrestre(Posicion posicion){
		Casillero casillero = this.tablero.get(posicion);
		return casillero.getSuperficieTerrestre();
	}
	
	public SuperficieAerea getSuperficieAerea(Posicion posicion){
		Casillero casillero = this.tablero.get(posicion);
		return casillero.getSuperficieAerea();
	}
	
	public void rellenarMapa() {
		/*Funcion que inicializa las superficies del mapa*/
		
		SuperficiesFactory fabrica = new SuperficiesFactory();
		SuperficieAerea nebulosa,tormenta,nube;
		SuperficieTerrestre rocosa,espinosa,pantano;
		nebulosa = fabrica.getNebulosaAndromeda();
		tormenta = fabrica.getTormentaPsionica();
		nube = fabrica.getNube();
		rocosa = fabrica.getRocas();
		espinosa = fabrica.getEspina();
		pantano = fabrica.getPantano();
		this.rellenarCompleto(rocosa,nube);
		this.rellenarDiagonalTerrestreDerecha(espinosa);
		this.rellenarDiagonalTerrestreIzquierda(pantano);
		this.rellenarCentroAereo(nebulosa);
		this.rellenarPosiciones(tormenta,3,6,10,30);
		this.rellenarPosiciones(tormenta,(TAMANIO-6),(TAMANIO-3),10,30);
		this.rellenarPosiciones(pantano,7,14,17,23);
	}
	
	//Metodos privados.
	
	private void rellenarPosiciones(Superficie superficie, int inicioF, int finF, 
			int inicioC, int finC) {
		for(int fila = inicioF; fila<finF; fila++){
			for(int columna = inicioC; columna<finC; columna++){
				this.ubicar(superficie, new Posicion(fila,columna));
			}
		}
		
	}

	private void rellenarCompleto(SuperficieTerrestre terrestre, SuperficieAerea aerea) {
		//LLena todo el mapa con las superficies que recibe.
		for(int fila = 0; fila < TAMANIO; fila++){
			for(int columna = 0; columna <TAMANIO; columna++){
					this.ubicar(terrestre, new Posicion (fila,columna));
					this.ubicar(aerea, new Posicion (fila,columna));
			}
		}
	}
	
	private void rellenarDiagonalTerrestreDerecha(SuperficieTerrestre terrestre) {
		
		//el -1 para que no choquen el primero ni el ultimo.
		for(int fila = 1; fila < TAMANIO-1; fila++){
			//Rellena la diagonal, uno a la derecha y uno a la izquierda.
			for(int columna = fila-1; columna <= fila+1; columna++){
				if(fila<18 || fila>21){
					this.ubicar(terrestre, new Posicion (fila,columna));
				}
			}
		}
		//ubico el primero y el ultimo.
		this.ubicar(terrestre, new Posicion (0,0));
		this.ubicar(terrestre, new Posicion (0,1));
		this.ubicar(terrestre, new Posicion (39,38));
		this.ubicar(terrestre, new Posicion (39,39));
	}
	
	private void rellenarDiagonalTerrestreIzquierda(SuperficieTerrestre terrestre) {
		
		//el -1 para que no choquen el primero ni el ultimo.
		for(int fila = 1; fila < TAMANIO-1; fila++){
			//Rellena la diagonal, uno a la derecha y uno a la izquierda.
			for(int columna = (TAMANIO-fila); columna > (TAMANIO-fila)-3; columna--){
				if(fila<18 || fila>21){
					this.ubicar(terrestre, new Posicion (fila,columna));
				}
			}
		}
		//ubico el primero y el ultimo.
		this.ubicar(terrestre, new Posicion (0,39));
		this.ubicar(terrestre, new Posicion (39,1));
		this.ubicar(terrestre, new Posicion (39,0));
		this.ubicar(terrestre, new Posicion (0,38));
	}
	
	private void rellenarCentroAereo(SuperficieAerea aerea){
		//Del medio 5 para cada lado
		for(int fila = ((TAMANIO/2)-5); fila<((TAMANIO/2)+5); fila++){
			for(int columna = ((TAMANIO/2)-5); columna<((TAMANIO/2)+5); columna++){
				this.ubicar(aerea, new Posicion(fila,columna));
			}
		}
	}
	
//	private void rellenarPorcionesAerea(SuperficieAerea aerea, int inicioF,int finF, int inicioC, int finC){
//		//Dadas las posiciones que le pasan por parametro llena esa parte del mapa con la superficie aerea.
//		for(int fila = inicioF; fila<finF; fila++){
//			for(int columna = inicioC; columna<finC; columna++){
//				this.ubicar(aerea, new Posicion(fila,columna));
//			}
//		}
//	}

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

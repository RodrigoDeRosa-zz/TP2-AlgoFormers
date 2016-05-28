package fiuba.algo3.algoFormers.modelo.personajes.manejadores;

import fiuba.algo3.algoFormers.modelo.excepciones.MovimientosAgotadosException;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class ManejadorDeMovimientos {
	
	private static int NULO=0;
	private static int UNICO=0;
	private int movimientosRestantes; 
	private int movimientosTotales;
	
	public ManejadorDeMovimientos(int movimientos){
		/*Manejador de movimientos que se inicializa con la distancia maxima
		a la que se puede mover un algoformer.*/
		this.setMovimientosRestantes(movimientos);
		this.setMovimientosTotales(movimientos);
	}
	
	private void setMovimientosRestantes(int movimientos){
		this.movimientosRestantes = movimientos;
	}
	
	private void setMovimientosTotales(int movimientos){
		this.movimientosTotales=movimientos;
	}
	
	private void restarMovimiento(){
		this.movimientosRestantes -= UNICO;
	}
	
	public void moverEnDireccion(AlgoFormer algoformer, Direccion direccion, Mapa mapa){
		/*Funcion que le pide al mapa que mueva un algoformer en alguina direccion.
		 * Recibe como parametro el algoformer a mover, la direccion y el mapa.
		 * Esta funcion lanza una excepcion si el algoformer ya utilizo todos sus movimientos
		 * disponibles en un turno
		 */
		
		if(this.movimientosRestantes == NULO){
			throw new MovimientosAgotadosException();
		}
		
		this.restarMovimiento();
		mapa.moverAlgoformerEnDireccion(algoformer,direccion);
	}
	
	//funcion que sirve para las pruebas
	public int getMovimientosRestantes(){
		return this.movimientosRestantes;
	}
}

package fiuba.algo3.algoFormers.modelo.personajes.manejadores;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class ManejadorDeMovimientos {
	
	private static int NULO=0;
	private static int UNICO=0;
	private int movimientosRestantes; 
	
	public ManejadorDeMovimientos(int movimientos){
		//Manejador de movimeintos que se inicializa con la distancia maxima
		//a la que se puede mover un algoformer.
		this.setMovimientosRestantes(movimientos);
	}
	
	private void setMovimientosRestantes(int movimientos){
		this.movimientosRestantes = movimientos;
	}
	
	private void restarMovimiento(){
		this.movimientosRestantes -= UNICO;
	}
	
	public void moverEnDireccion(AlgoFormer algoformer, Direccion direccion, Mapa mapa){
		this.restarMovimiento();
		mapa.moverAlgoformerEnDireccion(algoformer,direccion);
	}
	
	//funcion que sirve para las pruebas
	public int getMovimientosRestantes(){
		return this.movimientosRestantes;
	}
}

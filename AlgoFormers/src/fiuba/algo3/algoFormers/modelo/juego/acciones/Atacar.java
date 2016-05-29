package fiuba.algo3.algoFormers.modelo.juego.acciones;

import fiuba.algo3.algoFormers.modelo.juego.Accion;
import fiuba.algo3.algoFormers.modelo.mapas.Mapa;
import fiuba.algo3.algoFormers.modelo.mapas.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;

public class Atacar extends Accion {

	private ManejadorDeAtaques manejador;
	
	public Atacar(Mapa mapa, AlgoFormer algoformerAtacante, Posicion posicion) {
		
		manejador = new ManejadorDeAtaques(mapa, algoformerAtacante, posicion);
	}
	
	@Override
	public void ejecutar(AlgoFormer algoformer) {
		// int poder = optimus.getAtaque();
		// int distancia = optimus.getDistanciaDeAtaque();
		// ManejadorDeAtaques manejador = new ManejadorDeAtaques(mapa, atacante);
		manejador.realizarAtaque();
	}

}

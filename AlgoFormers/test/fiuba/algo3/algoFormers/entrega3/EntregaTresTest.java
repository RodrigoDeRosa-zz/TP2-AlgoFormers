package fiuba.algo3.algoFormers.entrega3;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.capturables.bonus.DobleCanion;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;
import fiuba.algo3.algoFormers.modelo.fabricas.algoFormers.AlgoFormerFactory;
import fiuba.algo3.algoFormers.modelo.mapa.Mapa;
import fiuba.algo3.algoFormers.modelo.mapa.Posicion;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public class EntregaTresTest {
	
	@Test
	public void testVerificarDanioConDobleCanionDuranteDiezTurnos(){
		AlgoFormerFactory factory = new AlgoFormerFactory();
		AutoBot optimus = (AutoBot) factory.getOptimusPrime();
		Decepticon megatron = (Decepticon) factory.getMegatron();
		
		DobleCanion dobleCanion = new DobleCanion();
		
		Mapa mapa = new Mapa();
		Posicion posicionIniOptimus = new Posicion(1,1);
		Posicion posicionBonus = new Posicion(1,2);
		Posicion posicionMegatron = new Posicion(1,3);
		
		mapa.ubicar(optimus, posicionIniOptimus);
		mapa.ubicar(dobleCanion, posicionBonus);
		mapa.ubicar(megatron, posicionMegatron);

		optimus.moverEnDireccion(new DirArriba(), mapa);
		optimus.finalizarTurno();
		
		for (int i = 0; i < 10; i++){
			if (i < 3){
				optimus.atacarPosicion(posicionMegatron, mapa);
				assertEquals(450, megatron.getVida());
			}
			if (i >= 3){
				optimus.atacarPosicion(posicionMegatron, mapa);
				assertEquals(500, megatron.getVida());
			}
			megatron.resetearVida();
			optimus.finalizarTurno();
		}
	}

}

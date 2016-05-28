package fiuba.algo3.algoFormers.entrega1;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoFormers.modelo.excepciones.MovimientosAgotadosException;
import fiuba.algo3.algoFormers.modelo.fabricas.AutoBotFactory;
import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeAtaques;
import fiuba.algo3.algoFormers.modelo.personajes.manejadores.ManejadorDeMovimientos;

public class ManejadoresTest {
	
	@Test
	public void testCrearManejadorMovimientos(){
		int movimientos = 3;
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(movimientos);
		assertNotNull(manejador);
	}
	
	@Test
	public void testVerificarMovimientosRestantesSinMover(){
		int movimientos =3;
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(movimientos);
		assertTrue(manejador.getMovimientosRestantes() == movimientos);
	}
	
	@Test 
	public void testVerifiarMovimientosRestantesConMovimiento(){
		
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		int movimientos = optimusPrime.getVelocidad();
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(movimientos);
		Mapa mapa = new Mapa();
		DirDerecha direc = new DirDerecha();
		assertTrue(manejador.getMovimientosRestantes() == movimientos);
		manejador.moverEnDireccion(optimusPrime,direc, mapa);
		assertTrue(manejador.getMovimientosRestantes() == movimientos-1);
	}
	
	@Test 
	public void testVerifiarMovimientosRestantesConMovimientoYReseteo(){
		
		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		int movimientos = optimusPrime.getVelocidad();
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(movimientos);
		Mapa mapa = new Mapa();
		DirDerecha direc = new DirDerecha();
		assertTrue(manejador.getMovimientosRestantes() == movimientos);
		manejador.moverEnDireccion(optimusPrime,direc, mapa);
		manejador.resetearMovimientos();
		assertTrue(manejador.getMovimientosRestantes() == movimientos);
	}
	
	@Test(expected=MovimientosAgotadosException.class)
	public void testVerifiarMovimientosRestantes(){

		AutoBotFactory factory = new AutoBotFactory();
		AlgoFormer optimusPrime = factory.getOptimusPrime();
		int movimientos = optimusPrime.getVelocidad();
		ManejadorDeMovimientos manejador = new ManejadorDeMovimientos(movimientos);
		Mapa mapa = new Mapa();
		DirDerecha direc = new DirDerecha();
		
		for(int x=0; x< movimientos+1; x++){
			manejador.moverEnDireccion(optimusPrime,direc, mapa);
		}
	}	
		
	@Test 
	public void testCrearManejadorAtaque(){
		ManejadorDeAtaques manejador = new ManejadorDeAtaques();
		assertNotNull(manejador);
	}
	
}


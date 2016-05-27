package fiuba.algo3.algoFormers.modelo.fabricas;

import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoAereo;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoTerrestre;

public class AutoBotFactory {

	//Constantes de vida
	private int VIDA_OPTIMUS = 500;
	private int VIDA_BUMBLEBEE = 350;
	private int VIDA_RATCHET = 150;
	//Constantes de velocidad
	private int VELOCIDAD_HUM_OPTIMUS = 2;
	private int VELOCIDAD_ALT_OPTIMUS = 5;
	private int VELOCIDAD_HUM_BUMBLEBEE = 2;
	private int VELOCIDAD_ALT_BUMBLEBEE = 5;
	private int VELOCIDAD_HUM_RATCHET = 1;
	private int VELOCIDAD_ALT_RATCHET = 8;
	//Constantes de ataque
	private int ATAQUE_HUM_OPTIMUS = 60;
	private int ATAQUE_ALT_OPTIMUS = 15;
	private int ATAQUE_HUM_BUMBLEBEE = 40;
	private int ATAQUE_ALT_BUMBLEBEE = 20;
	private int ATAQUE_HUM_RATCHET = 5;
	private int ATAQUE_ALT_RATCHET = 35;
	
	public AutoBotFactory(){
		
	}
	
	public AutoBot getOptimusPrime(){
		Alterno peterbilt379 = new AlternoTerrestre(VELOCIDAD_ALT_OPTIMUS);
		return this.crearAutoBot(VIDA_OPTIMUS, peterbilt379, VELOCIDAD_HUM_OPTIMUS);
	}
	
	public AutoBot getBumblebee(){
		Alterno camaro = new AlternoTerrestre(VELOCIDAD_ALT_BUMBLEBEE);
		return this.crearAutoBot(VIDA_BUMBLEBEE, camaro, VELOCIDAD_HUM_BUMBLEBEE);
	}
	
	public AutoBot getRatchet(){
		Alterno f22raptor = new AlternoAereo(VELOCIDAD_ALT_RATCHET);
		return this.crearAutoBot(VIDA_RATCHET, f22raptor, VELOCIDAD_HUM_RATCHET);
	}
	
	/**
	 * Crea un AutoBot con los parametros recibidos, evita la repeticion de codigo
	 * en las otras tres funciones. 
	 */
	private AutoBot crearAutoBot(int vida, Alterno alterno, int velocidadH){
		return new AutoBot(vida, alterno, velocidadH);
	}
	
}

package fiuba.algo3.algoFormers.modelo.fabricas;

import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;

public class AutoBotFactory {

	private int VIDA_OPTIMUS = 500;
	private int VIDA_BUMBLEBEE = 350;
	private int VIDA_RATCHET = 150;
	
	public AutoBotFactory(){
		
	}
	
	public AutoBot getOptimusPrime(){
		return this.crearAutoBot(VIDA_OPTIMUS);
	}
	
	public AutoBot getBumblebee(){
		return this.crearAutoBot(VIDA_BUMBLEBEE);
	}
	
	public AutoBot getRatchet(){
		return this.crearAutoBot(VIDA_RATCHET);
	}
	
	/**
	 * Crea un AutoBot con los parametros recibidos, evita la repeticion de codigo
	 * en las otras tres funciones. 
	 */
	private AutoBot crearAutoBot(int vida){
		return new AutoBot(vida);
	}
	
}

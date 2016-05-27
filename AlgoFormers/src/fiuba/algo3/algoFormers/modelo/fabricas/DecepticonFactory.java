package fiuba.algo3.algoFormers.modelo.fabricas;

import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public class DecepticonFactory {
	
	private int VIDA_MEGATRON = 550;
	private int VIDA_FRENZY = 400;
	private int VIDA_BONECRUSHER = 200;
	
	public DecepticonFactory(){

	}
	
	public Decepticon getMegatron(){
		return this.crearDecepticon(VIDA_MEGATRON);
	}
	
	public Decepticon getFrenzy(){
		return this.crearDecepticon(VIDA_FRENZY);
	}
	
	public Decepticon getBonecrusher(){
		return this.crearDecepticon(VIDA_BONECRUSHER);
	}
	
	/**
	 * Crea un Decepticon con los parametros recibidos, evita la repeticion de codigo
	 * en las otras tres funciones. 
	 */
	private Decepticon crearDecepticon(int vida){
		return new Decepticon(vida);
	}
}

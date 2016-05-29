package fiuba.algo3.algoFormers.modelo.fabricas;

import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoAereo;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoTerrestre;

public class DecepticonFactory {
	
	//Nombres
	private String NOMBRE_MEGATRON = "Megatron";
	private String NOMBRE_FRENZY = "Frenzy";
	private String NOMBRE_BONECRUSHER = "Bonecrusher";
	//Constantes de vida
	private int VIDA_MEGATRON = 550;
	private int VIDA_FRENZY = 400;
	private int VIDA_BONECRUSHER = 200;
	//Constantes de velocidad
	private int VELOCIDAD_HUM_MEGATRON = 1;
	private int VELOCIDAD_ALT_MEGATRON = 8;
	private int VELOCIDAD_HUM_FRENZY = 2;
	private int VELOCIDAD_ALT_FRENZY = 6;
	private int VELOCIDAD_HUM_BONECRUSHER = 1;
	private int VELOCIDAD_ALT_BONECRUSHER = 8;
	//Constantes de ataque
	private int ATAQUE_HUM_MEGATRON = 10;
	private int ATAQUE_ALT_MEGATRON = 55;
	private int ATAQUE_HUM_FRENZY = 10;
	private int ATAQUE_ALT_FRENZY = 25;
	private int ATAQUE_HUM_BONECRUSHER = 30;
	private int ATAQUE_ALT_BONECRUSHER = 30;
	//Constantes de distancia de ataque
	private int DIST_ATAQUE_HUM_MEGATRON = 3;
	private int DIST_ATAQUE_ALT_MEGATRON = 2;
	private int DIST_ATAQUE_HUM_FRENZY = 5;
	private int DIST_ATAQUE_ALT_FRENZY = 2;
	private int DIST_ATAQUE_HUM_BONECRUSHER = 3;
	private int DIST_ATAQUE_ALT_BONECRUSHER = 3;	
	
	public DecepticonFactory(){

	}
	
	public Decepticon getMegatron(){
		Alterno jetCibertroniano = new AlternoAereo(VELOCIDAD_ALT_MEGATRON, ATAQUE_ALT_MEGATRON, DIST_ATAQUE_ALT_MEGATRON);
		return this.crearDecepticon(NOMBRE_MEGATRON, VIDA_MEGATRON, jetCibertroniano, VELOCIDAD_HUM_MEGATRON, ATAQUE_HUM_MEGATRON, DIST_ATAQUE_HUM_MEGATRON);
	}
	
	public Decepticon getFrenzy(){
		Alterno buffaloHMPCV = new AlternoTerrestre(VELOCIDAD_ALT_FRENZY, ATAQUE_ALT_FRENZY, DIST_ATAQUE_ALT_FRENZY);
		return this.crearDecepticon(NOMBRE_FRENZY, VIDA_FRENZY, buffaloHMPCV, VELOCIDAD_HUM_FRENZY, ATAQUE_HUM_FRENZY, DIST_ATAQUE_HUM_FRENZY);
	}
	
	public Decepticon getBonecrusher(){
		Alterno duster = new AlternoTerrestre(VELOCIDAD_ALT_BONECRUSHER, ATAQUE_ALT_BONECRUSHER, DIST_ATAQUE_ALT_BONECRUSHER);
		return this.crearDecepticon(NOMBRE_BONECRUSHER, VIDA_BONECRUSHER, duster, VELOCIDAD_HUM_BONECRUSHER, ATAQUE_HUM_BONECRUSHER, DIST_ATAQUE_HUM_BONECRUSHER);
	}
	
	/**
	 * Crea un Decepticon con los parametros recibidos, evita la repeticion de codigo
	 * en las otras tres funciones. 
	 */
	private Decepticon crearDecepticon(String nombre, int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		return new Decepticon(nombre, vida, alterno, velocidadH, ataqueH, distAtaqueH);
	}
}

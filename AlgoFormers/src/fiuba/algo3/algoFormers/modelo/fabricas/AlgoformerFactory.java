package fiuba.algo3.algoFormers.modelo.fabricas;

import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoAereo;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.AlternoTerrestre;
/**
 * Clase AlgoformerFactory, se utiliza para crear los distintos algoformers que pueden ser utilizados
 * como personajes en el juego. Contiene todos los datos necesarios para crearlos, y metodos para
 * devolverlos.
 */
public class AlgoformerFactory {
	
	/* AUTOBOTS */
	
	//OPTIMUS
	private String NOMBRE_OPTIMUS = "OPTIMUS";
	private int VIDA_OPTIMUS = 500;
	private int VELOCIDAD_HUM_OPTIMUS = 2;
	private int VELOCIDAD_ALT_OPTIMUS = 5;
	private int ATAQUE_HUM_OPTIMUS = 50;
	private int ATAQUE_ALT_OPTIMUS = 15;
	private int DIST_ATAQUE_HUM_OPTIMUS = 2;
	private int DIST_ATAQUE_ALT_OPTIMUS = 4;
	
	//BUMBLEBEE
	private String NOMBRE_BUMBLEBEE = "BUMBLEBEE"; 
	private int VIDA_BUMBLEBEE = 350;
	private int VELOCIDAD_HUM_BUMBLEBEE = 2;
	private int VELOCIDAD_ALT_BUMBLEBEE = 5;
	private int ATAQUE_HUM_BUMBLEBEE = 40;
	private int ATAQUE_ALT_BUMBLEBEE = 20;
	private int DIST_ATAQUE_HUM_BUMBLEBEE = 1;
	private int DIST_ATAQUE_ALT_BUMBLEBEE = 3;
	
	//RATCHET
	private String NOMBRE_RATCHET = "RATCHET";
	private int VIDA_RATCHET = 150;
	private int VELOCIDAD_HUM_RATCHET = 1;
	private int VELOCIDAD_ALT_RATCHET = 8;
	private int ATAQUE_HUM_RATCHET = 5;
	private int ATAQUE_ALT_RATCHET = 35;
	private int DIST_ATAQUE_HUM_RATCHET = 5;
	private int DIST_ATAQUE_ALT_RATCHET = 2;
	
	
	/* DECEPTICONS */
	
	//MEGATRON
	private String NOMBRE_MEGATRON = "MEGATRON";
	private int VIDA_MEGATRON = 550;
	private int VELOCIDAD_HUM_MEGATRON = 1;
	private int VELOCIDAD_ALT_MEGATRON = 8;
	private int ATAQUE_HUM_MEGATRON = 10;
	private int ATAQUE_ALT_MEGATRON = 55;
	private int DIST_ATAQUE_HUM_MEGATRON = 3;
	private int DIST_ATAQUE_ALT_MEGATRON = 2;
	
	//FRENZY
	private String NOMBRE_FRENZY = "FRENZY";
	private int VIDA_FRENZY = 400;
	private int VELOCIDAD_HUM_FRENZY = 2;
	private int VELOCIDAD_ALT_FRENZY = 6;
	private int ATAQUE_HUM_FRENZY = 10;
	private int ATAQUE_ALT_FRENZY = 25;
	private int DIST_ATAQUE_HUM_FRENZY = 5;
	private int DIST_ATAQUE_ALT_FRENZY = 2;
	
	//BONECRUSHER
	private String NOMBRE_BONECRUSHER = "BONECRUSHER";
	private int VIDA_BONECRUSHER = 200;	
	private int VELOCIDAD_HUM_BONECRUSHER = 1;
	private int VELOCIDAD_ALT_BONECRUSHER = 8;	
	private int ATAQUE_HUM_BONECRUSHER = 30;
	private int ATAQUE_ALT_BONECRUSHER = 30;	
	private int DIST_ATAQUE_HUM_BONECRUSHER = 3;
	private int DIST_ATAQUE_ALT_BONECRUSHER = 3;
	
	private Decepticon crearDecepticon(String nombre, int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		return new Decepticon(nombre, vida, alterno, velocidadH, ataqueH, distAtaqueH);
	}
	
	private AutoBot crearAutoBot(String nombre, int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		return new AutoBot(nombre, vida, alterno, velocidadH, ataqueH, distAtaqueH);
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
	
	public AutoBot getOptimusPrime(){
		Alterno peterbilt379 = new AlternoTerrestre(VELOCIDAD_ALT_OPTIMUS, ATAQUE_ALT_OPTIMUS, DIST_ATAQUE_ALT_OPTIMUS);
		return this.crearAutoBot(NOMBRE_OPTIMUS, VIDA_OPTIMUS, peterbilt379, VELOCIDAD_HUM_OPTIMUS, ATAQUE_HUM_OPTIMUS, DIST_ATAQUE_HUM_OPTIMUS);
	}
	
	public AutoBot getBumblebee(){
		Alterno camaro = new AlternoTerrestre(VELOCIDAD_ALT_BUMBLEBEE, ATAQUE_ALT_BUMBLEBEE, DIST_ATAQUE_ALT_BUMBLEBEE);
		return this.crearAutoBot(NOMBRE_BUMBLEBEE, VIDA_BUMBLEBEE, camaro, VELOCIDAD_HUM_BUMBLEBEE, ATAQUE_HUM_BUMBLEBEE, DIST_ATAQUE_HUM_BUMBLEBEE);
	}
	
	public AutoBot getRatchet(){
		Alterno f22raptor = new AlternoAereo(VELOCIDAD_ALT_RATCHET, ATAQUE_ALT_RATCHET, DIST_ATAQUE_ALT_RATCHET);
		return this.crearAutoBot(NOMBRE_RATCHET, VIDA_RATCHET, f22raptor, VELOCIDAD_HUM_RATCHET, ATAQUE_HUM_RATCHET, DIST_ATAQUE_HUM_RATCHET);
	}
	
}

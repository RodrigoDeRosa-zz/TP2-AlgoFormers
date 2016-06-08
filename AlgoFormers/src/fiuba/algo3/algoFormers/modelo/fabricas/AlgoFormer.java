package fiuba.algo3.algoFormers.modelo.fabricas;

public enum AlgoFormer {
	OPTIMUS_PRIME ("Optimus Prime", 500, 2, 5, 50, 15, 2, 4),
	
	
	private final String nombre;
	private final int vida;
	private final int velHum;
	private final int velAlt;
	private final int ataqueHum;
	private final int ataqueAlt;
	private final int distAtHum;
	private final int distAtAlt;
	AlgoFormer(String nombre, int vida, int velHum, int velAlt, int ataqueHum, int ataqueAlt, int distAtHum, int distAtAlt){
		
	}

}

//Nombres
	private String NOMBRE_OPTIMUS = "Optimus Prime";
	private String NOMBRE_BUMBLEBEE = "Bumblebee";
	private String NOMBRE_RATCHET = "Ratchet";
	//Constantes de Vida
	private int VIDA_OPTIMUS = 500;
	private int VIDA_BUMBLEBEE = 350;
	private int VIDA_RATCHET = 150;
	//Constantes de Velocidad
	private int VELOCIDAD_HUM_OPTIMUS = 2;
	private int VELOCIDAD_ALT_OPTIMUS = 5;
	private int VELOCIDAD_HUM_BUMBLEBEE = 2;
	private int VELOCIDAD_ALT_BUMBLEBEE = 5;
	private int VELOCIDAD_HUM_RATCHET = 1;
	private int VELOCIDAD_ALT_RATCHET = 8;
	//Constantes de ataque
	private int ATAQUE_HUM_OPTIMUS = 50;
	private int ATAQUE_ALT_OPTIMUS = 15;
	private int ATAQUE_HUM_BUMBLEBEE = 40;
	private int ATAQUE_ALT_BUMBLEBEE = 20;
	private int ATAQUE_HUM_RATCHET = 5;
	private int ATAQUE_ALT_RATCHET = 35;
	//Constantes de DistanciaDeAtaque
	private int DIST_ATAQUE_HUM_OPTIMUS = 2;
	private int DIST_ATAQUE_ALT_OPTIMUS = 4;
	private int DIST_ATAQUE_HUM_BUMBLEBEE = 1;
	private int DIST_ATAQUE_ALT_BUMBLEBEE = 3;
	private int DIST_ATAQUE_HUM_RATCHET = 5;
	private int DIST_ATAQUE_ALT_RATCHET = 2;

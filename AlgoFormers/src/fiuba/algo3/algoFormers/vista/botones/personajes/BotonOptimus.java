package fiuba.algo3.algoFormers.vista.botones.personajes;

import fiuba.algo3.algoFormers.modelo.juego.Juego;

public class BotonOptimus extends BotonPersonaje{

	private final static String imagen = "/home/rodrigo/git/PruebasJavaFX/AlgoFormers/Optimus Prime.png";	
	
	public BotonOptimus(Juego juego){
		super(juego, imagen, 60, 60);
	}
	
}

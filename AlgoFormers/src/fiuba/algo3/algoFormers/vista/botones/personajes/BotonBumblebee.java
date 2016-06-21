package fiuba.algo3.algoFormers.vista.botones.personajes;

import fiuba.algo3.algoFormers.modelo.juego.Juego;

public class BotonBumblebee extends BotonPersonaje {

	private final static String imagen = "/home/rodrigo/git/PruebasJavaFX/AlgoFormers/Bumblebee.png";	
	
	public BotonBumblebee(Juego juego){
		super(juego, imagen, 60, 60);
	}
	
}

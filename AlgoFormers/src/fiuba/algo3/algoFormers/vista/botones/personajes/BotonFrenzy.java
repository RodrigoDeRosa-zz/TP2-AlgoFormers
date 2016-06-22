package fiuba.algo3.algoFormers.vista.botones.personajes;

import fiuba.algo3.algoFormers.modelo.juego.Juego;

public class BotonFrenzy extends BotonPersonaje {

	private final static String imagen = "file:src/fiuba/algo3/algoFormers/vista/imagenes/Frenzy.png";	
	
	public BotonFrenzy(Juego juego){
		super(juego, imagen, 60, 60, juego.getAlgoformer("Frenzy"));
	}
	
}

package fiuba.algo3.algoFormers.vista.botones.personajes;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class BotonBonecrusher extends BotonPersonaje {

	private final static String imagen = "file:src/fiuba/algo3/algoFormers/vista/imagenes/Bonecrusher.png";	
	
	public BotonBonecrusher(Juego juego){
		super(juego, imagen, 60, 60);
	}
	
}

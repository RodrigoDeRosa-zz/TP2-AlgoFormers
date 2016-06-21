package fiuba.algo3.algoFormers.vista.botones.direcciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajo;

public class BotonDireccionAbajo extends BotonDireccion {

	private final static String imagen = "/home/rodrigo/git/PruebasJavaFX/Flechas/Abajo.png";
	
	public BotonDireccionAbajo(Juego juego) {
		super(juego, new DirAbajo(), imagen);
	}

}

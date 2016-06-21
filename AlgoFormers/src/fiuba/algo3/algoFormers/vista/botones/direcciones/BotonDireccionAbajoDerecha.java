package fiuba.algo3.algoFormers.vista.botones.direcciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajoDer;

public class BotonDireccionAbajoDerecha extends BotonDireccion {

	private final static String imagen = "/home/rodrigo/git/PruebasJavaFX/Flechas/AbajoDerecha.png";
	
	public BotonDireccionAbajoDerecha(Juego juego) {
		super(juego, new DirAbajoDer(), imagen);
	}

}
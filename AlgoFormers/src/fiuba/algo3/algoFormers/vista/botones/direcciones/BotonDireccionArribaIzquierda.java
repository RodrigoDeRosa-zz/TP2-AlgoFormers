package fiuba.algo3.algoFormers.vista.botones.direcciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArribaIzq;

public class BotonDireccionArribaIzquierda extends BotonDireccion {

	private final static String imagen = "/home/rodrigo/git/PruebasJavaFX/Flechas/ArribaIzquierda.png";
	
	public BotonDireccionArribaIzquierda(Juego juego) {
		super(juego, new DirArribaIzq(), imagen);
	}

}

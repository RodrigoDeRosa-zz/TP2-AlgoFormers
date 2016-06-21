package fiuba.algo3.algoFormers.vista.botones.direcciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.direcciones.DirAbajoIzq;

public class BotonDireccionAbajoIzquierda extends BotonDireccion {

	private final static String imagen = "/home/rodrigo/git/PruebasJavaFX/Flechas/AbajoIzquierda.png";
	
	public BotonDireccionAbajoIzquierda(Juego juego) {
		super(juego, new DirAbajoIzq(), imagen);
	}

}

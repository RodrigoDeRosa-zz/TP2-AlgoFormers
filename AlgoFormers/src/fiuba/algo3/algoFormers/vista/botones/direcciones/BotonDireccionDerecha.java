package fiuba.algo3.algoFormers.vista.botones.direcciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.direcciones.DirDerecha;

public class BotonDireccionDerecha extends BotonDireccion {

	private final static String imagen = "/home/rodrigo/git/PruebasJavaFX/Flechas/Derecha.png";
	
	public BotonDireccionDerecha(Juego juego) {
		super(juego, new DirDerecha(), imagen);
	}

}

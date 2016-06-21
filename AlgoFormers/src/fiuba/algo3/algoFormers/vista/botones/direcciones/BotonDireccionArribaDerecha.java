package fiuba.algo3.algoFormers.vista.botones.direcciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArribaDer;

public class BotonDireccionArribaDerecha extends BotonDireccion {
	
	private final static String imagen = "/home/rodrigo/git/PruebasJavaFX/Flechas/ArribaDerecha.png";
	
	public BotonDireccionArribaDerecha(Juego juego){
		super(juego, new DirArribaDer(), imagen);
	}
	
}

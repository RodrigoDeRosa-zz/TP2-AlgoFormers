package fiuba.algo3.algoFormers.vista.botones.direcciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.direcciones.DirArriba;

public class BotonDireccionArriba extends BotonDireccion {
	
	private final static String imagen = "/home/rodrigo/git/PruebasJavaFX/Flechas/Arriba.png";
	
	public BotonDireccionArriba(Juego juego){
		super(juego, new DirArriba(), imagen);
	}
	
}
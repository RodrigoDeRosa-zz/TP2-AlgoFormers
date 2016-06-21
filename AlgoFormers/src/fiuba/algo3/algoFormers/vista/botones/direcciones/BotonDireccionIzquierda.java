package fiuba.algo3.algoFormers.vista.botones.direcciones;

import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.modelo.direcciones.DirIzquierda;

public class BotonDireccionIzquierda extends BotonDireccion {

	private final static String imagen = "file:src/fiuba/algo3/algoFormers/vista/imagenes/Izquierda.png";
	
	public BotonDireccionIzquierda(Juego juego) {
		super(juego, new DirIzquierda(), imagen);
	}

}

package fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion;

import fiuba.algo3.algoFormers.modelo.efecto.EfectoPantano;
import fiuba.algo3.algoFormers.modelo.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.tipos.UnidadTerrestre;

public class Humanoide extends EstadoDeTransformacion {

	public Humanoide(int velocidad, int ataque, int distAtaque){
		super(velocidad, ataque, distAtaque);
		this.tipo= new UnidadTerrestre();
	}
	
	public void guardarEfectoPantano(EfectoPantano efecto){
		throw new MovimientoInvalidoException();
	}
	
}

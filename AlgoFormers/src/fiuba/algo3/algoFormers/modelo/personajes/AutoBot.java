package fiuba.algo3.algoFormers.modelo.personajes;

import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;

import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;

public class AutoBot extends Algoformer {

	public AutoBot(String nombre, int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		super(nombre, vida, alterno, velocidadH, ataqueH, distAtaqueH);
	}

	@Override
	public void recibirDanio(Algoformer algoformer) {
		
		algoformer.atacar(this);
		
	}

	@Override
	public void atacar(AutoBot autobot) {
		autobot.recibirDanio(this);
		
	}

	@Override
	public void atacar(Decepticon decepticon) {
		decepticon.recibirDanio(this);
		
	}
	
	@Override
	public void recibirDanio(AutoBot autobot) {
		
		throw new FuegoAmigoException();		
		
	}

	@Override
	public void recibirDanio(Decepticon decepticon) {
		
		this.vida.descontar(decepticon.getPuntosAtaque());
		
	}

}

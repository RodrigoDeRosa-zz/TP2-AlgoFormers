package fiuba.algo3.algoFormers.modelo.personajes;

import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;

public class Decepticon extends AlgoFormer{

	public Decepticon(String nombre, int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		super(nombre, vida, alterno, velocidadH, ataqueH, distAtaqueH);
	}
	
	
	@Override
	public void recibirDanio(AlgoFormer algoformer) {
		
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
		
		this.vida.descontarVida(autobot.getAtaque());
				
		
	}

	@Override
	public void recibirDanio(Decepticon decepticon) {
		
		throw new FuegoAmigoException();
		
	}


}

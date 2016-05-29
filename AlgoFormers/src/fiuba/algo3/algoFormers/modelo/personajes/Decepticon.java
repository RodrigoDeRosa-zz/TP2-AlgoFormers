package fiuba.algo3.algoFormers.modelo.personajes;

import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;

public class Decepticon extends AlgoFormer{

	public Decepticon(int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		super(vida, alterno, velocidadH, ataqueH, distAtaqueH);
	}
	
	@Override
	public void recibirDanio(AutoBot autobot) {
		
		this.vida.descontarVida(autobot.getAtaque());
				
		
	}

	@Override
	public void recibirDanio(Decepticon decepticon) {
		
		throw new FuegoAmigoException();
		
	}

	@Override
	public void atacar(Atacable atacable) {
		
		atacable.recibirDanio(this);
		
	}
	
	@Override
	public void recibirDanio(AlgoFormer algoformer) {
		
		algoformer.atacar(this);
		
	}

}

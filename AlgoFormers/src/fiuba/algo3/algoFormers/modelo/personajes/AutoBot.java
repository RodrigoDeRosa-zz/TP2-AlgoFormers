package fiuba.algo3.algoFormers.modelo.personajes;

import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.algoFormers.modelo.excepciones.NoEsAtacableException;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;

public class AutoBot extends AlgoFormer {

	public AutoBot(int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		super(vida, alterno, velocidadH, ataqueH, distAtaqueH);
	}

	@Override
	public void recibirDanio(AutoBot autobot) {
		
		throw new FuegoAmigoException();		
		
	}

	@Override
	public void recibirDanio(Decepticon decepticon) {
		
		this.vida.descontarVida(decepticon.getAtaque());
		
	}


	@Override
	public void recibirDanio(AlgoFormer algoformer) {
		
		algoformer.recibirDanio(this);
		
	}




}

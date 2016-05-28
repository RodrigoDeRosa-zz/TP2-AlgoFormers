package fiuba.algo3.algoFormers.modelo.personajes;

import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;

public class Decepticon extends AlgoFormer{

	public Decepticon(int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		super(vida, alterno, velocidadH, ataqueH, distAtaqueH);
	}
	
	public void recibirDanio(Ubicable ubicable, int poderAtaque){
		
		if(ubicable.getClass() == this.getClass()){
			throw new FuegoAmigoException();
		}
		this.vida.descontarVida(poderAtaque);
	}

}

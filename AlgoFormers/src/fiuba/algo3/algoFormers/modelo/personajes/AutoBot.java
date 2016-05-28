package fiuba.algo3.algoFormers.modelo.personajes;

import fiuba.algo3.algoFormers.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.algoFormers.modelo.personajes.estadosDeTransformacion.Alterno;

public class AutoBot extends AlgoFormer {

	public AutoBot(int vida, Alterno alterno, int velocidadH, int ataqueH, int distAtaqueH){
		super(vida, alterno, velocidadH, ataqueH, distAtaqueH);
	}
	
	public void recibirDaño(AutoBot autobot){
		throw new FuegoAmigoException();
	}
	
	public void recibirDaño(Decepticon decepticon){
		// falta restarle la vida this.vida = ;
		
	}
}

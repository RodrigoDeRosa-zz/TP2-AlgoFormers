package fiuba.algo3.algoFormers.modelo.interfaces;

import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public interface Atacable extends Ubicable{
	
	public void recibirDanio(Ubicable ubicable, int poderAtaque);

}

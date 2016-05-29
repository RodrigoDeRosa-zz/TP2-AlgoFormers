package fiuba.algo3.algoFormers.modelo.interfaces;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public interface Atacable extends Ubicable{
		
	public void recibirDanio(AlgoFormer algoformer);
	
	public void recibirDanio(AutoBot autobot);
	
	public void recibirDanio(Decepticon decepticon);
	

}

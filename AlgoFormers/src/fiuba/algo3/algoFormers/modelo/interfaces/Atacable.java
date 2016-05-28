package fiuba.algo3.algoFormers.modelo.interfaces;

import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

public interface Atacable {
	
	public void recibirDaño(AutoBot autobot, int poderAtaque);
	public void recibirDaño(Decepticon decepticon, int poderAtaque);
}

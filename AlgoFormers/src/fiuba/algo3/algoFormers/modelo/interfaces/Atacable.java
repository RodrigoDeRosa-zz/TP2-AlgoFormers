package fiuba.algo3.algoFormers.modelo.interfaces;

import fiuba.algo3.algoFormers.modelo.personajes.AutoBot;
import fiuba.algo3.algoFormers.modelo.personajes.Decepticon;

/**
 * Interfaz Atacable, que se utiliza para manejar los danios recibidos entre los distintos algoformers.
 */
public interface Atacable extends Ubicable{
			
	/**
	 * Recibe el danio del autobot pasado como parametro. Si este atacable es un autobot, se lanza
	 * una excepcion de FuegoAmigoException. Si este atacable es un decepticon, se computan los
	 * danios segun el estado actual.
	 * @param autobot :Un autobot en estado valido.
	 */
	public void recibirDanio(AutoBot autobot);
	
	/**
	 * Recibe el danio del decepticon pasado como parametro. Si este atacable es un decepticon, se lanza
	 * una excepcion de FuegoAmigoException. Si este atacable es un autobot, se computan los
	 * danios segun el estado actual.
	 * @param decepticon :Un decepticon en estado valido.
	 */
	public void recibirDanio(Decepticon decepticon);
	

}

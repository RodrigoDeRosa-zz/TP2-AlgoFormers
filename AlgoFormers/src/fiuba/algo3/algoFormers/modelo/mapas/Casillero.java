package fiuba.algo3.algoFormers.modelo.mapas;

import fiuba.algo3.algoFormers.modelo.capturables.Chispa;
import fiuba.algo3.algoFormers.modelo.interfaces.Atacable;
import fiuba.algo3.algoFormers.modelo.interfaces.Capturable;

public class Casillero {

	private Atacable atacable;
	private Capturable capturable;
	private boolean ocupado;
	private boolean ocupadoCapturable;
	
	public Casillero(){
		atacable = null;
		capturable = null;
		ocupado = false;
		ocupadoCapturable = false;
	}
	
	public void setAtacable(Atacable atacable){
		this.atacable = atacable;
		ocupado = true;
	}

	public void setCapturable(Capturable capturable) {
		this.capturable = capturable;
		ocupadoCapturable = true;
	}
	
	public boolean estaOcupado() {
		return ocupado;
	}

	public boolean estaOcupadoCapturable() {
		return ocupadoCapturable;
	}
	
	public Atacable getAtacable() {
		return atacable;
	}

	public void desocuparAtacable() {
		atacable = null;
		ocupado = false;
	}

	public void ocuparConAtacable(Atacable atacable) {
		this.atacable = atacable;
		ocupado = true;
	}

	public Capturable getCapturable() {
		return this.capturable;
	}

}

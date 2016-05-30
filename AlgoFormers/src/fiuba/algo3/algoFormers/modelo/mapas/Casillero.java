package fiuba.algo3.algoFormers.modelo.mapas;

import fiuba.algo3.algoFormers.modelo.capturables.Chispa;
import fiuba.algo3.algoFormers.modelo.interfaces.Capturable;
import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;

public class Casillero {

	private Ubicable ubicable;
	private Capturable capturable;
	private boolean ocupado;
	
	public Casillero(){
		ubicable = null;
		capturable = null;
		ocupado = false;
	}
	
	public void setUbicable(Ubicable unUbicable){
		this.ubicable = unUbicable;
		ocupado = true;
	}

	public void setCapturable(Chispa laChispa) {
		this.capturable = laChispa;
		ocupado = true;
	}
	
	public boolean estaOcupado() {
		return ocupado;
	}

	public Ubicable getUbicable() {
		return ubicable;
	}

	public void desocuparUbicable() {
		ubicable = null;
		ocupado = false;
	}

	public void ocuparConUbicable(Ubicable ubicable) {
		this.ubicable = ubicable;
		ocupado = true;
	}

	public Capturable getCapturable() {
		return this.capturable;
	}

}

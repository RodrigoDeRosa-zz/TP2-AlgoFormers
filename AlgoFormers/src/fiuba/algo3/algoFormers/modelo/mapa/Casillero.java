package fiuba.algo3.algoFormers.modelo.mapa;

import fiuba.algo3.algoFormers.modelo.excepciones.CasilleroOcupadoException;
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
	
	public void ubicar(Atacable atacable){
		this.verificarCasilleroEstaVacio();
		this.setAtacable(atacable);
	}
	
	public void ubicar(Capturable capturable){
		this.verificarCasilleroCapturableEstaVacio();
		this.setCapturable(capturable);
	}
	
	private void setAtacable(Atacable atacable){
		this.atacable = atacable;
		ocupado = true;
	}

	private void setCapturable(Capturable capturable) {
		this.capturable = capturable;
		ocupadoCapturable = true;
	}
	
	private boolean estaOcupado() {
		return ocupado;
	}

	private boolean estaOcupadoCapturable() {
		return ocupadoCapturable;
	}
	
	public Atacable getAtacable() {
		return atacable;
	}
	
	public Capturable getCapturable() {
		return this.capturable;
	}
	
	public void desocuparAtacable() {
		atacable = null;
		ocupado = false;
	}
	
	private void verificarCasilleroEstaVacio() {
		if (this.estaOcupado()){
			throw new CasilleroOcupadoException("Ya hay un atacable en este casillero");
		}
	}


	private void verificarCasilleroCapturableEstaVacio() {
		if (this.estaOcupadoCapturable()){
			throw new CasilleroOcupadoException("Ya hay un capturable en este casillero");
		}
	}

}

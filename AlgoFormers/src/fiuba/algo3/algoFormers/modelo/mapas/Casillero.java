package fiuba.algo3.algoFormers.modelo.mapas;

import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;

public class Casillero {

	private Ubicable ubicable;
	
	public Casillero(){
		ubicable = null;
	}
	
	public void ocupar(Ubicable unUbicable){
		this.ubicable = unUbicable;
	}

	public boolean estaOcupado() {
		return (ubicable != null);
	}

	public Ubicable getUbicable() {
		return ubicable;
	}

	public void desocupar() {
		ubicable = null;
	}

}

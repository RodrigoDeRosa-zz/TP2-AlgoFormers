package fiuba.algo3.algoFormers.modelo.mapas;

import fiuba.algo3.algoFormers.modelo.interfaces.Ubicable;

public class Casillero {

	private Ubicable ubicable;
	private boolean ocupado;
	
	public Casillero(){
		
		ocupado = false;
		
	}
	
	public void setUbicable(Ubicable unUbicable){
		
		this.ubicable = unUbicable;
		ocupado = true;
		
		
	}

	public boolean estaOcupado() {
		
		return ocupado;
	
	}

	public Ubicable getUbicable() {
		
		return ubicable;
		
	}

	public void desocuparUbicable() {
		// TODO Auto-generated method stub
		
	}

	public void ocuparConUbicable(Ubicable ubicable) {
		// TODO Auto-generated method stub
		
	}
}

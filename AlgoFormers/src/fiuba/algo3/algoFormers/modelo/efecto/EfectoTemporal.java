package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public class EfectoTemporal extends Efecto{

	protected int turnos;

	public EfectoTemporal(int multiplicador, int base, int turnos){
		 super(multiplicador,base);
		 this.turnos = turnos;
	}

	@Override
	public void aplicarseEn(AlgoFormer algoformer) {
		// TODO Auto-generated method stub
		
	}

	public void restarTurno() {
		turnos--;
	}

	public boolean tiempoTerminado() {
		return (turnos == 0);
	}
}

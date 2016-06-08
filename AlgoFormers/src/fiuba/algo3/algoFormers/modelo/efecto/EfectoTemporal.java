package fiuba.algo3.algoFormers.modelo.efecto;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class EfectoTemporal extends Efecto{

	protected int turnos;

	public EfectoTemporal(int multiplicador, int base, int turnos){
		 super(multiplicador,base);
		 this.turnos = turnos;
	}

	public abstract void aplicarseEn(AlgoFormer algoformer);

	public void restarTurno() {
		turnos--;
	}

	public boolean tiempoTerminado() {
		return (turnos == 0);
	}
}

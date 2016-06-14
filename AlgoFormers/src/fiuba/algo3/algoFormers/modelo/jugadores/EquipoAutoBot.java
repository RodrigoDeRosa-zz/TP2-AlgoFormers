package fiuba.algo3.algoFormers.modelo.jugadores;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;
import fiuba.algo3.algoFormers.modelo.personajes.Superion;

public class EquipoAutoBot extends Equipo{

	private Superion megabot;
	
	public EquipoAutoBot(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres){
		super(uno, dos, tres);
		this.setMegaBot(uno, dos, tres);
	}
	
	public void setMegaBot(AlgoFormer uno, AlgoFormer dos, AlgoFormer tres) {
		this.megabot = new Superion(this.calcularVidaMegaBot(), uno, dos, tres);
	}
	
	@Override
	protected void definirMegaBotComoActual(int vida) {
		this.personajeActual = this.megabot.vida(vida);
	}
}

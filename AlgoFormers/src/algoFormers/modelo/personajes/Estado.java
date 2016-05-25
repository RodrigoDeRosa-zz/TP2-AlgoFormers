package algoFormers.modelo.personajes;

public abstract class Estado {
	
	protected int vida;
	protected int ataque;
	protected int distanciaAtaque;
	protected int velocidad;

	public Estado(int vida, int ataque, int distanciaAtaque, int velocidad){
		this.vida = vida;
		this.ataque = ataque;
		this.distanciaAtaque = distanciaAtaque;
		this.velocidad = velocidad;	
	}

}

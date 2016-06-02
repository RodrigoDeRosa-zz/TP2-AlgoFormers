package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import java.util.ArrayList;

import fiuba.algo3.algoFormers.modelo.personajes.AlgoFormer;

public abstract class Atributo {
	
	protected int valor;
	protected ArrayList<Atributo> bonus;
	
	public Atributo(int valor){
		this.setValor(valor);
		this.setBonus();
	}
	
	private void setValor(int valor){
		this.valor = valor;
	 }
	
	private void setBonus(){
		this.bonus = new ArrayList<Atributo>();
	}
	
	public abstract void aplicarseEn(AlgoFormer algoformer);
	
	public void agregarBonus(Atributo atributo){
		this.bonus.add(atributo);
	}
	
	//Metodos para las pruebas. No se deberian usar
	public int getValor(){
		return this.valor;
	}

}

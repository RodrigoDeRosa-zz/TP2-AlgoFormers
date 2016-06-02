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
	
	private void quitarBonus(Atributo atributo){
		this.bonus.remove(this.bonus.indexOf(atributo));
	}
	
	private int calcularValor(){
		int valor_final = this.valor;
		for (Atributo efecto : this.bonus){
			valor_final += efecto.getValor();
		}
		return valor_final;
	}
	
	//Metodos para las pruebas. No se deberian usar
	public int getValor(){
		return this.calcularValor();
	}

}

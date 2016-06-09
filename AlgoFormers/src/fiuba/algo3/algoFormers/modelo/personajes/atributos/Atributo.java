package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import java.util.ArrayList;

import fiuba.algo3.algoFormers.modelo.efecto.EfectoEstatico;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoTemporal;

public abstract class Atributo {
	
	protected ArrayList<EfectoEstatico> efectosEstaticos;
	protected ArrayList<EfectoTemporal> efectosTemporales;
	protected int valorActual;
	protected int valorOriginal;
	
	public Atributo(int valor){
		efectosEstaticos = new ArrayList<EfectoEstatico>();
		efectosTemporales = new ArrayList<EfectoTemporal>();
		valorOriginal = valor;
		valorActual = valor;
	}
	
	public void agregarEfectoFijo(EfectoEstatico efecto){
		efectosEstaticos.remove(efecto);
		efectosEstaticos.add(efecto);
		this.valorActual = this.calcularValorActual(this.valorOriginal);
	}
	
	public void agregarEfectoTemporal(EfectoTemporal efecto){
		efectosTemporales.add(efecto);
		this.valorActual = this.calcularValorActual(this.valorActual);
	}	
	
	public int valorActual(){
		return this.valorActual;
	}
	
	public void actualizar(){
		this.valorActual = this.calcularValorActual(this.valorOriginal);
	}

	public int calcularValorActual(int valorBase){
		int valorCalculado = valorBase;
		for (int i = 0; i < efectosEstaticos.size(); i++){
			EfectoEstatico efecto = efectosEstaticos.get(i); 
			valorCalculado += efecto.obtenerValorFijo();
			valorCalculado += (valorBase*efecto.obtenerValorMult())/100; 
		}
		for (int i = 0; i < efectosTemporales.size(); i++){
			EfectoTemporal efecto = efectosTemporales.get(i); 
			valorCalculado += efecto.obtenerValorFijo();
			valorCalculado += (valorBase*efecto.obtenerValorMult())/100;
			efecto.restarTurno();
			if (efecto.tiempoTerminado()){
				efectosTemporales.remove(efecto);
			}
		}
		
		//Para la nebulosa de andromeda, el valor calculado va a ser negativo y por eso se restaura a cero
		if (valorCalculado < 0) valorCalculado = 0;
		
		return valorCalculado;
		
	}
	
}

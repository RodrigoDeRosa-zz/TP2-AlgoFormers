package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import java.util.ArrayList;

import fiuba.algo3.algoFormers.modelo.efecto.EfectoEstatico;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoTemporal;

public abstract class Atributo {
	
	protected ArrayList<EfectoEstatico> efectosEstaticos;
	protected ArrayList<EfectoTemporal> efectosTemporales;
	protected int valorActual;
	
	public Atributo(int valor){
		efectosEstaticos = new ArrayList<EfectoEstatico>();
		efectosTemporales = new ArrayList<EfectoTemporal>();
		valorActual = valor;
	}
	
	public void agregarEfectoFijo(EfectoEstatico efecto){
		efectosEstaticos.remove(efecto);
		efectosEstaticos.add(efecto);
	}
	
	public void agregarEfectoTemporal(EfectoTemporal efecto){
		efectosTemporales.add(efecto);
	}	

	public int calcularValorActual(){
		int valorCalculado = valorActual;
		for (EfectoEstatico efecto : this.efectosEstaticos){
			valorCalculado += efecto.obtenerValorFijo();
			valorCalculado += (valorActual*efecto.obtenerValorMult())/100; 
		}
		for (EfectoTemporal efecto : this.efectosTemporales){
			valorCalculado += efecto.obtenerValorFijo();
			valorCalculado -= (valorActual*efecto.obtenerValorMult())/100;
			efecto.restarTurno();
			if (efecto.tiempoTerminado()){
				efectosTemporales.remove(efecto);
			}
		}
		return valorCalculado;
		
	}
	
}

package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import java.util.ArrayList;

public abstract class Atributo {
	
	protected ArrayList<EfectoEstatico> efectosEstaticos;
	protected ArrayList<EfectoTemporal> efectosTemporales;
	protected int valorOriginal;
	protected int valorActual
	
	public Atributo(int valor){
		efectosEstaticos = new ArrayList<EfectoEstatico>;
		efectosTemporales = new ArrayList<EfectoTemporal>;
		valorActual = valor;
	}
	
	public agregarEfectoFijo(EfectoEstatico efecto){
		efectosFijos.add(efecto);
	}
	
	public agregarEfectoTemporal(EfectoTemporal efecto){
		efectosTemporales.add(efecto);
	}	

	public int calcularValorActual(){
		int valorCalculado = valorActual;
		for (efectosEstaticos efecto : this.efectosEstaticos){
			valorCalculado += efecto.obtenerValorijo();
			valorCalculado += valorActual*efecto.obtenerValorMult(); 
		}
		for (efectosTemporales efecto : this.efectosTemporales){
			valorCalculado += efecto.obtenerValorijo();
			valorCalculado += valorActual*efecto.obtenerValorMult();
			efecto.restarTurno();
			if (efecto.tiempoTerminado){
				efectosTemporales.remove(efecto);
			}
		}
		return valorCalculado
		
	}
	
}

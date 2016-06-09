package fiuba.algo3.algoFormers.modelo.personajes.atributos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import fiuba.algo3.algoFormers.modelo.efecto.EfectoEstatico;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoTemporal;

public abstract class Atributo {
	
	protected ArrayList<EfectoEstatico> efectosEstaticos;
	protected HashMap<EfectoTemporal, Integer> efectosTemporales;
	protected int valorActual;
	protected int valorOriginal;
	private int valorCalculado;//Esto esta aca por el scope de lambda expression
	
	public Atributo(int valor){
		efectosEstaticos = new ArrayList<EfectoEstatico>();
		efectosTemporales = new HashMap<EfectoTemporal, Integer>();
		valorOriginal = valor;
		valorActual = valor;
	}
	
	public void agregarEfectoFijo(EfectoEstatico efecto){
		efectosEstaticos.remove(efecto);
		efectosEstaticos.add(efecto);
		this.valorActual = this.calcularValorActual(this.valorOriginal);
	}
	
	public void agregarEfectoTemporal(EfectoTemporal efecto){
		this.efectosTemporales.put(efecto, efecto.turnos());
		this.valorActual = this.calcularValorActual(this.valorActual);
	}	
	
	public int valorActual(){
		return this.valorActual;
	}
	
	public void actualizar(){
		this.valorActual = this.calcularValorActual(this.valorOriginal);
	}

	public int calcularValorActual(int valorBase){
		this.valorCalculado = valorBase;
		for (int i = 0; i < efectosEstaticos.size(); i++){
			EfectoEstatico efecto = efectosEstaticos.get(i); 
			this.valorCalculado += efecto.obtenerValorFijo();
			this.valorCalculado += (valorBase*efecto.obtenerValorMult())/100; 
		}
		Set<EfectoTemporal> efectos = this.efectosTemporales.keySet();
		Iterator<EfectoTemporal> iter = efectos.iterator();
		HashMap<EfectoTemporal, Integer> efectosActualizados = new HashMap<EfectoTemporal, Integer>();
		while (iter.hasNext()) {
		    EfectoTemporal efecto = iter.next();
		    this.valorCalculado += efecto.obtenerValorFijo();
			this.valorCalculado += (valorBase*efecto.obtenerValorMult())/100;
			int turnos = this.efectosTemporales.get(efecto);
			if (turnos - 1 == 0){
				this.efectosTemporales.remove(efecto);
			} else {efectosActualizados.put(efecto, turnos - 1);}		    
		}
		
		this.efectosTemporales = efectosActualizados;
		
		//Para la nebulosa de andromeda, el valor calculado va a ser negativo y por eso se restaura a cero
		if (valorCalculado < 0) valorCalculado = 0;
		
		return valorCalculado;
	}
	
	//Metodo para pruebas
	public void resetear(){
		this.valorActual = this.valorOriginal;
	}
	
}

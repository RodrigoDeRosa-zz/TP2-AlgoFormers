package fiuba.algo3.algoFormers.modelo.fabricas;

import fiuba.algo3.algoFormers.modelo.efecto.EfectoAtaque;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoEstatico;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoTemporal;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoVelocidad;
import fiuba.algo3.algoFormers.modelo.efecto.EfectoVida;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieAerea;
import fiuba.algo3.algoFormers.modelo.mapa.superficies.SuperficieTerrestre;

public class SuperficiesFactory {
	
		
	public SuperficieTerrestre getPantano(){
		EfectoVelocidad efectoV = new EfectoVelocidad();
		EfectoTemporal efectoPantano = new EfectoTemporal(DatosS.EFECTOPANTANO.getMultiplicador(),
				DatosS.EFECTOPANTANO.getBase(), efectoV, DatosS.EFECTOPANTANO.getTurnos());
		SuperficieTerrestre sup = new SuperficieTerrestre(efectoPantano);
		return sup;
	}
		
	public SuperficieTerrestre getRocas(){
		EfectoVida efectoV = new EfectoVida();
		EfectoTemporal efectoRocas = new EfectoTemporal(DatosS.EFECTOROCAS.getMultiplicador(),
				DatosS.EFECTOROCAS.getBase(), efectoV, DatosS.EFECTOROCAS.getTurnos());
		SuperficieTerrestre sup = new SuperficieTerrestre(efectoRocas);
		return sup;
	}
		
	public SuperficieTerrestre getEspina(){
		EfectoVida efectoV = new EfectoVida();
		EfectoTemporal efectoEspina = new EfectoTemporal(DatosS.EFECTOESPINA.getMultiplicador(),
				DatosS.EFECTOESPINA.getBase(), efectoV, DatosS.EFECTOESPINA.getTurnos());
		SuperficieTerrestre sup = new SuperficieTerrestre(efectoEspina);
		return sup;
	}
	
	public SuperficieAerea getNube(){
		EfectoVida efectoV = new EfectoVida();
		EfectoTemporal efectoNube = new EfectoTemporal(DatosS.EFECTONUBE.getMultiplicador(),
				DatosS.EFECTONUBE.getBase(), efectoV, DatosS.EFECTONUBE.getTurnos());
		SuperficieAerea sup = new SuperficieAerea(efectoNube);
		return sup;
	}
	
	public SuperficieAerea getTormentaPsionica(){
		EfectoAtaque efectoA = new EfectoAtaque();
		EfectoEstatico efectoTormenta = new EfectoEstatico(DatosS.EFECTOTORMENTAPSIONICA.getMultiplicador(),
				DatosS.EFECTOTORMENTAPSIONICA.getBase(), efectoA);
		SuperficieAerea sup = new SuperficieAerea(efectoTormenta);
		return sup;
	}
	
	public SuperficieAerea getNebulosaAndromeda(){
		EfectoVelocidad efectoV = new EfectoVelocidad();
		EfectoTemporal efectoNebulosa = new EfectoTemporal(DatosS.EFECTONEBULOSAANDROMEDA.getMultiplicador(),
				DatosS.EFECTONEBULOSAANDROMEDA.getBase(), efectoV,
				DatosS.EFECTONEBULOSAANDROMEDA.getTurnos());
		SuperficieAerea sup = new SuperficieAerea(efectoNebulosa);
		return sup;
	}	
}

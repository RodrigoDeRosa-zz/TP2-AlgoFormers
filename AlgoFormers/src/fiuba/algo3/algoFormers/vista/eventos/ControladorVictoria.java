package fiuba.algo3.algoFormers.vista.eventos;

import fiuba.algo3.algoFormers.modelo.jugadores.Jugador;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorAutobots;
import fiuba.algo3.algoFormers.modelo.jugadores.JugadorDecepticons;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControladorVictoria {

    @FXML
    private ImageView ImagenVictoria;
    
    private Jugador ganador;
    private static final String autobots = "file:src/fiuba/algo3/algoFormers/vista/imagenes/VictoriaAutoBots.png";
    private static final String decepticons = "file:src/fiuba/algo3/algoFormers/vista/imagenes/VictoriaDecepticons.png";
    
    private void setGanador(Jugador ganador){
    	this.ganador = ganador;
    }
    
    private void displayImagen(){
    	if (this.ganador.getClass() == JugadorAutobots.class){
    		ImagenVictoria.setImage(new Image(autobots));
    	}
    	if (this.ganador.getClass() == JugadorDecepticons.class){
    		ImagenVictoria.setImage(new Image(decepticons));
    	}
    }

    public void initData(Jugador ganador){
    	this.setGanador(ganador);
    	this.displayImagen();
    }
    
}

package fiuba.algo3.algoFormers.vista.contenedores;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import fiuba.algo3.algoFormers.modelo.juego.Juego;
import fiuba.algo3.algoFormers.vista.botones.direcciones.BotonDireccionAbajo;
import fiuba.algo3.algoFormers.vista.botones.direcciones.BotonDireccionAbajoDerecha;
import fiuba.algo3.algoFormers.vista.botones.direcciones.BotonDireccionAbajoIzquierda;
import fiuba.algo3.algoFormers.vista.botones.direcciones.BotonDireccionArriba;
import fiuba.algo3.algoFormers.vista.botones.direcciones.BotonDireccionArribaDerecha;
import fiuba.algo3.algoFormers.vista.botones.direcciones.BotonDireccionArribaIzquierda;
import fiuba.algo3.algoFormers.vista.botones.direcciones.BotonDireccionDerecha;
import fiuba.algo3.algoFormers.vista.botones.direcciones.BotonDireccionIzquierda;

public class ContenedorMoverEmergente extends VBox{
	
	private Juego juego;
	
	public ContenedorMoverEmergente(Juego juego){
		this.setJuego(juego);
		this.setBotonera();
		this.setFondo();
	}
	
	private void setJuego(Juego juego){
		this.juego = juego;
	}
	
	private void setBotonera(){
		Button arriba = new BotonDireccionArriba(this.juego);
		Button abajo = new BotonDireccionAbajo(this.juego);
		Button derecha = new BotonDireccionDerecha(this.juego);
		Button izquierda = new BotonDireccionIzquierda(this.juego);
		Button arribaDerecha = new BotonDireccionArribaDerecha(this.juego);
		Button arribaIzquierda = new BotonDireccionArribaIzquierda(this.juego);
		Button abajoDerecha = new BotonDireccionAbajoDerecha(this.juego);
		Button abajoIzquierda = new BotonDireccionAbajoIzquierda(this.juego);
		
		ContenedorBotonesMoverEmergente movimientos = new ContenedorBotonesMoverEmergente(arriba, abajo, derecha, izquierda, arribaDerecha, 
				arribaIzquierda, abajoDerecha, abajoIzquierda);
		
		ContenedorCancelar confCanc = new ContenedorCancelar();
		
		this.getChildren().addAll(movimientos, confCanc);		
	}
	
	private void setFondo(){
//	   	File file = new File("/home/rodrigo/git/PruebasJavaFX/Etc/FondoPanelBotones.png");
	   	Image imagenPanel = new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/FondoPanelBotones.png");
	   	BackgroundImage imagen = new BackgroundImage(imagenPanel,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagen));
	}

}

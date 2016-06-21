package fiuba.algo3.algoFormers.vista.contenedores;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ContenedorBotonesPrincipal extends GridPane{

	private Button mover;
	private Button atacar;
	private Button combinar;
	private Button transformar;
	private Button finalizarTurno;
	
	public ContenedorBotonesPrincipal(Button mover, Button atacar, Button transformar, Button combinar, Button finalizarTurno){
		this.setMover(mover);
		this.setAtacar(atacar);
		this.setTransformar(transformar);
		this.setCombinar(combinar);
		this.setFinalizarTurno(finalizarTurno);
		this.setImagenesLaterales();

		this.distribuirBotones();
		this.setAlignment(Pos.BASELINE_CENTER);
		this.setFondo();
	}
	
	private void setImagenesLaterales() {
//		File autoBot = new File("/home/rodrigo/git/PruebasJavaFX/Etc/AutoBot.png");
//		ImageView imagenAB = new ImageView(new Image(autoBot.toURI().toString()));
		ImageView imagenAB = new ImageView(new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/Autobot.png"));
		imagenAB.setFitHeight(50);
		imagenAB.setFitWidth(50);
		
//		File decepticon = new File("/home/rodrigo/git/PruebasJavaFX/Etc/Decepticon.png");
		ImageView imagenD = new ImageView(new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/Decepticon.png"));
		imagenD.setFitHeight(50);
		imagenD.setFitWidth(50);
		
		VBox contenedorImagenes = new VBox(imagenAB, imagenD);
		contenedorImagenes.setAlignment(Pos.CENTER);
		this.add(contenedorImagenes, 0, 0);
	}

	private void distribuirBotones(){
		this.add(this.mover, 1, 0);
		this.add(this.atacar, 2, 0);
		this.add(this.transformar, 3, 0);
		this.add(this.combinar, 4, 0);
		this.add(this.finalizarTurno, 5, 0);
	}
	
	private void setFondo(){
	   	Image imagenPanel = new Image("file:src/fiuba/algo3/algoFormers/vista/imagenes/FondoPanelBotones.png");
	   	BackgroundImage imagen = new BackgroundImage(imagenPanel,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagen));
	}
	
	private void setMover(Button mover){this.mover = mover;}
	private void setAtacar(Button atacar){this.atacar = atacar;}
	private void setCombinar(Button combinar){this.combinar = combinar;}
	private void setTransformar(Button transformar){this.transformar = transformar;}
	private void setFinalizarTurno(Button finalizarTurno){this.finalizarTurno = finalizarTurno;}
	
}

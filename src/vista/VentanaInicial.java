package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import juego.Juego;
import areaJuego.Mapa;


public class VentanaInicial extends BorderPane {

    MenuOpciones menu;
    VistaModelo vistaModelo;
    Canvas canvas;
    VBox box;

    public VentanaInicial(Stage stage, Juego modelo) {
        this.setMenu(stage);
        this.setCentro(modelo);
    }

    
    private void setMenu(Stage stage) {
        this.menu = new MenuOpciones(stage);
        this.setTop(menu);
    }
    
    private void setCentro(Juego modelo) {

        canvas = new Canvas(1000, 800);
        vistaModelo = new VistaModelo(modelo, canvas);
        vistaModelo.dibujar();

        box = new VBox(canvas);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(20);
        box.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        box.setBackground(new Background(imagenDeFondo));

        this.setCenter(box);
    }

        
    public MenuOpciones getMenuOpciones() {
        return menu;
    }

}

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
import areaJuego.Mapa;


public class VentanaInicial extends BorderPane {

    MenuOpciones menu;
    Terreno terreno;
    Canvas canvas;
    VBox box;

    public VentanaInicial(Stage stage, Mapa mapa) {
        this.setMenu(stage);
        
    }

    
    private void setMenu(Stage stage) {
        this.menu = new MenuOpciones(stage);
        this.setTop(menu);
    }

        
    public MenuOpciones getMenuOpciones() {
        return menu;
    }

}

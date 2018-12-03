package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import juego.Juego;
import vistaAcciones.BotonEntrarEventHandler;

public class SaludoInicial extends VBox {

    Stage stage;

    public SaludoInicial(Stage stage, Scene proximaEscena, Juego modelo) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vistaImagenes/principalEditado.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        Label labelJug1 = new Label("Jugador 1:");
        labelJug1.setTextFill(Color.web("#FF9922"));
        TextField campo1 = new TextField();
        HBox hb1 = new HBox();
        hb1.setAlignment(Pos.CENTER);
        hb1.getChildren().addAll(labelJug1, campo1);
        
        Label labelJug2 = new Label("Jugador 2:");
        TextField campo2 = new TextField();
        HBox hb2 = new HBox();
        hb2.setAlignment(Pos.CENTER);
        hb2.getChildren().addAll(labelJug2, campo2);
        
        VBox vb = new VBox();
        vb.getChildren().addAll(hb1, hb2);
        vb.setAlignment(Pos.CENTER);

        Button botonEntrar = new Button();
        botonEntrar.setText("Entrar");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        
        etiqueta.setText("Bienvenidos al videojuego AlgoEmpires II. Clickee en entrar.");
        etiqueta.setTextFill(Color.web("#66A7C5"));

        BotonEntrarEventHandler opcionEntrar = new BotonEntrarEventHandler(stage, proximaEscena, campo1, campo2, modelo);
        botonEntrar.setOnAction(opcionEntrar);

        this.getChildren().addAll(botonEntrar, vb);
    }

}
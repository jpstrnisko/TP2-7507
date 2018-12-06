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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import juego.Juego;
import vistaAcciones.OpcionInstruccionesEventHandler;
import vistaAcciones.BotonEntrarEventHandler;
import vistaAcciones.TeclaEntrarEventHandler;
import javafx.scene.input.*;

import java.io.File;

import javafx.event.EventHandler;

public class SaludoInicial extends VBox {

    Stage stage;

    public SaludoInicial(Stage stage, Scene proximaEscena, Juego modelo) {

        super();

        this.stage = stage;
        
        File f = new File("aplicacion/aoe2mainmusic.mp3");
        Media media = new Media(f.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        player.setVolume(0.2);
        player.setCycleCount(1);

        this.setAlignment(Pos.CENTER_RIGHT);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Image imagen = new Image("file:aplicacion/assets/fondo-algoempires.jpg");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        Label labelJug1 = new Label("Jugador 1:");
        labelJug1.setTextFill(Color.web("rgb(250,44,0)"));
        labelJug1.setFont(Font.font ("Castellar", FontWeight.EXTRA_BOLD, 18));
        TextField campo1 = new TextField();
        HBox hb1 = new HBox();
        hb1.setAlignment(Pos.CENTER_RIGHT);
        hb1.getChildren().addAll(labelJug1, campo1);
        
        Label labelJug2 = new Label("Jugador 2:");
        labelJug2.setTextFill(Color.web("rgb(250,44,0)"));
        labelJug2.setFont(Font.font ("Castellar", FontWeight.EXTRA_BOLD, 18));
        TextField campo2 = new TextField();
        HBox hb2 = new HBox();
        hb2.setAlignment(Pos.CENTER_RIGHT);
        hb2.getChildren().addAll(labelJug2, campo2);
        
        VBox vb = new VBox();
        vb.getChildren().addAll(hb1, hb2);
        vb.setAlignment(Pos.CENTER_RIGHT);

        Button botonEntrar = new Button();
        botonEntrar.setText("Entrar");


        BotonEntrarEventHandler opcionEntrar = new BotonEntrarEventHandler(stage, proximaEscena, campo1, campo2, modelo);
        botonEntrar.setOnAction(opcionEntrar);
        
        TeclaEntrarEventHandler teclaEntrar = new TeclaEntrarEventHandler(stage, proximaEscena,campo1, campo2, modelo);
        botonEntrar.setOnKeyPressed(teclaEntrar);
        
        
        
        
        this.getChildren().addAll(botonEntrar, vb);
    }

}
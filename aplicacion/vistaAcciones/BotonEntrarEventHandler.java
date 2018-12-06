package vistaAcciones;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import juego.Juego;
import turnos.Jugador;
import turnos.MaximoJugadoresError;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
    TextField campo1;
    TextField campo2;
    Juego modelo;

    public BotonEntrarEventHandler(Stage stage, Scene proximaEscena, TextField campo1, TextField campo2, Juego modelo) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.campo1 = campo1;
        this.campo2 = campo2;
        this.modelo = modelo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	String nombreJug1 = campo1.getText();
    	String nombreJug2 = campo2.getText();
    	
    	if(nombreJug1.trim().equals("") || nombreJug2.trim().equals("")) {
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Error");
            alert.setHeaderText("Jugador con Nombre Vacio");
            String mensaje = "Por favor ingrese un nombre para ambos jugadores.";
            alert.setContentText(mensaje);
            alert.show();
    	}else {
    		
    		modelo.obtenerJugadores().get(0).cambiarNombre(nombreJug1);
    		modelo.obtenerJugadores().get(1).cambiarNombre(nombreJug2);

            stage.setScene(proximaEscena);
            stage.setFullScreenExitHint("");
            //stage.setFullScreen(true);
            
    	}
    	
    	
    }
}

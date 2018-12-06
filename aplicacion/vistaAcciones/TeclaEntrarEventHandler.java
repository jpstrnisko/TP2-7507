package vistaAcciones;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import juego.Juego;
import javafx.scene.input.*;





public class TeclaEntrarEventHandler implements EventHandler<KeyEvent> {
	
	Stage stage;
    Scene proximaEscena;
    TextField campo1;
    TextField campo2;
    Juego modelo;
  
    public TeclaEntrarEventHandler(Stage stage, Scene proximaEscena, TextField campo1, TextField campo2, Juego modelo) {
    	this.stage = stage;
        this.proximaEscena = proximaEscena;
        this.campo1 = campo1;
        this.campo2 = campo2;
        this.modelo = modelo;
        
    }

    @Override
    public void handle(KeyEvent keyEvent) {
    	String nombreJug1 = campo1.getText();
    	String nombreJug2 = campo2.getText();
    	
    		    	
    	if(keyEvent.getCode() == KeyCode.ENTER)  {
    		
    		if (campo1.getText().isEmpty() || campo2.getText().isEmpty()) {
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
    	
    
}

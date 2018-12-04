package vista;

import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import vistaAcciones.OpcionAcercaDeEventHandler;
import vistaAcciones.OpcionPantallaCompletaEventHandler;
import vistaAcciones.OpcionSalirEventHandler;

public class MenuOpciones extends MenuBar {
	
	MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

      	public MenuOpciones (Stage stage) {

	        Menu menuArchivo = new Menu("Archivo");
	        Menu menuVer = new Menu("Ver");
	        Menu menuAyuda = new Menu("Ayuda");
	        
	        MenuItem opcionSalir = new MenuItem("Salir");
	        MenuItem opcionAbrir = new MenuItem("Abrir");
	        MenuItem opcionAcerca = new MenuItem("Acerca de...");
	        
	        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
	        opcionSalir.setOnAction(opcionSalirHandler);
	        
	        OpcionAcercaDeEventHandler opcionAcercaHandler = new OpcionAcercaDeEventHandler(stage);
	        opcionAcerca.setOnAction(opcionAcercaHandler);
	        
	        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage,opcionPantallaCompleta);
	        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
	        
	        opcionPantallaCompleta.setDisable(false);
	        
	        menuArchivo.getItems().addAll(opcionSalir);
	        menuAyuda.getItems().addAll(opcionAcerca);
	        menuVer.getItems().addAll(opcionPantallaCompleta);
	        
	        this.getMenus().addAll(menuArchivo,menuVer,menuAyuda);
       }
       
       public void aplicacionMaximizada() {
    	   opcionPantallaCompleta.setDisable(true);
       }
       
       
     

}

package vista;

import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import vistaAcciones.Salir;

public class MenuOpciones extends MenuBar {

       public MenuOpciones (Stage stage) {

        Menu menuArchivo = new Menu("Archivo");
        
        MenuItem salir = new MenuItem("Salir");
        
        Salir opcionSalir = new Salir();
        salir.setOnAction(opcionSalir);

        menuArchivo.getItems().addAll(salir);
        
        this.getMenus().addAll(menuArchivo);
    }

}

package vistaAcciones;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import vista.MenuOpciones;

public class ManejoAplicacion implements EventHandler<KeyEvent> {

    private Stage stage;
    private MenuOpciones menu;

    public ManejoAplicacion(Stage stage, MenuOpciones menu) {
        this.stage = stage;
        this.menu = menu;
    }

    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ESCAPE) {
            stage.setMaximized(false);
            menu.aplicacionMinimizada();
            
           
        }
    }
}

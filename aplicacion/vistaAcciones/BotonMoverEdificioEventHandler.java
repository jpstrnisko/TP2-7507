package vistaAcciones;


import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import vista.VistaModelo;
import areaJuego.Posicion;
import edificios.Edificio;


public class BotonMoverEdificioEventHandler implements EventHandler<ActionEvent> {

    VistaModelo vista;
    Posicion posicion;
    Edificio seleccionada;
    

    public BotonMoverEdificioEventHandler(VistaModelo vista, Edificio seleccionada, Posicion posicion) {
       this.posicion = posicion;
       this.seleccionada = seleccionada;
    }

    @Override
    public void handle(ActionEvent evento) {
         seleccionada.establecerPosicion(posicion);
         this.vista.update();
         
     }
        
    }
    
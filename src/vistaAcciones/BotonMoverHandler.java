package vistaAcciones;


import javafx.event.EventHandler;
import vista.VistaModelo;
import juego.Juego;
import areaJuego.Posicion;
import javafx.scene.input.*;


public class BotonMoverHandler implements EventHandler<MouseEvent> {

    private final VistaModelo vista;
    private final Juego modelo;
    private final Posicion posicion;
    

    public BotonMoverHandler(VistaModelo vista, Juego juego, Posicion posicion) {
       this.vista = vista;
       this.modelo = juego;
       this.posicion = posicion;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.modelo.moverUnidad(modelo.obtenerJugadores().get(0),posicion);
        this.vista.update();
    }
    
} 


package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import juego.Juego;
import turnos.Jugador;
import turnos.MaximoJugadoresError;
import areaJuego.Mapa;
import vista.VentanaInicial;
import vistaAcciones.ManejoAplicacion;


public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Algo Empires II");
        Mapa mapa = new Mapa(100,100);
        
        Juego modelo = this.crearModelo();

        VentanaInicial ventana = new VentanaInicial(stage, modelo);
        Scene escenaVentana = new Scene(ventana, 640, 480);

        ManejoAplicacion aplicacion = new ManejoAplicacion(stage, ventana.getMenuOpciones());
        escenaVentana.setOnKeyPressed(aplicacion);
        
        SaludoInicial saludo = new SaludoInicial(stage, escenaVentana);
        Scene escenaSaludo = new Scene(saludo, 640, 480);

        // add handler to this:
        // stage.setOnCloseRequest()

        stage.setScene(escenaSaludo);


        stage.setFullScreen(false);



        stage.show();

    }
    
    private Juego crearModelo() throws Exception {
    	Juego juego = Juego.obtenerInstancia();
    	juego.agregarJugador(new Jugador("1"));
    	juego.agregarJugador(new Jugador("2"));
    	juego.comenzarJuego();
    	return juego;
    	
    }

    
}

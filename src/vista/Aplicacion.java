package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import juego.Juego;
import turnos.Jugador;
import turnos.MaximoJugadoresError;
import java.io.File;
import areaJuego.Mapa;
import vista.VentanaInicial;
import vistaAcciones.ManejoAplicacion;
import javafx.scene.media.*;


public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Algo Empires II");
        Mapa mapa = new Mapa(100,100);
        
        Juego modelo = this.crearModelo();
        
        File f = new File("aplicacion/aoe2mainmusic.mp3");
        Media media = new Media(f.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        player.setVolume(0.8);
        player.setCycleCount(1);

        VentanaInicial ventana = new VentanaInicial(stage, modelo);
        Scene escenaVentana = new Scene(ventana, 1200, 800);

        ManejoAplicacion aplicacion = new ManejoAplicacion(stage, ventana.getMenuOpciones());
        escenaVentana.setOnKeyPressed(aplicacion);
        
        SaludoInicial saludo = new SaludoInicial(stage, escenaVentana, modelo);
        Scene escenaSaludo = new Scene(saludo, 1200, 800);


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

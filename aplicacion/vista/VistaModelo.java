package vista;

import java.util.List;

import edificios.Castillo;
import edificios.Cuartel;
import edificios.Edificio;
import edificios.Cuartel;
import edificios.PlazaCentral;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import juego.Juego;
import unidades.Aldeano;
import unidades.ArmaDeAsedio;
import unidades.Arquero;
import unidades.Espadachin;
import unidades.Unidad;

public class VistaModelo {
	private Juego modelo;
    Canvas canvas;
    int altoCelda;
    int anchoCelda;

    public VistaModelo(Juego modelo, Canvas canvas) {
        this.modelo = modelo;
        this.canvas = canvas;
        altoCelda = (int) canvas.getHeight()/(modelo.obtenerMapa().obtenerAlto());
    	anchoCelda = (int) canvas.getWidth()/(modelo.obtenerMapa().obtenerAncho());
    }

    public void dibujar() {
        this.dibujarTerreno();
        this.dibujarUnidades(modelo.obtenerUnidadesDelJugador(modelo.obtenerJugadores().get(0)), "Blue");
        this.dibujarUnidades(modelo.obtenerUnidadesDelJugador(modelo.obtenerJugadores().get(1)), "Red");
        this.dibujarEdificios(modelo.obtenerEdificiosDelJugador(modelo.obtenerJugadores().get(0)), "Blue");
        this.dibujarEdificios(modelo.obtenerEdificiosDelJugador(modelo.obtenerJugadores().get(1)), "Red");
    }

    private void dibujarEdificios(List<Edificio> edificios, String color) {
		Image imagen = null;
		for (Edificio edificio: edificios) {
			int tamanio = (int) Math.sqrt(edificio.obtenerTamanio());
			if(edificio instanceof Castillo)
				imagen = new Image("file:aplicacion/assets/PNG Format/castle" + color + ".png");
			if(edificio instanceof PlazaCentral)
				imagen = new Image("file:aplicacion/assets/PNG Format/towncenter" + color + ".png");
			if(edificio instanceof Cuartel)
				imagen = new Image("file:aplicacion/assets/PNG Format/barracks" + color + ".png");
			if(edificio.estaEnConstruccion())
				imagen = new Image("file:aplicacion/assets/PNG Format/rubble" + color + ".png");
			canvas.getGraphicsContext2D().drawImage(imagen, edificio.obtenerPosicionInicial().obtenerPosicionX()*anchoCelda, edificio.obtenerPosicionInicial().obtenerPosicionY()*altoCelda, anchoCelda*tamanio, altoCelda*tamanio);
		}
	}

	private void dibujarUnidades(List<Unidad> unidades, String color) {
    	Image imagen = null;
    	
    	for (Unidad unidad: unidades) {
    		if(unidad instanceof Aldeano)
    			imagen = new Image("file:aplicacion/assets/PNG Format/male" + color + ".png");
    		if(unidad instanceof Espadachin)
    			imagen = new Image("file:aplicacion/assets/PNG Format/champion" + color + ".png");
    		if(unidad instanceof Arquero)
    			imagen = new Image("file:aplicacion/assets/PNG Format/archer" + color + ".png");
    		if(unidad instanceof ArmaDeAsedio)
    			if (((ArmaDeAsedio)unidad).estaMontada()) {
    				imagen = new Image("file:aplicacion/assets/PNG Format/treb_open" + color + ".png");
    			}
    			else
    				imagen = new Image("file:aplicacion/assets/PNG Format/treb_pack" + color + ".png");
    		canvas.getGraphicsContext2D().drawImage(imagen, unidad.obtenerPosicion().obtenerPosicionX()*anchoCelda, unidad.obtenerPosicion().obtenerPosicionY()*altoCelda, anchoCelda, altoCelda);
    	}
	}

	private void dibujarUnidad(Unidad unidad) {
		Image imagen = new Image("file:aplicacion/assets/PNG Format/male1ed.png");
		canvas.getGraphicsContext2D().drawImage(imagen, unidad.obtenerPosicion().obtenerPosicionX()*anchoCelda, unidad.obtenerPosicion().obtenerPosicionY()*altoCelda, anchoCelda, altoCelda);
	}

	private void dibujarTerreno() {
		this.clean();
		/*canvas.getGraphicsContext2D().setFill(Color.GREEN);*/
	}

    public void clean() {
    	canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        /*canvas.getGraphicsContext2D().setFill(Color.GREEN);
        canvas.getGraphicsContext2D().fillRect(0, 0, 1000, 800);*/
    }

    public void update() {
        this.dibujar();
    }
}

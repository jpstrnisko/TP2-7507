package vista;

import java.util.List;

import edificios.Castillo;
import edificios.Edificio;
import edificios.PlazaCentral;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import juego.Juego;
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
        this.dibujarUnidades();
        this.dibujarEdificios(modelo.obtenerEdificiosDelJugador(modelo.obtenerJugadores().get(0)));
        this.dibujarEdificios(modelo.obtenerEdificiosDelJugador(modelo.obtenerJugadores().get(1)));
    }

    private void dibujarEdificios(List<Edificio> edificios) {
		Image imagen = null;
		for (Edificio edificio: edificios) {
			int tamanio = (int) Math.sqrt(edificio.obtenerTamanio());
			if(edificio instanceof Castillo)
				imagen = new Image("file:aplicacion/assets/PNG Format/castle.png");
			if(edificio instanceof PlazaCentral)
				imagen = new Image("file:aplicacion/assets/PNG Format/Towncenter.png");
			canvas.getGraphicsContext2D().drawImage(imagen, edificio.obtenerPosicionInicial().obtenerPosicionX()*anchoCelda, edificio.obtenerPosicionInicial().obtenerPosicionY()*altoCelda, anchoCelda*tamanio, altoCelda*tamanio);
		}
	}

	private void dibujarUnidades() {
    	List <Unidad> unidades = modelo.obtenerUnidades();
    	for (Unidad unidad: unidades) {
    		dibujarUnidad(unidad);
    	}
	}

	private void dibujarUnidad(Unidad unidad) {
		Image imagen = new Image("file:aplicacion/assets/PNG Format/male1ed.png");
		canvas.getGraphicsContext2D().drawImage(imagen, unidad.obtenerPosicion().obtenerPosicionX()*anchoCelda, unidad.obtenerPosicion().obtenerPosicionY()*altoCelda, anchoCelda, altoCelda);
	}

	private void dibujarTerreno() {
		this.clean();
		canvas.getGraphicsContext2D().setFill(Color.GREEN);
	}

    public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.GREEN);
        canvas.getGraphicsContext2D().fillRect(0, 0, 1000, 800);
    }

    public void update() {
        this.dibujar();
    }
}

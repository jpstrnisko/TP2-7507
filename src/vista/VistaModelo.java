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
    private int anchoCelda = 35;
    private int altoCelda = 35;

    public VistaModelo(Juego modelo, Canvas canvas) {
        this.modelo = modelo;
        this.canvas = canvas;
    }

    public void dibujar() {
        this.dibujarTerreno();
        this.dibujarUnidades();
        this.dibujarEdificios(modelo.obtenerEdificiosDelJugador(modelo.obtenerJugadores().get(0)));
        this.dibujarEdificios(modelo.obtenerEdificiosDelJugador(modelo.obtenerJugadores().get(1)));
    }

    private void dibujarEdificios(List<Edificio> edificios) {
		this.dibujarCastillos(edificios);
		this.dibujarPlazasCentrales(edificios);
	}

	private void dibujarPlazasCentrales(List<Edificio> edificios) {
		Image imagen = new Image("file:aplicacion/assets/PNG Format/Towncenter.png");
		for (Edificio edificio: edificios) {
			if(edificio instanceof PlazaCentral)
				canvas.getGraphicsContext2D().drawImage(imagen, edificio.obtenerPosicionInicial().obtenerPosicionX()*anchoCelda, edificio.obtenerPosicionInicial().obtenerPosicionY()*altoCelda, anchoCelda*2, altoCelda*2);
		}
	}

	private void dibujarCastillos(List<Edificio> edificios) {
		Image imagen = new Image("file:aplicacion/assets/PNG Format/castle.png");
		for (Edificio edificio: edificios) {
			if(edificio instanceof Castillo)
				canvas.getGraphicsContext2D().drawImage(imagen, edificio.obtenerPosicionInicial().obtenerPosicionX()*anchoCelda, edificio.obtenerPosicionInicial().obtenerPosicionY()*altoCelda, anchoCelda*4, altoCelda*4);
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
		canvas.getGraphicsContext2D().drawImage(imagen, unidad.obtenerPosicion().obtenerPosicionY()*anchoCelda, unidad.obtenerPosicion().obtenerPosicionX()*altoCelda, anchoCelda, altoCelda);
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

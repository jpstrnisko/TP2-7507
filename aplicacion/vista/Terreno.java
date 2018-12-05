package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import areaJuego.Mapa;

public class Terreno {

    private Mapa mapa;
    Canvas canvas;

    public Terreno (Mapa mapa, Canvas canvas) {
        this.mapa = mapa;
        this.canvas = canvas;
    }

    public void dibujar() {
        this.dibujarMapa();
    }

    private void dibujarMapa() {
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.LIGHTGREEN);
    }

    public void clean() {

        canvas.getGraphicsContext2D().setFill(Color.LIGHTGREEN);
        canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
    }

    public void update() {
        this.dibujar();
    }

}

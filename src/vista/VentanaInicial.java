package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import juego.Juego;
import vistaAcciones.BotonMoverHandler;
import javafx.scene.input.*;
import areaJuego.Posicion;
import javafx.event.EventHandler;



public class VentanaInicial extends BorderPane {

    MenuOpciones menu;
    VistaModelo vistaModelo;
    Juego juego;
    Canvas canvas;
    VBox box;

    public VentanaInicial(Stage stage, Juego modelo) {
        this.setMenu(stage);
        this.setCentro(modelo);
        this.setControles(modelo);
        
    }

    
    private void setMenu(Stage stage) {
        this.menu = new MenuOpciones(stage);
        this.setTop(menu);
    }
    
    private void setCentro(Juego modelo) {

        canvas = new Canvas(1000, 800);
        vistaModelo = new VistaModelo(modelo, canvas);
        vistaModelo.dibujar();

        box = new VBox(canvas);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(20);
        box.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        box.setBackground(new Background(imagenDeFondo));

        this.setCenter(box);
    }
    
    private void setControles(Juego modelo) {
    	
    	TextField field = new TextField("Ejemplo");
    	Text txtNode = new Text("Ejemplo");
    	txtNode.setFont(Font.font(45));
    	txtNode.setX(80);
    	txtNode.setY(80);
    	
    	ContextMenu context = new ContextMenu();
    	
    	MenuItem mover = new MenuItem("Mover");
    	MenuItem construir = new MenuItem("Construir");
    	MenuItem recolectar = new MenuItem("Recolectar");
    	MenuItem reparar = new MenuItem("Reparar");
    	
    	
    	context.getItems().addAll(mover,construir,recolectar,reparar);
    	
    	field.setContextMenu(context);
    	
        txtNode.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        	
        	public void handle(MouseEvent t) {
        		if (t.getButton() == MouseButton.SECONDARY)
        			context.show(txtNode, t.getScreenX(), t.getScreenY());
        		
        	}
        });
        
        VBox contenedorVertical = new VBox(txtNode);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);
        
    }

        
    public MenuOpciones getMenuOpciones() {
        return menu;
    }

}
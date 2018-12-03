package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import edificios.Castillo;
import edificios.Cuartel;
import edificios.PlazaCentral;
import interfaces.Atacable;
import javafx.event.EventHandler;



public class VentanaInicial extends BorderPane {

    MenuOpciones menu;
    VistaModelo vistaModelo;
    Juego juego;
    Canvas canvas;
    VBox box;
    Atacable seleccionado = null;

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

        canvas = new Canvas(900, 690);
        vistaModelo = new VistaModelo(modelo, canvas);
        vistaModelo.dibujar();
        int altoCelda = (int) canvas.getHeight()/(modelo.obtenerMapa().obtenerAlto());
    	int anchoCelda = (int) canvas.getWidth()/(modelo.obtenerMapa().obtenerAncho());
    	
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent click) {
        		this.clickEn(click.getX(), click.getY());
        	}

			private void clickEn(double x, double y) {
				Posicion posicionSeleccionada = new Posicion((int) x/anchoCelda, (int) y/altoCelda);
				seleccionado = modelo.obtenerMapa().obtenerAtacableEn(posicionSeleccionada);
				if(seleccionado == null)
					return;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle(seleccionado.toString());
				setControles(modelo);

				alert.showAndWait();
			}
        });
        
        box = new VBox(canvas);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(20);
        box.setPadding(new Insets(25));
        box.setMinHeight(canvas.getHeight());
        box.setMinWidth(canvas.getWidth());
        box.setMaxHeight(canvas.getHeight());
        box.setMaxWidth(canvas.getWidth());
        /*Image imagen = new Image("file:src/vista/imagenes/fondo-verde.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        box.setBackground(new Background(imagenDeFondo));*/
        this.setCenter(box);
    }
    
    private void setControles(Juego modelo) {
    	if (seleccionado == null) {
    		return;
    	}
    	
    	if (seleccionado instanceof PlazaCentral)
    		setControlesPlazaCentral(modelo);
    	
    	if (seleccionado instanceof Cuartel)
    		setControlesPlazaCentral(modelo);
    	
    	if (seleccionado instanceof Castillo)
    		setControlesPlazaCentral(modelo);
    	
    	
    		
    	/*TextField field = new TextField("Ejemplo");
    	Text txtNode = new Text("Ejemplo");
    	txtNode.setFont(Font.font(15));
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
        contenedorVertical.setMaxWidth(200);

        this.setLeft(contenedorVertical);*/
        
    }

        
    private void setControlesPlazaCentral(Juego modelo) {
    	Label nombre = new Label("Plaza Central");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/Towncenter.png"));
    	imagen.setFitHeight(100);
    	imagen.setFitWidth(100);
    	VBox contenedorVertical = new VBox(nombre, imagen);
    	contenedorVertical.setMaxWidth(200);
    	
    	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
    		Button crearAldeano = new Button("Crear Aldeano");
    		contenedorVertical.getChildren().addAll(crearAldeano);
    	}
        
        

        this.setLeft(contenedorVertical);
	}

	public MenuOpciones getMenuOpciones() {
        return menu;
    }

}
package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import juego.Juego;
import unidades.Aldeano;
import javafx.scene.input.*;
import areaJuego.Posicion;
import edificios.Castillo;
import edificios.Cuartel;
import edificios.PlazaCentral;
import interfaces.Atacable;
import javafx.event.EventHandler;
import vistaAcciones.*;



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
				setControles(modelo);
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
    	
    	VBox contenedorVertical = new VBox();
    	contenedorVertical.setMaxWidth(200);
    	Button botonAvanzarTurno = new Button("Avanzar turno");
    	
    	contenedorVertical.getChildren().addAll(botonAvanzarTurno);
    	contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
    	
    	BotonAvanzarTurnoHandler avanzar = new BotonAvanzarTurnoHandler(vistaModelo, modelo);
    	botonAvanzarTurno.setOnAction(avanzar);
    	
    	   	
    	    	
    	if (seleccionado instanceof PlazaCentral)
    		setControlesPlazaCentral(modelo, contenedorVertical);
    	
    	if (seleccionado instanceof Castillo)
    		setControlesCastillo(modelo, contenedorVertical);
    	
    	if (seleccionado instanceof Cuartel)
    		setControlesCuartel(modelo, contenedorVertical);
    	
    	if (seleccionado instanceof Aldeano)
    		setControlesAldeano(modelo, contenedorVertical);
    	
    	this.setLeft(contenedorVertical);
        
    }

        
    private void setControlesAldeano(Juego modelo, VBox contenedorVertical) {
    	Label jugador = new Label("Jugador");
    	Label nombreJugador = new Label(modelo.obtenerJugadorActual().obtenerNombre().toString().toUpperCase());
    	Label nombre = new Label("Aldeano");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/male1.png"));
    	imagen.setFitHeight(100);
    	imagen.setFitWidth(100);
    	contenedorVertical.getChildren().addAll(jugador,nombreJugador, nombre, imagen);
    	
    	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
    		
    		Button botonConstruir = new Button("Construir");
    		
    		ContextMenu menuConstruir = new ContextMenu();
    		
    		ImageView imagenPlaza = new ImageView();
        	imagenPlaza.setImage(new Image("file:aplicacion/assets/PNG Format/Towncenter.png"));
        	imagenPlaza.setFitHeight(20);
        	imagenPlaza.setFitWidth(20);
        	
    		MenuItem plazaCentral = new MenuItem("Plaza Central");
    		plazaCentral.setGraphic(imagenPlaza);
    		
    		ImageView imagenCuartel = new ImageView();
        	imagenCuartel.setImage(new Image("file:aplicacion/assets/PNG Format/barracks.png"));
        	imagenCuartel.setFitHeight(20);
        	imagenCuartel.setFitWidth(20);
        	        	
    		MenuItem cuartel = new MenuItem("Cuartel");
    		cuartel.setGraphic(imagenCuartel);
    		    		    		
    		menuConstruir.getItems().addAll(plazaCentral,cuartel);
    		
    		botonConstruir.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            	@Override
            	public void handle(MouseEvent click) {
            		if (click.getButton() == MouseButton.SECONDARY) {
            			menuConstruir.show(botonConstruir,click.getScreenX(), click.getScreenY());
            		}
            	}
    		});	
    		
    		Button botonReparar = new Button("Reparar");
    		
    		contenedorVertical.getChildren().addAll(botonConstruir, botonReparar);
    	}
        
        this.setLeft(contenedorVertical);
	}

	private void setControlesPlazaCentral(Juego modelo, VBox contenedorVertical) {
		Label jugador = new Label("Jugador");
    	Label nombreJugador = new Label(modelo.obtenerJugadorActual().obtenerNombre().toString().toUpperCase());
    	Label nombre = new Label("Plaza Central");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/Towncenter.png"));
    	imagen.setFitHeight(100);
    	imagen.setFitWidth(100);
    	contenedorVertical.getChildren().addAll(jugador,nombreJugador,nombre, imagen);
    	
    	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
    		Button botonCrearAldeano = new Button("Crear Aldeano");
    		BotonCrearAldeanoHandler crearAldeano = new BotonCrearAldeanoHandler(modelo, (PlazaCentral) seleccionado);
    		botonCrearAldeano.setOnAction(crearAldeano);
    		contenedorVertical.getChildren().addAll(botonCrearAldeano);
    	}
        
        this.setLeft(contenedorVertical);
	}
    
    private void setControlesCastillo(Juego modelo, VBox contenedorVertical) {
    	Label jugador = new Label("Jugador");
    	Label nombreJugador = new Label(modelo.obtenerJugadorActual().obtenerNombre().toString().toUpperCase());
    	Label nombre = new Label("Castillo");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/castle.png"));
    	imagen.setFitHeight(100);
    	imagen.setFitWidth(100);
    	contenedorVertical.getChildren().addAll(jugador,nombreJugador,nombre, imagen);
    	
    	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
    		Button botonCrearArmaDeAsedio = new Button("Crear Arma de Asedio");
    		BotonCrearArmaDeAsedioHandler crearArma = new BotonCrearArmaDeAsedioHandler(modelo, (Castillo) seleccionado);
    		botonCrearArmaDeAsedio.setOnAction(crearArma);
    		contenedorVertical.getChildren().addAll(botonCrearArmaDeAsedio);
    	}
        
        this.setLeft(contenedorVertical);
	}
    
    private void setControlesCuartel(Juego modelo, VBox contenedorVertical) {
    	Label jugador = new Label("Jugador");
    	Label nombreJugador = new Label(modelo.obtenerJugadorActual().obtenerNombre().toString().toUpperCase());
    	Label nombre = new Label("Cuartel");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/barracks.png"));
    	imagen.setFitHeight(100);
    	imagen.setFitWidth(100);
    	
    	contenedorVertical.getChildren().addAll(jugador,nombreJugador,nombre, imagen);
    	
    	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
    		
    		Button botonCrearArquero = new Button("Crear Arquero");
    		BotonCrearArqueroHandler crearArquero = new BotonCrearArqueroHandler(modelo, (Cuartel) seleccionado);
    		botonCrearArquero.setOnAction(crearArquero);
    		
    		Button botonCrearEspadachin = new Button("Crear Espadachin");
    		BotonCrearEspadachinHandler crearEspadachin = new BotonCrearEspadachinHandler(modelo, (Cuartel) seleccionado);
    		botonCrearEspadachin.setOnAction(crearEspadachin);
    		
    		contenedorVertical.getChildren().addAll(botonCrearArquero,botonCrearEspadachin);
    	}
        
        this.setLeft(contenedorVertical);
	}

	public MenuOpciones getMenuOpciones() {
        return menu;
    }

}
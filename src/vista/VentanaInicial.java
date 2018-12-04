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
import unidades.Aldeano;
import vistaAcciones.BotonEntrarEventHandler;
import vistaAcciones.BotonMoverHandler;
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
    	Button botonCrearCuartel = new Button("Crear Cuartel");
    	contenedorVertical.getChildren().addAll(botonAvanzarTurno,botonCrearCuartel);
    	contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
    	
    	BotonAvanzarTurnoHandler avanzar = new BotonAvanzarTurnoHandler(vistaModelo, modelo);
    	botonAvanzarTurno.setOnAction(avanzar);
    	
    	Posicion posicion = (new Posicion(20,20));
    	
    	BotonCrearCuartelHandler nuevoCuartel = new BotonCrearCuartelHandler(vistaModelo, modelo, posicion);
    	botonCrearCuartel.setOnAction(nuevoCuartel);
    	
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
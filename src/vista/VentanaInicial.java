package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import juego.Juego;
import unidades.Aldeano;
import unidades.Espadachin;
import vistaAcciones.BotonEntrarEventHandler;
import vistaAcciones.BotonMoverHandler;
import javafx.scene.input.*;
import areaJuego.Posicion;
import edificios.Castillo;
import edificios.Cuartel;
import edificios.Edificio;
import edificios.PlazaCentral;
import interfaces.Atacable;
import javafx.event.EventHandler;
import vistaAcciones.*;
import turnos.Jugador;



public class VentanaInicial extends BorderPane {

    MenuOpciones menu;
    VistaModelo vistaModelo;
    Juego juego;
    Canvas canvas;
    VBox box;
    public Posicion posicionPrimaria = null;
    public Atacable seleccionado = null;
    public Posicion posicionSecundaria = null;
    public Atacable seleccionadoSecundario = null;
    Edificio edificioConstruir = null;

    public VentanaInicial(Stage stage, Juego modelo) throws Exception {
        this.setMenu(stage);
        this.setCentro(modelo);
        this.setControles(modelo);
    }

    private void setMenu(Stage stage) {
        this.menu = new MenuOpciones(stage);
        this.setTop(menu);
    }

    public void setCentro(Juego modelo) {

        canvas = new Canvas(900, 690);
        vistaModelo = new VistaModelo(modelo, canvas);
        vistaModelo.dibujar();
        int altoCelda = (int) canvas.getHeight()/(modelo.obtenerMapa().obtenerAlto());
    	int anchoCelda = (int) canvas.getWidth()/(modelo.obtenerMapa().obtenerAncho());

        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent click) {
        		if(click.getButton().equals(MouseButton.PRIMARY))
					try {
						this.clickIzquierdoEn(click.getX(), click.getY());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		if(click.getButton().equals(MouseButton.SECONDARY))
					try {
						this.clickDerechoEn(click.getX(), click.getY());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        	}

			private void clickIzquierdoEn(double x, double y) throws Exception {
				posicionPrimaria = new Posicion((int) x/anchoCelda, (int) y/altoCelda);
				if(edificioConstruir != null) {
					this.controlConstruccionEdificio();
					edificioConstruir = null;
				}
				seleccionado = modelo.obtenerMapa().obtenerAtacableEn(posicionPrimaria);
				posicionSecundaria = null;
				seleccionadoSecundario = null;
				setControles(modelo);
			}

			private void controlConstruccionEdificio() {
				if(edificioConstruir instanceof Cuartel)
					((Aldeano) seleccionado).construirCuartel(posicionPrimaria);
			}

			private void clickDerechoEn(double x, double y) throws Exception {
				posicionSecundaria = new Posicion((int) x/anchoCelda, (int) y/altoCelda);
				seleccionadoSecundario = modelo.obtenerMapa().obtenerAtacableEn(posicionSecundaria);
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

    public void setControles(Juego modelo) throws Exception {
    	
    	VBox contenedorHorizontal = new VBox();
    	contenedorHorizontal.setMaxSize(200, 400);
    	contenedorHorizontal.setSpacing(5);
    	contenedorHorizontal.setPadding(new Insets(40));
        
            	
    	Label jugador = new Label("Jugador:");
    	jugador.setTextFill(Color.BLUE);
    	jugador.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 12));
    	Label nombreJugador = new Label(modelo.obtenerJugadorActual().obtenerNombre().toString().toUpperCase());
    	Label oro = new Label("Oro:");
    	oro.setTextFill(Color.BLUE);
    	oro.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 12));
    	int cantOro = modelo.obtenerJugadorActual().obtenerOro();
    	Label oroDisponible = new Label(String.valueOf(cantOro));
    	Label unidades = new Label("Unidades:");
    	unidades.setTextFill(Color.BLUE);
    	unidades.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 12));
    	    	
    	contenedorHorizontal.getChildren().addAll(jugador,nombreJugador,oro,oroDisponible);
    	
    	VBox contenedorVertical = new VBox();
    	contenedorVertical.setMaxWidth(200);
    	Button botonAvanzarTurno = new Button("Avanzar turno");
    	
    	contenedorVertical.getChildren().addAll(botonAvanzarTurno);
    	contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(30));
                
    	BotonAvanzarTurnoHandler avanzar = new BotonAvanzarTurnoHandler(vistaModelo, this, modelo);
    	botonAvanzarTurno.setOnAction(avanzar);

    	if (seleccionado instanceof PlazaCentral)
    		setControlesPlazaCentral(modelo, contenedorVertical);

    	if (seleccionado instanceof Castillo)
    		setControlesCastillo(modelo, contenedorVertical);

    	if (seleccionado instanceof Cuartel)
    		setControlesCuartel(modelo, contenedorVertical);

    	if (seleccionado instanceof Aldeano)
    		setControlesAldeano(modelo, contenedorVertical);

    	if (seleccionado instanceof Espadachin)
    		setControlesEspadachin(modelo, contenedorVertical);

    	this.setLeft(contenedorVertical);
    	this.setRight(contenedorHorizontal);

    }

    /*private void setControlesCuartel(Juego modelo, VBox contenedorVertical) {
    	Label nombre = new Label("Cuartel");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/barracks.png"));
    	imagen.setFitHeight(100);
    	imagen.setFitWidth(100);
    	HBox vida = dibujarVida();
    	contenedorVertical.getChildren().addAll(nombre, vida, imagen);

    	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
    		Button botonCrearEspadachin = new Button("Crear Espadachin");
    		BotonCrearEspadachinHandler crearEspadachin = new BotonCrearEspadachinHandler(modelo, (Cuartel) seleccionado);
    		botonCrearEspadachin.setOnAction(crearEspadachin);
    		contenedorVertical.getChildren().addAll(botonCrearEspadachin);
    	}

        this.setLeft(contenedorVertical);
    }*/

    private void setControlesEspadachin(Juego modelo, VBox contenedorVertical) throws Exception {
    	Label nombre = new Label("Espadachin");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/twohanded1.png"));
    	imagen.setFitHeight(90);
    	imagen.setFitWidth(90);
    	HBox vida = dibujarVida();
    	contenedorVertical.getChildren().addAll(nombre, vida, imagen);

    	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
    		if (seleccionadoSecundario != null) {
    			((Espadachin)seleccionado).seleccionarObjetivo(seleccionadoSecundario);
    		}
    		else if (posicionSecundaria != null) {
        		((Espadachin)seleccionado).mover(posicionSecundaria);
        		this.vistaModelo.dibujar();
        	}
    	}

        this.setLeft(contenedorVertical);
	}

	private HBox dibujarVida() {
		int vida = seleccionado.obtenerVida();
		int vidaMaxima = seleccionado.obtenerVidaMaxima();
		double porcentajeVida = (double)vida / (double)vidaMaxima;
		Canvas canvas = new Canvas(80, 10);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.RED);
		gc.fillRect(80 * porcentajeVida, 0, 80 * (1 - porcentajeVida), 10);
		gc.setFill(Color.GREEN);
		gc.fillRect(0, 0, 80 * porcentajeVida, 10);
		Label lVida = new Label(String.valueOf(vida) + "/");
		Label lVidaMax = new Label(String.valueOf(vidaMaxima));
		HBox box = new HBox(canvas, lVida, lVidaMax);
		box.setAlignment(Pos.CENTER);
		return box;
	}


    private void setControlesAldeano(Juego modelo, VBox contenedorVertical) throws Exception{
    	   	
    	Label nombre = new Label("Aldeano");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/male1.png"));
    	imagen.setFitHeight(90);
    	imagen.setFitWidth(90);
    	HBox vida = dibujarVida();
    	contenedorVertical.getChildren().addAll(nombre, vida, imagen);

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

    		if (posicionSecundaria != null) {
        		((Aldeano)seleccionado).mover(posicionSecundaria);
        		this.vistaModelo.dibujar();
        	}
    		/*
    		Button botonConstruirCuartel = new Button("Construir cuartel");
    		BotonConstruirCuartelHandler construirCuartel = new BotonConstruirCuartelHandler(this, modelo, (Aldeano)seleccionado);
    		botonConstruirCuartel.setOnAction(construirCuartel);
    		*/
    		
    	}

        this.setLeft(contenedorVertical);
	}


	private void setControlesPlazaCentral(Juego modelo, VBox contenedorVertical) {
		
    	Label nombre = new Label("Plaza Central");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/Towncenter.png"));
    	imagen.setFitHeight(90);
    	imagen.setFitWidth(90);
    	HBox vida = dibujarVida();
    	contenedorVertical.getChildren().addAll(nombre, vida, imagen);

    	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
    		Button botonCrearAldeano = new Button("Crear Aldeano");
    		BotonCrearAldeanoHandler crearAldeano = new BotonCrearAldeanoHandler(modelo, (PlazaCentral) seleccionado);
    		botonCrearAldeano.setOnAction(crearAldeano);
    		contenedorVertical.getChildren().addAll(botonCrearAldeano);
    	}

        this.setLeft(contenedorVertical);
	}

    private void setControlesCastillo(Juego modelo, VBox contenedorVertical) {
    	
    	Label nombre = new Label("Castillo");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/castle.png"));
    	imagen.setFitHeight(100);
    	imagen.setFitWidth(100);
    	HBox vida = dibujarVida();
    	contenedorVertical.getChildren().addAll(nombre, vida, imagen);

    	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
    		Button botonCrearArmaDeAsedio = new Button("Crear Arma de Asedio");
    		BotonCrearArmaDeAsedioHandler crearArma = new BotonCrearArmaDeAsedioHandler(modelo, (Castillo) seleccionado);
    		botonCrearArmaDeAsedio.setOnAction(crearArma);
    		contenedorVertical.getChildren().addAll(botonCrearArmaDeAsedio);
    	}

        this.setLeft(contenedorVertical);
	}

    private void setControlesCuartel(Juego modelo, VBox contenedorVertical) {
    	
    	Label nombre = new Label("Cuartel");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/barracks.png"));
    	imagen.setFitHeight(100);
    	imagen.setFitWidth(100);
    	HBox vida = dibujarVida();
    	contenedorVertical.getChildren().addAll(nombre, vida, imagen);

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

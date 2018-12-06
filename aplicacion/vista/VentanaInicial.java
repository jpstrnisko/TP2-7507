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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import juego.Juego;
import unidades.Aldeano;
import unidades.ArmaDeAsedio;
import unidades.Arquero;
import unidades.Espadachin;
import javafx.scene.input.*;
import edificios.*;
import java.io.Console;
import java.io.File;
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

	private MenuOpciones menu;
    private VistaModelo vistaModelo;
    private Juego juego;
    private Canvas canvas;
    private VBox box;
    public Posicion posicionPrimaria = null;
    public Atacable seleccionado = null;
    public Posicion posicionSecundaria = null;
    public Atacable seleccionadoSecundario = null;
    private Edificio edificioConstruir = null;

    public VentanaInicial(Stage stage, Juego modelo) throws Exception {
        this.setMenu(stage);
        this.setCentro(modelo);
        this.setControles(modelo);
    }

    private void chequearGanador(Juego modelo) {
		if(modelo.finalizo()) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText(null);
			alert.setContentText("Ha ganado el jugador " + modelo.obtenerGanador().obtenerNombre());

			alert.showAndWait();
		}
	}

	private void setMenu(Stage stage) {
        this.menu = new MenuOpciones(stage);
        this.setTop(menu);
    }

    public void setCentro(Juego modelo) {

        canvas = new Canvas(910, 700);
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
				if(getEdificioConstruir() != null) {
					this.controlConstruccionEdificio();
					setEdificioConstruir(null);
				}
				seleccionado = modelo.obtenerMapa().obtenerAtacableEn(posicionPrimaria);
				posicionSecundaria = null;
				seleccionadoSecundario = null;
				setControles(modelo);
			}

			private void controlConstruccionEdificio() {
				if(getEdificioConstruir() instanceof Cuartel) {
					((Aldeano) seleccionado).construirCuartel(posicionPrimaria);
					vistaModelo.dibujar();
				}
					
				if(getEdificioConstruir() instanceof PlazaCentral) {
					((Aldeano) seleccionado).construirPlazaCentral(posicionPrimaria);
					vistaModelo.dibujar();
				}
			}

			private void clickDerechoEn(double x, double y) throws Exception {
				posicionSecundaria = new Posicion((int) x/anchoCelda, (int) y/altoCelda);
				seleccionadoSecundario = modelo.obtenerMapa().obtenerAtacableEn(posicionSecundaria);
				setControles(modelo);
			}
        });

        box = new VBox(canvas);
        Image tile = new Image("file:aplicacion/assets/PNG Format/tile.png", altoCelda, anchoCelda, false, false);
        BackgroundImage bkI = new BackgroundImage(tile, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background bk = new Background(bkI);
        box.setBackground(bk);
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
    	
    	this.chequearGanador(modelo);
    	
    	VBox contenedorHorizontal = new VBox();
    	contenedorHorizontal.setMaxSize(200, 400);
    	contenedorHorizontal.setSpacing(5);
    	contenedorHorizontal.setPadding(new Insets(40));
        
            	
    	Label jugador = new Label("Jugador:");
    	jugador.setTextFill(Color.BLUE);
    	jugador.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 10));
    	Label nombreJugador = new Label(modelo.obtenerJugadorActual().obtenerNombre().toString().toUpperCase());
    	
    	Label oro = new Label("Oro:");
       	oro.setTextFill(Color.BLUE);
    	oro.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 10));
    	ImageView imagenOro = new ImageView();
    	imagenOro.setImage(new Image("file:aplicacion/assets/PNG Format/oro.png"));
    	imagenOro.setFitHeight(25);
    	imagenOro.setFitWidth(25);
    	oro.setGraphic(imagenOro);
    	int cantOro = modelo.obtenerJugadorActual().obtenerOro();
    	Label oroDisponible = new Label(String.valueOf(cantOro));
    	
    	Label nivelPoblacion = new Label("Poblacion:");
    	nivelPoblacion.setTextFill(Color.BLUE);
    	nivelPoblacion.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 10));
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/poblacion2.png"));
    	imagen.setFitHeight(25);
    	imagen.setFitWidth(25);
    	nivelPoblacion.setGraphic(imagen);
    	int cantPoblacion = modelo.obtenerPoblacion(modelo.obtenerJugadorActual());
    	Label poblacion = new Label(String.valueOf(cantPoblacion));
    	    	
    	contenedorHorizontal.getChildren().addAll(jugador,nombreJugador,oro,oroDisponible,nivelPoblacion,poblacion);
    	
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
    	
    	if (seleccionado instanceof Arquero)
    		setControlesArquero(modelo, contenedorVertical);
    	
    	if (seleccionado instanceof ArmaDeAsedio)
    		setControlesArmaDeAsedio(modelo, contenedorVertical);
    	
    	

    	this.setLeft(contenedorVertical);
    	this.setRight(contenedorHorizontal);

    }

    private void setControlesArmaDeAsedio(Juego modelo, VBox contenedorVertical) throws Exception {
    	Label nombre = new Label("Arma de asedio");
    	Label costo = new Label("Costo:");
    	int costoArma = ((ArmaDeAsedio)seleccionado).obtenerCosto();
    	Label costoOro = new Label(String.valueOf(costoArma));
    	Label nombreJugador = new Label(((Jugador) seleccionado.obtenerJugador()).obtenerNombre().toString().toUpperCase());
    	ImageView imagen = new ImageView();
    	if (((ArmaDeAsedio)seleccionado).estaMontada())
    		imagen.setImage(new Image("file:aplicacion/assets/PNG Format/treb_open1.png"));
    	else
    		imagen.setImage(new Image("file:aplicacion/assets/PNG Format/treb_pack1.png"));
    	imagen.setFitHeight(90);
    	imagen.setFitWidth(90);
    	Label estado = new Label("Estado:");
    	String estadoArma;
    	if (((ArmaDeAsedio)seleccionado).estaMontada()) {
    		estadoArma = "Montada";
    	} else estadoArma = "Desmontada";
    	Label estadoActual = new Label(estadoArma.toString());
    	estadoActual.setTextFill(Color.BLUE);
    	HBox vida = dibujarVida();
    	contenedorVertical.getChildren().addAll(nombre, nombreJugador, vida, costo, costoOro,estado, estadoActual, imagen);
    	
    	if(seleccionado.obtenerJugador() == modelo.obtenerJugadorActual()) {
    		Button botonMontar = new Button("Montar");
        	Button botonDesmontar = new Button("Desmontar");
        	
        	BotonMontarArmaDeAsedioEventHandler montar = new BotonMontarArmaDeAsedioEventHandler(modelo, (ArmaDeAsedio) seleccionado);
        	botonMontar.setOnAction(montar);
        	
        	BotonDesmontarArmaDeAsedioEventHandler desmontar = new BotonDesmontarArmaDeAsedioEventHandler(modelo, (ArmaDeAsedio) seleccionado);
        	botonDesmontar.setOnAction(desmontar);
        	
        	  	
        	contenedorVertical.getChildren().addAll(botonMontar, botonDesmontar);
        	
        	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
        		if (seleccionadoSecundario != null) {
        			((ArmaDeAsedio)seleccionado).seleccionarObjetivo(seleccionadoSecundario);
        		}
        		else if (posicionSecundaria != null) {
            		((ArmaDeAsedio)seleccionado).mover(posicionSecundaria);
            		this.vistaModelo.dibujar();
            	}
        	}

            this.setLeft(contenedorVertical);
    	}
    	
	}

	private void setControlesArquero(Juego modelo, VBox contenedorVertical) throws Exception {
    	Label nombre = new Label("Arquero");
    	Label nombreJugador = new Label(((Jugador) seleccionado.obtenerJugador()).obtenerNombre().toString().toUpperCase());
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/archer1.png"));
    	imagen.setFitHeight(90);
    	imagen.setFitWidth(90);
    	Label costo = new Label("Costo:");
    	int costoArquero = ((Arquero)seleccionado).obtenerCosto();
    	Label costoOro = new Label(String.valueOf(costoArquero));
    	HBox vida = dibujarVida();
    	contenedorVertical.getChildren().addAll(nombre, nombreJugador, vida, costo, costoOro, imagen);

    	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
    		if (seleccionadoSecundario != null) {
    			((Arquero)seleccionado).seleccionarObjetivo(seleccionadoSecundario);
    		}
    		else if (posicionSecundaria != null) {
        		((Arquero)seleccionado).mover(posicionSecundaria);
        		this.vistaModelo.dibujar();
        	}
    	}

        this.setLeft(contenedorVertical);
	}

	private void setControlesEspadachin(Juego modelo, VBox contenedorVertical) throws Exception {
    	Label nombre = new Label("Espadachin");
    	Label nombreJugador = new Label(((Jugador) seleccionado.obtenerJugador()).obtenerNombre().toString().toUpperCase());
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/twohanded1.png"));
    	imagen.setFitHeight(90);
    	imagen.setFitWidth(90);
    	Label costo = new Label("Costo:");
    	int costoEspadachin = ((Espadachin)seleccionado).obtenerCosto();
    	Label costoOro = new Label(String.valueOf(costoEspadachin));
    	HBox vida = dibujarVida();
    	contenedorVertical.getChildren().addAll(nombre, nombreJugador, vida, costo, costoOro, imagen);

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
    	Label costo = new Label("Costo:");
    	int costoAldeano = ((Aldeano)seleccionado).obtenerCosto();
    	Label costoOro = new Label(String.valueOf(costoAldeano));
    	HBox vida = dibujarVida();
    	Label nombreJugador = new Label(((Jugador) seleccionado.obtenerJugador()).obtenerNombre().toString().toUpperCase());
    	contenedorVertical.getChildren().addAll(nombre, nombreJugador, vida, costo, costoOro, imagen);

    	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
    		
    		Button botonConstruir = new Button("Construir");
    		/*Button botonMover = new Button("Mover");
    				
    		BotonMoverHandler mover = new BotonMoverHandler(vistaModelo,(Aldeano) seleccionado,posicionPrimaria);
    		botonMover.setOnAction(mover);*/
    		
    		ContextMenu menuConstruir = new ContextMenu();
    		
    		ImageView imagenPlaza = new ImageView();
        	imagenPlaza.setImage(new Image("file:aplicacion/assets/PNG Format/Towncenter.png"));
        	imagenPlaza.setFitHeight(20);
        	imagenPlaza.setFitWidth(20);
        	
    		MenuItem menuPlazaCentral = new MenuItem("Plaza Central");
    		menuPlazaCentral.setGraphic(imagenPlaza);
    		
    		BotonConstruirPlazaHandler construirPlazaCentralHandler = new BotonConstruirPlazaHandler(this, modelo, (Aldeano)seleccionado);
    		menuPlazaCentral.setOnAction(construirPlazaCentralHandler);
    		
    		ImageView imagenCuartel = new ImageView();
        	imagenCuartel.setImage(new Image("file:aplicacion/assets/PNG Format/barracks.png"));
        	imagenCuartel.setFitHeight(20);
        	imagenCuartel.setFitWidth(20);
        	        	
    		MenuItem menuCuartel = new MenuItem("Cuartel");
    		menuCuartel.setGraphic(imagenCuartel);
    		BotonConstruirCuartelHandler construirCuartelHandler = new BotonConstruirCuartelHandler(this, modelo, (Aldeano)seleccionado);
    		menuCuartel.setOnAction(construirCuartelHandler);
    		    		    		
    		menuConstruir.getItems().addAll(menuPlazaCentral, menuCuartel);
    		
    		botonConstruir.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            	@Override
            	public void handle(MouseEvent click) {
            		if (click.getButton() == MouseButton.SECONDARY) {
            			menuConstruir.show(botonConstruir,click.getScreenX(), click.getScreenY());
            		}
            	}
    		});	
    		
    		contenedorVertical.getChildren().addAll(botonConstruir);

    		if (posicionSecundaria != null) {
        		((Aldeano)seleccionado).mover(posicionSecundaria);
        		this.vistaModelo.dibujar();
        	}
    		if (seleccionadoSecundario != null && Edificio.class.isAssignableFrom(seleccionadoSecundario.getClass())) {
    			((Aldeano)seleccionado).repararEdificio((Edificio) seleccionadoSecundario);
    		}
    		
    		
    	}

        this.setLeft(contenedorVertical);
	}


	private void setControlesPlazaCentral(Juego modelo, VBox contenedorVertical) {
		Media media = new Media(new File("aplicacion/assets/sounds/towncenter.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        player.setVolume(0.6);
        player.setCycleCount(1);
    	Label nombre = new Label("Plaza Central");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/Towncenter.png"));
    	imagen.setFitHeight(90);
    	imagen.setFitWidth(90);
    	Label costo = new Label("Costo:");
    	int costoPlaza = ((PlazaCentral)seleccionado).obtenerCosto();
    	Label costoOro = new Label(String.valueOf(costoPlaza));
    	HBox vida = dibujarVida();
    	Label nombreJugador = new Label(((Jugador) seleccionado.obtenerJugador()).obtenerNombre().toString().toUpperCase());
    	contenedorVertical.getChildren().addAll(nombre, nombreJugador, costo, costoOro, vida, imagen);

    	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
    		Button botonCrearAldeano = new Button("Crear Aldeano");
    		
    		/*Button botonMover = new Button("Mover");
			
    		BotonMoverEdificioEventHandler mover = new BotonMoverEdificioEventHandler(vistaModelo, (PlazaCentral) seleccionado, posicionPrimaria);
    		botonMover.setOnAction(mover);*/
    		
    		
    		BotonCrearAldeanoHandler crearAldeano = new BotonCrearAldeanoHandler(modelo, (PlazaCentral) seleccionado);
    		botonCrearAldeano.setOnAction(crearAldeano);
    		contenedorVertical.getChildren().addAll(botonCrearAldeano);
    	}

        this.setLeft(contenedorVertical);
	}

    private void setControlesCastillo(Juego modelo, VBox contenedorVertical) {
    	Media media = new Media(new File("aplicacion/assets/sounds/castle.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        player.setVolume(0.6);
        player.setCycleCount(1);
    	
    	Label nombre = new Label("Castillo");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/castle.png"));
    	imagen.setFitHeight(100);
    	imagen.setFitWidth(100);
    	HBox vida = dibujarVida();
    	Label nombreJugador = new Label(((Jugador) seleccionado.obtenerJugador()).obtenerNombre().toString().toUpperCase());
    	contenedorVertical.getChildren().addAll(nombre, nombreJugador, vida, imagen);

    	if (modelo.obtenerJugadorActual() == seleccionado.obtenerJugador()) {
    		Button botonCrearArmaDeAsedio = new Button("Crear Arma de Asedio");
    		BotonCrearArmaDeAsedioHandler crearArma = new BotonCrearArmaDeAsedioHandler(modelo, (Castillo) seleccionado);
    		botonCrearArmaDeAsedio.setOnAction(crearArma);
    		contenedorVertical.getChildren().addAll(botonCrearArmaDeAsedio);
    	}

        this.setLeft(contenedorVertical);
	}

    private void setControlesCuartel(Juego modelo, VBox contenedorVertical) {
        Media media = new Media(new File("aplicacion/assets/sounds/barracks.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        player.setVolume(0.6);
        player.setCycleCount(1);
    	Label nombre = new Label("Cuartel");
    	ImageView imagen = new ImageView();
    	imagen.setImage(new Image("file:aplicacion/assets/PNG Format/barracks.png"));
    	imagen.setFitHeight(100);
    	imagen.setFitWidth(100);
    	Label costo = new Label("Costo:");
    	int costoCuartel = ((Cuartel)seleccionado).obtenerCosto();
    	Label costoOro = new Label(String.valueOf(costoCuartel));
    	HBox vida = dibujarVida();
    	Label nombreJugador = new Label(((Jugador) seleccionado.obtenerJugador()).obtenerNombre().toString().toUpperCase());
    	contenedorVertical.getChildren().addAll(nombre, nombreJugador, costo, costoOro, vida, imagen);

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

	public Edificio getEdificioConstruir() {
		return edificioConstruir;
	}

	public void setEdificioConstruir(Edificio edificioConstruir) {
		this.edificioConstruir = edificioConstruir;
	}

}

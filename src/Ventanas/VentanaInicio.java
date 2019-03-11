/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Alejandro
 */
public class VentanaInicio {
    
    private StackPane pane;
    private Button btnNuevaPartida;
    private Button btnContinuar;
    private Button btnSalir;
    private Scene scene;

    public VentanaInicio() {
        btnNuevaPartida = new Button("Nueva Partida");
        btnContinuar = new Button("Cargar Partida");
        btnSalir = new Button("Salir");
        
        pane = new StackPane();
        Image imagenInicio = new Image("img/PantallaInicio2.png");
        ImageView imageView = new ImageView(imagenInicio);
        pane.getChildren().add(imageView);
        VBox botones = new VBox();
        botones.getChildren().add(btnNuevaPartida);
        botones.getChildren().add(btnContinuar);
        botones.getChildren().add(btnSalir);
        botones.setAlignment(Pos.CENTER);
        botones.setPadding(new Insets(150, 0, 0, 0));
        pane.getChildren().add(botones);
        
        pane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        
        this.scene = new Scene(pane, 1368, 720);
        
        scene.getStylesheets().add("style/styles.css");
    }
    
    public Scene getScene () {
        return scene;
    }
    
    public StackPane getLayout () {
        return pane;
    }

    public Button getBtnNuevaPartida() {
        return btnNuevaPartida;
    }

    public Button getBtnContinuar() {
        return btnContinuar;
    }

    public Button getBtnSalir() {
        return btnSalir;
    }
    
    public void mostrar (Stage stage){
        stage.setTitle("Game Skull");
        stage.setScene(scene);
        stage.show();
    }
    
    
}

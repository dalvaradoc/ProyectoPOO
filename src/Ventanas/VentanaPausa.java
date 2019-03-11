/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Alejandro
 */
public class VentanaPausa {
    
    private Button btnContinuar;
    private Button btnGuardar;
    private Button btnVolver;
    private Button btnSalir;
    private Scene scene;

    public VentanaPausa() {
        Pane pane = new Pane();
        VBox botones = new VBox(10);
        btnContinuar = new Button("Continuar");
        btnGuardar = new Button("Guardar");
        btnVolver = new Button("Pantalla de Inicio");
        btnSalir = new Button("Salir");
        botones.getChildren().add(btnContinuar);
        botones.getChildren().add(btnGuardar);
        botones.getChildren().add(btnVolver);
        botones.getChildren().add(btnSalir);
        botones.setPadding(new Insets(50, 0, 0, 50));
        
        pane.getChildren().add(botones);
        pane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        
        scene = new Scene(pane, 1368, 720);
        scene.getStylesheets().add("style/styles.css");
    }

    public Button getBtnContinuar() {
        return btnContinuar;
    }

    public Button getBtnGuardar() {
        return btnGuardar;
    }

    public Button getBtnVolver() {
        return btnVolver;
    }

    public Button getBtnSalir() {
        return btnSalir;
    }

    public Scene getScene() {
        return scene;
    }
    
    public void mostrar (Stage stage){
        stage.setScene(scene);
        stage.show();
    }
}

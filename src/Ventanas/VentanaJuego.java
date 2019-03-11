/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import Structure.GameLoop;
import javafx.event.EventHandler;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 *
 * @author Alejandro
 */
public class VentanaJuego {
    
    private Pane root;
    private GraphicsContext gc;
    private Camera camera;
    private Scene scene;
    private static GameLoop gameLoop;

    public VentanaJuego() {
        root = new Pane();
        Canvas canvas = new Canvas(4000,4000);
        root.getChildren().add(canvas);
        this.scene = new Scene(root, 1368, 720, Color.BLACK);
        gc = canvas.getGraphicsContext2D();
        
        camera = new PerspectiveCamera(false);
        scene.setCamera(camera);
        gameLoop = GameLoop.getGameLoop();
        gameLoop.setGraphicsContext(gc);
        gameLoop.setCamera(camera);
    }
    
     public Scene getScene () {
        return scene;
    }
    
    public Pane getLayout () {
        return root;
    }
    
    public void mostrar (Stage stage){
        stage.setScene(scene);
        stage.show();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

import Ventanas.ControladorInicio;
import Ventanas.Modelo;
import Ventanas.Singleton;
import java.io.File;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 *
 * @author Alejandro
 */
public class Tablero extends Application{

    @Override
    public void start(Stage primaryStage){
        
        String musicFile = "src/Sounds/Memoraphile-SpookyDungeon.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
              mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.setVolume(0.1);
        mediaPlayer.play();
        
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        
        Singleton singleton = Singleton.getSingleton();
        singleton.setStage(primaryStage);
        
        Modelo modelo = new Modelo();
        ControladorInicio ventana = new ControladorInicio(modelo);
        
        ventana.mostrarVista();        
        primaryStage.show();
    }
    
    public static void main (String[] args){
        launch();
    }
    
}

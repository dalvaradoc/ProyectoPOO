/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Structure.GameLoop;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Alejandro
 */
public class ControladorJuego {
    private VentanaJuego ventana;
    private Modelo modelo;
    private boolean running, jumping, goLeft, goRight;
    
    public ControladorJuego (Modelo modelo) {
        this.modelo = modelo;
        this.ventana = new VentanaJuego();
        //Adicionar eventos
        this.ventana.getScene().setOnKeyPressed(new TeclaPresionada());
        this.ventana.getScene().setOnKeyReleased(new TeclaSoltada());
    }
    
    public void mostrarVista () {
        Singleton singleton = Singleton.getSingleton();
        GameLoop.getGameLoop().start();
        this.ventana.mostrar(singleton.getStage());
    }
    
    class TeclaPresionada implements EventHandler<KeyEvent>{
        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case LEFT:  goLeft  = true; break;
                case RIGHT: goRight  = true; break;
                case SHIFT: running = true; break;
                case SPACE: jumping = true; break;
            }
            boolean[] keysLoop = {goLeft, goRight, running, jumping};
            GameLoop.getGameLoop().setKeys(keysLoop);
            if (event.getCode() == KeyCode.ESCAPE){
                ControladorPausa pausa = new ControladorPausa(modelo);
                GameLoop.getGameLoop().stop();
                pausa.mostrarVista();
            }
        }
        
    }
    
    class TeclaSoltada implements EventHandler<KeyEvent>{
        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case LEFT:  goLeft  = false; break;
                case RIGHT: goRight  = false; break;
                case SHIFT: running = false; break;
                case SPACE: jumping = false; break;
            }
            boolean[] keysLoop = {goLeft, goRight, running, jumping};
            GameLoop.getGameLoop().setKeys(keysLoop);
        }
    }
    
    
    
//    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                switch (event.getCode()) {
//                    case LEFT:  goLeft  = true; break;
//                    case RIGHT: goRight  = true; break;
//                    case SHIFT: running = true; break;
//                    case SPACE: jumping = true; break;
//                }
//                boolean[] keysLoop = {goLeft, goRight, running, jumping};
//                gameLoop.setKeys(keysLoop);
//                Button bt = new Button("OK");
//                if (event.getCode() == KeyCode.ESCAPE){
////                    gameLoop.stop();
//                }
//                if (event.getCode() == KeyCode.ENTER){
////                    gameLoop.start();
//                }
//            }
//        });
//
//        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                switch (event.getCode()) {
//                    case LEFT:  goLeft  = false; break;
//                    case RIGHT: goRight  = false; break;
//                    case SHIFT: running = false; break;
//                    case SPACE: jumping = false; break;
//                }
//                boolean[] keysLoop = {goLeft, goRight, running, jumping};
//                gameLoop.setKeys(keysLoop);
//            }
//        });
}

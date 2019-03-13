/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Structure.GameLoop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;

/**
 *
 * @author Alejandro
 */
public class ControladorInicio {
    private VentanaInicio ventana;
    private Modelo modelo;
    
    public ControladorInicio (Modelo modelo) {
        this.modelo = modelo;
        this.ventana = new VentanaInicio();
        //Adicionar eventos
        this.ventana.getBtnNuevaPartida().setOnAction(new EventoBotonNuevaPartida());
        this.ventana.getBtnContinuar().setOnAction(new EventoBotonContinuar());
        this.ventana.getBtnSalir().setOnAction(new EventoBotonSalir());
    }
    
    public void mostrarVista () {
        Singleton singleton = Singleton.getSingleton();
        ventana.getScene().setCursor(Cursor.DEFAULT);
        this.ventana.mostrar(singleton.getStage());
    }
    
    class EventoBotonNuevaPartida implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            //Empieza el gameloop desde el nivel 1
            ControladorJuego juego = new ControladorJuego(modelo);
            try {
                GameLoop.getGameLoop().setLevelInt(0);
            } catch (IOException ex) {
                Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            juego.mostrarVista();
            
            GameLoop.getGameLoop().start();
        }
    }
    
    class EventoBotonContinuar implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            ControladorJuego juego = new ControladorJuego(modelo);
            //Empieza el gameloop desde el nivel guardado
            File saveFile = new File("savefile.txt");
//            ControladorJuego juego = new ControladorJuego(modelo);
            if (saveFile.exists()){
                try {
                    Scanner in = new Scanner(saveFile);
                    int lvl = in.nextInt();
                    GameLoop.getGameLoop().setLevelInt(lvl);
                    juego.mostrarVista();
                    GameLoop.getGameLoop().start();
                } catch (FileNotFoundException ex) {
                    System.out.println("No hay ningun archivo de guardado");
                    Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    GameLoop.getGameLoop().setLevelInt(0);
                } catch (IOException ex) {
                    Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
                }
                juego.mostrarVista();
                GameLoop.getGameLoop().start();
            }
        }
    }
    
    class EventoBotonSalir implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            //Cierra el juego.
            System.exit(0);
        }
        
    }
    
    
}

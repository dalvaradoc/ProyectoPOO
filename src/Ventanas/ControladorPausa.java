/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Structure.GameLoop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Alejandro
 */
public class ControladorPausa {
    private VentanaPausa ventana;
    private ControladorJuego juego;
    private Modelo modelo;

    public ControladorPausa(Modelo modelo) {
        this.modelo = modelo;
        this.juego = juego;
        this.juego = new ControladorJuego(modelo);
        this.ventana = new VentanaPausa();
        //Se asignan las acciones
        this.ventana.getBtnContinuar().setOnAction(new EventoBotonPContinuar());
        this.ventana.getBtnGuardar().setOnAction(new Guardar());
        this.ventana.getBtnVolver().setOnAction(new EventoBotonPVolver());
        this.ventana.getBtnSalir().setOnAction(new EventoBotonPSalir());
    }
    
    public void mostrarVista () {
        Singleton singleton = Singleton.getSingleton();
        this.ventana.mostrar(singleton.getStage());
    }
    
    class EventoBotonPContinuar implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            GameLoop.getGameLoop().start();
            juego.mostrarVista();
        }
    }
    
    class Guardar implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            File saveFile = new File("savefile.txt");
            if (!saveFile.exists()){
                try {
                    saveFile.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(ControladorPausa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                PrintStream out = new PrintStream(saveFile);
                out.print(GameLoop.getGameLoop().getLevelInt());
                out.flush();
                out.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorPausa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    class EventoBotonPVolver implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            ControladorInicio inicio = new ControladorInicio(modelo);
            inicio.mostrarVista();
        }
    }
    
    class EventoBotonPSalir implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    }
}

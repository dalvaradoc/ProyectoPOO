/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

import Objetos.Antorcha;
import Objetos.Bat;
import Objetos.Pincho;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author Alejandro
 */
public class Level {
    private int number;
    private Image img;
    
    private Door door;
    
    private int[] limitsCamera;
    private int[] initialPosProta;
    private int[] initialPosKey;
    
    private ArrayList<Bloque> bloques;
    private ArrayList<Pincho> pinchos;
    private ArrayList<Bat> bats;
    private ArrayList<Antorcha> antorchas;

    public Level(int number, String imgPath, Door door, int[] limitsCamera, int[] initialPosProta) {
        this.number = number;
        this.door = door;
        img = new Image(imgPath);
        
        this.bloques = new ArrayList<>();
        this.pinchos = new ArrayList<>();
        this.bats = new ArrayList<>();
        this.antorchas = new ArrayList<>();
        
        this.limitsCamera = limitsCamera;
        this.initialPosProta = initialPosProta;
        this.initialPosKey = new int[2];
        this.initialPosKey[0] = door.getKey().getX();
        this.initialPosKey[1] = door.getKey().getY();
    }
    
    public ArrayList<Bloque> getBloques() {
        return this.bloques;
    }
    
    public boolean addBloque (int x, int y, int width, int height) {
        return bloques.add(new Bloque(x, y, width, height));
    }
    
    public ArrayList<Pincho> getPinchos() {
        return pinchos;
    }
    
    public boolean addPincho (Pincho pincho){
        return pinchos.add(pincho);
    }

    public ArrayList<Antorcha> getAntorchas() {
        return antorchas;
    }
    
    public boolean addAntorcha (Antorcha antorcha){
        return antorchas.add(antorcha);
    }

    public ArrayList<Bat> getBats() {
        return bats;
    }
    
    public boolean addBat (Bat bat){
        return bats.add(bat);
    }

    public int[] getLimitsCamera() {
        return limitsCamera;
    }

    public int[] getInitialPosProta() {
        return initialPosProta;
    }

    public int[] getInitialPosKey() {
        return initialPosKey;
    }

    public Image getImg() {
        return img;
    }

    public Door getDoor() {
        return door;
    }
    
    
    
}

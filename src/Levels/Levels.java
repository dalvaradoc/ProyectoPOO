/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Objetos.Antorcha;
import Objetos.Bat;
import Structure.Bloque;
import Structure.Door;
import Structure.Level;
import Objetos.Pincho;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class Levels {
    private ArrayList<Level> levels;
    private static Levels allLevels = null;
    
    public static Levels getAllLevels () {
        if (allLevels == null){
            allLevels = new Levels();
        }
        return allLevels;
    }

    private Levels() {
        levels = new ArrayList<>();
        
        //Level 1
        Door door1 = new Door(1088, 256);
        door1.setKey(960, 384);
        
        Level lvl1 = new Level(1, "img/Level1.png", door1, new int[] {0,100, 12*64}, new int[] {80,371});
        
        lvl1.getBloques().add(new Bloque(0, 450, 2000, 80));
        lvl1.getBloques().add(new Bloque(0, 0, 64, 436));
        lvl1.getBloques().add(new Bloque(1290, 0, 64, 1000));
        lvl1.addBloque(64, 0, 19*64, 64);
        
        lvl1.addAntorcha(new Antorcha(6*64, 3*64));
        lvl1.addAntorcha(new Antorcha(14*64, 3*64));
        
        levels.add(lvl1);
        
        //Level 2:
        
        //24, 4 door
        //10, 5 key
        //49, 93 prot
        
        Door door2 = new Door(24*64, 4*64);
        door2.setKey(10*64, 5*64);
        
        Level lvl2 = new Level(2, "img/Level2.png", door2, new int[] {0, 27*64, 9*64}, new int[] {49*4, 93*4});
        
        lvl2.addBloque(64, 7*64, 8*64, 3*64);
        lvl2.addBloque(12*64, 7*64, 15*64, 3*64);
        lvl2.addBloque(0, 64, 64, 6*64);
        lvl2.addBloque(27*64, 64, 64, 6*64);
        
        lvl2.addPincho(new Pincho(16*64, 6*64, 0));
        
        lvl2.addAntorcha(new Antorcha(6*64, 3*64));
        lvl2.addAntorcha(new Antorcha(13*64, 3*64));
        lvl2.addAntorcha(new Antorcha(20*64, 3*64));
        
        levels.add(lvl2);
        
        //Level 3
        
        //Door 36, 8
        //Key 29, 3
        //Prota 49, 205
        
        Door door3 = new Door(36*64, 8*64);
        door3.setKey(29*64, 3*64);
        
        Level lvl3 = new Level(3, "img/Level3.png", door3, new int[] {0, 41*64, 15*64}, new int[] {49*4, 205*4});
        
        lvl3.addBloque(0, 11*64, 64, 3*64);
        lvl3.addBloque(64, 14*64, 4*64-20, 3*64);
        lvl3.addBloque(6*64, 13*64, 6*64, 40);
        lvl3.addBloque(8*64, 9*64, 64, 40);
        lvl3.addBloque(64, 10*64, 4*64, 64);
        lvl3.addBloque(4*64, 64, 64, 9*64);
        lvl3.addBloque(5*64, 7*64, 64, 40);
        lvl3.addBloque(5*64, 7*64, 64, 40);
        lvl3.addBloque(8*64, 5*64, 64, 40);
        lvl3.addBloque(5*64, 0, 27*64, 64);
        lvl3.addBloque(9*64, 3*64, 64, 8*64);
        lvl3.addBloque(10*64, 3*64, 14*64, 64);
        lvl3.addBloque(11*64, 7*64, 64, 4*64);
        lvl3.addBloque(10*64, 10*64, 64, 64);
        lvl3.addBloque(12*64, 6*64, 10*64, 64);
        lvl3.addBloque(24*64, 3*64, 64, 3*64);
        lvl3.addBloque(25*64, 6*64, 3*64, 64);
        lvl3.addBloque(28*64, 4*64, 64, 2*64);
        lvl3.addBloque(29*64, 4*64, 2*64, 64);
        lvl3.addBloque(31*64, 64, 64, 3*64);
        lvl3.addBloque(13*64, 14*64, 4*64, 64);
        lvl3.addBloque(17*64, 13*64, 64, 64);
        lvl3.addBloque(18*64, 12*64, 64, 64);
        lvl3.addBloque(19*64, 11*64, 21*64, 64);
        lvl3.addBloque(22*64, 7*64, 64, 2*64);
        lvl3.addBloque(22*64, 8*64, 9*64, 64);
        lvl3.addBloque(30*64, 6*64, 64, 2*64);
        lvl3.addBloque(31*64, 5*64, 3*64, 64);
        lvl3.addBloque(40*64, 64, 64, 10*64);
        lvl3.addBloque(33*64, 64, 64, 4*64);
        
        //Pinchos Arriba
        lvl3.addPincho(new Pincho(9*64, 2*64, 0));
        lvl3.addPincho(new Pincho(13*64, 2*64, 0));
        lvl3.addPincho(new Pincho(21*64, 2*64, 0));
        lvl3.addPincho(new Pincho(22*64, 2*64, 0));
        lvl3.addPincho(new Pincho(25*64, 5*64, 4));
        lvl3.addPincho(new Pincho(26*64, 5*64, 4));
        lvl3.addPincho(new Pincho(27*64, 5*64, 4));
        //Pinchos Derecha
        lvl3.addPincho(new Pincho(5*64, 8*64, 1));
        lvl3.addPincho(new Pincho(5*64, 9*64, 1));
        lvl3.addPincho(new Pincho(5*64, 10*64, 1));
        lvl3.addPincho(new Pincho(5*64, 1*64, 1));
        lvl3.addPincho(new Pincho(5*64, 2*64, 1));
        //Pinchos Abajo
        lvl3.addPincho(new Pincho(9*64, 11*64, 2));
        lvl3.addPincho(new Pincho(10*64, 11*64, 2));
        lvl3.addPincho(new Pincho(11*64, 11*64, 2));
        lvl3.addPincho(new Pincho(11*64, 1*64, 2));
        lvl3.addPincho(new Pincho(16*64, 1*64, 2));
        lvl3.addPincho(new Pincho(17*64, 1*64, 2));
        //Pinchos Izquierda
        lvl3.addPincho(new Pincho(8*64, 10*64, 3));
        lvl3.addPincho(new Pincho(8*64, 6*64, 3));
        lvl3.addPincho(new Pincho(16*64, 13*64, 3));
        lvl3.addPincho(new Pincho(18*64, 11*64, 3));
        
        lvl3.addBat(new Bat(19*64, 10*64, new int[]  {19*64, 33*64}));
        
        lvl3.addAntorcha(new Antorcha(9*64, 64));
        lvl3.addAntorcha(new Antorcha(14*64, 64));
        lvl3.addAntorcha(new Antorcha(18*64, 64));
        lvl3.addAntorcha(new Antorcha(23*64, 64));
        lvl3.addAntorcha(new Antorcha(29*64, 2*64));
        lvl3.addAntorcha(new Antorcha(22*64, 9*64));
        lvl3.addAntorcha(new Antorcha(26*64, 9*64));
        lvl3.addAntorcha(new Antorcha(30*64, 9*64));
        lvl3.addAntorcha(new Antorcha(35*64, 7*64));
        lvl3.addAntorcha(new Antorcha(39*64, 7*64));
        
        levels.add(lvl3);
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }
    
    
}

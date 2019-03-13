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
        
        // 14 2 Door
        // 43 3 Key
        // 65 64 Prota
        
        Door door3 = new Door(13*64, 2*64);
        door3.setKey(42*64, 3*64);
        
        Level lvl3 = new Level(3, "img/Level5.png", door3, new int[] {0, 51*64, 20*64}, new int[] {65*4,64*4});
        
        //lvl3.addBloque(*64, *64, *64, *64);
        lvl3.addBloque(0*64, 5*64, 7*64, 1*64);
        lvl3.addBloque(10*64, 5*64, 8*64, 1*64);
        lvl3.addBloque(0*64, 1*64, 18*64, 1*64);
        lvl3.addBloque(0*64, 2*64, 1*64, 3*64);
        lvl3.addBloque(17*64, 2*64, 1*64, 3*64);
        lvl3.addBloque(6*64, 6*64, 1*64, 3*64);
        lvl3.addBloque(10*64, 6*64, 1*64, 3*64);
        lvl3.addBloque(0*64, 9*64, 7*64, 1*64);
        lvl3.addBloque(10*64, 9*64, 10*64, 1*64);
        lvl3.addBloque(0*64, 10*64, 1*64, 9*64);
        lvl3.addBloque(0*64, 19*64, 52*64, 1*64);
        lvl3.addBloque(19*64, 10*64, 3*64, 1*64);
        lvl3.addBloque(21*64, 11*64, 1*64, 2*64);
        lvl3.addBloque(21*64, 13*64, 7*64, 1*64);
        lvl3.addBloque(27*64, 12*64, 6*64, 1*64);
        lvl3.addBloque(32*64, 8*64, 1*64, 4*64);
        lvl3.addBloque(32*64, 7*64, 9*64, 1*64);
        lvl3.addBloque(40*64, 1*64, 1*64, 6*64);
        lvl3.addBloque(50*64, 1*64, 1*64, 18*64);
        lvl3.addBloque(40*64, 0*64, 11*64, 1*64);
        lvl3.addBloque(9*64, 8*64, 1*64, 40);
        lvl3.addBloque(7*64, 12*64, 3*64, 40);
        lvl3.addBloque(3*64, 14*64, 1*64, 40);
        lvl3.addBloque(11*64, 14*64, 1*64, 40);
        lvl3.addBloque(17*64, 14*64, 1*64, 40);
        lvl3.addBloque(6*64, 16*64, 1*64, 40);
        lvl3.addBloque(14*64, 16*64, 1*64, 40);
        lvl3.addBloque(21*64, 16*64, 1*64, 40);
        lvl3.addBloque(24*64, 17*64, 1*64, 40);
        lvl3.addBloque(29*64, 17*64, 3*64, 40);
        lvl3.addBloque(36*64, 15*64, 4*64, 40);
        lvl3.addBloque(42*64, 12*64, 5*64, 40);
        lvl3.addBloque(47*64, 8*64, 2*64, 40);
        lvl3.addBloque(42*64, 4*64, 3*64, 40);
        
        //PinchoArriba
        for (int i = 1; i < 26; i += 2){
            lvl3.addPincho(new Pincho(i*64, 18*64, 0));
        }
        for (int i = 27; i < 47; i++){
            lvl3.addPincho(new Pincho(i*64, 18*64, 0));
        }
        lvl3.addPincho(new Pincho(48*64, 18*64, 0));
        //PinchosIzquierda
        for (int i = 1; i < 19; i++){
            lvl3.addPincho(new Pincho(49*64, i*64, 3));
        }
        //PinchosAbajo
        for (int i = 28; i < 49; i++){
            if (i == 33 || i == 41){
                continue;
            }
            if (i < 33){
                lvl3.addPincho(new Pincho(i*64, 13*64, 2));
            } else if (i < 41){
                lvl3.addPincho(new Pincho(i*64, 8*64, 2));
            } else {
                lvl3.addPincho(new Pincho(i*64, 1*64, 2));
            }
        }
        //PinchosDerecha
        for (int i = 1;  i < 13; i++){
            if (i < 8){
                lvl3.addPincho(new Pincho(41*64, i*64, 1));
            } else {
                lvl3.addPincho(new Pincho(33*64, i*64, 1));
            }
        }
        
        lvl3.addBat(new Bat(2*64, 13*64, new int [] {1*64, 20*64}));
        lvl3.addBat(new Bat(17*64, 13*64, new int [] {1*64, 20*64}));
        lvl3.addBat(new Bat(9*64, 15*64, new int [] {1*64, 24*64}));
        lvl3.addBat(new Bat(21*64, 15*64, new int [] {1*64, 24*64}));
        lvl3.addBat(new Bat(17*64, 17*64, new int [] {1*64, 17*64}));
        
        lvl3.addAntorcha(new Antorcha(4*64, 2*64));
        lvl3.addAntorcha(new Antorcha(12*64, 2*64));
        lvl3.addAntorcha(new Antorcha(16*64, 2*64));
        lvl3.addAntorcha(new Antorcha(6*64, 14*64));
        lvl3.addAntorcha(new Antorcha(14*64, 14*64));
        lvl3.addAntorcha(new Antorcha(30*64, 15*64));
        lvl3.addAntorcha(new Antorcha(38*64, 13*64));
        lvl3.addAntorcha(new Antorcha(44*64, 10*64));
        lvl3.addAntorcha(new Antorcha(47*64, 3*64));
        
        levels.add(lvl3);
        
        //Level 4
        
        //Door 36, 8
        //Key 29, 3
        //Prota 49, 205
        
        Door door4 = new Door(36*64, 8*64);
        door4.setKey(29*64, 3*64);
        
        Level lvl4 = new Level(4, "img/Level3.png", door4, new int[] {0, 41*64, 15*64}, new int[] {49*4, 205*4});
        
        lvl4.addBloque(0, 11*64, 64, 3*64);
        lvl4.addBloque(64, 14*64, 4*64-20, 3*64);
        lvl4.addBloque(6*64, 13*64, 6*64, 40);
        lvl4.addBloque(8*64, 9*64, 64, 40);
        lvl4.addBloque(64, 10*64, 4*64, 64);
        lvl4.addBloque(4*64, 64, 64, 9*64);
        lvl4.addBloque(5*64, 7*64, 64, 40);
        lvl4.addBloque(5*64, 7*64, 64, 40);
        lvl4.addBloque(8*64, 5*64, 64, 40);
        lvl4.addBloque(5*64, 0, 27*64, 64);
        lvl4.addBloque(9*64, 4*64, 64, 7*64);
        lvl4.addBloque(9*64, 3*64, 16*64, 64);
        lvl4.addBloque(11*64, 7*64, 64, 4*64);
        lvl4.addBloque(10*64, 10*64, 64, 64);
        lvl4.addBloque(12*64, 6*64, 10*64, 64);
        lvl4.addBloque(24*64, 4*64, 64, 2*64);
        lvl4.addBloque(25*64, 6*64, 3*64, 64);
        lvl4.addBloque(28*64, 5*64, 64, 2*64);
        lvl4.addBloque(28*64, 4*64, 3*64, 64);
        lvl4.addBloque(31*64, 64, 64, 3*64);
        lvl4.addBloque(13*64, 14*64, 4*64, 64);
        lvl4.addBloque(17*64, 13*64, 64, 64);
        lvl4.addBloque(18*64, 12*64, 64, 64);
        lvl4.addBloque(19*64, 11*64, 21*64, 64);
        lvl4.addBloque(22*64, 7*64, 64, 2*64);
        lvl4.addBloque(22*64, 8*64, 9*64, 64);
        lvl4.addBloque(30*64, 6*64, 64, 2*64);
        lvl4.addBloque(31*64, 5*64, 3*64, 64);
        lvl4.addBloque(40*64, 64, 64, 10*64);
        lvl4.addBloque(33*64, 64, 64, 4*64);
        
        //Pinchos Arriba
        lvl4.addPincho(new Pincho(9*64, 2*64, 0));
        lvl4.addPincho(new Pincho(13*64, 2*64, 0));
        lvl4.addPincho(new Pincho(21*64, 2*64, 0));
        lvl4.addPincho(new Pincho(22*64, 2*64, 0));
        lvl4.addPincho(new Pincho(25*64, 5*64, 4));
        lvl4.addPincho(new Pincho(26*64, 5*64, 4));
        lvl4.addPincho(new Pincho(27*64, 5*64, 4));
        //Pinchos Derecha
        lvl4.addPincho(new Pincho(5*64, 8*64, 1));
        lvl4.addPincho(new Pincho(5*64, 9*64, 1));
        lvl4.addPincho(new Pincho(5*64, 10*64, 1));
        lvl4.addPincho(new Pincho(5*64, 1*64, 1));
        lvl4.addPincho(new Pincho(5*64, 2*64, 1));
        //Pinchos Abajo
        lvl4.addPincho(new Pincho(9*64, 11*64, 2));
        lvl4.addPincho(new Pincho(10*64, 11*64, 2));
        lvl4.addPincho(new Pincho(11*64, 11*64, 2));
        lvl4.addPincho(new Pincho(11*64, 1*64, 2));
        lvl4.addPincho(new Pincho(16*64, 1*64, 2));
        lvl4.addPincho(new Pincho(17*64, 1*64, 2));
        //Pinchos Izquierda
        lvl4.addPincho(new Pincho(8*64, 10*64, 3));
        lvl4.addPincho(new Pincho(8*64, 6*64, 3));
        lvl4.addPincho(new Pincho(16*64, 13*64, 3));
        lvl4.addPincho(new Pincho(18*64, 11*64, 3));
        
        lvl4.addBat(new Bat(19*64, 10*64, new int[]  {19*64, 33*64}));
        
        lvl4.addAntorcha(new Antorcha(9*64, 64));
        lvl4.addAntorcha(new Antorcha(14*64, 64));
        lvl4.addAntorcha(new Antorcha(18*64, 64));
        lvl4.addAntorcha(new Antorcha(23*64, 64));
        lvl4.addAntorcha(new Antorcha(29*64, 2*64));
        lvl4.addAntorcha(new Antorcha(22*64, 9*64));
        lvl4.addAntorcha(new Antorcha(26*64, 9*64));
        lvl4.addAntorcha(new Antorcha(30*64, 9*64));
        lvl4.addAntorcha(new Antorcha(35*64, 7*64));
        lvl4.addAntorcha(new Antorcha(39*64, 7*64));
        
        levels.add(lvl4);
        
        
        //Level 5
        // 43 1 Door
        // 11 3 Key
        // 6 3 Prota
        
        Door door5 = new Door(43*64, 1*64);
        door5.setKey(11*64, 3*64);
        
        Level lvl5 = new Level(5, "img/Level4.png", door5, new int[] {0, 47*64, 5*64}, new int[] {81*4, 47*4});
        
        lvl5.addBloque(0, 4*64, 47*64, 64);
        lvl5.addBloque(0, 0, 9*64, 64);
        lvl5.addBloque(40*64, 0, 7*64, 64);
        lvl5.addBloque(8*64, 64, 33*64, 64);
        lvl5.addBloque(0, 64, 64, 3*64);
        lvl5.addBloque(46*64, 64, 64, 3*64);
        
        //PinchosArriba
        lvl5.addPincho(new Pincho(8*64, 3*64, 0));
        lvl5.addPincho(new Pincho(9*64, 3*64, 0));
        lvl5.addPincho(new Pincho(13*64, 3*64, 0));
        lvl5.addPincho(new Pincho(19*64, 3*64, 0));
        lvl5.addPincho(new Pincho(20*64, 3*64, 0));
        lvl5.addPincho(new Pincho(21*64, 3*64, 0));
        lvl5.addPincho(new Pincho(22*64, 3*64, 0));
        lvl5.addPincho(new Pincho(23*64, 3*64, 0));
        lvl5.addPincho(new Pincho(27*64, 3*64, 0));
        lvl5.addPincho(new Pincho(31*64, 3*64, 0));
        lvl5.addPincho(new Pincho(39*64, 3*64, 0));
        //PinchosAbajo
        lvl5.addPincho(new Pincho(11*64, 2*64, 2));
        lvl5.addPincho(new Pincho(15*64, 2*64, 2));
        lvl5.addPincho(new Pincho(16*64, 2*64, 2));
        lvl5.addPincho(new Pincho(17*64, 2*64, 2));
        lvl5.addPincho(new Pincho(25*64, 2*64, 2));
        lvl5.addPincho(new Pincho(29*64, 2*64, 2));
        lvl5.addPincho(new Pincho(33*64, 2*64, 2));
        lvl5.addPincho(new Pincho(34*64, 2*64, 2));
        lvl5.addPincho(new Pincho(35*64, 2*64, 2));
        lvl5.addPincho(new Pincho(36*64, 2*64, 2));
        lvl5.addPincho(new Pincho(37*64, 2*64, 2));
        
        lvl5.addAntorcha(new Antorcha(2*64, 64));
        lvl5.addAntorcha(new Antorcha(6*64, 64));
        lvl5.addAntorcha(new Antorcha(42*64, 64));
        
        Bat batlvl5 = new Bat(64, 3*64, new int[] {64, 40*64});
        lvl5.addBat(batlvl5);        
        
        levels.add(lvl5);
        
        //Level 6
        
        // 48 18 Door
        // 27 12 Key
        // 49 64 Prota
        
        Door door6 = new Door(48*64, 18*64);
        door6.setKey(27*64, 12*64);
        
        Level lvl6 = new Level(6, "img/Level6.png", door6, new int[] {0, 53*64, 22*64}, new int[] {49*4, 64*4});
        
        lvl6.addBloque(0*64, 5*64, 10*64, 64);
        lvl6.addBloque(0, 0, 14*64, 64);
        lvl6.addBloque(9*64, 21*64, 13*64, 64);
        lvl6.addBloque(21*64, 5*64, 5*64, 64);
        lvl6.addBloque(17*64, 0*64, 13*64, 64);
        lvl6.addBloque(25*64, 21*64, 2*64, 64);
        lvl6.addBloque(29*64, 18*64, 18*64, 64);
        lvl6.addBloque(28*64, 21*64, 25*64, 64);
        lvl6.addBloque(46*64, 17*64, 7*64, 64);
        lvl6.addBloque(13*64, 17*64, 5*64, 64);
        lvl6.addBloque(0*64, 1*64, 64, 4*64);
        lvl6.addBloque(9*64, 6*64, 64, 15*64);
        lvl6.addBloque(13*64, 1*64, 64, 16*64);
        lvl6.addBloque(17*64, 1*64, 64, 16*64);
        lvl6.addBloque(21*64, 6*64, 64, 15*64);
        lvl6.addBloque(25*64, 6*64, 64, 15*64);
        lvl6.addBloque(29*64, 1*64, 64, 17*64);
        lvl6.addBloque(52*64, 18*64, 64, 3*64);
        lvl6.addBloque(20*64, 17*64, 64, 40);
        lvl6.addBloque(18*64, 13*64, 64, 40);
        lvl6.addBloque(20*64, 9*64, 64, 40);
        
        //PinchosArriba
        lvl6.addPincho(new Pincho(10*64, 20*64, 0));
        lvl6.addPincho(new Pincho(13*64, 20*64, 0));
        lvl6.addPincho(new Pincho(16*64, 20*64, 0));
        lvl6.addPincho(new Pincho(19*64, 20*64, 0));
        lvl6.addPincho(new Pincho(30*64, 20*64, 0));
        lvl6.addPincho(new Pincho(31*64, 20*64, 0));
        lvl6.addPincho(new Pincho(35*64, 20*64, 0));
        lvl6.addPincho(new Pincho(40*64, 20*64, 0));
        lvl6.addPincho(new Pincho(41*64, 20*64, 0));
        lvl6.addPincho(new Pincho(42*64, 20*64, 0));
        lvl6.addPincho(new Pincho(43*64, 20*64, 0));
        lvl6.addPincho(new Pincho(23*64, 4*64, 0));
        lvl6.addPincho(new Pincho(24*64, 4*64, 0));
        lvl6.addPincho(new Pincho(25*64, 4*64, 0));
        //PinchosDerecha
        lvl6.addPincho(new Pincho(0*64, 0*64, 1));
        lvl6.addPincho(new Pincho(18*64, 8*64, 1));
        for (int i = 6; i < 18; i++){
            lvl6.addPincho(new Pincho(26*64, i*64, 1));
        }
        //PinchosIzquierda
        lvl6.addPincho(new Pincho(20*64, 12*64, 3));
        lvl6.addPincho(new Pincho(20*64, 5*64, 3));
        for (int i = 6; i < 18; i++){
            lvl6.addPincho(new Pincho(28*64, i*64, 3));
        }
        //PinchosAbajo
        lvl6.addPincho(new Pincho(33*64, 19*64, 2));
        lvl6.addPincho(new Pincho(37*64, 19*64, 2));
        lvl6.addPincho(new Pincho(45*64, 19*64, 2));
        
        lvl6.addBat(new Bat(10*64, 7*64, new int[] {10*64, 28*64}));
        lvl6.addBat(new Bat(11*64, 10*64, new int[] {10*64, 28*64}));
        lvl6.addBat(new Bat(10*64, 15*64, new int[] {10*64, 28*64}));
        
        lvl6.addAntorcha(new Antorcha(4*64, 2*64));
        lvl6.addAntorcha(new Antorcha(11*64, 2*64));
        lvl6.addAntorcha(new Antorcha(11*64, 9*64));
        lvl6.addAntorcha(new Antorcha(11*64, 17*64));
        lvl6.addAntorcha(new Antorcha(13*64, 19*64));
        lvl6.addAntorcha(new Antorcha(17*64, 19*64));
        lvl6.addAntorcha(new Antorcha(19*64, 15*64));
        lvl6.addAntorcha(new Antorcha(19*64, 10*64));
        lvl6.addAntorcha(new Antorcha(19*64, 5*64));
        lvl6.addAntorcha(new Antorcha(19*64, 2*64));
        lvl6.addAntorcha(new Antorcha(23*64, 2*64));
        lvl6.addAntorcha(new Antorcha(27*64, 2*64));
        lvl6.addAntorcha(new Antorcha(27*64, 5*64));
        lvl6.addAntorcha(new Antorcha(27*64, 10*64));
        lvl6.addAntorcha(new Antorcha(27*64, 15*64));
        lvl6.addAntorcha(new Antorcha(27*64, 19*64));
        lvl6.addAntorcha(new Antorcha(39*64, 19*64));
        lvl6.addAntorcha(new Antorcha(47*64, 18*64));
        lvl6.addAntorcha(new Antorcha(51*64, 18*64));
        
        levels.add(lvl6);
        
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }
    
}

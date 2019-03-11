/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prota;

/**
 *
 * @author Alejandro
 */
public class Prota {
    private int x;
    private int y;
    
    private int speed;

    public Prota(int x, int y) {
        this.x = x;
        this.y = y;
        speed = 5;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void moverDer () {
        x += speed;
    }
    
    public void moverIzq () {
        x -= speed;
    }
    
    public void saltar (int pixels){
        y -= pixels;
    }
}

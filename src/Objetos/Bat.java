/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Prota.Prota;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author Alejandro
 */
public class Bat extends Prota {
    
    private Image img;
    private int iAnim;
    private int[] movLimX;
    
    public Bat(int x, int y, int[] movLimX) {
        super(x, y-5);
        this.img = new Image("img/Bat.png");
        this.iAnim = 0;
        this.movLimX = movLimX;
    }
    
    public void draw (GraphicsContext gc){
        if (this.getSpeed() > 0){
            if (this.getX()+128 > movLimX[1]){
                this.setSpeed(-this.getSpeed());
            }
            this.moverDer();
        } else {
            if (this.getX() < movLimX[0]){
                this.setSpeed(-this.getSpeed());
            }
            this.moverDer();
        }
        
        if (iAnim < 15){
             this.setY(this.getY()-1);
        } else {
            this.setY(this.getY()+1);
        }
        
        
        gc.drawImage(img, (iAnim/5)*128, 0, 128, 64, this.getX(), this.getY(), 128, 64);
        this.iAnim++;
        if (this.iAnim > 29) {
            this.iAnim = 0;
        }
    }
}

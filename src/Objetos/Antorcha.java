/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author Alejandro
 */
public class Antorcha {
    private int x;
    private int y;
    private int iAnim;
    private Image img;

    public Antorcha(int x, int y) {
        this.x = x;
        this.y = y;
        this.iAnim = 0;
        this.img = new Image("img/Antorcha.png");
    }

    public void draw (GraphicsContext gc) {
        gc.drawImage(img, (iAnim/13)*64, 0, 64, 64, x, y, 64, 64);
        if (iAnim > (13*3)-5){
            iAnim = 0;
        }
        iAnim++;
    }
    
}

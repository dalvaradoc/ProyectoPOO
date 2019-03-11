/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import javafx.scene.image.Image;

/**
 *
 * @author Alejandro
 */
public class Pincho {
    private int x;
    private int y;
    private int rot;
    private Image img;

    public Pincho(int x, int y, int rot) {
        this.x = x;
        this.y = y;
        this.rot = rot;
        this.img = new Image("img/Pinchos.png");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImg() {
        return img;
    }

    public int getRot() {
        return rot;
    }
}

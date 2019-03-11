/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

/**
 *
 * @author Alejandro
 */
public class Key {
    private int x;
    private int y;
    private Door door;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Key(int x, int y, Door door) {
        this.x = x;
        this.y = y;
        this.door = door;
    }
    
    public void collected () {
        door.setClosed(false);
    }
}

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
public class Door {
    private int x;
    private int y;
    private boolean closed;
    private Key key;

    public Door(int x, int y) {
        this.x = x;
        this.y = y;
        this.closed = true;
    }
    
    public void setKey (int xk, int yk) {
        key = new Key(xk, yk, this);
    }

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

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Key getKey() {
        return key;
    }
    
}

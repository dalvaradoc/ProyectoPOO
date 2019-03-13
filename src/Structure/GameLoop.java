/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

import Objetos.Bat;
import Objetos.Pincho;
import Prota.Prota;
import java.awt.Rectangle;
import javafx.animation.AnimationTimer;
import javafx.scene.Camera;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import Levels.Levels;
import Objetos.Antorcha;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class GameLoop extends AnimationTimer{
    
    private GraphicsContext gc;
    
    private boolean[] keys;
    
    private Image protaImgMap;
    private Prota prota;
    private Rectangle protRect;
    private Rectangle returnDoor;
    
    private Image puertaImg;
    private Image siluetaLlave;
    
    private int sx, sy, dw, iAnim, animSpeed, iJump, iGravity, rotint, offsetCamx, offsetCamy, iPuerta, iMuerte;
    private boolean protRot;
    private boolean jump, secJump, muerto;
    
    private Camera camara;
    
    private Levels levels;
    private int levelint;
    private Level actualLevel;
    private ArrayList<Bloque> bloques;
    private ArrayList<int[]> muertes;    
    
    //Lo vuelvo singleton
    private static GameLoop gameLoop = null;
    
    public static GameLoop getGameLoop () {
        if (gameLoop == null){
            gameLoop = new GameLoop();
        }
        return gameLoop;
    }
    
    public boolean setGraphicsContext (GraphicsContext gc){
        this.gc = gc;
        return true;
    }
    
    public boolean setCamera (Camera camara){
        this.camara = camara;
        this.camara.setTranslateY(prota.getY() - offsetCamy);
        return true;
    }

    private GameLoop() {
        protaImgMap = new Image("img/MapaPersonaje_64x64.png");
        keys = new boolean[4];
        muertes = new ArrayList<>();
        sx = 0;
        sy = 0;
        iAnim = 0;
        iMuerte = 0;
        animSpeed = 8;
        iPuerta = 0;
        //iGravity = 0;
        dw = 64;
        protRot = false;
        jump = false;
        secJump = false;
        muerto = false;
        //countJump = 2;
        offsetCamx = 500;
        offsetCamy = 400;
        levels = Levels.getAllLevels();
        levelint = 0;
        actualLevel = levels.getLevels().get(levelint);
        prota = new Prota(actualLevel.getInitialPosProta()[0], actualLevel.getInitialPosProta()[1]);
        protRect = new Rectangle(prota.getX(), prota.getY(), 64, 64);
        bloques = actualLevel.getBloques();
        puertaImg = new Image("img/Puerta.png");
        siluetaLlave = new Image("img/SiluetaLlave.png");
        returnDoor = new Rectangle(actualLevel.getInitialPosProta()[0]-100, actualLevel.getInitialPosProta()[1]-112, 40, 192);
    }

    public void setKeys(boolean[] keys) {
        this.keys = keys;
    }
    
    public int getLevelInt (){
        return levelint;
    }
    
    public boolean setLevelInt (int n) throws IOException {
        if (n < 0 || n > levels.getLevels().size()+1){
            return false;
        }
        if (n == 0){
            this.nuevaPartida();
            return true;
        }
        this.cargarNivel(n);
        return true;
    }
    
    public ArrayList<Bloque> isIntersectingBloque (){
        ArrayList<Bloque> bIntersecando = new ArrayList<>();
        for (Bloque b : bloques){
            if (b.intersects(protRect)){
                bIntersecando.add(b);
            }
        }
        return bIntersecando;
    }
    
    public void showBloques () {
        for (Bloque b : bloques){
            gc.setFill(Color.WHITE);
            gc.fillRect(b.x, b.y, b.width, b.height);
            gc.fillRect(protRect.x, protRect.y, protRect.width, protRect.height);
            gc.setFill(Color.BLACK);
            gc.fillRect(b.x+2, b.y+2, b.width-5, b.height-5);
            gc.fillRect(protRect.x+2, protRect.y+2, protRect.width-4, protRect.height-4);
        }
    }
    
    private void movimiento () throws IOException{
        
        protRect.setLocation(prota.getX() + rotint, prota.getY());
        
        ArrayList<Bloque> cb = isIntersectingBloque();
        
        //Si no se esta presionando nada
        if (!keys[0] && !keys[1]){
            sx = 0;
        }
        
        //Si se pulsa la tecla izquierda
        if (keys[0]){
            offsetCamx = 580;
            if (keys[2]){
                sy = 4*64;
                animSpeed = 5;
                if (prota.getSpeed() < 15){
                    prota.setSpeed(prota.getSpeed()+1);
                }
                prota.moverIzq();
            } else {
                prota.setSpeed(10);
                prota.moverIzq();
            }
            if (!cb.isEmpty()){
                for (Bloque b : cb){
//                    if (b.x+b.width < prota.getX() && prota.getY() > b.y && prota.getY() < b.y+b.height){
//                        prota.moverDer();
//                    }
                    if (prota.getX() > b.x+b.width-32 && prota.getY()+64 > b.y+10 && prota.getY() < b.y+b.height){
                        prota.moverDer();                        
                    }
                }
            }
            
            if (iAnim == animSpeed){
                sx += 64;
            }
            if (sx >= 4*64) {
                sx = 0;
            }
            
            //Si estaba mirando hacia la izquierda
            if (!protRot){
                dw = -64;
                protRot = true;
                prota.setX(prota.getX() + 64);
                rotint -= 64;
            }
        }
        
        //Si se presiona la tecla derecha
        if (keys[1]){
            offsetCamx = 500;
            if (keys[2]){
                sy = 4*64;
                animSpeed = 5;
                if (prota.getSpeed() < 15){
                    prota.setSpeed(prota.getSpeed()+1);
                }
                prota.moverDer();
            } else {
                prota.setSpeed(10);
                prota.moverDer();
            }
            if (!cb.isEmpty()){
                for (Bloque b : cb){
//                    if (b.x > prota.getX() && prota.getY() > b.y && prota.getY() < b.y+b.height){
//                        prota.moverIzq();
//                    }
                    if (prota.getX()+64 <= b.x + 32  && prota.getY()+64 > b.y && prota.getY() < b.y+b.height){
                        prota.moverIzq();
                    }
                }
            }
            if (iAnim == animSpeed){
                sx += 64;
            }
            if (sx >= 4*64) {
                sx = 0;
            }
            
            //Si estaba mirando hacia la izquierda
            if (protRot){
                dw = 64;
                protRot = false;
                prota.setX(prota.getX() - 64);
                rotint += 64;
            }
        }
        
        int aceleracionG = (int)(iGravity*(iGravity*9.0/4.5)/150.0);
        if (aceleracionG > 17){
            aceleracionG = 17;
        }
        if (cb.isEmpty()){
            prota.setY(prota.getY()+ aceleracionG);
        } else {
            for (Bloque b : cb){
//                if (prota.getX() > b.x && prota.getX() < b.x+b.width && prota.getY() < b.y) {
                if ((prota.getX()+40 <= b.x+b.width || prota.getX() >= b.x) && prota.getY()+64 < b.y+20 && prota.getY() < b.y){ 
                    jump = false;
                    secJump = false;
                    //countJump = 2;
                    iGravity = 0;
                    prota.setY(b.y-63);
                    offsetCamy = b.y-500;
                } else {                   
                    prota.setY(prota.getY()+ aceleracionG);
                }
            }
        }
        //Si se presiona espacio y no se ha saltado
        if (keys[3] && !jump){
            jump = true;
            iGravity = 0;
            iJump = 0;
            //System.out.println(prota.getX() + " " + prota.getY());
        }
        
        //Si se presiona espacio y no se ha hecho el segundo salto
        if (keys[3] && !secJump && iJump>6){
            secJump = true;
            iGravity = 0;
            iJump = 0;
        }
        
        //Si va a hacer el primer o segundo salto
        if (jump || secJump){
            jump(cb);
        }
        
        //Logica de la llave-puerta
        Rectangle keyRect = new Rectangle(actualLevel.getDoor().getKey().getX(), actualLevel.getDoor().getKey().getY(), 16, 16);
        Rectangle doorRect = new Rectangle(actualLevel.getDoor().getX()+100, actualLevel.getDoor().getY(), 92,192);
        
        if (protRect.intersects(keyRect)){
            actualLevel.getDoor().setClosed(false);
        }
        
        if (protRect.intersects(doorRect) && iPuerta > 25){
            this.cargarNivel(levelint+1);
        }
        
        //Revisar si el personaje se cayó del mapa

        if (prota.getY() > actualLevel.getLimitsCamera()[2]){
            this.morir();
        }
        
        //Si hay una puerta de regreso y entra en ella, lo regresa de nivel
        if (protRect.intersects(returnDoor)){
            cargarNivel(levelint-1);
        }
        
        //Si toca un pincho muere
        for (Pincho p : actualLevel.getPinchos()){
            Rectangle rectPincho;
            switch (p.getRot()){
                case 0:
                    rectPincho = new Rectangle(p.getX(), p.getY()+44, 64, 20);
                    break;
                case 1:
                    rectPincho = new Rectangle(p.getX(), p.getY(), 20, 64);
                    break;
                case 2:
                    rectPincho = new Rectangle(p.getX(), p.getY(), 64, 20);
                    break;
                case 3:
                    rectPincho = new Rectangle(p.getX()+44, p.getY(), 20, 64);
                    break;
                default:
                    rectPincho = new Rectangle(p.getX(), p.getY()+44, 64, 20);
                    break;
            }
            if (protRect.intersects(rectPincho)){
                this.morir();
            }
        }
        
        //Si toca un muercielago muere
        for (Bat b : actualLevel.getBats()){
            Rectangle rectBat = new Rectangle(b.getX(), b.getY(), 128, 64);
            if (protRect.intersects(rectBat)){
                this.morir();
            }
        }
    }
    
    private void guardadoAutomatico (int n) throws IOException {
        File saveFile = new File("savefile.txt");
        saveFile.createNewFile();
        PrintStream out = new PrintStream(saveFile);
        out.print(n);
        out.flush();
        out.close();
    }
    
    private void nuevaPartida () throws IOException{
        levelint = 0;
        actualLevel = levels.getLevels().get(0);
        bloques = actualLevel.getBloques();     
        muertes = new ArrayList<>();
        actualLevel.getDoor().setClosed(true);
        prota.setX(actualLevel.getInitialPosProta()[0]);
        prota.setY(actualLevel.getInitialPosProta()[1]);
        actualLevel.getDoor().setKey(actualLevel.getInitialPosKey()[0], actualLevel.getInitialPosKey()[1]);
        returnDoor = new Rectangle(actualLevel.getInitialPosProta()[0]-100, actualLevel.getInitialPosProta()[1]-112, 40, 192);
        iPuerta = 0;
        this.guardadoAutomatico(0);
    }
    
    private void cargarNivel (int lvl) throws IOException {
        if (levels.getLevels().size() < lvl+1){
            return;
        }
        actualLevel = levels.getLevels().get(lvl);
        bloques = actualLevel.getBloques();
        if (lvl >= levelint){
            this.guardadoAutomatico(lvl);
            actualLevel.getDoor().setClosed(true);
            prota.setX(actualLevel.getInitialPosProta()[0]);
            prota.setY(actualLevel.getInitialPosProta()[1]);
            actualLevel.getDoor().setKey(actualLevel.getInitialPosKey()[0], actualLevel.getInitialPosKey()[1]);
            iPuerta = 0;
        } else {
            prota.setX(actualLevel.getDoor().getX()-10-Math.max(0, dw));
            prota.setY(actualLevel.getDoor().getY()+50);
            actualLevel.getDoor().setClosed(false);
            actualLevel.getDoor().setKey((int)camara.getTranslateX()+ (1368/2) + offsetCamx + Math.min(rotint, 0) + 50, (int)camara.getTranslateY()+32);
            iPuerta = 26;
        }        
        muertes = new ArrayList<>();
        returnDoor = new Rectangle(actualLevel.getInitialPosProta()[0]-100, actualLevel.getInitialPosProta()[1]-112, 40, 192);
        levelint = lvl;
    }
    
    private void jump (ArrayList<Bloque> cb) {
        sy = 64;
        if (!cb.isEmpty()){
            for (Bloque b : cb){
                if (prota.getY()-16 < b.y+b.height && !(prota.getY()<b.y) && (prota.getX()+32 <= b.x+b.width && prota.getX() >= b.x) && prota.getY() > b.y){
                    prota.saltar(-16);
                }
            }
        }
            if (iJump < 3){
                prota.saltar(16);
                sx = 0;
            } else if (iJump < 6){
                prota.saltar(16);
                sx = 64;
            } else if (iJump < 9){
                prota.saltar(16);
                sx = 2*64;
            }
            protRect.setLocation(prota.getX()+rotint, prota.getY());
    }
    
    private void morir () {
        muerto = true;       
    }

    @Override
    public void handle(long l) {
        
        //Coloreo el fondo de negro
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 4000, 4000);
        
        //Numeros que definen las animaciones y ayuda con la gravedad/salto
        sy = 0;
        iAnim++;
        iJump++;
        iGravity++;
        animSpeed = 8;
        
        if(!muerto){
        
        try {
            //Metodo que analiza el movimiento del personaje y revisa las colisiones.
            movimiento();
        } catch (IOException ex) {
            Logger.getLogger(GameLoop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        }
        
        //Se dibuja en el canvas la imagen del nivel, la llave, la puerta y el
        //personaje.
        gc.drawImage(actualLevel.getImg(), 0, 0);
        if (!actualLevel.getDoor().isClosed()){
            //Si la puerta deja de estar cerrada, la llave se dibuja en la esquina superior derecha, y se empieza
            //la animacion de la puerta.
            actualLevel.getDoor().setKey((int)camara.getTranslateX()+ (1368/2) + offsetCamx + Math.min(rotint, 0) + 50, (int)camara.getTranslateY()+32);
            if (iPuerta < 26){
                iPuerta++;
            }
            if (iPuerta < 5){
                gc.drawImage(puertaImg, 192,0, 192, 192, actualLevel.getDoor().getX(), actualLevel.getDoor().getY(), 192, 192);
            } else if (iPuerta < 10){
                gc.drawImage(puertaImg, 192+192,0, 192, 192, actualLevel.getDoor().getX(), actualLevel.getDoor().getY(), 192, 192);
            } else if (iPuerta < 15){
                gc.drawImage(puertaImg, 0,192, 192, 192, actualLevel.getDoor().getX(), actualLevel.getDoor().getY(), 192, 192);
            } else if (iPuerta < 20){
                gc.drawImage(puertaImg, 192,192, 192, 192, actualLevel.getDoor().getX(), actualLevel.getDoor().getY(), 192, 192);
            } else if (iPuerta < 25){
                gc.drawImage(puertaImg, 192+192,192, 192, 192, actualLevel.getDoor().getX(), actualLevel.getDoor().getY(), 192, 192);
            } else {
                gc.drawImage(puertaImg, 192+192+192,192, 192, 192, actualLevel.getDoor().getX(), actualLevel.getDoor().getY(), 192, 192);
            }
        } else {
            gc.drawImage(puertaImg, 0,0, 192, 192, actualLevel.getDoor().getX(), actualLevel.getDoor().getY(), 192, 192);
        }
        gc.drawImage(puertaImg, 640, 64, 64, 64, actualLevel.getDoor().getKey().getX(), actualLevel.getDoor().getKey().getY(),64,64);
        
         //Se dibuja una calabera donde murio el personaje.
        for (int[] muerte : muertes){
            gc.drawImage(protaImgMap, 3*64, 2*64, 64, 64, muerte[0], muerte[1], muerte[2], 64);
        }
        
        //Dibuja todos los pinchos
        for (Pincho p : actualLevel.getPinchos()){
            gc.drawImage(p.getImg(),p.getRot()*64, 0, 64, 64, p.getX(), p.getY(), 64, 64);
        }
        
        //Dibuja todos los murcielagos
        for (Bat b : actualLevel.getBats()){
            b.draw(gc);
        }
        
        //Se dibujan las antorchas
        for (Antorcha a : actualLevel.getAntorchas()){
            a.draw(gc);
        }
        
        //Se dibuja la silueta de la llave si la puerta esta cerrada
        if (actualLevel.getDoor().isClosed()){
            gc.drawImage(siluetaLlave, (int)camara.getTranslateX()+ (1368/2) + offsetCamx + Math.min(rotint, 0) + 50, (int)camara.getTranslateY()+32);
        }
        
        //Se dibuja el personaje, si ve una animacion de muerte
        if (!muerto){
        gc.drawImage(protaImgMap, sx, sy, 64, 64, prota.getX(), prota.getY(), dw, 64);
        } else {
            gc.drawImage(protaImgMap, (iMuerte/5)*64, 128, 64, 64, prota.getX(), prota.getY(), dw, 64);
            iMuerte++;
            if (iMuerte > 20){
                iMuerte = 0;
                muertes.add(new int[] {prota.getX(), prota.getY(), dw});
                prota.setX(actualLevel.getInitialPosProta()[0]+20-Math.min(0, dw));
                prota.setY(actualLevel.getInitialPosProta()[1]);
                actualLevel.getDoor().setClosed(true);
                actualLevel.getDoor().setKey(actualLevel.getInitialPosKey()[0], actualLevel.getInitialPosKey()[1]);
                iPuerta = 0;
                muerto = false;
            }
        }
        
        //Se repite el iterador de animacion cada animSpeed
        if (iAnim >= animSpeed){
            iAnim = 0;
        }
        
        //Esto hace que la camara siga al personaje. Falta mejorar
        
        if (camara.getTranslateX()+offsetCamx < prota.getX()+32+(dw*3)){
            double dist = (prota.getX()+32+(dw*3))- (camara.getTranslateX()+offsetCamx);
            camara.setTranslateX(camara.getTranslateX()+(dist/40));
        }
        
        if (camara.getTranslateX()+offsetCamx > prota.getX()+32+(dw*3)){
            double dist = (camara.getTranslateX()+offsetCamx)-(prota.getX()+32+(dw*3));
            camara.setTranslateX(camara.getTranslateX()-(dist/40));
        }
        
        if (camara.getTranslateY()+400 > prota.getY()+32){
            double dist = (camara.getTranslateY()+400)-(prota.getY()+32);
            camara.setTranslateY(camara.getTranslateY()-(dist/40));
        }
        
        if (camara.getTranslateY()+400 < prota.getY()+32){
            double dist = (prota.getY()+32)-(camara.getTranslateY()+400);
            camara.setTranslateY(camara.getTranslateY()+(dist/40));
        }
        
        if (camara.getTranslateX() < 0){
            camara.setTranslateX(0);
        }
        
        if (camara.getTranslateY() < 0){
            camara.setTranslateY(0);
        }
        

//        showBloques();

    }
}

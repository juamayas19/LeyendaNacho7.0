/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leyendadenacho;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;

/**
 *
 * @author LENOVO
 */
public class Fondo {
    private int x;
    private int y;
    private Image place;

    public Fondo(int x, int y, String place) throws FileNotFoundException {
        this.x = x;
        this.y = y;
        FileInputStream archivo = new FileInputStream(place);
        this.place = new Image(archivo);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getPlace() {
        return place;
    }

    
    

    

    
    

   
    
    public void up (){
    this.y++;

}
    public void down(){
    this.y--;
    }
    
    
    public void right (){
    this.x--;

}
    public void left(){
    this.x++;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leyendadenacho;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author Juan Camilo
 */
public class Chaza {
    private int alto;
    private int ancho;
    private Image image;
    private ArrayList<Items>Inventory;
    
    public Chaza(int alto, int ancho) throws FileNotFoundException{
        this.alto = alto;
        this.ancho = ancho;
        FileInputStream image = new FileInputStream ("src/image/Inventario_1.png");
        this.image = new Image(image);
        this.Inventory = new ArrayList<Items>();
    }
    public int getAlto() {
        return alto;
    }
    public int getAncho() {
        return ancho;
    }
    public Image getImage() {
        return image;
    }
    public ArrayList<Items> getInventory() {
        return Inventory;
    }
}

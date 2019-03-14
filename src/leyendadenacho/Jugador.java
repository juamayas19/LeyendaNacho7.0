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
public class Jugador {
    private int atack;
    private int defense;

    private Chaza inventario;
    private int luks;
    private int x;
    private int y;
    private Image imagen;
    private int alto;
    private int ancho;
    public Jugador(int alto, int ancho,int x, int y) throws FileNotFoundException {
        this.luks=0;
        this.alto=alto;
        this.ancho=ancho;
        this.x=x;
        this.y=y;
        FileInputStream image = new FileInputStream("src/image/prota.png");
        this.imagen=new Image(image);
        this.inventario= new Chaza(20,20);
        
    }
    public void buy(Chaza chaza, int i){
        String name= chaza.getInventory().get(i).getName();
        int atack= chaza.getInventory().get(i).getAtack();
        int value= chaza.getInventory().get(i).getValue();
        int defense= chaza.getInventory().get(i).getDefense();
        Image image= chaza.getInventory().get(i).getImage();
        Items item = new Items(name, atack, value, defense, image);
        this.inventario.getInventory().add(item);
        chaza.getInventory().remove(i);
    }

    public int getAlto() {
        return alto;
    }
    public void entregar(Items item){
        this.inventario.getInventory().remove(item);
    }
    public int getAncho() {
        return ancho;
    }

    public void setAtack(int atack) {
        this.atack = atack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setLuks(int luks) {
        this.luks = luks;
    }
    
    public int getAtack() {
        return atack;
    }

    public int getDefense() {
        return defense;
    }

    public Chaza getInventario() {
        return inventario;
    }

    public int getLuks() {
        return luks;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagen() {
        return imagen;
    }
    
    public void useItem(int i){
        this.atack+=this.inventario.getInventory().get(i).getAtack();
        this.defense+=this.inventario.getInventory().get(i).getDefense();
        this.inventario.getInventory().remove(i);
    }
    

   
    

    
}

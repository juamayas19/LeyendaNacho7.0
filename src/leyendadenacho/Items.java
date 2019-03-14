/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leyendadenacho;

import javafx.scene.image.Image;

/**
 *
 * @author Juan Camilo
 */
public class Items {
    private String name;
    private int atack;
    private int value;
    private int defense;
    private Image image;

    public Items(String name, int atack, int value, int defense, Image image) {
        this.name = name;
        this.atack = atack;
        this.value = value;
        this.defense = defense;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getAtack() {
        return atack;
    }

    public int getValue() {
        return value;
    }

    public int getDefense() {
        return defense;
    }

    public Image getImage() {
        return image;
    }
}

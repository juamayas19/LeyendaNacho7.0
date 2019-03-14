/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leyendadenacho;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class LeyendaDeNacho extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane layout  = new Pane();  
        Canvas canvas = new Canvas(700,600);
        
        layout.getChildren().add(canvas);
        Scene escena = new Scene(layout, 700, 600, Color.web("rgb(99, 111, 61)"));
        
              
        
        
        
        GraphicsContext lapiz = canvas.getGraphicsContext2D();
        canvas.setScaleX(2.5);
        canvas.setScaleY(2.5);
        Game juego = new Game(escena, lapiz);
        juego.start();
        
        primaryStage.setScene(escena);
        primaryStage.setTitle("La Leyenda De Nacho");
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        Application.launch(args);
        
    }
}
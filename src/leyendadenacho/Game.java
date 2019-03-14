 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leyendadenacho;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author LENOVO
 */
public class Game extends AnimationTimer{
    
    private GraphicsContext lapiz;
    private  Scene escena;
    private Chaza chaza = new Chaza(50,50);
    private Jugador jugador;
    private Fondo fondo;
    private ArrayList<Fondo> npc= new ArrayList();
    
    private Image prota;
    private double secuencia =0;
    private int numero ; 
    
    private ArrayList<String> pulsacionTeclado = null;   
    
    

    
    public Game(Scene escena, GraphicsContext lapiz) throws FileNotFoundException{
        this.lapiz = lapiz;
        this.escena= escena;
        this.jugador= new Jugador(16,18,350,300);
        FileInputStream read = new FileInputStream("src/image/carnet.png");
        Image image_1= new Image(read);
        FileInputStream read3 = new FileInputStream("src/image/manzana.png");
        Image image_3= new Image(read3);
        ArrayList<Items> items= new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            chaza.getInventory().add(new Items("Manzana",0, 2, 2,image_3));
        }
        FileInputStream read2 = new FileInputStream("src/image/trabajo.png");
        Image image_2= new Image(read2);
        
        jugador.getInventario().getInventory().add(new Items("Carnet", 0,0,0,image_1));
        jugador.getInventario().getInventory().add(new Items("Trabajo", 0,0,0,image_2));
        this.fondo= new Fondo(-250, -500,"src/image/cheruido.png" );
        this.npc.add(new Fondo(200,100, "src/image/Jaider Perea.png")) ;
        this.npc.add(new Fondo(310,400, "src/image/Vegetariano.png")) ;
        this.npc.add(new Fondo(345,500, "src/image/feminista1.png")) ;
        this.npc.add(new Fondo(305,310, "src/image/Cuentero.png")) ;
        this.npc.add(new Fondo(222,143, "src/image/metacho.png")) ;
        this.npc.add(new Fondo(370,225, "src/image/gomelo1.png")) ;
        this.npc.add(new Fondo(390,535, "src/image/chaza.png")) ;
        this.npc.add(new Fondo(413, 543, "src/image/Apple_Tree.png"));
        FileInputStream archivoj = new FileInputStream("src/image/prota.png");
        this.prota= new Image(archivoj);
        pulsacionTeclado = new ArrayList<>();
        
               
        escena.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    if ( !pulsacionTeclado.contains(code) )
                        pulsacionTeclado.add( code );
                }
            });

        escena.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    pulsacionTeclado.remove( code );
                }
            });

    }
   public void mostrarDinero(int luks){
       lapiz.setFill(Color.YELLOW);
       lapiz.fillRoundRect(425, 195, 50 , 50, 55, 55);
       lapiz.setStroke(Color.BLACK);
       lapiz.strokeText("Luks: " + luks, 436, 225, 30);
   }
    public void mostrarTexto (String texto){
              lapiz.setFill(Color.WHITE);
              lapiz.fillRoundRect(220, 360, 260 , 55, 10, 10);
              //lapiz.fillRect(220, 360, 260, 55);
              lapiz.setStroke(Color.BLUE);
              lapiz.strokeRoundRect(222, 363, 256 , 50, 10, 10);
              lapiz.setStroke(Color.BLACK);
              lapiz.strokeText(texto, 225, 375, 250);
    }
    public void mostrarTextoGrande (String texto,  int x,int  y){
              lapiz.setFill(Color.WHITE);
              lapiz.fillRoundRect(220, 200, x , y, 10, 10);
              //lapiz.fillRect(220, 360, 260, 55);
              lapiz.setStroke(Color.BLUE);
              lapiz.strokeRoundRect(222, 205, x-4 , y-4, 10, 10);
              lapiz.setStroke(Color.BLACK);
              lapiz.strokeText(texto, 225, 227, 250);
    }
    

    public void protaShape (){
     lapiz.setStroke(Color.TRANSPARENT);
     lapiz.strokeRect(350, 300, jugador.getAncho(), jugador.getAlto());
    }
    @Override
    public void handle(long now) {
        boolean intro=false;
        if(intro==false){
            mostrarTextoGrande("Bienvenido a la leyenda de nacho", 256, 256);
            if(pulsacionTeclado.contains("A")){
                intro=true;
            }
            
        }
        lapiz.drawImage(fondo.getPlace(), fondo.getX(), fondo.getY());
        for (int i = 0; i < npc.size(); i++) {
            lapiz.drawImage(npc.get(i).getPlace(), npc.get(i).getX(), npc.get(i).getY());
        }
        boolean colision_detectada = false;
        boolean colision_npc=false;
        lapiz.setFill(Color.TRANSPARENT);
        protaShape();
        Shape leon_de_greiff = new Rectangle(fondo.getX()+812+82, fondo.getY()+757+70, 143, 217);
        Shape s_prota = new Rectangle(350, 300, 18, 18);
        Shape intersection = SVGPath.intersect(leon_de_greiff, s_prota);
         mostrarDinero(jugador.getLuks());
        if (s_prota.intersects(leon_de_greiff.getBoundsInParent())) {
            colision_detectada = true;

            // stop();
         } 
        if(s_prota.intersects(npc.get(0).getX(),npc.get(0).getY(), 16,18)){
            mostrarTexto("Mira vé, que frío está haciendo en la nevera, ¿oís?");
        }
        if(s_prota.intersects(npc.get(1).getX(),npc.get(1).getY(), 16,18)){
            mostrarTexto("Uy vecino, ando vendiendo unos deliciosos sándwiches vegetarianos");
        }
        if(s_prota.intersects(npc.get(2).getX(),npc.get(2).getY(), 16,18)){
            mostrarTexto("¡LUCHAD POR VUESTROS DERECHOS!");
        }
        if(s_prota.intersects(npc.get(3).getX(),npc.get(3).getY(), 16,18)){
            mostrarTexto("Poemas a mil");
        }
        if(s_prota.intersects(npc.get(4).getX(),npc.get(4).getY(), 16,18)){
            mostrarTexto("¡LARGA VIDA AL METAL¡");
        }
        if(s_prota.intersects(npc.get(5).getX(),npc.get(5).getY(), 16,18)){
            mostrarTexto("¿Hiciste el trabajo con Percha? Pago bien weon (Selecciona R para preguntar)");
            if(pulsacionTeclado.contains("R")){
                mostrarTexto("Para entregar tu trabajo abre el inventario y entregalo con E");
                
            }
            
            if(jugador.getLuks()<20){
            if(pulsacionTeclado.contains("E")){
                    jugador.entregar(jugador.getInventario().getInventory().get(1));
                    jugador.setLuks(jugador.getLuks()+20);
                }
        }}
        if(s_prota.intersects(npc.get(6).getX(),npc.get(6).getY(), 18,20)){
            mostrarTexto("Bienvenido a la chaza, presiona R para entrar");
            if(pulsacionTeclado.contains("R")){
                mostrarTexto("Para comprar, presiona el número de casilla del producto y luego C");
                lapiz.drawImage(chaza.getImage(), npc.get(6).getX()+40, npc.get(6).getY()-50);
                lapiz.drawImage(chaza.getInventory().get(0).getImage(), npc.get(6).getX()+55, npc.get(6).getY()-40);
                for (int i = 0; i < chaza.getInventory().size(); i++) {
                if(pulsacionTeclado.contains("H")){
                    mostrarTexto("Nombre: "+ chaza.getInventory().get(i).getName()+" Valor: "+chaza.getInventory().get(i).getValue());
                    if(pulsacionTeclado.contains("C")){
                    jugador.buy(chaza, i);
                    
                }
                }
                
                }
            }
        }
        
                if (pulsacionTeclado.contains("LEFT")){
                  if(colision_detectada == false){fondo.left();
                  }else{for (int i = 0; i < 20; i++) {
                  fondo.right();
                      }
                    }
                  for (int i = 0; i < npc.size(); i++) {
                        npc.get(i).left();
                    }
                  this.secuencia= 6;
                  if(this.numero % 10 == 0){
                if(this.secuencia == 8){
                  this.secuencia = 6;
                }else{
                  this.secuencia++;
                }
          }
                }
                
                if (pulsacionTeclado.contains("RIGHT")){
                  if(colision_detectada == false){fondo.right();
                  }else{for (int i = 0; i < 20; i++) {
                  fondo.left();
                      }
                    }
                    for (int i = 0; i < npc.size(); i++) {
                        npc.get(i).right();
                    }
                  this.secuencia=9;
                  if(this.numero % 10 == 0){
                if(this.secuencia == 11){
                  this.secuencia = 9;
                }else{
                  this.secuencia++;
                }
          }
                }
                if (pulsacionTeclado.contains("UP")){
                  if(colision_detectada == false){fondo.up();
                  }else{for (int i = 0; i < 20; i++) {
                  fondo.down();
                      }
                    }
                  for (int i = 0; i < npc.size(); i++) {
                        npc.get(i).up();
                    }
                  this.secuencia=0;
                  
                  if(this.numero % 20 == 0){
                     if(this.secuencia == 2){
                  this.secuencia = 0;
                }else{
                  this.secuencia++;
                }
          }
                }
                if (pulsacionTeclado.contains("DOWN")){
                  if(colision_detectada == false){fondo.down();
                  }else{for (int i = 0; i < 20; i++) {
                  fondo.up();
                      }
                    }
                 
                  for (int i = 0; i < npc.size(); i++) {
                        npc.get(i).down();
                    }
                  this.secuencia= 3;
                  
                  if(this.numero % 20 == 0){
                if(this.secuencia == 5){
                  this.secuencia = 3;
                }else{
                  this.secuencia++;
                }
          }
                }       
                
                if (pulsacionTeclado.contains("F")){
                    mostrarTexto("Hola");
                } 
                
                if (pulsacionTeclado.contains("I")){
                    
                    lapiz.drawImage(jugador.getInventario().getImage(), 250, 250);
                    lapiz.drawImage(jugador.getInventario().getInventory().get(0).getImage(), 263, 263);
                for (int i = 1; i < jugador.getInventario().getInventory().size(); i++) {
                    int contador=263;    
                    if("trabajo".equals(jugador.getInventario().getInventory().get(1).getName())){
                        lapiz.drawImage(jugador.getInventario().getInventory().get(1).getImage(), 288, 263);
                    }
                    lapiz.drawImage(jugador.getInventario().getInventory().get(i).getImage(), contador+25, 263);

                    }    
                }
                
        
        
        lapiz.drawImage(jugador.getImagen(),18*this.secuencia, 0, 18, 18, jugador.getX(), jugador.getY(), 18, 18);
        
             this.numero++;
             
             

        }
               
        
        
    }


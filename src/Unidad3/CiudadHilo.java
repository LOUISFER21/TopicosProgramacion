/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Unidad3;

import java.util.concurrent.Semaphore;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author fersa
 */
public class CiudadHilo extends JFrame
{
    PanelFondo contenedor;
    JLabel lblcarrito, lblcarrito2;
    Icon carro, carro1;
    int  x=30, y=260, x2=345, y2=30;
    Semaphore sh1, sh2, sh3, sh4, sh5, sh6;
    
    CiudadHilo()
    {
        contenedor= new PanelFondo("calle.png");
        contenedor.setLayout(null);
        carro=new ImageIcon("auto3.gif");
        carro1= new ImageIcon("auto1.gif");
        
        lblcarrito=new JLabel(carro);
        lblcarrito.setBounds(x,y,60, 40);
        lblcarrito2=new JLabel(carro1);
        lblcarrito2.setBounds(x2, y2, 60, 40);
        
        sh1 = new Semaphore(0, true);
        sh2 = new Semaphore(0, true);
        sh3 = new Semaphore(0, true);
        sh4 = new Semaphore(0, true);

        
        new Thread(new carro3(sh1)).start();
        new Thread(new carro3(sh1)).stop();
        new Thread(new carro3(sh2)).start();
        new Thread(new carro3(sh2)).stop();
        new Thread(new carro3(sh3)).start();
        new Thread(new carro3(sh4)).stop();
        new Thread(new carro4(sh4)).start();
        
        contenedor.add(lblcarrito);
        contenedor.add(lblcarrito2);
        
        add(contenedor);
        setSize(750, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args [])
    {
        new CiudadHilo();
    }
    class carro1 extends Thread {

        Semaphore sh1;
        Semaphore sh2;

        public carro1(Semaphore sh1, Semaphore sh2)
        {
            this.sh1 = sh1;
            this.sh2 = sh2;
        }

        public void run() 
        {
            while (x < 280) 
            {
                try 
                {
                    Thread.sleep((int) (Math.random() * 400));
                } 
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }
                x += 10;
                lblcarrito.setLocation(x, y);
            }
            sh2.release();
        }
    }
    class carro2 extends Thread {

        Semaphore sh2;
        Semaphore sh3;

        public carro2(Semaphore sh2, Semaphore sh3) {
            this.sh2 = sh2;
            this.sh3 = sh3;
        }

        public void run() 
        {
            while (y2 < 230) 
            {
                try 
                {
                    Thread.sleep((int) (Math.random() * 400));
                } 
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }
                y2 += 10;
                lblcarrito2.setLocation(x2, y2);
            }
            sh3.release();
        }
    }
    class carro3 extends Thread {

        Semaphore sh3;

        public carro3(Semaphore sh3) {
            this.sh3 = sh3;
            
        }

        public void run() 
        {
            while (x < 640) 
            {
                try 
                {
                    Thread.sleep((int) (Math.random() * 400));
                } 
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }
                x += 10;
                lblcarrito.setLocation(x, y);
            }
        }
    }
    class carro4 extends Thread {

        Semaphore sh4;
        
        public carro4(Semaphore sh4) {
            
            this.sh4 = sh4;
        }

        public void run() 
        {
            while (y2 < 460) 
            {
                try 
                {
                    Thread.sleep((int) (Math.random() * 400));
                } 
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }
                y2 += 10;
                lblcarrito2.setLocation(x2, y2);
            }
            
        }
    }
}

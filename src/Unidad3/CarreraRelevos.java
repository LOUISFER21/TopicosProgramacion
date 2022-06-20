
package Unidad3;
 import javax.swing.JLabel;
import java.awt.*;
import java.util.concurrent.Semaphore;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class CarreraRelevos extends JFrame
{

    PanelFondo contenedor;
    Icon caballo, caballo2, caballo3, caballo4, caballo5, caballo6;
    JLabel lbl_potro1, lbl_potro2, lbl_potro3, lbl_potro4, lbl_potro5,lbl_potro6 ;
    int x1 = 55, x2 = 555, y1 = 20, y2 = 50, x3 = 55, y3 = 170, x4 =550, x5=55, x6=550, y4 = 190, y5= 320, y6=350;
    Semaphore sh1, sh2, sh3, sh4, sh5, sh6;
    int  cont=0;
    public CarreraRelevos() {
        contenedor = new PanelFondo("fondocaballos.png");
        contenedor.setLayout(null);
        caballo = new ImageIcon("caballo102.gif");
        caballo2 = new ImageIcon("caballo102.gif");
        caballo3 = new ImageIcon("caballo102.gif");
        caballo4 = new ImageIcon("caballo102.gif");
        caballo5 = new ImageIcon("caballo102.gif");
        caballo6 = new ImageIcon("caballo102.gif");
        
        lbl_potro1 = new JLabel(caballo);
        lbl_potro1.setBounds(x1, y1, 64, 64);
        lbl_potro2 = new JLabel(caballo2);
        lbl_potro2.setBounds(x2, y2, 64, 64);
        lbl_potro3 = new JLabel(caballo3);
        lbl_potro3.setBounds(x3, y3, 64, 64);
        lbl_potro4 = new JLabel(caballo3);
        lbl_potro4.setBounds(x4, y4, 64, 64);
        lbl_potro5 = new JLabel(caballo3);
        lbl_potro5.setBounds(x5, y5, 64, 64);
        lbl_potro6 = new JLabel(caballo3);
        lbl_potro6.setBounds(x6, y6, 64, 64);

        sh1 = new Semaphore(0, true);
        sh2 = new Semaphore(0, true);
        sh3 = new Semaphore(0, true);
        sh4 = new Semaphore(0, true);
        sh5 = new Semaphore(0, true);
        sh6 = new Semaphore(0, true);

        //Ejecucion de hilos
        new Thread(new caballo1(sh1, sh2)).start();
        new Thread(new caballo2(sh2, sh3)).start();
        new Thread(new caballo3(sh3, sh4)).start();
        new Thread(new caballo4(sh4, sh5)).start();
        new Thread(new caballo5(sh5, sh6)).start();
        new Thread(new caballo6(sh6)).start();


        contenedor.add(lbl_potro1);
        contenedor.add(lbl_potro2);
        contenedor.add(lbl_potro3);
        contenedor.add(lbl_potro4);
        contenedor.add(lbl_potro5);
        contenedor.add(lbl_potro6);
        add(contenedor);
        setSize(1217, 517);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new CarreraRelevos();
    }

    class caballo1 extends Thread {

        Semaphore sh1;
        Semaphore sh2;

        public caballo1(Semaphore sh1, Semaphore sh2) {
            this.sh1 = sh1;
            this.sh2 = sh2;
        }

        public void run() 
        {
            while (x1 < 550) 
            {
                try 
                {
                    Thread.sleep((int) (Math.random() * 400));
                } 
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }
                x1 += 10;
                lbl_potro1.setLocation(x1, y1);
            }
            sh2.release();
        }
    }

    class caballo2 extends Thread {

        Semaphore sh2;
        Semaphore sh3;


        public caballo2(Semaphore sh2, Semaphore sh3)
        {
            this.sh2 = sh2;
            this.sh3 = sh3;

        }

        public void run() {
            try{
                sh2.acquire();
            }catch(Exception e)
            {
                System.out.println("Error : " + e.getMessage());
            }
            while (x2 < 1100) 
            {
                try 
                {
                    
                    Thread.sleep((int) (Math.random() * 400));
                } 
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }
                x2 += 10;
                lbl_potro2.setLocation(x2, y2);
            }
            cont ++;
            JOptionPane.showMessageDialog(null, "Caballo 1 quedo en lugar: "+ cont);
            
            //sh3.release();
        }
    }
    class caballo3 extends Thread {

        Semaphore sh3;
        Semaphore sh4;

        public caballo3(Semaphore sh3, Semaphore sh4) {
            this.sh3 = sh3;
            this.sh4 = sh4;
        }
        
        public void run() 
        {
            /*try{
                sh3.acquire();
            }catch(Exception e)
            {
                System.out.println("Error : " + e.getMessage());
            }*/
            while (x3 < 550) 
            {
                try 
                {
                    //sh3.acquire();
                    Thread.sleep((int) (Math.random() * 400));
                } 
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }
                x3 += 10;
                lbl_potro3.setLocation(x3, y3);
            }
            sh4.release();
        }
    }
    class caballo4 extends Thread {

        Semaphore sh4;
        Semaphore sh5;

        public caballo4(Semaphore sh4, Semaphore sh5) {
            this.sh4 = sh4;
            this.sh5 = sh5;
        }
        
        public void run() 
        {
            try{
                sh4.acquire();
            }catch(Exception e)
            {
                System.out.println("Error : " + e.getMessage());
            }
            while (x4 < 1100) 
            {
                try 
                {
                    //sh3.acquire();
                    Thread.sleep((int) (Math.random() * 400));
                } 
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }
                x4 += 10;
                lbl_potro4.setLocation(x4, y4);
            }
            cont ++;
            JOptionPane.showMessageDialog(null, "Caballo 2 quedo en lugar: "+ cont);
            
            sh5.release();
        }
    }
    class caballo5 extends Thread {

        Semaphore sh5;
        Semaphore sh6;

        public caballo5(Semaphore sh5,Semaphore sh6) {
            this.sh5 = sh5;
            this.sh6 = sh6;
        }
        
        public void run() 
        {
            /*try{
                sh5.acquire();
            }catch(Exception e)
            {
                System.out.println("Error : " + e.getMessage());
            }*/
            while (x5 < 550) 
            {
                try 
                {
                    //sh3.acquire();
                    Thread.sleep((int) (Math.random() * 400));
                } 
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }
                x5 += 10;
                lbl_potro5.setLocation(x5, y5);
            }
            sh6.release();
        }
    }
    class caballo6 extends Thread {

        Semaphore sh6;

        public caballo6(Semaphore sh6) {
            this.sh6 = sh6;
        }
        
        public void run() 
        {
            try{
                sh6.acquire();
            }catch(Exception e)
            {
                System.out.println("Error : " + e.getMessage());
            }
            while (x6 < 1100) 
            {
                try 
                {
                    //sh3.acquire();
                    Thread.sleep((int) (Math.random() * 400));
                } 
                catch (Exception e) 
                {
                    System.out.println("Error : " + e.getMessage());
                }
                x6 += 10;
                lbl_potro6.setLocation(x6, y6);
            }
            cont ++;
            JOptionPane.showMessageDialog(null, "Caballo 1 quedo en lugar: "+ cont);
            
        }
    }
}


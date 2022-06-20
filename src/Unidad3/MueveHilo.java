package Unidad3;
import java.awt.*;
import javax.swing.*;
public class MueveHilo extends JFrame 
{
    PanelFondo contenedor;
    JLabel lblcarrito, lblcarrito2;
    
    Icon carro, carroA, carroB, carroC, carrop, carropA, carropB, carropC;
    
    int  x=70, y=55, x2=70, y2=60;
    correauto1 auto1;
    correauto2 auto2;
    MueveHilo()
    {
        contenedor= new PanelFondo("fondopista.png");
        contenedor.setLayout(null);
        carro=new ImageIcon("carrito.png");
        carroA = new ImageIcon("carritoabajo.png");
        carroB=new ImageIcon("carrito2.png");
        carroC=new ImageIcon("carritoarriba.png");
        
        carrop=new ImageIcon("carritop.png");
        carropA = new ImageIcon("carritoabajop.png");
        carropB=new ImageIcon("carrito2p.png");
        carropC=new ImageIcon("carritoarribap.png");
        
        lblcarrito=new JLabel(carro);
        lblcarrito.setBounds(x,y,60, 40);
        lblcarrito2=new JLabel(carrop);
        lblcarrito2.setBounds(x2, y2, 60, 40);
        
        contenedor.add(lblcarrito);
        contenedor.add(lblcarrito2);
        
        add(contenedor);
        
        auto1 = new correauto1();
        auto1.start(); //mover auto
        auto2 = new correauto2();
        auto2.start();
        
        setSize(750, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[])
    {
        MueveHilo mh = new MueveHilo();
        
    }
    class correauto1 extends Thread
    {
        
        public void run()
        {
            while (true)
            {
                while(x<600)
                {
                    
                    try
                    {
                        Thread.sleep(10);
                        //x+=5;
                        x+=(int)(Math.random()*40);
                        
                        lblcarrito.setLocation(x,y);
                        lblcarrito.setBounds(x,y,60, 40);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error hilo: "+ e.getMessage());
                    }              
                }
                lblcarrito.setIcon(carroA);
                while(y<420)
                {
                    try
                    {
                        Thread.sleep(10);
                        y+=5;
                        lblcarrito.setLocation(x,y);
                        lblcarrito.setBounds(x,y, 40,60);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error hilo: "+ e.getMessage());
                    }              
                }
                lblcarrito.setIcon(carroB);
                while(x>70)
                {
                    try
                    {
                        Thread.sleep(10);
                        x-=5;
                        lblcarrito.setLocation(x,y);
                        lblcarrito.setBounds(x,y,60, 40);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error hilo: "+ e.getMessage());
                    }              
                }
                lblcarrito.setIcon(carroC);
                while(y>55)
                {
                    try
                    {
                        Thread.sleep(10);
                        y-=5;
                        lblcarrito.setLocation(x,y);
                        lblcarrito.setBounds(x,y, 40,60);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error hilo: "+ e.getMessage());
                    }              
                }
                lblcarrito.setIcon(carro);
            }
        }
    }
    class correauto2 extends Thread
    {
        
        public void run()
        {
            while (true)
            {
                while(x2<600)
                {
                    try
                    {
                        Thread.sleep(30);
                        //x2+=5;
                        x2 +=(int)(Math.random()*40);
                        lblcarrito2.setLocation(x2,y2);
                        lblcarrito2.setBounds(x2, y2, 60, 40);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error hilo: "+ e.getMessage());
                    }              
                }
                lblcarrito2.setIcon(carropA);
                while(y2<420)
                {
                    try
                    {
                        Thread.sleep(10);
                        y2+=5;
                        lblcarrito2.setLocation(x2,y2);
                        lblcarrito2.setBounds(x2, y2, 40, 60);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error hilo: "+ e.getMessage());
                    }              
                }
                lblcarrito2.setIcon(carropB);
                while(x2>70)
                {
                    try
                    {
                        Thread.sleep(10);
                        x2-=5;
                        lblcarrito2.setLocation(x2,y2);
                        lblcarrito2.setBounds(x2, y2, 60, 40);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error hilo: "+ e.getMessage());
                    }              
                }
                lblcarrito2.setIcon(carropC);
                while(y2>55)
                {
                    try
                    {
                        Thread.sleep(10);
                        y2-=5;
                        lblcarrito2.setLocation(x2,y2);
                        lblcarrito2.setBounds(x2, y2, 40, 60);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error hilo: "+ e.getMessage());
                    }              
                }
                lblcarrito2.setIcon(carrop);
            }
        }
    }
}

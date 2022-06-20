
package Unidad3;

import java.util.concurrent.Semaphore;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NaveHilo extends JFrame
{
    PanelFondo contenedor;
    JLabel lblcarrito,lblcarrito2;
    Semaphore sh1,sh2;
    Icon carro,carro_a;
    int  x1=50,y1=450,x2=800,y2=300;      
    
    public NaveHilo()
    {
        contenedor= new PanelFondo("pistanave.png");
        contenedor.setLayout(null);
        
        carro= new ImageIcon("nave.png");
        lblcarrito= new JLabel(carro); 
        lblcarrito.setBounds(x1,y1,90,90);
        
        carro_a=new ImageIcon("nave2.png");
        lblcarrito2= new JLabel(carro_a);
        lblcarrito2.setBounds(x2,y2,90,90);
        
        sh1=new Semaphore(0,true);
        sh2= new Semaphore(0,true);
        
        contenedor.add(lblcarrito2);
        contenedor.add(lblcarrito);
        add(contenedor);
        
        new Thread(new auto(sh2)).start();
        
        setSize(1000,1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    public static void main(String args[])
    {
        NaveHilo ex= new NaveHilo();
    }
    
    class auto extends Thread
    {
        Semaphore sh2;
        public auto(Semaphore sh2)
        {
            this.sh2=sh2;
        }
        public void run()
        {
            while(x2>550)
            {
                try
                {
                  Thread.sleep(10);
                }
                catch(Exception e)
                {
                    System.out.println("Error 1:"+e.getMessage());
                }
                x2-=5;
                lblcarrito2.setLocation(x2,y2);
            }
            sh2.release();
            while(x1<420)
            {
                try
                {
                  Thread.sleep(10);
                }
                catch(Exception e)
                {
                    System.out.println("Error 2:"+e.getMessage());
                }
                x1+=5;
                lblcarrito.setLocation(x1,y1);
            }
            sh2.release();
            while(y2>5)
            {
                try
                {
                    Thread.sleep(10);
                }
                catch(Exception e)
                {
                    System.out.println("Error 3:"+e.getMessage());
                }
                y2-=5;
                lblcarrito2.setLocation(x2,y2);
            }
            sh2.release();
            while(y1>300)
            {
                try
                {
                    Thread.sleep(10);
                }
                catch(Exception e)
                {
                    System.out.println("Error4:"+e.getMessage());
                    
                }
                y1-=5;
                lblcarrito.setLocation(x1,y1);
            }
            sh2.release();
            while(x1<900)
            {
                try
                {
                    Thread.sleep(10);
                }
                catch(Exception e)
                {
                    System.out.println("Error5:"+e.getMessage());
                }
                x1+=5;
                lblcarrito.setLocation(x1,y1);
            }
        }
        
        
       
    }
}
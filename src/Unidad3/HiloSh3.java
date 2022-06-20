package Unidad3;
import java.util.concurrent.Semaphore;
public class HiloSh3 extends Thread
{
    Semaphore sh3;
    
    public HiloSh3 (Semaphore sh3)
    {
        this.sh3=sh3;
    }
    //metodo especial de los hilos run 
    @Override
    public void run()
    {
        try
        {
            sh3.acquire();//luz verde para que inicie mi hilo con semaforo 1
            
            for (int i=0; i<20;i++)
            { 
                Thread.sleep(100);
                System.out.println("Random "+ Math.random()*101);   
            }
        }
        catch(Exception  e)
            {
                System.out.println("Error Hilo sh2: "+ e.getMessage());
            }
    }
}

package Unidad3;
import java.util.concurrent.Semaphore;
public class HiloSh1 extends Thread
{
    Semaphore sh1;
    Semaphore sh2;
    public HiloSh1 (Semaphore sh1, Semaphore sh2)
    {
        this.sh1=sh1;
        this.sh2=sh2;
    }
    //metodo especial de los hilos run 
    @Override
    public void run()
    {
        try
        {
            //sh1.acquire();//luz verde para que inicie mi hilo con semaforo 1
        
            for (int i=0; i<20;i++)
            {               
                
                    Thread.sleep(100);
                    System.out.println("Numero: "+1);
                
            }
            sh2.release(); // liberamos el hilo semaforo 2 paraque inicie
        }
        catch(Exception  e)
            {
                System.out.println("Error Hilo sh1: "+ e.getMessage());
            }
    }
}

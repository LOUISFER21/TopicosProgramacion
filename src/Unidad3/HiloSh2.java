package Unidad3;
import java.util.concurrent.Semaphore;
public class HiloSh2 extends Thread
{
    Semaphore sh2;
    Semaphore sh3;
    
    public HiloSh2 (Semaphore sh2, Semaphore sh3)
    {
        this.sh2=sh2;
        this.sh3=sh3;
    }
    //metodo especial de los hilos run 
    @Override
    public void run()
    {
        try
        {
            sh2.acquire();//luz verde para que inicie mi hilo con semaforo 1
            String cad = "acidodesoxirribonucleico";
            for (int i=0; i<cad.length();i++)
            { 
                Thread.sleep(100);
                System.out.println("Caracter: "+cad.charAt(i));   
            }
            sh3.release(); // liberamos el hilo semaforo 2 paraque inicie
        }
        catch(Exception  e)
            {
                System.out.println("Error Hilo sh2: "+ e.getMessage());
            }
    }
}
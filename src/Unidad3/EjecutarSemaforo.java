package Unidad3;
import java.util.concurrent.Semaphore;
public class EjecutarSemaforo
{
    public static void main(String args [])
    {
        EjecutarSemaforo es = new EjecutarSemaforo();
        es.ejecutar();
    }
    void ejecutar()
    {
        Semaphore sh1, sh2, sh3;
        
        sh1=new Semaphore(0, true);
        sh2=new Semaphore(0, true);
        sh3=new Semaphore(0, true);
        new Thread (new HiloSh1(sh1, sh2)).start();
        new Thread (new HiloSh2(sh2, sh3)).start();
        new Thread (new HiloSh3(sh3)).start();
    }
}

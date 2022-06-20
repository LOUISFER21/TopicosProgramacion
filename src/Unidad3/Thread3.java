
package Unidad3;

/**
 *
 * @author fersa
 */
public class Thread3 extends Thread 
{
    public void run()
    {
        int n=0;
        while(n<75)
        {
            n=(int)(Math.random()*101);
            System.out.println("Random:"+n);
            try
            {
                Thread.sleep(700);
            }
            catch(Exception e)
            {
                System.out.println("error: "+ e.getMessage());
            } 
        }
    }
}

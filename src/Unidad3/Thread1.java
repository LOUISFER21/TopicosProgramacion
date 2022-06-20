/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Unidad3;

/**
 *
 * @author fersa
 */
public class Thread1  extends Thread
{
    @Override
    public void run()
    {
        for (int i=0; i<20; i++)
        {
            System.out.println("Numero: "+i);
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                System.out.println("error: "+ e.getMessage());
            } 
        }
    }
}

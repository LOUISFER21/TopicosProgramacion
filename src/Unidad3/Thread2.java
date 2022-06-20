/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Unidad3;

/**
 *
 * @author fersa
 */
public class Thread2 extends Thread
{
    @Override
    public void run()
    {
        String cad= " Parangaricutirimicuaro";
        for (int i=0; i<cad.length(); i++)
        {
            System.out.println("Caracter: "+cad.charAt(i));
            try
            {
                Thread.sleep(300);
            }
            catch(Exception e)
            {
                System.out.println("error: "+ e.getMessage());
            } 
        }
    }
}
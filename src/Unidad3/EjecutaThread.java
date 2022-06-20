/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Unidad3;

/**
 *
 * @author fersa
 */
public class EjecutaThread 
{
    public static void main(String args [])
    {
        Thread1 h1 = new Thread1();
        Thread2 h2 = new Thread2();
        Thread3 h3 = new Thread3();
        
        h1.start();
        h2.start();
        h3.start();
    }
    
}

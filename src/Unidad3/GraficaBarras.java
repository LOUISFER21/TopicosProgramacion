/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Unidad3;

/**
 *
 * @author fersa
 */
import java.awt.*;
import javax.swing.*;
public class GraficaBarras extends JFrame
{
	 int cal[]=new int[10];
	 int mayor=0;
	 public int ejex=20,ejey=330,alto,ancho=25;
	 public int escala,y1=0,y2,y0=50,resta=0,x0=15; 
	 
	public GraficaBarras(){
	    setTitle("Grafica");
	    setSize(400,430);
	    setBackground(Color.CYAN);
	   
	}
	public void paint(Graphics x){
		
		Graphics2D d=(Graphics2D)x;
		escala=(ejey-y1)/llenar(cal);
		x.setColor(Color.gray);
		x.fillRect(0,0,450,450);		
		x.drawString( "Gafica Barras", 100, 50);
		x.setColor(Color.white);
		x.drawLine(10, 10, 10, 381);
		x.drawLine(10, 381, 300, 381);
		
		for(int i=0;i<cal.length;i++)
		{
			System.out.println("i "+i);
			x.setColor(Color.getHSBColor((int)(Math.random()*256),
                                (int)(Math.random()*256),(int)(Math.random()*256)));
			
			resta=(mayor-cal[i])*escala;
			
			alto=ejey-resta;
			
			d.setPaint(new GradientPaint(0, 0, Color.red, 10f,10f,
                                Color.blue,true));
			d.fill(new Rectangle(ejex,resta+y0,ancho,alto));
			
			//x.fill3DRect( ejex,resta+y0,ancho,alto,false );

			//x.fillRect(ejex,resta+y0, ancho,alto);
			x.setColor(Color.black);			
			x.drawString(""+cal[i],ejex,resta+y0-5);			
			ejex=ejex+ancho+5;
			x0=x0+ancho+5;
			
			
		}
	
	
	}
	
	int llenar(int cal[])
	{
		for(int i=0;i<cal.length;i++)
		{
			cal[i]=(int)(Math.random()*11);
		}
	    mayor=cal[0];
		for(int i=0;i<cal.length;i++){
		  if(mayor<cal[i])	{
		  	mayor=cal[i];
		  }
		}
		return mayor;
	}	
	public static void main(String []arg){
		 
		    
		GraficaBarras g=new GraficaBarras();
		g.setLocationRelativeTo(null);
		g.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		   
	    g.show();	
	}
}
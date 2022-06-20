
package Unidad1;
import javax.swing.*;

public class EjemploNull extends JFrame 
{
    JTextField entrada;
    JTextArea salida;
    JButton boton;
    JScrollPane barras;
    
    public EjemploNull()        //constructir
    {
        super("PRUEBA NULL");   //super constructor, donde invoca al contrunstructor de la clase padre Jframe
        setLayout(null);
        entrada=new JTextField("Teclee");
        salida=new JTextArea();
        entrada.setBounds(50,120,100,20);
        boton=new JButton("Mostrar");
        boton.setBounds(30,30,100,50);
        //salida.setBounds(50,150, 200,100);
        barras = new JScrollPane(salida);
        //barras.add(salida);
        barras.setBounds(50, 150, 200, 100);
        add(entrada);
        add(barras);
        add(boton);
        setSize(400,400);
        setVisible(true);
        
    }
    public static void main(String[] args)
    {
        EjemploNull Arc=new EjemploNull();
        Arc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


package Unidad1;
import javax.swing.*;
import java.awt.*;

public class EjemploBorder extends JFrame
{
    EjemploBorder()
    {
        Container panel = getContentPane();
        JButton norte = new JButton ("Norte");
        norte.setFont (new Font ("Calibri", Font.BOLD, 25));
        JButton sur = new JButton ("Sur");
        JButton este = new JButton ("Este");
        JButton oeste = new JButton ("Oeste");
        oeste.setFont (new Font ("Calibri", Font.BOLD, 25));
        JButton centro = new JButton ("Centro");
        
        panel.add(norte, BorderLayout.NORTH);
        panel.add(sur, BorderLayout.SOUTH);
        panel.add(este, BorderLayout.EAST);
        panel.add(oeste, BorderLayout.WEST);
        panel.add(centro, BorderLayout.CENTER);
        
        setSize(400, 300);
        setTitle("Prueba de BorderLayoutLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main (String args[])
    {
        new EjemploBorder();
    }
    
}

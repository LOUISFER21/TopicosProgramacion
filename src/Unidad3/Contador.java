
package Unidad3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.*;

public class Contador extends JFrame implements Observer
{   
    public Contador()
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    public void jButtonActionPerformed(ActionEvent evt)
    {
        this.btn1.setEnabled(false);
        Cronometro c = new Cronometro(5, 50, 50);
    }
    public static void main(String args [])
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Contador().setVisible(true);
            }
        });
    }
    private JButton btn1;
    private JLabel lblcro;

    @Override
    public void update(Observable o, Object arg) 
    {
        lblcro.setText((String) arg);
    }

    private void initComponents() 
    {
     }
    
}

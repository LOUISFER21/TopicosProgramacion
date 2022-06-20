
package Unidad2;

/**
 *
 * @author LOUIS
 */
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Cambia implements ActionListener
{
    JPanel pa;
    JMenuItem it2;
    public Cambia(JPanel p, JMenuItem it)
    {
	this.pa = p;
	this.it2 = it;
    }
    public void actionPerformed(ActionEvent v)
    {
	if(it2.getText().equals("Rojo")) pa.setBackground(Color.RED);
	if(it2.getText().equals("Verde")) pa.setBackground(Color.GREEN);
	if(it2.getText().equals("Azul")) pa.setBackground(Color.BLUE);
	if(it2.getText().equals("Rosa")) pa.setBackground(Color.PINK);
	if(it2.getText().equals("Negro")) pa.setBackground(Color.BLACK);
    }
}
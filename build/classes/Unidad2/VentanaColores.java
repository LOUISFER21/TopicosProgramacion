
package Unidad2;

/**
 *
 * @author LOUIS
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class VentanaColores extends JFrame 
{
	JMenuBar barra = new JMenuBar();
	JMenuItem mnurojo = new JMenuItem("Rojo");
	JMenuItem mnuverde = new JMenuItem("Verde");
	JMenuItem mnuazul = new JMenuItem("Azul");
	JMenuItem mnurosa = new JMenuItem("Rosa");
	JMenuItem mnunegro = new JMenuItem("Negro");
	JPanel panel = new JPanel();
	public VentanaColores()
	{
		setTitle("Cambio de colores de ventana");
		setSize(300,200);
		Container c = getContentPane();
		c.add(panel);
		panel.add(barra);
		barra.add(mnurojo);
		barra.add(mnuverde);
		barra.add(mnuazul);
		barra.add(mnurosa);
		barra.add(mnunegro);
		
		mnurojo.addActionListener(new Cambia(panel,mnurojo));
		mnuverde.addActionListener(new Cambia(panel,mnuverde));
		mnuazul.addActionListener(new Cambia(panel,mnuazul));
		mnurosa.addActionListener(new Cambia(panel,mnurosa));
		mnunegro.addActionListener(new Cambia(panel,mnunegro));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
		
	}
	public static void main(String[] args)
	{
		VentanaColores v = new VentanaColores();
		v.setVisible(true);
	}

}


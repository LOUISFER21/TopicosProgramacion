
package Examen2;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class TablaCursos extends JFrame implements ActionListener
{
    JTable tabla;
    JButton btnregresa;
    JScrollPane barras;
    String datos[][];
    String titulos[]={"tipo de curso","Numero de personas"}; 
    
    
    public TablaCursos(Asesorias array[], int cont)
    {
        datos = new String[cont][7];
        
        for(int i=0; i<cont; i++)
        {
            datos[i][0] = array[i].especialidad;
            datos[i][1] = array[i].especialidad;

        }
        tabla = new JTable (datos,titulos);
        barras = new JScrollPane(tabla);
        barras.setBounds(30, 30, 500, 400);
        
        btnregresa = new JButton("Regresar");
        btnregresa.setBounds(260, 440, 100, 20);
        btnregresa.addActionListener(this);
        
        setLayout(null);
        add(barras);
        add(btnregresa);
        setVisible(true);
        setSize(590, 520);
        this.getContentPane().setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==btnregresa)
        {
            
        }
    }
}
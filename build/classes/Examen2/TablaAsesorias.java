
package Examen2;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class TablaAsesorias extends JFrame implements ActionListener
{
    JTable tabla;
    JButton btnregresa;
    JScrollPane barras;
    String datos[][];
    String titulos[]={"Nombre","Especialidad","turno", "materia", "hora", "pago"}; 
    
    
    public TablaAsesorias(Asesorias array[], int cont)
    {
        datos = new String[cont][7];
        
        for(int i=0; i<cont; i++)
        {
            datos[i][0] = array[i].nombre_docente;
            datos[i][1] = array[i].especialidad;
            datos[i][2] = array[i].turno;
            datos[i][3] = ""+array[i].materia;
            datos[i][4] = ""+array[i].hora_pago;
            datos[i][5] = ""+array[i].pago;
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
            FormularioAsesorias.form.t.setVisible(false);
            FormularioAsesorias.form.setVisible(true);
        }
    }
}
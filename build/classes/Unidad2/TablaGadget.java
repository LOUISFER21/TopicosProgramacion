
package Unidad2;

/**
 *
 * @author LOUIS
 */

import javax.swing.*;
import java.awt.event.*;
public class TablaGadget extends JFrame implements ActionListener
{
    JTable tabla;
    JButton btnregresar;
    JScrollPane barras;
    String datos[][];
    String titulos[]={"ID Gadget", "Marca", "Nombre", "Tamaño","Procesador","RAM", "Almacenamiento","Precio"};
    
    public TablaGadget(Gadget array[], int cont)
    {
        datos = new String[cont][8];
        for(int i=0; i<cont; i++)
        {
            datos[i][0]= array[i].id_gad;
            datos[i][1]= array[i].marca;
            datos[i][2] = array[i].nombre;
            datos[i][3]= ""+array[i].tamanio;
            datos[i][4]=array[i].procesador;
            datos[i][5]=""+array[i].ram;
            datos[i][6]=array[i].almacenamiento;
            datos[i][7]=""+array[i].precio;
            
            tabla = new JTable (datos,titulos);
        barras = new JScrollPane(tabla);
        barras.setBounds(30, 30, 500, 400);
        
        btnregresar = new JButton("Regresar");
        btnregresar.setBounds(260, 440, 100, 20);
        btnregresar.addActionListener(this);
        
        setLayout(null);
        add(barras);
        add(btnregresar);
        setVisible(true);
        setSize(590, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        }
    
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==btnregresar)
        {
            GadgetMejorado.form.t.setVisible(false);
            GadgetMejorado.form.setVisible(true);
        }
    }
}

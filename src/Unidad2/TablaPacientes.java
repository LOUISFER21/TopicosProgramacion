
package Unidad2;

/**
 *
 * @author LOUIS
 */
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
public class TablaPacientes extends JFrame implements ActionListener
{
    JTable tabla;
    JButton btnregresa;
    JScrollPane barras;
    String datos[][];
    String titulos[]={"Nombre","Domicilio","Sexo", "Edad", "T_sangre", "Peso", "Talla"}; 
    
    
    public TablaPacientes(Paciente array[], int cont)
    {
        datos = new String[cont][7];
        
        for(int i=0; i<cont; i++)
        {
            datos[i][0] = array[i].nom;
            datos[i][1] = array[i].domicilio;
            datos[i][2] = array[i].sexo;
            datos[i][3] = ""+array[i].edad;
            datos[i][4] = array[i].t_sangre;
            datos[i][5] = ""+array[i].peso;
            datos[i][6] = ""+array[i].talla;
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
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); ///cerrar ventana
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==btnregresa)
        {
            FormularioPaciente.form.t.setVisible(false);
            FormularioPaciente.form.setVisible(true);
        }
    }
}

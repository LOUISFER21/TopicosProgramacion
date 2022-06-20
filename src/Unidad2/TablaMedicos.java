
package Unidad2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author LOUIS
 */
public class TablaMedicos extends JFrame implements ActionListener
{
    JTable tabla;
    JButton btnregresa;
    JScrollPane barras;
    String matrizdatos[][];
    String encabezados[] = {"Cedula", "Nombre", "Especialidad", "Dependencia", "Turno", "Num.Consultorio"};
   
    public TablaMedicos(Medico consultorios[], int numdoc)
    {
        matrizdatos=new String[numdoc][6];
        for(int i=0; i<numdoc; i++)
        {
            matrizdatos[i][0]= ""+consultorios[i].cedula;
            matrizdatos[i][1]=consultorios[i].nombre;
            matrizdatos[i][2]=consultorios[i].especialidad;
            matrizdatos[i][3]=consultorios[i].dependencia;
            matrizdatos[i][4]=consultorios[i].turno;
            matrizdatos[i][5]=""+consultorios[i].num_consultorio;
        }
        tabla = new JTable (matrizdatos,encabezados);
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
            FormularioMedico.form.t.setVisible(false);
            FormularioMedico.form.setVisible(true);
        }
    }
}


package Unidad2;

/**
 *
 * @author LOUIS
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Hospital extends JFrame implements ActionListener
{
   //static Hospital hos;
   JLabel lbltit, lblficha, lblpaciente, lblmedico, lblfecha, lblhora;
   JTextField txtficha, txtfecha, txthora;
   JComboBox cmbpaciente, cmbmedico;
   JButton btnregistrar, btnmostrar, btnregresar;
   JPanel cita;
   Hospital()
   {
        cita = new JPanel();
        cita.setLayout(null);
        
        lbltit = new JLabel("GENERAR CONSULTA");
        lbltit.setFont(new Font("Arial", Font.BOLD, 14));
        lbltit.setBounds(50,10,180,40);
        
        lblficha = new JLabel ("Ficha: ");
        lblficha.setBounds(10, 60, 100, 20);
        txtficha = new JTextField();
        txtficha.setBounds(120, 60, 100, 20);
        
        /*lblpaciente = new JLabel ("Paciente: ");
        lblpaciente.setBounds(10, 90, 100, 20);
        cmbpaciente = new JComboBox();
        cmbpaciente.setBounds(120, 90, 100, 20);
        for(int i=0; i<FormularioPaciente.form.cont; i++)
        {
            cmbpaciente.addItem(FormularioPaciente.form.cajas[i].nom);
        }
        lblmedico =new JLabel("Medico: ");
        lblmedico.setBounds(10, 120, 100, 20);
        
        cmbmedico = new JComboBox(); 
        cmbmedico.setBounds(120, 120, 100, 20);
        for(int i=0; i<FormularioPaciente.formmed.numdoc; i++)
        {
           cmbmedico.addItem(FormularioPaciente.formmed.consultorios[i].nombre);
        }*/
        
        lblfecha =new JLabel("Fecha: ");
        lblfecha.setBounds(10, 150, 100, 20);
        txtfecha = new JTextField(); 
        txtfecha.setBounds(120, 150, 100, 20);
        
        lblhora = new JLabel("Hora");
        lblhora.setBounds(10, 180, 100, 20);
        txthora = new JTextField ();
        txthora.setBounds(120, 180, 100, 20);
        
        btnregistrar = new JButton ("Registrar");
        btnregistrar.setBounds(50, 210, 70, 20);
        btnmostrar = new JButton ("Mostrar");
        btnmostrar.setBounds(130, 210, 70, 20);
        btnregresar = new JButton ("Regresar");
        btnregresar.setBounds(75, 250, 100, 20);
        
        
        
        
        add(lbltit);
        add(lblficha);  add(txtficha);
        /*add(lblpaciente);   add(cmbpaciente);
        add(lblmedico);   add(cmbmedico);*/
        add(lblfecha);  add(txtfecha);
        add(lblhora);   add(txthora);
        add(btnregistrar);  add(btnmostrar);    add(btnregresar);
        add(cita);
        
        //setVisible(true);
        setSize(250, 350);
        cita.setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
   
   }
   //public static void main(String args [])
   //{
   //    hos = new Hospital();
   //}
   @Override
   public void actionPerformed(ActionEvent even)
   {
       /*if(even.getSource()==btnregistrar)
       {
       
       }
       if(even.getSource()==btnmostrar)
       {
       
       }
       if(even.getSource()==btnregresar)
       {
       
       }*/
   }
   /*void limpiar()
   {
   
   }*/
   void construir_combos()
   {
       lblpaciente = new JLabel ("Paciente: ");
        lblpaciente.setBounds(10, 90, 100, 20);
        cmbpaciente = new JComboBox();
        
        for(int i=0; i<FormularioPaciente.form.cont; i++)
        {
            cmbpaciente.addItem(FormularioPaciente.form.cajas[i].nom);
        }
        cmbpaciente.setBounds(120, 90, 100, 20);
        
        
        lblmedico =new JLabel("Medico: ");
        lblmedico.setBounds(10, 120, 100, 20);
        cmbmedico = new JComboBox(); 
        
        for(int i=0; i<FormularioPaciente.formmed.numdoc; i++)
        {
           cmbmedico.addItem(FormularioPaciente.formmed.consultorios[i].nombre);
        }
        cmbmedico.setBounds(120, 120, 100, 20);
        
        cita.add(lblpaciente);   cita.add(cmbpaciente);
        cita.add(lblmedico);   cita.add(cmbmedico);
        
        repaint();
   }
}


/*
clases estaticas se acceden por medio de la clase.

las variables estaticas son propias de la clase y no del objeto,
es decir las variables estaticas se deben acceder mediante el nombre de la clase.objeto que se decea llamar
*/
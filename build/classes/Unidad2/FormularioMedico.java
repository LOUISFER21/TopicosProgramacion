package Unidad2;
/**
 *
 * @author LOUIS
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioMedico extends JFrame implements ActionListener
{    
    
    JLabel lbltit, lblced, lblnom, lblesp, lbldep, lbltur, lblnc;
    JTextField txtced, txtnom;
    JComboBox cmbesp, cmbdep, cmbnc;
    JRadioButton rdmat, rdves;
    ButtonGroup grouptur;
    JButton btnreg, btnmos, btnregresar;
    JPanel cont;
    //JPanel panelturno;
    
    static FormularioMedico form;
    Medico doc;
    Medico consultorios[] = new Medico[100];
    int numdoc=0;
    TablaMedicos t;
    
    FormularioMedico()
    {
        cont = new JPanel();
        cont.setLayout(null);
        
        lbltit = new JLabel("REGISTRO MEDICO");
        lbltit.setFont(new Font("Arial", Font.BOLD, 14));
        lbltit.setBounds(100,10,180,40);
        
        lblced = new JLabel ("Cedula: ");
        lblced.setBounds(10, 60, 100, 20);
        txtced = new JTextField();
        txtced.setBounds(120, 60, 100, 20);
        
        lblnom = new JLabel ("Nombre: ");
        lblnom.setBounds(10, 90, 100, 20);
        txtnom = new JTextField();
        txtnom.setBounds(120, 90, 100, 20);
        
        lblesp =new JLabel("Especialidad: ");
        lblesp.setBounds(10, 120, 100, 20);
        cmbesp = new JComboBox(); 
        cmbesp.setBounds(120, 120, 100, 20);
            cmbesp.addItem("Selecciona");
            cmbesp.addItem("Medico General");
            cmbesp.addItem("Pediatra");
            cmbesp.addItem("Traumatologia");
            cmbesp.addItem("Internista");
            cmbesp.addItem("Cardologia");
            cmbesp.addItem("Ginecologia");
        lbldep =new JLabel("Dependencia: ");
        lbldep.setBounds(10, 150, 100, 20);
        cmbdep = new JComboBox(); 
        cmbdep.setBounds(120, 150, 100, 20);
            cmbdep.addItem("Selecciona");
            cmbdep.addItem("IMSS");
            cmbdep.addItem("ISSITE");
            cmbdep.addItem("ISSEMYM");
            cmbdep.addItem("ISSFAM");
            cmbdep.addItem("PARTICULAR");
        
        lbltur = new JLabel("Turno");
        lbltur.setBounds(10, 180, 100, 20);
        rdmat = new JRadioButton("Matunino");
        rdmat.setBounds(120, 180,70 , 20);
        rdves = new JRadioButton("Vespertino");
        rdves.setBounds(200, 180, 70, 20);
        grouptur = new ButtonGroup();
            grouptur.add(rdmat);
            grouptur.add(rdves);
        
        lblnc= new JLabel ("Num. Consultorio: ");
        lblnc.setBounds(10, 210, 100, 20);
        cmbnc = new JComboBox();
        cmbnc.setBounds(120, 210, 100, 20);
            cmbnc.addItem("Selecionar");
            cmbnc.addItem("1");
            cmbnc.addItem("2");
            cmbnc.addItem("3");
            cmbnc.addItem("4");
            
        btnreg = new JButton("Registrar");
        btnreg.setBounds(30, 250, 100, 20);
        btnreg.addActionListener(this);
        
        btnmos = new JButton("Mostrar");
        btnmos.setBounds(140, 250, 100, 20);
        btnmos.addActionListener(this);
        
        btnregresar = new JButton("Cita");
        btnregresar.setBounds(80, 280, 100, 20);
        btnregresar.addActionListener(this);
        
        add(lbltit);
        add(lblced);    add(txtced);
        add(lblnom);    add(txtnom);
        add(lblesp);    add(cmbesp);
        add(lbldep);    add(cmbdep);
        add(lbltur);    add(rdmat); add(rdves);
        add(lblnc);     add(cmbnc);
        add(btnreg); add(btnmos);  add(btnregresar);
        add(cont);
        
        //setVisible(true);
        setSize(300, 380);
        cont.setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);   
        
        consultorios=new Medico[100];
        
    }
    public static void main(String args[])
    {
         form = new FormularioMedico(); 
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {   
        if(e.getSource()==btnreg)
        {
            doc = new Medico();
            doc.cedula=Integer.parseInt(txtced.getText());
            doc.nombre=txtnom.getText();
            doc.especialidad=cmbesp.getSelectedItem().toString();
            doc.dependencia=cmbdep.getSelectedItem().toString();
            if(rdmat.isSelected())
            {
                doc.turno="Matutino";
            }
            if(rdves.isSelected())
            {
                doc.turno="Vespertino";
            }
            doc.num_consultorio=Integer.parseInt(cmbnc.getSelectedItem().toString());
            
            consultorios[numdoc]=doc;
            numdoc++;
            
            JOptionPane.showMessageDialog(null, "*********Paciente registrado Correctamente*****");
            limpiar();
        }
            
        if(e.getSource()==btnmos)
        {
           t = new TablaMedicos (consultorios, numdoc);
           form.setVisible(false);
        }
        if(e.getSource()==btnregresar)
        {
            //FormularioMedico.form.t.setVisible(true);
            //FormularioMedico.form.setVisible(false);
            FormularioPaciente.formhos.construir_combos();
            FormularioPaciente.formhos.setVisible(true);
            FormularioPaciente.formmed.setVisible(false);
        }
    }  
    void limpiar()
    {
        txtnom.setText("");
        txtced.setText("");
        cmbnc.setSelectedIndex(0);
        cmbesp.setSelectedIndex(0);
        cmbdep.setSelectedIndex(0);
        grouptur.clearSelection();        
    }
}


//Tarea realizar mi tabla 


/*
***********************************NOTAS****************************************
Static: Una variable que pertenece a la clase no al objeto
*/
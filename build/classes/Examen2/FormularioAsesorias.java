
package Examen2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioAsesorias extends JFrame implements ActionListener
{    
    
    JLabel lbltit, lblnombre, lblespecialidad, lblturno, lblmateria, lblhorapago, lblpago;
    JTextField txtnombre, txtmateria, txtpago;
    JComboBox cmbespecialidad, cmbhora;
    JRadioButton rdmat, rdves;
    ButtonGroup grouptur;
    JButton btnreg, btnmos, btnregresar;
    JPanel cont;
    
    static FormularioAsesorias form;
    static FormularioCurso formmed;
    Asesorias doc;
    Asesorias oficinas[] = new Asesorias[100];
    int numdoc=0;
    TablaAsesorias t;
    
    FormularioAsesorias()
    {
        formmed = new FormularioCurso();
        
        cont = new JPanel();
        cont.setLayout(null);
        
        lbltit = new JLabel("REGISTRO ASESORIAS");
        lbltit.setFont(new Font("Arial", Font.BOLD, 14));
        lbltit.setBounds(100,10,180,40);
        
        lblnombre= new JLabel ("NOMBRE DEL DOCENTE: ");
        lblnombre.setBounds(10, 60, 100, 20);
        txtnombre = new JTextField();
        txtnombre.setBounds(120, 60, 100, 20);
        
        lblespecialidad = new JLabel ("ESPECIALIDAD: ");
        lblespecialidad.setBounds(10, 90, 100, 20);
        cmbespecialidad = new JComboBox();
        cmbespecialidad.setBounds(120, 90, 100, 20);
            cmbespecialidad.addItem("Selcciona");
            cmbespecialidad.addItem("Licenciatura");
            cmbespecialidad.addItem("Maestria");
            cmbespecialidad.addItem("Doctorado");
        
        lblturno =new JLabel("TURNO: ");
        lblturno.setBounds(10, 120, 100, 20);
        rdmat = new JRadioButton("Matunino"); 
        rdmat.setBounds(120, 120, 70, 20);
        rdves = new JRadioButton("Vespertino");
        rdves.setBounds(200, 120, 70, 20);
        grouptur = new ButtonGroup();
            grouptur.add(rdmat);
            grouptur.add(rdves);    
            
        lblmateria =new JLabel("MATERIA: ");
        lblmateria.setBounds(10, 150, 100, 20);
        txtmateria = new JTextField(); 
        txtmateria.setBounds(120, 150, 100, 20);
            
        
        lblhorapago = new JLabel("HORA");
        lblhorapago.setBounds(10, 180, 100, 20);
        cmbhora = new JComboBox();
        cmbhora.setBounds(120, 180,70 , 20);
            cmbhora.addItem("seleciona");
            cmbhora.addItem("1");
            cmbhora.addItem("2");
            cmbhora.addItem("3");
            cmbhora.addItem("4");
            cmbhora.addItem("5");
            cmbhora.addItem("6");
            cmbhora.addItem("7");
            cmbhora.addItem("8");
        
        lblpago= new JLabel ("PAGO POR HORA: ");
        lblpago.setBounds(10, 210, 100, 20);
        txtpago = new JTextField();
        txtpago.setBounds(120, 210, 100, 20);
          
         
            
        btnreg = new JButton("Registrar");
        btnreg.setBounds(30, 250, 100, 20);
        btnreg.addActionListener(this);
        
        btnmos = new JButton("Mostrar");
        btnmos.setBounds(140, 250, 100, 20);
        btnmos.addActionListener(this);
        
        btnregresar = new JButton("Registrar");
        btnregresar.setBounds(80, 280, 100, 20);
        btnregresar.addActionListener(this);
        
        add(lbltit);
        add(lblnombre);    add(txtnombre);
        add(lblespecialidad);    add(cmbespecialidad);
        add(lblturno);    add(rdmat); add(rdves);
        add(lblmateria);    add(txtmateria);
        add(lblhorapago);    add(cmbhora);
        add(lblpago);     add(txtpago);
        add(btnreg); add(btnmos);  add(btnregresar);
        add(cont);
        
        setVisible(true);
        setSize(300, 380);
        cont.setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);   
        
        oficinas=new Asesorias[100];
        
    }
    public static void main(String args[])
    {
         form = new FormularioAsesorias(); 
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {   
        if(e.getSource()==btnreg)
        {
            doc = new Asesorias();
            doc.nombre_docente=txtnombre.getText();
            doc.especialidad = cmbespecialidad.getSelectedItem().toString();
            if(rdmat.isSelected())
            {
                doc.turno="Matutino";
            }
            if(rdves.isSelected())
            {
                doc.turno="Vespertino";
            }
            doc.materia=txtmateria.getText();
            
            doc.hora_pago=Integer.parseInt(cmbhora.getSelectedItem().toString());
            doc.pago=Double.parseDouble(txtpago.getText());
            
            oficinas[numdoc]=doc;
            numdoc++;
            
            JOptionPane.showMessageDialog(null, "*********Asesor registrado Correctamente*****");
            limpiar();
        }
            
        if(e.getSource()==btnmos)
        {
        t = new TablaAsesorias (oficinas, numdoc);
           form.setVisible(false);
        }
        if(e.getSource()==btnregresar)
        {
            formmed.setVisible(true);
           form.setVisible(false);
        }
    }  
    void limpiar()
    {
        
        
        cmbespecialidad.setSelectedIndex(0);
        grouptur.clearSelection();
        txtmateria.setText("");
        cmbhora.setSelectedIndex(0);
        txtpago.setText("");
        
    
    }
}

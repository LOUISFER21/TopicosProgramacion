
package ExamenUnidad1;
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;

public class ContratoTrabajador extends JFrame implements ActionListener 
{
    JLabel lbltit, lblnom, lblape, lblsexo, lblpuesto, lblhs, lblservi, lblcontra;
    JTextField txtnom, txtape;
    JRadioButton rdhombre, rdmujer, rdtempo, rdperma;
    ButtonGroup groupsexo,groupcontra;
    JComboBox cmbpuesto, cmbhs;
    JCheckBox chcaja, chseg, chnet;
    JButton btregistrar, btmostrar;
    String datos, sexo, servicios, contrato;
    int sueldo=6000;
    
   JLabel lblimg;
   Icon icon_img;
   
   ContratoTrabajador()
   {
       setLayout(null);
       lbltit = new JLabel("CONTRATO TRABAJADOR");
       lbltit.setBounds(125, 10, 200, 30);
       
       lblnom = new JLabel ("Nombre: ");
       lblnom.setBounds(10, 60, 100, 20);
       
       txtnom = new JTextField();
       txtnom.setBounds(120, 60, 100, 20 );
       
       lblape = new JLabel ("Apellido: ");
       lblape.setBounds(10,90, 100, 20);
       
       txtape = new JTextField();
       txtape.setBounds(120, 90, 100, 20);
       
       lblsexo = new JLabel("SExo: ");
       lblsexo.setBounds(10, 120, 100, 20);
       
       rdhombre = new JRadioButton("Hombre");
       rdhombre.setBounds(120, 120, 50, 20);
       
       rdmujer = new JRadioButton("Mujer");
       rdmujer.setBounds(170, 120, 50, 20);
       groupsexo = new ButtonGroup();
       groupsexo.add(rdhombre);
       groupsexo.add(rdmujer);
       
       lblpuesto = new JLabel("Puesto: ");
       lblpuesto.setBounds(10, 150, 100, 20);
       
       cmbpuesto = new JComboBox();
       cmbpuesto.setBounds(120, 150, 100, 20);
            cmbpuesto.addItem("Tester");
            cmbpuesto.addItem("Front end");
            cmbpuesto.addItem("Back end");
            cmbpuesto.addItem("Full stack");
            
       lblhs = new JLabel("Horas/Semana");
       lblhs.setBounds(10, 180, 100, 20);
       
       cmbhs = new JComboBox();
       cmbhs.setBounds(120, 180, 100, 20);
            for(int i=1; i<=40; i++)
            {
                cmbhs.addItem(i);
            }
        
        lblservi = new JLabel("Servicios Adicionales");
        lblservi.setBounds(10, 220, 200, 20);
        
        chcaja = new JCheckBox("Caja Aho");
        chcaja.setBounds(10, 240, 50, 20);
        chseg = new JCheckBox("Seg. Acd");
        chseg.setBounds(60, 240, 50, 20);
        chnet = new JCheckBox("Nexfliz");
        chnet.setBounds(110, 240, 50, 20);
        
        lblcontra = new JLabel("Tipo Contrato");
        lblcontra.setBounds(10, 270, 100, 20);
        
        rdtempo = new JRadioButton("Temporal");
        rdtempo.setBounds(120, 270, 50, 20);
        rdperma = new JRadioButton("Permanente");
        rdperma.setBounds(170, 270, 50, 20);
        groupcontra = new ButtonGroup();
            groupcontra.add(rdtempo);
            groupcontra.add(rdperma);
        
        btregistrar = new JButton("Registrar");
        btregistrar.setBounds(120, 300, 70, 20);
        btregistrar.addActionListener(this);
        
        btmostrar = new JButton("Mostrar");
        btmostrar.setBounds(230, 300, 70, 20);
        btmostrar.addActionListener(this);
        
        icon_img = new ImageIcon("img.png");
        lblimg = new JLabel(icon_img);
        lblimg.setBounds(230, 60, 150, 170);
        
        add(lbltit);
        add(lblnom);    add(txtnom);
        add(lblape);    add(txtape);
        add(lblsexo);   add(rdhombre);  add(rdmujer);
        add(lblpuesto); add(cmbpuesto);
        add(lblhs);     add(cmbhs);
        add(lblservi);
        add(chcaja);    add(chseg); add(chnet);
        add(lblcontra); add(rdtempo);   add(rdperma);
        
        add(lblimg);
        
        add(btregistrar); add(btmostrar);
        
        setVisible(true);
        setSize(410, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public static void main(String args[])
   {
       new ContratoTrabajador();
   }
   
    @Override
   public void actionPerformed(ActionEvent evt)
   {
       if(rdhombre.isSelected())
       {
           sexo = "Hombre";
       }
       else
       {
           sexo = "Mujer";
       }
       if(chcaja.isSelected())
       {
           servicios = "_Caja de ahorro_"; 
       }
       if(chseg.isSelected())
       {
           servicios += "_Seguro Accidentes_";
       }
       if(chnet.isSelected())
       {
           servicios += "_Nexfliz_";
       }

       if(rdtempo.isSelected())
       {
           contrato = "Temporal";
       }
       else 
       {
           contrato = "Permanente";
       }
       
       {
       
       }
       if(cmbpuesto.equals("Tester"))
       {
           sueldo = 400;
       }else
       if(cmbpuesto.equals("Front eds"))
       {
           sueldo = 600;
       }else
       if(cmbpuesto.equals("Back end"))
       {
       
           sueldo = 800;
       }else 
           if(cmbpuesto.equals("Full stack"))
           {
                sueldo = 1000;
           }
      
      
       datos = "Nombre: "+txtnom.getText()
               +"\nApellido: "+ txtape.getText()
               +"\nSexo: "+ sexo
               +"\nPuesto: " + cmbpuesto.getSelectedItem().toString()
               +"\nHoras/Semana: "+ cmbhs.getSelectedItem().toString()
               +"\nServicios Adicionales: "+ servicios
               +"\nContrato: "+ contrato 
               +"\nSueldo: "+sueldo;
       
       
       
       if(evt.getSource()==btregistrar)
       {
           JOptionPane.showMessageDialog(null, "Datos Registrados");
       }
       if(evt.getSource()==btmostrar)
       {
           JOptionPane.showMessageDialog(null, datos);
           limpiar();
       }
   }
   void limpiar()
   {
       txtnom.setText("");
       txtape.setText("");
       groupsexo.clearSelection();
       cmbpuesto.setSelectedIndex(0);
       cmbhs.setSelectedIndex(0);
       chcaja.setSelected(false);
       chseg.setSelected(false);
       chnet.setSelected(false);
       groupcontra.clearSelection();
   }
   
}

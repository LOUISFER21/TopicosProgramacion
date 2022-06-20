
package Unidad1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;   
////interfaz: conjunto de acciones generalizadas.
public class EjemploGrid extends JFrame implements ActionListener
{
    JLabel lbltit, lbltitv, lblmarca, lblmodelo, lblcolor, lblyear
            ,lbltran, lblequip, lbltranv;
    JTextField txtmarca, txtmodelo;
    JComboBox cmbcolor, cmbyear;
    JRadioButton rdaut, rdstd;
    ButtonGroup grupotrans;
    JCheckBox chrines, chsonido, chled;
    JButton btnreg, btnmost;
    JPanel contenedor;
    String datoauto, transmision, equip;
    Double precio;
    
    EjemploGrid()
    {
        lbltit    = new JLabel      ("REGISTRO DE AUTOS");
        lbltitv   = new JLabel      ("");
        lblmarca  = new JLabel      ("MARCA");
        txtmarca  = new JTextField  ();
        lblmodelo = new JLabel      ("MODELO");
        txtmodelo = new JTextField  ();
        lblcolor  = new JLabel      ("COLOR");
        cmbcolor  = new JComboBox();
            cmbcolor.addItem        ("Seleciona un color");
            cmbcolor.addItem        ("Rojo");
            cmbcolor.addItem        ("Gris");
            cmbcolor.addItem        ("Negro");
            cmbcolor.addItem        ("Blanco");
            cmbcolor.addItem        ("AZUL");
        lblyear   = new JLabel      ("ANIO DE FABRICACION");
        cmbyear   = new JComboBox   ();
            for(int i = 2015; i<=2022; i++)
            {
                cmbyear.addItem(i);
            }
        lbltran   = new JLabel      ("TRANSMISION");
        lbltranv  = new JLabel      ("");
        rdaut     = new JRadioButton("AUTOMATICO");
        rdaut.setOpaque(false);                     //para que el fondo sea igual
        rdstd     = new JRadioButton("ESTANDOR");
        lblequip  = new JLabel      ("EQUIPAMIENTO");
        chrines   = new JCheckBox   ("RINES VIBRANIUM");
        chsonido  = new JCheckBox   ("SORROUND C/FLOW");
        chled     = new JCheckBox   ("LUCES LED F/F");
        
        btnreg    = new JButton     ("REGISTRAR");
        btnreg.addActionListener(this);     //escuchador, que esta escuchando
        
        btnmost   = new JButton     ("MOSTRAR");    
        btnmost.addActionListener(this);
        
        contenedor= new JPanel      ();
        contenedor.setLayout(new GridLayout(10, 2));   //crea un contenedor para almacenar
        
        contenedor.add(lbltit);             contenedor.add(lbltitv);
        contenedor.add(lblmarca);           contenedor.add(txtmarca);
        contenedor.add(lblmodelo);          contenedor.add(txtmodelo);
        contenedor.add(lblcolor);           contenedor.add(cmbcolor);
        contenedor.add(lblyear);            contenedor.add(cmbyear);
        contenedor.add(lbltran);            contenedor.add(lbltranv);
        contenedor.add(rdaut);              contenedor.add(rdstd);
        contenedor.add(lblequip);           contenedor.add(chrines);
        contenedor.add(chsonido);           contenedor.add(chled);
        contenedor.add(btnreg);             contenedor.add(btnmost);
        
        add(contenedor);        //se agrega el contenedor
        
        grupotrans = new ButtonGroup();
        grupotrans.add(rdaut);
        grupotrans.add(rdstd);
        
        setVisible(true);
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args [])
    {
        new EjemploGrid();  //Objeto anonimo que no tiene nombre para 
                            //invocarse posteriormente
    }
    @Override   ///medoto sobreescrito
    public void actionPerformed(ActionEvent evt)       ///evt es la variable/// este es un metodo 
                                                       //  general(funciona para todo lo que tenga agregado un "ActionListener")
    {
        
        //get  ---- obtener ///solo cuando son texto
        //set -----colocar  ///
        if(rdaut.isSelected())
        {
            transmision = "Automatico";
            precio = 300000.0;
        }
        else
        {
            transmision = "Estandar";
            precio = 280000.0;
        }
        if(chled.isSelected())
        {
            equip+=" - Luces led f/f- ";
            precio += 10000;
        }
        if(chsonido.isSelected())
        {
            equip += " - Surround c/flow - ";
            precio += 25000;
        }
        if(chrines.isSelected())
        {
            equip += " - Rines vibranium - ";
            precio += 40000;
        }
        
        datoauto = "Marca: "+txtmarca.getText()
                +"\nModelo: "+txtmodelo.getText() + "\nColor: "
                +cmbcolor.getSelectedItem().toString()
                +"\nAnio: "+cmbyear.getSelectedItem().toString()
                +"\nTransmicion: "+transmision + "\nEquipo: "+equip;//para obtener el texto de marca
        
        if(evt.getSource()==btnreg)
        {
            
            //GadgetNull gt = new  GadgetNull();
            JOptionPane.showMessageDialog(null, "Auto registrado con exito");
        }
        if(evt.getSource()==btnmost)
        {
            JOptionPane.showMessageDialog(null, datoauto
                    + "\nEl costo total del auto es: "+precio);
            lbltitv.setText("Costo auto: "+precio);
            limpiarDatos();
        }   
    }
    
    void limpiarDatos()
    {
        txtmarca.setText("");
        txtmodelo.setText("");
        cmbcolor.setSelectedIndex(0);
        cmbyear.setSelectedIndex(0);
        grupotrans.clearSelection();
        chled.setSelected(false);
        chrines.setSelected(false);
        chsonido.setSelected(false);
    }
}

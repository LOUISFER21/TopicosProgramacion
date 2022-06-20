
package Unidad2;

/**
 *
 * @author LOUIS
 */
import java.awt.Font;
import javax.swing.*;   //caja de herramientas para ciertos fines
                        //sirve para utilizar componentes graficos
import java.awt.event.*;

public class GadgetMejorado extends JFrame implements ActionListener
{
    Gadget productos;
    TablaGadget t;
    static GadgetMejorado form;
    Gadget cajas[] = new Gadget[100];
    
    JLabel lbltit, lblid, lblmar, lblnom, lbltam, lblcpu, lblram, lblalma, lblpre;
    JLabel lblimagen;  ///para poner una imagen 
    Icon icono_img;  /// para poner una imagen 
    JTextField txtid, txtnom, txtpre;
    JComboBox cmbmar, cmbtam, cmbram;
    JRadioButton rdinter, rdamd;
    ButtonGroup groupcpu;   ///grupo de JRadioButton
    JCheckBox chssd, chhdd;
    JButton btnregis, btnmos;
    JTextArea areaima;
    String datos, procesa, almacenamiento;
    Double precio;
    int cont=0;
    
    
    
        GadgetMejorado()    //Constructor para inicializar los componentes
    {
            
            setLayout(null);
            lbltit = new JLabel("REGISTRO GADGET");
            lbltit.setFont(new Font("Arial",Font.BOLD, 12));
            lbltit.setBounds(125, 10, 200, 30);
            ////////////////////////////////////////////////////////////////////
            lblid = new JLabel ("ID Gadget");
            lblid.setBounds(10, 60, 100, 20);
            txtid = new JTextField();
            txtid.setBounds(120, 60,100,20);
            ////////////////////////////////////////////////////////////////////
            lblmar = new JLabel ("Marca");
            lblmar.setBounds(10, 90, 100, 20);
            cmbmar = new JComboBox();
            cmbmar.setBounds(120, 90, 100, 20);
            cmbmar.addItem("Elige una opcion");
            cmbmar.addItem("HP");
            cmbmar.addItem("Compac");
            cmbmar.addItem("Mac");
            ////////////////////////////////////////////////////////////////////
            lblnom = new JLabel("Nombre");
            lblnom.setBounds(10, 120, 100, 20);
            txtnom = new JTextField(); 
            txtnom.setBounds(120, 120, 100, 20);
            ////////////////////////////////////////////////////////////////////
            lbltam = new JLabel("Tamanio");
            lbltam.setBounds(10, 150, 100, 20);
            cmbtam = new JComboBox();
            cmbtam.setBounds(120,150,100,20);
                for(int i=10; i<=25; i++)
                {
                    cmbtam.addItem(i);
                }
            ////////////////////////////////////////////////////////////////////
            lblcpu = new JLabel ("Procesador"); 
            lblcpu.setBounds(10, 180, 100, 20);
            rdinter = new JRadioButton("Inter");
            rdinter.setBounds(120, 180, 50, 20);
            rdamd = new JRadioButton("AMD");
            rdamd.setBounds(170, 180, 50, 20);
            groupcpu = new ButtonGroup();
            groupcpu.add(rdinter);
            groupcpu.add(rdamd);
            ///////////////////////////////////////////////////////////////////
            lblram = new JLabel("RAM");
            lblram.setBounds(10, 210, 100, 20);
            cmbram = new JComboBox();
            cmbram.setBounds(120, 210, 100, 20);
            int num = 4;
            while (num <= 64){
                cmbram.addItem(num);
                num*=2;
            }
            ///////////////////////////////////////////////////////////////////
            lblalma = new JLabel("Almacenamiento");
            lblalma.setBounds(10, 240, 100, 20);
            chssd = new JCheckBox("SSD");
            chssd.setBounds(120, 240, 50, 20);
            chhdd = new JCheckBox("HDD");
            chhdd.setBounds(170, 240, 50, 20);
            ////////////////////////////////////////////////////////////////////
            lblpre = new JLabel("Precio");
            lblpre.setBounds(10, 270, 100, 20);
            txtpre = new JTextField();
            txtpre.setBounds(120, 270, 100, 20);
            ////////////////////////////////////////////////////////////////////
            btnmos = new JButton("Mostrar");
            btnmos.setBounds(230, 300, 70, 20);
            btnmos.addActionListener(this);
            
            btnregis = new JButton("Registrar");
            btnregis.setBounds(120, 300, 70, 20);
            btnregis.addActionListener(this);
            ////////////////////////////////////////////////////////////////////
            ///////////IMAGEN//////////////////////////
            icono_img = new ImageIcon("img.png");
            lblimagen = new JLabel(icono_img);
            
            lblimagen.setBounds(230, 60, 145, 170);
            ////////////////////////////////////////////////////////////////////
                    add(lbltit);
            add(lblid);      add(txtid);
            add(lblmar);     add(cmbmar);
            add(lblnom);     add(txtnom);
            add(lbltam);     add(cmbtam);
            add(lblcpu);     add(rdinter);  add(rdamd);
            add(lblram);     add(cmbram);
            add(lblalma);    add(chssd);    add(chhdd);
            add(lblpre);     add(txtpre);
            add(btnregis);     add(btnmos);
            add(lblimagen);
            /////////////////////////////////////////////////////////////////////
            
            
            
            setVisible(true);
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
    }
        ///////////////////////////////////    public static void main(String args [])
/////////////////////////////////////
    public static void main(String args [])
    {
        form = new GadgetMejorado();
    }
    
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==btnregis)
        {
            productos = new Gadget();

            productos.id_gad=txtid.getText();
            productos.marca = cmbmar.getSelectedItem().toString();
            productos.nombre =txtnom.getText();
            productos.tamanio = Integer.parseInt(cmbtam.getSelectedItem().toString());
            if(rdinter.isSelected())
            {
                productos.procesador="Inter";
            }
            if(rdamd.isSelected())
            {
                productos.procesador="ADM";
            }
            productos.ram = Integer.parseInt(cmbram.getSelectedItem().toString());
            if(chssd.isSelected())
            {
                productos.almacenamiento += "SSD"; 
            }
            if(chhdd.isSelected())
            {
                productos.almacenamiento += "HDD";
            }
            productos.precio = Double.parseDouble(txtpre.getText());

            cajas[cont] = productos;
            cont ++;

            JOptionPane.showMessageDialog(null, "****Producto Registrado***");
            limpiar();
        }
        /*
        if(rdinter.isSelected())
        {
            procesa="Inter";
        }
        else
        {
            procesa="AMD";
        }
        if(chssd.isSelected())
        {
            almacenamiento += "_SSD_";
        }
        if(chhdd.isSelected())
        {
            almacenamiento += "_HDD_";
        }
        datos = "ID Gadget: "+ txtid.getText()
                +"\nMarca: "+ cmbmar.getSelectedItem().toString()
                +"\nNombre: " + txtnom.getText()
                +"\nTamanio: " + cmbtam.getSelectedItem().toString()
                +"\nProcesador: " + procesa
                +"\nRam: " + cmbram.getSelectedItem().toString()
                +"\nAlmacenamiento: " + almacenamiento
                +"\n\nPrecio: "+ txtpre.getText();
        */
        
        if(evt.getSource()==btnmos)
        {
            //JOptionPane.showMessageDialog(null, datos);
            //limpiar();
            t = new TablaGadget (cajas, cont);
            form.setVisible(false);
        }
        /*
        if(evt.getSource()==btnregis)
        {
            JOptionPane.showMessageDialog(null, "Gadget Registrado");
        }
        */
    }
    void limpiar()
    {
        txtid.setText("");
        cmbmar.setSelectedIndex(0);
        txtnom.setText("");
        cmbtam.setSelectedIndex(0);
        groupcpu.clearSelection();
        cmbram.setSelectedIndex(0);
        chssd.setSelected(false);
        chhdd.setSelected(false);
        txtpre.setText("");
        
    }
}

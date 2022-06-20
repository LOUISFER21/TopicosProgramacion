package Unidad2;
/**
 *
 * @author LOUIS
 */
import java.awt.Color;
import java.awt.color.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
public class FormularioPaciente extends JFrame implements ActionListener
{
    
    Paciente morido;
    TablaPacientes t;
    static FormularioPaciente form;   //tipo static 
    static FormularioMedico formmed;
    static Hospital formhos;
    Paciente cajas[]= new Paciente[100];   //es un array
    
    JLabel lblimg, lbltit, lblnom, lbldom, lblsex, lbledad, lbltsangre,
            lblpeso, lbltalla;
    JTextField txtnom, txtdom, txtpeso, txttalla;
    JRadioButton rdhombre, rdmujer;
    ButtonGroup groupsexo;
    JComboBox cmbedad, cmbtsangre;
    JButton btnregistrar, btnmostrar, btnmedico;
    Icon imagen;
    JPanel panel;    //panel
    String datos, sexo;
    int cont=0;
    
    FormularioPaciente()    //Constructor
    {
        formmed = new FormularioMedico();
        formhos = new Hospital();
        
        panel = new JPanel();
        panel.setLayout(null);
        
        imagen = new ImageIcon("logo.png");
        lblimg = new JLabel(imagen);
        lblimg.setBounds(10,10, 40, 40);
        
        lbltit = new JLabel("REGISTRO PACIENTE");
        lbltit.setFont(new Font("Arial", Font.BOLD, 14));
        lbltit.setBounds(70,15,150,30);

        lblnom = new JLabel ("Nombre: ");
        lblnom.setBounds(10, 60, 100, 20);
        
        txtnom = new JTextField();
        txtnom.setBounds(160, 60, 100, 20);
        
        lbldom = new JLabel ("Domicilio: ");
        lbldom.setBounds(10, 90, 100, 20);
        
        txtdom = new JTextField();
        txtdom.setBounds(160, 90, 100, 20);
        
        lblsex = new JLabel("Sexo: ");
        lblsex.setBounds(10, 120, 100, 20);
        
        rdhombre = new JRadioButton("Hombre");
        rdhombre.setBounds(140, 120, 70, 20);
        rdmujer = new JRadioButton("Mujer");
        rdmujer.setBounds(215, 120, 70, 20);
        groupsexo = new ButtonGroup();
            groupsexo.add(rdhombre);
            groupsexo.add(rdmujer);
            
        lbledad = new JLabel("Edad: ");
        lbledad.setBounds(10, 150, 100, 20);
        
        cmbedad = new JComboBox();
        cmbedad.setBounds(160, 150, 100, 20);
            for(int i=1; i<=110; i++)
            {
                cmbedad.addItem(i);
            }
        lbltsangre = new JLabel ("Tipo de sangre: ");
        lbltsangre.setBounds(10, 180, 100, 20);
        cmbtsangre = new JComboBox();
        cmbtsangre.setBounds(160, 180, 100, 20);
            cmbtsangre.addItem("Selecciona");
            cmbtsangre.addItem("O+");
            cmbtsangre.addItem("O-");
            cmbtsangre.addItem("A+");
            cmbtsangre.addItem("A-");
            cmbtsangre.addItem("B+");
            cmbtsangre.addItem("B-");
            
        lblpeso = new JLabel ("Peso: ");
        lblpeso.setBounds(10, 210, 100, 20);
        
        txtpeso = new JTextField();
        txtpeso.setBounds(160, 210, 100, 20);
        
        lbltalla = new JLabel ("Talla: ");
        lbltalla.setBounds(10, 240, 100, 20);
        
        txttalla = new JTextField();
        txttalla.setBounds(160, 240, 100, 20);
        
        btnregistrar = new JButton("Registrar");
        btnregistrar.setBounds(50, 280, 100, 20);
        btnregistrar.addActionListener(this);
        
        btnmostrar = new JButton("Mostrar");
        btnmostrar.setBounds(170, 280, 100, 20);
        btnmostrar.addActionListener(this);
        
        btnmedico = new JButton("Registrar medico");
        btnmedico.setBounds(120, 310, 100, 20);
        btnmedico.addActionListener(this);
        
        
        
            
        
        
        
        
        
        add(lblimg);    add(lbltit);
        add(lblnom);    add(txtnom);
        add(lbldom);    add(txtdom);
        add(lblsex);    add(rdhombre);  add(rdmujer);
        add(lbledad);   add(cmbedad);
        add(lbltsangre); add(cmbtsangre);
        add(lblpeso);   add(txtpeso);
        add(lbltalla);  add(txttalla);
        add(btnregistrar);  add(btnmostrar);
        add(btnmedico);
        add(panel);
        
        
        setVisible(true);
        setSize(310, 380);
        panel.setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
    }
    public static void main(String args[])
    {
        form = new FormularioPaciente();   //misma propiedad static (objeto static)
    }
    
    @Override
    public void actionPerformed(ActionEvent evt)
    {    
       if(evt.getSource()==btnregistrar) //si la fuente del evento es igual a boton registrar
       {
            morido = new Paciente();
            
            morido.nom=txtnom.getText();
            morido.domicilio=txtdom.getText();
            if(rdhombre.isSelected())
            {
                morido.sexo = "Hombre";
            }
            if(rdmujer.isSelected())
            {
                morido.sexo = "Mujer";
            }
            morido.edad =Integer.parseInt(cmbedad.getSelectedItem().toString());
            morido.t_sangre = cmbtsangre.getSelectedItem().toString();
            morido.peso = Double.parseDouble(txtpeso.getText());
            morido.talla =Double.parseDouble(txttalla.getText());
            
            cajas[cont] = morido;
            cont ++;
            
            JOptionPane.showMessageDialog(null, "*********Paciente registrado Correctamente*****");
            limpiar();
       }
       if(evt.getSource()==btnmostrar)
       {
           /*
           for(int i=0; i<cont; i++)
           {
            JOptionPane.showMessageDialog(null,"Nombre: "+ cajas[i].nom
                + "\nDomicilio: "+ cajas[i].domicilio
                + "\nSexo: " + cajas[i].sexo
                + "\nEdad: " + cajas[i].edad
                + "\nTipo de sangre: " + cajas[i].t_sangre
                + "\nPeso: " + cajas[i].peso
                + "\nTalla: "+ cajas[i].talla);   
           } 
           */
           //TablaPacientes t = new TablaPacientes (cajas, cont);
           t = new TablaPacientes (cajas, cont);
           form.setVisible(false);
           
           //this.setVisible(false);    // Es para quitar ventana
           
       }
       if(evt.getSource()==btnmedico)
       {
           formmed.setVisible(true);
           form.setVisible(false);
       }
    }
    
    void limpiar()
    {
        txtnom.setText("");
        txtdom.setText("");
        groupsexo.clearSelection();
        cmbedad.setSelectedIndex(0);
        cmbtsangre.setSelectedIndex(0);
        txtpeso.setText("");
        txttalla.setText("");
    }
    
}

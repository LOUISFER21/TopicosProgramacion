
package Examen2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioCurso extends JFrame implements ActionListener
{    
    
    JLabel lbltit, lbltipo, lblnumero;
    JComboBox cmbtipo, cmbnumero;
    JButton btnreg, btnmos, btnregresar;
    JPanel cont;
    
    static FormularioCurso form;
    static FormularioBaucher formfinal;
    CursoAcesorias doc;
    CursoAcesorias consultorios[] = new CursoAcesorias[100];
    int numdoc=0;
    
    
    String nombre="Luis", Materia="mate";
    double pago=200, total=70, iva=32, totalneto;
    
    TablaCursos t;
    
    FormularioCurso()
    {
        cont = new JPanel();
        cont.setLayout(null);
        
        lbltit = new JLabel("AGENDA CURSO");
        lbltit.setFont(new Font("Arial", Font.BOLD, 14));
        lbltit.setBounds(100,10,180,40);
        
        lbltipo = new JLabel ("Tipo de curso: ");
        lbltipo.setBounds(10, 60, 100, 20);
        cmbtipo = new JComboBox();
        cmbtipo.setBounds(120, 60, 100, 20);
            cmbtipo.addItem("Selecciona");
            cmbtipo.addItem("intensivo");
            cmbtipo.addItem("otro");
            
        lblnumero = new JLabel ("Numero de personas: ");
        lblnumero.setBounds(10, 90, 100, 20);
        cmbnumero = new JComboBox();
        cmbnumero.setBounds(120, 90, 100, 20);
            cmbnumero.addItem("seleciona");
            cmbnumero.addItem("1");
            cmbnumero.addItem("2");
            cmbnumero.addItem("3");
            cmbnumero.addItem("4");
            cmbnumero.addItem("5");
            
        btnreg = new JButton("Registrar");
        btnreg.setBounds(30, 250, 100, 20);
        btnreg.addActionListener(this);
        
        btnmos = new JButton("Mostrar");
        btnmos.setBounds(140, 250, 100, 20);
        btnmos.addActionListener(this);
        
        btnregresar = new JButton("Imprimir Baucher");
        btnregresar.setBounds(80, 280, 100, 20);
        btnregresar.addActionListener(this);
        
        add(lbltit);
        add(lbltipo);    add(cmbtipo);
        add(lblnumero);    add(cmbnumero);
        add(btnreg); add(btnmos);  add(btnregresar);
        add(cont);
        
        //setVisible(true);
        setSize(300, 380);
        cont.setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);   
        
        consultorios=new CursoAcesorias[100];
        
    }
    public static void main(String args[])
    {
         form = new FormularioCurso(); 
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {   
        if(e.getSource()==btnreg)
        {
            doc = new CursoAcesorias();
            doc.tipo=cmbtipo.getSelectedItem().toString();
            doc.personas=Integer.parseInt(cmbnumero.getSelectedItem().toString());
            consultorios[numdoc]=doc;
            numdoc++;
            
            JOptionPane.showMessageDialog(null, "*********cita registrado Correctamente*****");
            limpiar();
        }
            
        if(e.getSource()==btnmos)
        {
           //t = new TablaCursos (consultorios, numdoc);
           //form.setVisible(false);
        }
        if(e.getSource()==btnregresar)
        {
            totalneto=pago+total+iva;
           JOptionPane.showMessageDialog(null, "**************Boucher de Acesoria****************"
                   + "\n Total: "+pago
                   +"\nMateria:"
                   + "\n Iva:"+iva
                   + "\n Total neto:"+totalneto
                    );
            
        }
    }  
    void limpiar()
    {
        
        
        cmbtipo.setSelectedIndex(0);
        cmbnumero.setSelectedIndex(0);         
    }
    void precios()
    {
        double preciomas;
        
        if(cmbtipo.equals("intersivo"))
        {
            preciomas= pago*.35;
        }
        
            
    }
}

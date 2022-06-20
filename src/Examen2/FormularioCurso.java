
package Examen2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioCurso extends JFrame  implements ActionListener 
{    
    
    JLabel lbltit, lbltipo, lblnumero, lbldocente;
    JComboBox cmbtipo, cmbnumero, cmbdocente;
    JButton btnreg, btnmos, btnregresar;
    JPanel cont;
    
    static FormularioCurso form;
    static FormularioAsesorias mas;
    CursoAcesorias doc;
    CursoAcesorias oficinass[] = new CursoAcesorias[100];
    int numdoc=0;
    TablaCursos tabla;
    
    double extraintensivo=0, extrapersonas=0;
    
    
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
            cmbtipo.addItem("normal");
            cmbtipo.addItem("Intensivo");
            cmbtipo.addItem("otro");
            
        lblnumero = new JLabel ("Numero de personas: ");
        lblnumero.setBounds(10, 90, 100, 20);
        cmbnumero = new JComboBox();
        cmbnumero.setBounds(120, 90, 100, 20);
            for(int i=1; i<20; i++)
            {
                cmbnumero.addItem(i);
            }
       
        
        btnreg = new JButton("Registrar");
        btnreg.setBounds(30, 250, 100, 20);
        btnreg.addActionListener(this);
        
        btnmos = new JButton("Mostrar");
        btnmos.setBounds(140, 250, 100, 20);
        btnmos.addActionListener(this);
        
        btnregresar = new JButton("Registrar acesoria");
        btnregresar.setBounds(80, 280, 100, 20);
        btnregresar.addActionListener(this);
        
        add(lbltit);
        add(lbltipo);    add(cmbtipo);
        add(lblnumero);    add(cmbnumero);
       
        add(btnreg); add(btnmos);  add(btnregresar);
        add(cont);
        
        setSize(300, 380);
        cont.setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        
        
        oficinass=new CursoAcesorias[100];
        
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
            
            oficinass[numdoc]=doc;
            numdoc++;
            
            JOptionPane.showMessageDialog(null, "*********Tipo acesoria registrado correctamente*****");
            limpiar();
            tipoCurso();
        }
            
        if(e.getSource()==btnmos)
        {
           tabla = new TablaCursos (oficinass, numdoc);
           form.setVisible(false);
        }
        if(e.getSource()==btnregresar)
        {
            FormularioAsesorias.formhos.construir_combos();
            FormularioAsesorias.formhos.setVisible(true);
            FormularioAsesorias.formmed.setVisible(false);
        }
    }  
    void tipoCurso()
    {
        if(doc.tipo.equalsIgnoreCase("intensivo"))
        {
            extraintensivo = mas.costohora*0.35;
        }
        if(doc.personas>2)
        {
            extrapersonas = doc.personas*.16;
        }
    
    }
    
    
   void limpiar()
   {     
       cmbtipo.setSelectedIndex(0);
       cmbnumero.setSelectedIndex(0);         
   }
}

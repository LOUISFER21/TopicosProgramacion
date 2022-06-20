package Examen2;
/**
 *
 * @author fersa
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CrearBaucher extends JFrame implements ActionListener
{
   JLabel lbltit, lbldocente, lblhora;
   JComboBox cmbhora;
   JComboBox cmbdocente;
   JButton btnregistrar, btnmostrar, btnimprimir;
   JPanel baucher;
   Double total, iva,tneto;
   static FormularioAsesorias mas;
   static FormularioCurso mas1;
   static CrearBaucher form = new CrearBaucher();
   CursoAcesorias doc;
   String nombre="Antonio",especialidad="Programacion", turno="Matutino",materia="Topicos de Programacioin", curso="normal", personas="5", horasp="6";
   String pagohora="120", pagot="720",  totalneto="556.8", ival="76.8", intensivo="0", personas1="115.2";
   int horas=0;
  
  
   CrearBaucher()
   {
        baucher = new JPanel();
        baucher.setLayout(null);
        
        lbltit = new JLabel("Pago Acesoria");
        lbltit.setFont(new Font("Arial", Font.BOLD, 14));
        lbltit.setBounds(50,10,180,40);
        
        lbldocente = new JLabel ("Elige a tu acesor: ");
        lbldocente.setBounds(10, 60, 100, 20);
        
        
       
        
        lblhora =new JLabel("Horas");
        lblhora.setBounds(10, 90, 100, 20);
        cmbhora = new JComboBox(); 
        cmbhora.setBounds(120, 90, 100, 20);
        for(int i=1; i<9; i++)
        {
            cmbhora.addItem(i);
        }
        
        
        
        btnregistrar = new JButton ("Registrar");
        btnregistrar.setBounds(70, 210, 100, 20);
        btnregistrar.addActionListener(this);
        btnimprimir = new JButton ("imprimir");
        btnimprimir.setBounds(70, 250, 100, 20);
        btnimprimir.addActionListener(this);
        
        
        
        
        add(lbltit);
        add(lbldocente);  
        add(lblhora);   add(cmbhora);
        add(btnregistrar); add(btnimprimir);
        add(baucher);
        
        setSize(250, 350);
        baucher.setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
   
   }
   
   @Override
   public void actionPerformed(ActionEvent even)
   {
       
       if(even.getSource()==btnregistrar)
       {
           horas=Integer.parseInt(cmbhora.getSelectedItem().toString());
           JOptionPane.showMessageDialog(null, "Acesoria Registrada");
           tipoCurso();
       }
       if(even.getSource()==btnimprimir)
       {
           JOptionPane.showMessageDialog(null, "*****************Baucher Acesorias***************"
                   + "\n"+ baucher());
       }
       
   }
   void construir_combos()
   {
        
        cmbdocente = new JComboBox();
        for(int i=0; i < FormularioAsesorias.form.numdoc; i++)
        {
            cmbdocente.addItem(FormularioAsesorias.form.oficinas[i].nombre_docente);
        }
        cmbdocente.setBounds(120, 60, 100, 20);
        baucher.add(cmbdocente);
        repaint();
   }
   void tipoCurso()
    {
        total=(mas.costohora+mas1.extraintensivo+mas1.extrapersonas)*form.horas;
        iva= total*.16;
        tneto= iva+total;
    }
   String baucher()
   {
       String cadena;
       cadena="Docente........................." + form.nombre
               +"\nEspecialidad................"+form.especialidad
               + "\nTurno......................"+form.turno
               + "\nMateria...................."+form.materia
               + "\nHora Pago..................$"+form.pagohora
               + "\nHoras de curso............."+ form.horasp  
               + "\nTipo de curso.............."+ form.curso
               + "\nNumero de Personas........."+form.personas
               + "\nTotal......................$"+form.pagot
               + "\nExtra curso intensivo......$"+form.intensivo
               + "\nExtra mas de dos personas..$"+form.personas1
               + "\nIva........................$"+form.ival
               + "\nTotal neto.................$"+form.totalneto;
       return cadena;
   }
   public static void main (String args[])
   {
       CrearBaucher p = new CrearBaucher();
        JOptionPane.showMessageDialog(null, "*****************Baucher Acesorias***************"
                + "\n"+ p.baucher());
   }
}



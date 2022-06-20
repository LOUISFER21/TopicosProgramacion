package Unidad3;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
public class EjemploKeylistener extends JFrame implements KeyListener,ActionListener
{
    int n=0, n1=0, n2=0, n3=0;
    String aux="", aux1="", aux2="", aux3="";
    JLabel lbltit, lbluser, lblpas, lblrfc, lblmail;
    JTextField txtuser, txtpas, txtrfc, txtmail;
    JButton btnregistrar, btnacceder;
    PanelFondo p1;   
    EjemploKeylistener ()
    {
            lbltit = new JLabel("LOGIN");
            lbltit.setFont(new Font("Arial",Font.BOLD, 14));
            lbltit.setBounds(200, 2, 200, 30);
            
            lbluser = new JLabel ("User");
            lbluser.setBounds(30, 60, 100, 20);
            txtuser = new JTextField();
            txtuser.setBounds(140, 60,100,20);
            
            lblpas = new JLabel ("Password");
            lblpas.setBounds(30, 90, 100, 20);
            txtpas = new JTextField();
            txtpas.setBounds(140, 90, 100, 20);
            
            lblrfc = new JLabel ("RFC");
            lblrfc.setBounds(30, 120, 100, 20);
            txtrfc = new JTextField();
            txtrfc.setBounds(140, 120, 100, 20);
            
            lblmail = new JLabel ("Email");
            lblmail.setBounds(30, 150, 100, 20);
            txtmail = new JTextField();
            txtmail.setBounds(140, 150, 100, 20);
            
            btnregistrar = new JButton("Registrar");
            btnregistrar.setBounds(100, 200, 100, 20);
            
            btnacceder = new JButton("Ingresar");
            btnacceder.setBounds(210, 200, 100, 20);
            
            p1=new PanelFondo("fondo.png");
            p1.setLayout(null);
            txtuser.addKeyListener(this);
            txtpas.addKeyListener(this);
            txtrfc.addKeyListener(this);
            txtmail.addKeyListener(this);
            
            add(lbltit);
            add(lbluser);      add(txtuser);
            add(lblpas);     add(txtpas);
            add(lblrfc);    add(txtrfc);   
            add(lblmail);   add(txtmail);
            add(btnacceder);    add(btnregistrar);
            add(p1);
            
            
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(433, 300);
            setLocationRelativeTo(null);
            
    }
    public static void main(String args [])
    {
        new EjemploKeylistener();        
    }
    @Override
    public void keyTyped(KeyEvent e) 
    {
        if(e.getSource()==txtuser)
        {    
            System.out.println("Presed log");
        }
        if(e.getSource()==txtpas)
        {
            System.out.println("Presed pas");
        }
    }
    @Override
    public void keyPressed(KeyEvent e) 
    {   
        System.err.println(txtuser.getText().length());
        System.err.println(txtpas.getText().length());
    }
    @Override
    public void keyReleased(KeyEvent e) 
    {
        if(e.getSource()==txtuser)
        {
            System.err.println(txtuser.getText().length());
            if(txtuser.getText().charAt(n)>=65 && txtuser.getText().charAt(n)<=90
              || txtuser.getText().charAt(n)>=97 && txtuser.getText().charAt(n)<=122)
            {
                aux += txtuser.getText().charAt(n);
                n++;
            }
            txtuser.setText(aux);
        }   
        if(e.getSource()==txtpas)
        {
            System.out.println(txtpas.getText().length());
            if(txtpas.getText().charAt(n1)>=49 && txtpas.getText().charAt(n1)<=57)
            {
                aux1+= txtpas.getText().charAt(n1);
                n1++;
            }
            txtpas.setText(aux1);
        }
        if(e.getSource()==txtrfc)
        {
            System.out.println("n3:" +n2);
                if(n2<10)
                {
                    if(n2<4)
                    {
                        if(txtrfc.getText().charAt(n2)>=65 && txtrfc.getText().charAt(n2)<=90
                            || txtrfc.getText().charAt(n2)>=97 && txtrfc.getText().charAt(n2)<=122)
                        {
                            aux2 += txtrfc.getText().charAt(n2);
                            n2++;
                        }
                        txtrfc.setText(aux2.toUpperCase()); 
                    }
                    else 
                    {
                        if(txtrfc.getText().charAt(n2)>=48 && txtrfc.getText().charAt(n2)<=57)
                        {
                            aux2 += txtrfc.getText().charAt(n2);
                            n2++;
                        }
                        txtrfc.setText(aux2.toUpperCase()); 
                    }
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Solo se permiten 10 caracteres");
                    txtrfc.setText(aux2.toUpperCase());
                }           
        }
        if(e.getSource()==txtmail)
        {
            if(isEmail(txtmail.getText()))
            {
                
            }
            else 
            {                
                JOptionPane.showMessageDialog(null, "Correo incorrecto validar correo");
                
                txtmail.requestFocus();
            }            
        }
        
    }
    //metodo para validar correo
    public boolean isEmail(String correo)
    {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        mat = pat.matcher(correo);
        if(mat.find())
        {
            return true;
        }
        else 
        {
           return false;
        }
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
    
    }   
}



/// validad main 

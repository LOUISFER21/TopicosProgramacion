package Unidad1;
import java.awt.*;
import javax.swing.*;
public class Ventana extends JFrame 
{
    JLabel lbltitulo;
    JTextField txtdato;
    Ventana()
    {
        lbltitulo=new JLabel("Primer ventana");  //Crear texto
        add (lbltitulo);     //Mostrar texto
        
        txtdato = new JTextField (10);
        add (txtdato);
        
        //se aplica en esta clase, misma ventana.
        setTitle("Mi ventana");
        setLayout(new FlowLayout()); // manejadores de contenido o arganizadores de contenido.
        setSize(300, 250);
        setVisible(true);  // visualizar ventana
        //setLocation(600, 300); // posicion de la ventana, con cordenadas
        setLocationRelativeTo(null); //la ventan aparece al centro
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerrar ventana, y no siga corriendo
    }
    public static void main(String args [])
    {
        //crear objeto
        Ventana ven = new Ventana();
    }
} //temina clase

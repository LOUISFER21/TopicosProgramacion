
package Unidad4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author LOUID
 */
public class ConsultaCliente extends JFrame implements ActionListener 
{

    JTable tabla;
    JScrollPane barras;
    String encabezados[] = {"ID_cliente", "Nombre", "Ap. Paterno", "Ap. Materno", "Edad", "Genero", "Direccion","Telefono"};
    String datos[][];
    Conexion c;    //para realizar la coneccion
    ResultSet res = null;
    int i = 0;
    JPanel cont;
    JLabel lbleliminar, lblnombre;
    JTextField txteliminar, txtnombre;
    JButton btneliminar;
    JButton btnmodificar;

    public ConsultaCliente() //constructor
    {
        cont = new JPanel();
        cont.setLayout(null); 
        construirTabla();
            lbleliminar = new JLabel("Ingresa ID a eliminar");
            lbleliminar.setBounds(20, 250, 130, 20);
            txteliminar = new JTextField();
            txteliminar.setBounds(160, 250, 100, 20);
            
            lblnombre= new JLabel("Ingresa direccion modificar");
            lblnombre.setBounds(20,280,130,20);
            txtnombre = new JTextField();
            txtnombre.setBounds(160,280,100,20);
            
            
            btneliminar = new JButton("Eliminar");
            btneliminar.setBounds(270, 250, 100, 20);
            btneliminar.addActionListener(this);
            
            btnmodificar = new JButton("Modificar");
            btnmodificar.setBounds(270, 280,100,20);
            btnmodificar.addActionListener(this);

            cont.add(lbleliminar);
            cont.add(txteliminar);
            cont.add(btneliminar);
            cont.add(btnmodificar);
            cont.add(lblnombre);
            cont.add(txtnombre);
            cont.add(barras);
            add(cont);

            setSize(750, 400);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void construirTabla()
    {
        try {
            i=0;
            c = new Conexion();
            res = c.consultar("Select * from clientes");
 
            System.out.println("filas: " + c.filas);
            datos = new String[c.filas][8];
            while (res.next()) {
                datos[i][0] = res.getString("id_cliente");
                datos[i][1] = res.getString("nombre");
                datos[i][2] = res.getString("ap_paterno");
                datos[i][3] = res.getString("ap_materno");
                datos[i][4] = res.getString("edad");
                datos[i][5] = res.getString("genero");
                datos[i][6] = res.getString("direccion");
                datos[i][7] = res.getString("telefono");
                i++;
            }
            tabla = new JTable(datos, encabezados);
            barras = new JScrollPane(tabla);
            barras.setBounds(20, 40, 700, 200);
            //add(barras);

        } catch (Exception e) {
            System.out.println("Error tabla: " + e.getMessage());
        } finally {
            c.cerrar_con();
        }    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btneliminar) {
            c = new Conexion();
            try {
                c.proceso_tabla("delete from clientes where id_cliente=" + txteliminar.getText());
                JOptionPane.showMessageDialog(null, "Se ha eliminado el registro");
                cont .remove(barras);
                construirTabla();
                cont.add(barras);
                repaint();
            } catch (Exception a) {
                System.out.append("Error eliminar: " + a.getMessage());
            }
        }
        if(e.getSource()==btnmodificar)
        {
            c =new Conexion();
            try
            {
                c.proceso_tabla("update clientes set direccion=' "+txtnombre.getText()+" ' where id_cliente=" +txteliminar.getText());
                cont .remove(barras);
                construirTabla();
                cont.add(barras);
                repaint();
            }
            catch(Exception ex)
            {
            
            }
        }
    }

}
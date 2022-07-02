/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Unidad4;

import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author LOUID
 */
public class ConsultaAuto extends JFrame implements ActionListener {

    JTable tabla;
    JScrollPane barras;
    String encabezados[] = {"ID_auto", "Marca", "Modelo", "Color", "Año", "Precio", "Transmicion"};
    String datos[][];
    Conexion c;    //para realizar la coneccion
    ResultSet res = null;
    int i = 0;
    JPanel cont;
    JLabel lbleliminar, lblmarca;
    JTextField txteliminar, txtmarca;
    JButton btneliminar;
    JButton btnmodificar;

    public ConsultaAuto() //constructor
    {
        cont = new JPanel();
        cont.setLayout(null); 
        construirTabla();
            lbleliminar = new JLabel("Ingresa ID a eliminar");
            lbleliminar.setBounds(20, 250, 130, 20);
            txteliminar = new JTextField();
            txteliminar.setBounds(160, 250, 100, 20);
            
            lblmarca = new JLabel("Ingresa marca modificar");
            lblmarca.setBounds(20,280,130,20);
            txtmarca = new JTextField();
            txtmarca.setBounds(160,280,100,20);
            
            
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
            cont.add(lblmarca);
            cont.add(txtmarca);
            cont.add(barras);
            add(cont);

            setSize(500, 400);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void construirTabla()
    {
        try {
            i=0;
            c = new Conexion();
            res = c.consultar("Select * from auto");
 
            System.out.println("filas: " + c.filas);
            datos = new String[c.filas][7];
            while (res.next()) {
                datos[i][0] = res.getString("id_auto");
                datos[i][1] = res.getString("marca");
                datos[i][2] = res.getString("modelo");
                datos[i][3] = res.getString("color");
                datos[i][4] = res.getString("anio");
                datos[i][5] = res.getString("precio");
                datos[i][6] = res.getString("transmicion");
                i++;
            }
            tabla = new JTable(datos, encabezados);
            barras = new JScrollPane(tabla);
            barras.setBounds(20, 40, 450, 200);
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
                c.proceso_tabla("delete from auto where id_auto=" + txteliminar.getText());
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
                c.proceso_tabla("update auto set marca=' "+txtmarca.getText()+" ' where id_auto=" +txteliminar.getText());
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

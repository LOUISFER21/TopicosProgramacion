
package Unidad2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;import java.awt.GridLayout;

import java.awt.event.ActionListener;
import javax.swing.*;

public class DJtabbedPane extends JFrame implements ActionListener
{
    
    JLabel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11, pp1, pp2, pp3;
    JPanel panel1,panel2,panel3, panel4;
    JRadioButton rd1,rd2,rd3,rd4,rd5,rd6,rd7,rd8,rd9,
            r1,r2,r3,r4,r5,r6,r7,r8,r9,
            radio1, radio2, radio3, radio4, radio5,radio6, radio7, radio8, radio9;
    ButtonGroup grupo,grupo2,grupo3,g1,g2,g3, gru1, gru2, gru3;
    JButton btn1,btn2,btn3, btn4;
    JTextField login,password;
    JTabbedPane panelconfichas=new JTabbedPane();
    int calificacion=0;
    
    DJtabbedPane(){
        panel3 = new JPanel();
        p10 = new JLabel("Ingresa tu numero de folio");
        login = new JTextField();
        p10.setBounds(20,50,150,20);
        login.setBounds(180,50,150,20);
        p11 = new JLabel("Ingresa tu RFC");
        p11.setBounds(20,80,150,20);
        password = new JPasswordField();
        password.setBounds(180,80,150,20);
        btn3 = new JButton("Iniciar sesion");
        btn3.setBounds(20,130,110,20);
        btn3.addActionListener(this);
        panel3.add(p10);
        panel3.add(login);
        panel3.add(p11);
        panel3.add(password);
        panel3.add(btn3);
        panel3.setLayout(null);
        panelconfichas.addTab("Fase uno", null, panel3);
        
        panel1 = new JPanel();
        panel1.setBackground(Color.white);
        p1 = new JLabel("Como se declara un objeto?");
        p1.setFont(new Font("Arial", Font.ITALIC, 12));
        p1.setForeground(Color.BLUE);
        rd1 = new JRadioButton("Practica=new Practica()");
        rd1.addActionListener(this);
        rd2 = new JRadioButton("Practica=new Objeto()");
        rd2.addActionListener(this);
        rd3 = new JRadioButton("Practica obj=new Practica()");
        rd3.addActionListener(this);
        p2 = new JLabel("Para que sirve el JRadioButton");
        p2.setFont(new Font("Arial", Font.ITALIC, 12));
        p2.setForeground(Color.blue);
        rd4 = new JRadioButton("Agrupar JLabels");
        rd5 = new JRadioButton("Escuchar un evento");
        rd6 = new JRadioButton("Seleccionar solo una opcion  de un conjunto");
        rd6.addActionListener(this);
        p3 = new JLabel("Como se declara un constructor?");
        p3.setFont(new Font("Arial", Font.ITALIC, 12));
        p3.setForeground(Color.blue);
        rd7 = new JRadioButton("Void Nombre de la clase y atributos entre parentesis");
        rd8 = new JRadioButton("Nombre de la clase (publica u estatica)");
        rd9 = new JRadioButton("Debe llamarse como el nombre de la clase y parentesis");
        rd9.addActionListener(this);
        panel1.setLayout(new GridLayout(13, 1));
        btn4 = new JButton("Siguiente");
        btn4.addActionListener(this);
        grupo = new ButtonGroup();
        grupo2 = new ButtonGroup();
        grupo3 = new ButtonGroup();
        
        panel2 = new JPanel();
        panel2.setBackground(Color.white);
        p4 = new JLabel("Como declarar un boton?");
        p4.setFont(new Font("Arial", Font.ITALIC, 12));
        p4.setForeground(Color.blue);
        r1 = new JRadioButton("bt1=JButton();");
        r2 = new JRadioButton("bt1=new JButton();");
        r3 = new JRadioButton("bt1=JButton[];");
        r2.addActionListener(this);
        p5 = new JLabel("Como declarar una nueva fuente?");
        p5.setFont(new Font("Arial", Font.ITALIC, 12));
        p5.setForeground(Color.blue);
        r4 = new JRadioButton("label.setFont(new Font(''Arial'', Font.Italic,12))");
        r5 = new JRadioButton("label.setfont(new Font(''Arial'', Font.Italic,12))");
        r6 = new JRadioButton("label.setfont(new Font(''arial'', Font.Italic,12))");
        r4.addActionListener(this);
        p6 = new JLabel("Cual es el metodo correcto para action Performed?");
        p6.setFont(new Font("Arial", Font.ITALIC, 12));
        p6.setForeground(Color.blue);
        r7 = new JRadioButton("void ActionPerformed(ActionEvent e)");
        r8 = new JRadioButton("public void actionPerformed(ActionEvent e)");
        r9 = new JRadioButton("public void ActionPerformed(actionEvent e)");
        r8.addActionListener(this);
        panel2.setLayout(new GridLayout(13, 1));
        
        btn1 = new JButton("Siguiente");
        btn1.addActionListener(this);
        g1 = new ButtonGroup();
        g2 = new ButtonGroup();
        g3 = new ButtonGroup();
        
        panel4 = new JPanel();
        panel4.setBackground(Color.white);
        pp1 = new JLabel("que es una variable?");
        pp1.setFont(new Font("Arial", Font.ITALIC, 12));
        pp1.setForeground(Color.BLUE);
        radio1 = new JRadioButton("Una palabra se que utiliza en los atributos");
        radio1.addActionListener(this);
        radio2 = new JRadioButton("elemento imprescindible que utilizaremos con el fin de almacenar datos");
        radio2.addActionListener(this);
        radio3 = new JRadioButton("las dos");
        radio3.addActionListener(this);
        pp2 = new JLabel("que es un atributo");
        pp2.setFont(new Font("Arial", Font.ITALIC, 12));
        pp2.setForeground(Color.blue);
        radio4 = new JRadioButton("Es una variable que a;macenma informacion");
        radio5 = new JRadioButton("caractesisticas de un objeto");
        radio6 = new JRadioButton("porciones de información que un objeto posee");
        radio6.addActionListener(this);
        pp3 = new JLabel("que es una interfaz grafica?");
        pp3.setFont(new Font("Arial", Font.ITALIC, 12));
        pp3.setForeground(Color.blue);
        radio7 = new JRadioButton("ventanas con informacion");
        radio8 = new JRadioButton(" cuadros de diálogo, barras de herramientas, botones, listas");
        radio9 = new JRadioButton("las dos anteriores");
        radio9.addActionListener(this);
        panel4.setLayout(new GridLayout(13, 1));
        btn2 = new JButton("Evaluar");
        btn2.addActionListener(this);
        gru1 = new ButtonGroup();
        gru2 = new ButtonGroup();
        gru3 = new ButtonGroup();
        
        grupo3= new ButtonGroup();
        grupo.add(rd1);
        grupo.add(rd2);
        grupo.add(rd3);
        grupo2.add(rd4);
        grupo2.add(rd5);
        grupo2.add(rd6);
        grupo3.add(rd7);
        grupo3.add(rd8);
        grupo3.add(rd9);
        panel1.add(p1);
        panel1.add(rd1);
        panel1.add(rd2);
        panel1.add(rd3);
        panel1.add(p2);
        panel1.add(rd4);
        panel1.add(rd5);
        panel1.add(rd6);
        panel1.add(p3);
        panel1.add(rd7);
        panel1.add(rd8);
        panel1.add(rd9);
        panel1.add(btn1);
        panelconfichas.addTab("Fase Dos", null, panel1);
        
        //btn2.addActionListener(this);
        g1 = new ButtonGroup();
        g2 = new ButtonGroup();
        g3 = new ButtonGroup();
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);
        g2.add(r4);
        g2.add(r5);
        g2.add(r6);
        g3.add(r7);
        g3.add(r8);
        g3.add(r9);
        panel2.add(p4);
        panel2.add(r1);
        panel2.add(r2);
        panel2.add(r3);
        panel2.add(p5);
        panel2.add(r4);
        panel2.add(r5);
        panel2.add(r6);
        panel2.add(p6);
        panel2.add(r7);
        panel2.add(r8);
        panel2.add(r9);
        panel2.add(btn4);
        panelconfichas.addTab("Fase Tres", null, panel2);
        panelconfichas.enable(false);
        
        btn2.addActionListener(this);
        gru1 = new ButtonGroup();
        gru2 = new ButtonGroup();
        gru3 = new ButtonGroup();
        gru1.add(radio1);
        gru1.add(radio2);
        gru1.add(radio3);
        gru2.add(radio4);
        gru2.add(radio5);
        gru2.add(radio6);
        gru3.add(radio7);
        gru3.add(radio8);
        gru3.add(radio9);
        panel4.add(pp1);
        panel4.add(radio1);
        panel4.add(radio2);
        panel4.add(radio3);
        panel4.add(pp1);
        panel4.add(radio4);
        panel4.add(radio5);
        panel4.add(radio6);
        panel4.add(pp3);
        panel4.add(radio7);
        panel4.add(radio8);
        panel4.add(radio9);
        panel4.add(btn2);
        panelconfichas.addTab("Fase cuatro", null, panel4);
        panelconfichas.enable(false); 
        
        panelconfichas.setSelectedIndex(0);
        
        add(panelconfichas);
        setSize(500, 300);
        setVisible(true);
        setTitle("Evaluacion de Topicos Avanzados de Programacion");
    }   
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btn1){
            panelconfichas.setSelectedIndex(2);
        }
        if(e.getSource()==btn4){
            panelconfichas.setSelectedIndex(3);
        }
        if(e.getSource()==btn2){
            int cal=0;
            if(rd3.isSelected()){
                cal++;
            }
            if(rd6.isSelected()){
                cal++;
            }
            if(rd9.isSelected()){
                cal++;
            }
            if(r2.isSelected()){
                cal++;
            }
            if(r4.isSelected()){
                cal++;
            }
            if(r8.isSelected()){
                cal++;
            }
            if(radio2.isSelected())
            {
                cal++;
            }
            if(radio8.isSelected())
            {
                cal++;
            }
            if(radio8.isSelected())
            {
                cal++;
            }
            calificacion=(cal * 100)/9;
            JOptionPane.showMessageDialog(null, "Tu calificacion obtenida es: "+calificacion);
        }
        if(e.getSource()==btn3){
            if(login.getText().equals("2022") && password.getText().equals("GASL020721")){
                panelconfichas.setSelectedIndex(1);
            }
            else{
                JOptionPane.showMessageDialog(null, "Datos incorrectos ingreselos nuevamente");
                password.setText("");
            }
        }
    }
    public static void main(String args[]){
        DJtabbedPane dj=new DJtabbedPane();
    }  
}
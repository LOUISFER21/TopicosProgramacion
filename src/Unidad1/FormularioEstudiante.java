//Formulario(es un documento, que contiene casillas para almacenar datos que introduce el usuario)
package Unidad1;
import java.awt.*;
import javax.swing.*;
public class FormularioEstudiante extends JFrame       //Contenedores de ventana (JFrame)   
{
    //Declarar.
    //Etiquetas.
    JLabel lblnombre, lblape, lblnumC, lblsexo, lblpromedio, lblcarrera, lblactCul, lblsemestre, lblestatusA;
    //Caja de texto. 
    JTextField txtnombre, txtape, txtnumC, txtpromedio, txtestatusA;
    //Opciones, solo escojer una.
    ButtonGroup gruposexo, grupoestatus;
    JRadioButton rdhombre, rdmujer, rdexcelente, rdbueno, rdregular, rdmalo; 
    JComboBox cmbcarrera, cmbsemestre;
    JCheckBox checktaek, checkvol, checkbask;
    JButton btnregistrar, btnlimpiar;
    
    //constructor, se llama igual que la clase, si no lo hay se crea uno por default
    //inicio constructor
    FormularioEstudiante()
    {
        ////////////////////////////////////////////////////////////////////////
        lblnombre = new JLabel("Nombre: ");
        lblnombre.setForeground(Color.BLUE);  //Color de letra
        lblnombre.setFont(new Font("Arial", Font.BOLD, 15));  //tipo y tamano de letra.
        
        txtnombre = new JTextField(10);
        txtnombre.setForeground(Color.RED);
        //txtnombre.setBackground(Color.BLUE); //Color de fondo de texto
        
        ////////////////////////////////////////////////////////////////////////
        lblape = new JLabel ("Apellidos: ");
        lblape.setForeground(Color.BLUE);
        lblape.setFont(new Font("Arial", Font.BOLD, 15));
        
        txtape = new JTextField (10);
        txtape.setForeground(Color.RED);
        
        ////////////////////////////////////////////////////////////////////////
        lblnumC = new JLabel ("Numero de cuenta: ");
        lblnumC.setForeground(Color.BLUE);
        lblnumC.setFont(new Font("Arial", Font.BOLD, 10));
        
        txtnumC = new JTextField(10);
        txtnumC.setForeground(Color.RED);
        
        ////////////////////////////////////////////////////////////////////////
        lblsexo = new JLabel ("Sexo: ");
        rdhombre = new JRadioButton("Hombre");
        rdmujer = new JRadioButton("Mujer");
        gruposexo = new ButtonGroup(); 
        gruposexo.add(rdhombre);
        gruposexo.add(rdmujer);
        
        ////////////////////////////////////////////////////////////////////////
        lblcarrera = new JLabel("Carrera: ");
        cmbcarrera = new JComboBox();  //Combo lista desplegable
        cmbcarrera.addItem("Elige una opcion");
        cmbcarrera.addItem("ISC");
        cmbcarrera.addItem("Admin");
        cmbcarrera.addItem("Arqui");
        cmbcarrera.addItem("turis");
        ////////////////////////////////////////////////////////////////////////
        lblsemestre = new JLabel ("Semestre: ");
        cmbsemestre = new JComboBox(); //Combo lista desplejable
        cmbsemestre.addItem("Elige una opcion");
        cmbsemestre.addItem("Primero");
        cmbsemestre.addItem("Segundo");
        cmbsemestre.addItem("Tercero");
        cmbsemestre.addItem("Cuarto");
        cmbsemestre.addItem("Quinto");
        cmbsemestre.addItem("Sexto");
        cmbsemestre.addItem("Septimo");
        cmbsemestre.addItem("Octavo");
        cmbsemestre.addItem("Noveno");
        ////////////////////////////////////////////////////////////////////////
        lblpromedio = new JLabel ("Promedio: ");
        txtpromedio = new JTextField(10);
        ////////////////////////////////////////////////////////////////////////
        lblestatusA = new JLabel("Estatus Academico: ");
        rdexcelente = new JRadioButton("Excelente");
        rdbueno = new JRadioButton("Bueno");
        rdregular = new JRadioButton("Regular");
        rdmalo = new JRadioButton ("Malo");
        grupoestatus = new ButtonGroup();
        grupoestatus.add(rdexcelente);
        grupoestatus.add(rdbueno);
        grupoestatus.add(rdregular);
        grupoestatus.add(rdmalo);
        
        ////////////////////////////////////////////////////////////////////////
        lblactCul =new JLabel("Complementarias");
        checktaek = new JCheckBox("Taekwondo");
        checkvol = new JCheckBox("Voleibol");
        checkbask = new JCheckBox("Basquelbol");        
        ////////////////////////////////////////////////////////////////////////
        
        btnregistrar = new JButton("Registrar");
        btnlimpiar = new JButton("Limpiar");
       // lblsemestre = new JLabel("Sementre: ");
        
        add(lblnombre);         add(txtnombre);
        add(lblape);            add(txtape);
        add(lblnumC);           add(txtnumC);
        add(lblsexo);           add(rdhombre);      add(rdmujer);  ///Se agregan para que aparesca en cuadro de caja
        add(lblcarrera);        add(cmbcarrera);
        add(lblsemestre);       add(cmbsemestre);
        add(lblpromedio);       add(txtpromedio);
        add(lblestatusA);       
        add(rdexcelente);   add(rdbueno);   add(rdregular); add(rdmalo);
        add(lblactCul);
        add(checktaek);     add(checkvol);   add(checkbask);
        
        add(btnregistrar);  add(btnlimpiar);
        
        setLayout(new FlowLayout ());
        setTitle("Formulario estudiante"); //Titulo caja de texto
        setSize(240, 400);  //Tamano de caja
        setVisible(true);   //Mostrar texto
        setLocationRelativeTo(null);  //Centrar caja
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Pare cerrar proceso
    } //Fin del constructor
    //metodo main para ejecutar
    public static void main(String args [])
    {
        new FormularioEstudiante();
    }
    //fin metodo main
}


package Unidad4;

import java.sql.*;

public class Conexion
{
    static String bd = "pruebatopicos";
    static String login = "root";
    static String password;
    static String url = "jdbc:mysql://localhost/"+bd;
    static boolean conectado;
    static Statement instruccion=null;
    static ResultSet resultados=null;
    static int filas=0;
    static String controlador="com.mysql.jdbc.Driver";
    static Connection conn;
    public Conexion()
    {
        conn = null;
        try
        {
            Class.forName(controlador).newInstance();

            conn = DriverManager.getConnection(url,login,"");
            instruccion=conn.createStatement();

            if (conn != null)
            {
                System.out.println("Conexion a base de datos "+url+" ... Ok");
                conectado=true;
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos "+ex.getMessage());
            conectado=false;
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex);
            conectado=false;
        }
        catch(Exception m)
        {
            conectado=false;
        }
    }
    public void altas(String sentencia)throws Exception
    {
            instruccion.executeUpdate(sentencia);
    }
    public static ResultSet consultar(String sentenciaSQL)
    {
        ResultSet res=null;
        try
        {
            res=instruccion.executeQuery(sentenciaSQL);
            while(res.next())
              filas++;

            res=instruccion.executeQuery(sentenciaSQL);
            return res;
        }
        catch(Exception m)
        {
            System.out.println("Error en la consulta"+m.getMessage());
        }
        return res;
    }
    public static int obtenerMaximo()
    {
        return filas;
    }
    public static void main(String args [])
    {
        Conexion test=new Conexion();
    }    
}
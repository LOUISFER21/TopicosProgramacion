
package Unidad4;


import java.sql.*;
public class Conexion 
{
    String bd="prueba";
    String login="root";
    String url="jdbc:mysql://localhost/"+bd;
    boolean conectado;
    Statement instruccion=null;
    ResultSet resultados=null;
    int filas=0;
    String controlador="com.mysql.jdbc.Driver";
    Connection conn;
    public Conexion()
    {
        conn=null;
        try{
            Class.forName(controlador).newInstance();
            conn=DriverManager.getConnection(url,login,"");
            instruccion=conn.createStatement();
            if(conn!=null)
            {
                System.out.println("Conexion a base de datos"+url+"...OK");
                conectado=true;
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos");
            conectado=false;
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex);
            conectado=false;
        }
        catch(Exception m){
            conectado=false;
        }
    }
    public void proceso_tabla(String sentencia)throws Exception{
        //altas, bajas y modificaciones
        instruccion.executeUpdate(sentencia);
    }
    public ResultSet consultar(String sentenciaSQL){
        ResultSet res=null;
        try{
            res=instruccion.executeQuery(sentenciaSQL);
            while(res.next())
                filas++;
                  
                res=instruccion.executeQuery(sentenciaSQL);
                return res;
            
        }catch(Exception m){
            System.out.println("Error en la consulta"+m.getMessage());
        }
        return res;
    }
    public int obtenerMaximo(){
        return filas;
    }
    public void cerrar_con(){
        try{
            conn.close();
        }catch(Exception e){
            System.out.println("Error al cerrar sesion");
        }
    }
    public static void main(String[] args) {
        Conexion test=new Conexion();
    }
}

import java.sql.*;
import conexion.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;


public class Persona extends PersonaApp.PersonaPOA {
    private ORB orb;    
    Conexion conex = new Conexion();
    
    @Override
    public boolean insertarPersona(int identificacion, String nombre, String apellido, String direccion, String telefono, String email) {
        boolean resultado = false;
        try {
            String query = "insert into persona(identificacion,nombre,apellido,direccion,telefono,email)"
                    + "values ('"+identificacion+"','"+nombre+"','"+apellido+"','"+direccion+"','"+telefono+"','"+email+"')";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if(valor > 0){
                resultado = true;
            }
            //Cerramos los recursos.
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public String consultarPersona(int identificacion) {
        String resultado = "";
        try {
            String query = "Select * from persona where identificacion = "+identificacion;
            System.out.println(query);
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(2)+ " - "
                        + rs.getString(3) + " - "
                        + rs.getString(4) + " - "
                        + rs.getString(5) + " - "
                        + rs.getString(6) + " - "
                        + rs.getString(7) + "\n";
            }
            st.close();
            rs.close();
            conex.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarPersona(int identificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarPersona(int identificacion, String nombre, String apellido, String direccion, String telefono, String email) {
        boolean resultado = false;
        try {
            String query = "update persona set nombre ='"+nombre+"', apellido = '"+apellido+"', direccion = '"+direccion+"', telefono = '"+telefono+"', email = '"+email+"' where identificacion = '"+identificacion+"'";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if(valor > 0){
                resultado = true;
            }
            //Cerramos los recursos.
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public String listarPersonas() {
        String resultado = "";
        try {
            String query = "Select * from persona";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(2)+ " - "
                        + rs.getString(3) + " - "
                        + rs.getString(4) + " - "
                        + rs.getString(5) + " - "
                        + rs.getString(6) + " - "
                        + rs.getString(7) + "\n";
            }
            st.close();
            rs.close();
            conex.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet listaEstados(){
        ResultSet resultado = null;
        
        try {
            String query = "Select id, nombre from estado";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un erro: "+e.getMessage());
        }
        
        return resultado;
    }
    
}

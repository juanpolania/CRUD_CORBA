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
                    + "values ("+identificacion+","+apellido+","+direccion+","+telefono+","+email+")";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarPersona(int identificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarPersona(int identificacion, String nombre, String apellido, String direccion, String telefono, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String listarPersonas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

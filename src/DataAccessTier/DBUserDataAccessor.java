/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessTier;

import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oscar
 */
public class DBUserDataAccessor implements DataAccessible {

    private Connection conectar() throws SQLException {
        // Configura la conexión a la base de datos
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/myusersdb", "root", "abcd*1234");
    }

    @Override
    public User getUser() {
        User user = null;

        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement("Select * FROM usuario;")) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                user = new User();
                user.setuDni(rs.getString("uDni"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setUsuario(rs.getString("usuario"));
                user.setContraseina(rs.getString("contraseina"));
                user.setEdad(rs.getInt("edad"));
            }
        } catch(SQLException e){
            
        }
        
        return user;

    }

}

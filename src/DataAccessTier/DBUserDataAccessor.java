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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase responsable de acceder a los datos del usuario desde la base de datos.
 * Implementa la interfaz {@link DataAccessible}.
 * 
 * @author oscar
 */
public class DBUserDataAccessor implements DataAccessible {
    
    private static final Logger LOGGER = Logger.getLogger(DBUserDataAccessor.class.getName());

    /**
     * Establece una conexión con la base de datos.
     * 
     * @return la conexión a la base de datos
     * @throws SQLException si ocurre un error al conectar
     */
    private Connection conectar() throws SQLException {
        // Configura la conexión a la base de datos
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/myusersdb", "root", "abcd*1234");
    }

    /**
     * Obtiene la información del usuario desde la base de datos y la mapea a un objeto {@link User}.
     * 
     * @return un objeto User con los datos del usuario, o null si no se encuentra
     */
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
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener el usuario de la base de datos", e);
        }
        
        return user;
    }
}


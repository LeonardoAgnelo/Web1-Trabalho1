package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import br.ufscar.dc.dsw.domain.Usuario;

public class UsuarioDAO extends GenericDAO{

    public void insert(Usuario Usuario){
        String sql = "INSERT INTO Usuario (id, nome, email, senha tipo) VALUES (?, ?, ?, ?, ?) ";

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setInt(1, Usuario.getId());
            statement.setString(2, Usuario.getNome());
            statement.setString(3, Usuario.getEmail());
            statement.setString(4, Usuario.getSenha());
            statement.setString(5, Usuario.getTipo());
            statement.executeUpdate();

            statement.close();
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void delete(Usuario Usuario){
        String sql = "DELETE FROM Usuario where id = ?";

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, Usuario.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
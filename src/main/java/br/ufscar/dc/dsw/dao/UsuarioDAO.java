package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import br.ufscar.dc.dsw.domain.Usuario;

public class UsuarioDAO extends GenericDAO{

    public void insert(Usuario usuario){
        String sql = "INSERT INTO usuario (nome, email, senha, tipo) VALUES (?, ?, ?, ?) ";

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getTipo());
            statement.executeUpdate();

            statement.close();
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void update(Usuario usuario) {
        String sql = "UPDATE cliente SET nome = ?, email = ?, senha = ?, WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.setLong(5, usuario.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Usuario usuario){
        String sql = "DELETE FROM usuario where id = ?";

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, usuario.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Integer getIdByEmail(String email){
        Integer id = -1;

        String sql = "SELECT id FROM usuario u WHERE u.email = ?";

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                id = resultSet.getInt("id");
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return id;
    }

    public Usuario getByEmail(String email){
        Usuario usuario = null;

        String sql = "SELECT * FROM usuario WHERE email = ?";

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                String tipo = resultSet.getString("tipo");

                usuario = new Usuario(id, nome, email, senha, tipo);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return usuario;
    }
}
package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Agencia;

public class AgenciaDAO extends GenericDAO {

    public void insert(Agencia agencia) {

        String sql = "INSERT INTO agencia (cnpj, descricao, id_usuario) VALUES (?, ?, ?)";
        //inserir na tabela usuario do banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.insert(agencia);
        Long id = usuarioDAO.getIdByEmail(agencia.getEmail());

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, agencia.getCnpj());
            statement.setString(2, agencia.getDescricao());
            statement.setLong(3, id);
            statement.executeUpdate();

            statement.close();
            conn.close();
            
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Agencia agencia) {
        String sql = "UPDATE agencia SET cnpj = ?, descricao = ? WHERE id_usuario = ?";
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.update(agencia);

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, agencia.getCnpj());
            statement.setString(2, agencia.getDescricao());
            statement.setLong(3, agencia.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void delete(Agencia agencia) {
        String sql = "DELETE FROM agencia where id_usuario = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, agencia.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Agencia> getAll() {
        List<Agencia> listaAgencia = new ArrayList<>();
        String sql = "SELECT * FROM agencia a, usuario u WHERE a.id_usuario=u.id ORDER BY u.id";

        try{
            Connection conn = getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String tipo = resultSet.getString("tipo");
                String cnpj = resultSet.getString("cnpj");
                String descricao = resultSet.getString("descricao");
                Agencia agencia = new Agencia(id, nome, email, senha, tipo, cnpj, descricao);

                listaAgencia.add(agencia);
            }
            resultSet.close();
            statement.close();
            conn.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return listaAgencia;
    }
    public Agencia getById(Long id){
        Agencia agencia = null;

        String sql = "SELECT * FROM agencia a, usuario u WHERE a.id_usuario=u.id AND u.id = ?";

        try{   
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);


            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String tipo = resultSet.getString("tipo");
                String cnpj = resultSet.getString("cnpj");
                String descricao = resultSet.getString("descricao");

                agencia = new Agencia(id, nome, email, senha, tipo, cnpj, descricao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return agencia;

    }
}
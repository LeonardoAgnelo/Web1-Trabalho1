package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import br.ufscar.dc.dsw.domain.Cliente;

public class ClienteDAO extends GenericDAO {

    public void insert(Cliente cliente){
        String sql = "INSERT INTO cliente (cpf, telefone, sexo, data_nascimento, id_usuario) VALUES (?, ?, ?, ?, ?)";
        //inserir na tabela usuario do banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.insert(cliente);
        Integer id = usuarioDAO.getIdByEmail(cliente.getEmail());

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getCpf());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getSexo());
            statement.setTimestamp(4, cliente.getDataNascimento());
            statement.setInt(5, id);
            statement.executeUpdate();

            statement.close();
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
    public void update(Cliente cliente) {
        String sql = "UPDATE cliente SET cpf = ?, telefone = ?, sexo = ?, data_nascimento = ? WHERE id_usuario = ?";
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.update(cliente);

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, cliente.getCpf());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getSexo());
            statement.setTimestamp(4, cliente.getDataNascimento());
            statement.setLong(5, cliente.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Cliente cliente){
        String sql = "DELETE FROM cliente WHERE id =  ?";

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, cliente.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> getAll() {
        List<Cliente> listaCliente = new ArrayList<>();
        String sql = "SELECT * FROM cliente c, usuario u WHERE c.id_usuario=u.id ORDER BY u.id";

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
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                Timestamp dataNascimento = resultSet.getTimestamp("data_nascimento");
                Cliente cliente = new Cliente(id, nome, email, senha, tipo, cpf, telefone, sexo, dataNascimento);

                listaCliente.add(cliente);
            }
            resultSet.close();
            statement.close();
            conn.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return listaCliente;
    }

    public Cliente getById(Long id){
        Cliente cliente = null;

        String sql = "SELECT * FROM cliente c, usuario u WHERE c.id_usuario=u.id AND u.id = ?";

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
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                Timestamp dataNascimento = resultSet.getTimestamp("data_nascimento");

                cliente = new Cliente(id, nome, email, senha, tipo, cpf, telefone, sexo, dataNascimento);
            }
            resultSet.close();
            statement.close();
            conn.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return cliente;

    }
}
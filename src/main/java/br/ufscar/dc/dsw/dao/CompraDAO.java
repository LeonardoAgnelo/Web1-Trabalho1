package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Compra;

public class CompraDAO extends GenericDAO {
    public void insert(Compra compra){
        String sql = "INSERT INTO compra (id_cliente, id_pacote, data_reuniao, link_reuniao) VALUES (?, ?, ?, ?)";

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setLong(1, compra.getCliente().getId());
            statement.setLong(2, compra.getPacoteTuristico().getId());
            statement.setTimestamp(3, compra.getDataReuniao());
            statement.setString(4, compra.getLinkReuniao());
            statement.executeUpdate();

            statement.close();
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Boolean verificaCompraClienteByIdPacote(Cliente cliente, String idPacote){
        String sql = "SELECT * FROM compra co, cliente cl WHERE co.id_pacote = " + idPacote + " AND co.id_cliente = " + cliente.getId() + " AND cl.id_usuario = " + cliente.getId();

        Boolean comprou = false;

        try{
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                String cpf = resultSet.getString("cpf");

                if (cpf.equals(cliente.getCpf())) {
                    comprou = true;
                }
            }
            resultSet.close();
            statement.close();
            conn.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return comprou;
    }
}

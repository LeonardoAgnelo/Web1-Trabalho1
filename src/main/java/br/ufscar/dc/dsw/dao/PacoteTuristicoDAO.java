package br.ufscar.dc.dsw.dao;

import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.domain.Destino;
import br.ufscar.dc.dsw.domain.Foto;
import br.ufscar.dc.dsw.domain.PacoteTuristico;

public class PacoteTuristicoDAO extends GenericDAO {
    public void insert(PacoteTuristico pacoteTuristico) {
        String sql = "INSERT INTO pacote_turistico (cnpj_agencia, destino_cidade, destino_estado, destino_pais, data_partida, duracao_dias, valor, descricao, qtd_foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, pacoteTuristico.getAgencia().getCnpj());
            statement.setString(2, pacoteTuristico.getDestino().getCidade());
            statement.setString(3, pacoteTuristico.getDestino().getEstado());
            statement.setString(4, pacoteTuristico.getDestino().getPais());
            statement.setTimestamp(5, pacoteTuristico.getDataPartida());
            statement.setInt(6, pacoteTuristico.getDuracaoDias());
            statement.setFloat(7, pacoteTuristico.getValor());
            statement.setString(8, pacoteTuristico.getDescricao());
            statement.setInt(9, pacoteTuristico.getQtdFotos());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PacoteTuristico> getAll(String destino, String agencia, Timestamp dataPartida) {
        List<PacoteTuristico> listaPacotesTuristicos = new ArrayList<>();

        String sql = "SELECT * FROM pacote_turistico p, agencia a, usuario u WHERE (p.cnpj = a.cnpj_agencia AND a.id_usuario = u.id)";

        if (!destino.isEmpty() && destino != null) {
            sql = sql.concat(" AND (p.destino_cidade LIKE %" + destino + "% OR p.destino_estado LIKE %" + destino + "% OR p.destino_pais LIKE %" + destino + "%");
        }

        if (!agencia.isEmpty() && agencia != null) {
            sql = sql.concat(" WHERE u.nome LIKE %" + agencia + "%");
        }

        if (dataPartida != null) {
            sql = sql.concat(" WHERE p.dataPartida LIKE %" + dataPartida + "%");
        }

        sql.concat(" ORDER BY p.id");

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long idUsuario = resultSet.getLong("id_usuario");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String tipo = resultSet.getString("tipo");
                String cnpj = resultSet.getString("cnpj");
                String descricaoAgencia = resultSet.getString("descricao");
                Agencia agenciaDomain = new Agencia(idUsuario, nome, email, senha, tipo, cnpj, descricaoAgencia);

                

                Integer id = resultSet.getInt("id");
                String destinoCidade = resultSet.getString("destino_cidade");
                String destinoEstado = resultSet.getString("destino_estado");
                String destinoPais = resultSet.getString("destino_pais");
                Timestamp dataPartidaPacote = resultSet.getTimestamp("data_partida");
                Integer duracaoDias = resultSet.getInt("duracao_dias");
                Float valor = resultSet.getFloat("valor");
                String descricao = resultSet.getString("descricao");
                Integer qtdFotos = resultSet.getInt("foto");

                Destino destinoModel = new Destino(destinoCidade, destinoEstado, destinoPais);

                List<Foto> fotos = new FotoDAO().getAllById(id);

                PacoteTuristico pacoteTuristico = new PacoteTuristico(id, agenciaDomain, destinoModel, dataPartidaPacote, duracaoDias, valor, descricao, qtdFotos, fotos);
                listaPacotesTuristicos.add(pacoteTuristico);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPacotesTuristicos;
    }
}

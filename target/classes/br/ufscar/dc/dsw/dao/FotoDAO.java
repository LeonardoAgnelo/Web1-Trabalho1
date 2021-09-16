package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Foto;

public class FotoDAO extends GenericDAO {

    public void insert(Foto foto) {
         String sql = "INSERT INTO foto (id_pacote, url) VALUES (?, ?)";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;

            statement = conn.prepareStatement(sql);
            statement.setString(1, usuario.getIdPacote());
            statement.setString(2, usuario.getUrl());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Foto> getAll() {

        List<Foto> listaFoto = new ArrayList<>();

        String sql = "SELECT * from foto l, pacote_turistico e where l.id_pacote = e.id";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String url = resultSet.getString("url");
    
                PacoteTuristico pacote = new PacoteTuristico(id, cnpj_agencia);
                Foto foto = new Foto(pacote_id, url);
                listaFoto.add(foto);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaFoto;
    }

}
package com.prova.series.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.prova.series.models.Series;

public class SeriesDAO {

    static ConectarBanco minhaConexao;

    private static final String INCLUIR = "insert into \"series\" (\"nome\", \"descricao\", \"nome_autor\", \"nome_diretor\", \"qtd_temporadas\", \"id\") values (?,?,?,?,?,?)";

    //private static final String idINCRMENTO = "select count(*) from \"series\"";
    
    private static final String BUSCAR = "select * from \"series\" where \"id\"=?";
    private static final String LISTARSERIES = "select * from \"series\"";

    public SeriesDAO() {
        minhaConexao = new ConectarBanco("jdbc:postgresql://localhost:5432/SERIES", "postgres", "12345");
    }

    public void addSeries(Series Serie) {
        try {
            minhaConexao.conectar();

            PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(INCLUIR);

            instrucao.setString(1, Serie.getNome());
            instrucao.setString(2, Serie.getDescricao());
            instrucao.setString(3, Serie.getNome_autor());
            instrucao.setString(4, Serie.getNome_diretor());
            instrucao.setInt(5, Serie.getQtd_temporadas());
            instrucao.setInt(6, Serie.getId());
            instrucao.execute();

            minhaConexao.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro na Inclusão: " + e.getMessage());
        }
    }
    /*
    public int idIncremento() {
        int qtd_cadastratadas = 0;

        try {

            minhaConexao.conectar();

            Statement instrucao = minhaConexao.getConexao().createStatement();
            
            ResultSet rs = instrucao.executeQuery(idINCRMENTO);

            if (rs.next()) {
                qtd_cadastratadas = rs.getInt("Contagem: ");
            }

            minhaConexao.desconectar();

        } catch (SQLException e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }

        return qtd_cadastratadas;
    }
    */
    
    public static ArrayList<Series> listaCompleta() {

        ArrayList<Series> lista_Series = new ArrayList<>();
        Series serie = null;

        try {
            minhaConexao.conectar();

            Statement instrucao = minhaConexao.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(LISTARSERIES);

            while (rs.next()) {
                
                serie = new Series(rs.getString("nome"), rs.getString("descricao"), rs.getString("nome_autor"), rs.getString("nome_diretor"), rs.getInt("qtd_temporadas"), rs.getInt("id"));
                
                lista_Series.add(serie);
            }

            minhaConexao.desconectar();

        } catch (SQLException e) {
            System.out.println("Erro na busca geral: " + e.getMessage());
        }

        return lista_Series;
    }
}

package com.prova.series.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prova.series.repository.ConectarBanco;

import org.springframework.web.bind.annotation.GetMapping;

public class PopulaBanco {
    @GetMapping("/config")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = (Connection) new ConectarBanco("jdbc:postgresql://localhost:5432/SERIES", "12345", "postgres");

            stmt = con.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS series (nome VARCHAR(55), descricao VARCHAR(200), nome_autor VARCHAR(55), nome_diretor VARCHAR(55),  qtd_temporadas INTEGER, Id_pk INTEGER SERIAL PRIMARY KEY");
            stmt.execute();

            stmt = con
                    .prepareStatement("insert into series (nome, descricao, nome_autor, nome_diretor, qtd_temporadas) values\n"
                            + "('OnePiece', 'Piratas', 'Oda', 'Nobunaga', '22'),\n"
                            + "('Naruto', 'Ninjas', 'Kishimoto', 'Goenji', '14'),\n"
                            + "('Smallville', 'Superman', 'DC', 'Clack Kent', '14'),\n"
                            + "('Supernatural', 'Monstros', 'JK Dean', 'Sam', '13'),\n"
                            + "('Dragon Ball', 'Goku', 'Akira', 'Vegeta', '50'),\n"
                            + "('Hunterxhunter', 'Melhor anime incompleto', 'Togashi', 'desempregado', '50')");
            stmt.execute();

            con.close();

            response.getWriter().println("ok");

        } catch (SQLException ex) {
            response.getWriter().println(ex);
        }
    }

}

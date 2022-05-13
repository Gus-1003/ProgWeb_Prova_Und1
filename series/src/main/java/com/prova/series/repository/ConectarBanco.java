package com.prova.series.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectarBanco {

    private String caminho;
    private String usuario;
    private String senha;
    private Connection conexao;

    public ConectarBanco(String c, String u, String s) {
        this.caminho = c;
        this.usuario = u;
        this.senha = s;
    }

    public void conectar() {
        try {

            Class.forName("org.postgresql.Driver");
            
            conexao = DriverManager.getConnection(caminho, usuario, senha);

        } catch (Exception e) {
            System.out.println("Erro ao conectar ao conectar ao banco");
        }
        
    }

    public void desconectar() {
        try {

            conexao.close();

        } catch (Exception e) {

            System.out.println("Erro na desconexão: " + e.getMessage());
        }
    }

    public Connection getConexao() {
        return conexao;
    }
}
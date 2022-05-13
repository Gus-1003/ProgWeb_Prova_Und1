package com.prova.series.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prova.series.repository.SeriesDAO;

import org.springframework.web.bind.annotation.GetMapping;

public class SeriesController {

    @GetMapping("/listaProdutos")
    public void doListAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<table>");

        var listaCompleta = SeriesDAO.listaCompleta();

        for (var serie:listaCompleta ){
            writer.println("<tr>");
            writer.println("<td>");
            writer.println(serie.getNome());
            writer.println("</td>");
            writer.println("<td>");
            writer.println(serie.getDescricao());
            writer.println("</td>");
            writer.println("<td>");
            writer.println(serie.getNome_autor());
            writer.println("</td>");
            writer.println("<td>");
            writer.println(serie.getNome_diretor());
            writer.println("</td>");
            writer.println("<td>");
            writer.println(serie.getQtd_temporadas());
            writer.println("</td>");
            writer.println("<td>");
            writer.println("<a href='/adicionarCarrinho?id="+serie.getId()+"'>Adicionar</a>");
            writer.println("</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");
        writer.println("</body></html>");
    }


}
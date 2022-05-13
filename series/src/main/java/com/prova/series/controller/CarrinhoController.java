package com.prova.series.controller;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prova.series.models.Series;
import com.prova.series.repository.SeriesDAO;

import org.springframework.web.bind.annotation.GetMapping;

public class CarrinhoController {


    @GetMapping("/visualizarCarrinho")
    public void doVisualizarCarrinho(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Cookie carrinho = new Cookie("carrinho", "");
        carrinho.setMaxAge(60*60*24*7);

        Cookie[] requestCookies = request.getCookies();
        boolean achouCarrinho = false;

        if (requestCookies != null){
            for (var c:requestCookies){
                if (c.getName().equals("carrinho")){
                    achouCarrinho = true;
                    carrinho = c;
                    break;
                }
            }
        }

        /*if (achouCarrinho){
            var writer = response.getWriter();
            writer.println("<html><body>");
            writer.println("<table>");

            var SeriesDao = new SeriesDAO();

            StringTokenizer tokenizer = new StringTokenizer(carrinho.getValue(), "|");

            while (tokenizer.hasMoreTokens() ){

                List<Series> series = SeriesDao.buscarSerie(Integer.parseInt(tokenizer.nextToken()));
                
                if (series != null){

                    Series serie = series.get(0);

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
                    writer.println("<a href='/removerCarrinho?id="+ serie.getId() +"'>Remover</a>");
                    writer.println("</td>");
                    writer.println("</tr>");
                }
            }

            writer.println("</table>");
            writer.println("</body></html>");
        }else{
            response.getWriter().println("Carrinho vazio");
        }*/
    }
}

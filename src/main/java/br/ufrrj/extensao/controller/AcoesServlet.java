package br.ufrrj.extensao.controller;

import br.ufrrj.extensao.model.AcaoExtensao;
import br.ufrrj.extensao.repository.AcaoRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/acoes")
public class AcoesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");


        if (acao == null || acao.isEmpty()) {
            
         
            String termoBusca = request.getParameter("busca");
            
            List<AcaoExtensao> lista;

           
            if (termoBusca != null && !termoBusca.trim().isEmpty()) {
                
                lista = AcaoRepository.searchByTitleOrStatus(termoBusca, null);
            } else {
                lista = AcaoRepository.getAll();
            }

            request.setAttribute("lista", lista);
            request.getRequestDispatcher("listagem.jsp").forward(request, response);
            return;
        }

        if (acao.equals("detalhes")) {
            String idStr = request.getParameter("id");

            if (idStr == null) {
                response.sendRedirect("acoes");
                return;
            }

            try {
                int id = Integer.parseInt(idStr);
                AcaoExtensao objeto = AcaoRepository.getById(id);

                if (objeto == null) {
                    response.sendRedirect("acoes");
                    return;
                }

                request.setAttribute("acao", objeto);
                request.getRequestDispatcher("detalhes.jsp").forward(request, response);
                
            } catch (NumberFormatException e) {
                response.sendRedirect("acoes");
            }
            return;
        }

        response.sendRedirect("acoes");
    }
}
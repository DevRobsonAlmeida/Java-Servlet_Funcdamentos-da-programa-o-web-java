package br.com.alura.empresa.servlet;

import br.com.alura.empresa.entity.Banco;
import br.com.alura.empresa.entity.Empresa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
//@WebServlet("/alterarEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Empresa empresa = new Empresa();

        try {
            empresa.setId(Integer.valueOf(request.getParameter("id")));
            Banco banco = new Banco();

            empresa = banco.consultarId(empresa.getId());
            empresa.setNome(request.getParameter("nome"));
            empresa.setDataAbertura(sdf.parse(request.getParameter("data")));

            response.sendRedirect("listaEmpresas");
        } catch (ParseException ex) {
            Logger.getLogger(AlteraEmpresaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

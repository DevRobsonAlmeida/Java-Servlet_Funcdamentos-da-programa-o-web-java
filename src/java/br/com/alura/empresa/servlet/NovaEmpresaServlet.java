package br.com.alura.empresa.servlet;

import br.com.alura.empresa.entity.Banco;
import br.com.alura.empresa.entity.Empresa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Empresa empresa = new Empresa();
        Date dataAbertura = null;

        String nomeEmpresa = request.getParameter("nome");
        String paramDataAbertura = request.getParameter("data");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = (paramDataAbertura == "" ? new Date() : sdf.parse(paramDataAbertura));
            
            empresa.setNome(nomeEmpresa);
            empresa.setDataAbertura(dataAbertura);
        } catch (ParseException ex) {
            throw new ServletException(ex);
        }


        Banco banco = new Banco();
        banco.adiciona(empresa);
        
        request.setAttribute("nomeEmpresa", empresa.getNome());
        request.setAttribute("dataAbertura", empresa.getDataAbertura());
        
        // Chamar JSP
//        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//        rd.forward(request, response);
        
        //Redireciona
        response.sendRedirect("listaEmpresas");
    }
}

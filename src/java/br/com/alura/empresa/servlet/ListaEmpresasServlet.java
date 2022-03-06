package br.com.alura.empresa.servlet;

import br.com.alura.empresa.entity.Banco;
import br.com.alura.empresa.entity.Empresa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    List<Empresa> lista = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Banco banco = new Banco();
        lista = banco.getEmpresas();

        // Chama JSP
        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
        request.setAttribute("empresas", lista);
        rd.forward(request, response);
    }

    public void remove(Empresa empresa) {
        lista.removeIf(c -> Objects.equals(c.getId(), empresa.getId()));
    }

}

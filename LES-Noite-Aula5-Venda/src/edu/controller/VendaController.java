package edu.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.entidade.Venda;

@WebServlet("/VendaController")
public class VendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VendaController() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeCliente = request.getParameter("nomeCliente");
		String plataforma = request.getParameter("plataforma");
		String descricao = request.getParameter("descricao");
		String data = request.getParameter("data");
		String valor = request.getParameter("valor");
		String cmd = request.getParameter("cmd");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		@SuppressWarnings("unchecked")
		List<Venda> listaVendas = (List<Venda>)request.getSession().getAttribute("LISTA");
		
		if (listaVendas == null) { 
			listaVendas = new ArrayList<Venda>();
			request.getSession().setAttribute("LISTA", listaVendas);
		}
		
		if ("Adicionar".equals(cmd)) { 
			Venda v = new Venda();
			v.setNomeCliente(nomeCliente);
			v.setDescricao(descricao);
			v.setPlataforma(plataforma);
			try {
				v.setData(sdf.parse(data));
				v.setValor(Float.parseFloat(valor));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			listaVendas.add(v);
			System.out.println( "Venda cadastrada, há " + listaVendas.size() + " vendas na lista");
			System.out.println( v );

		} else if("Pesquisar".equals(cmd)) {
			List<Venda> vendasEncontradas = new ArrayList<Venda>();
			for (Venda venda : listaVendas) {
				if (venda.getNomeCliente().contains( nomeCliente )) { 
					System.out.println("Venda encontrada : ");
					System.out.println( venda );
					vendasEncontradas.add( venda );
				}
			}
			request.getSession().setAttribute("VENDASENCONTRADAS", vendasEncontradas);
		}
		
		
		response.sendRedirect("./venda.jsp");
	}

}

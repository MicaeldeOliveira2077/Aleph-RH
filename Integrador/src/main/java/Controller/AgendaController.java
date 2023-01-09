package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conexao.Conex;
import Model.Agenda1;
import Model.AgendaDao;

/**
 * Servlet implementation class AgendaController
 */
@WebServlet(urlPatterns = { "/AgendaController", "/agendar", "/edicao", "/listagem", "/exclusao", "/editaragenda" })
public class AgendaController extends HttpServlet {
	Agenda1 agen = new Agenda1();

	Conex Conexao = new Conex();

	AgendaDao dao = new AgendaDao();

	private static final long serialVersionUID = 1L;

	public AgendaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		if (action.equals(("/listagem"))) {
			ListarAgenda(request, response);
		} else if (action.equals("/edicao")) {
			ExibirAgenda(request, response);
		} else if (action.equals("/exclusao")) {
			ExcluirAgenda(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		String action = request.getServletPath();
		if (action.equals("/agendar")) {
			ASalvar(request, response);
		} else if(action.equals("/editaragenda")) {
			EditarAgenda(request,response);
		}

	}

	protected void ASalvar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		agen.setAssunto(request.getParameter("assunto"));
		agen.setData_agd(request.getParameter("data_agd"));
		agen.setTexto(request.getParameter("texto"));

		dao.Salvar(agen);
		response.sendRedirect("listagem");
		// System.out.println(agen.getAgd_id()+agen.getAssunto()+agen.getData_agd()+agen.getTexto());
	}

	protected void ListarAgenda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Agenda1> lista = dao.Listar();
		request.setAttribute("agens", lista);
		RequestDispatcher rd = request.getRequestDispatcher("Agendalist.jsp");
		rd.forward(request, response);

		

	}

	protected void ExibirAgenda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int Agd_id = Integer.parseInt(request.getParameter("agd_id"));

		agen.setAgd_id(Agd_id);

		dao.BuscaAgd(agen);
		;

		request.setAttribute("agd_id", agen.getAgd_id());
		request.setAttribute("assunto", agen.getAssunto());
		request.setAttribute("data_agd", agen.getData_agd());
		request.setAttribute("texto", agen.getTexto());

		RequestDispatcher rd = request.getRequestDispatcher("Agendaedit.jsp");
		rd.forward(request, response);

	}

	protected void EditarAgenda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int agd_id = Integer.parseInt(request.getParameter("agd_id"));

		agen.setAgd_id(agd_id);
		agen.setAssunto(request.getParameter("assunto"));
		agen.setData_agd(request.getParameter("data_agd"));
		agen.setTexto(request.getParameter("texto"));

		dao.Editar(agen);

		response.sendRedirect("listagem");

	}

	protected void ExcluirAgenda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int agd_id = Integer.parseInt(request.getParameter("agd_id"));

		agen.setAgd_id(agd_id);

		dao.Excluir(agen);

		response.sendRedirect("listagem");

	}
}

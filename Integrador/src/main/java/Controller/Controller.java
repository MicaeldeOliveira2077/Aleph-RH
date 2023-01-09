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
import Model.FunDao;
import Model.Funcionario;



@WebServlet(urlPatterns={"/Controller","/novofun","/buscafun","/selecionado","/fSalvar","/excluir"})
public class Controller extends HttpServlet {
	Funcionario fun = new Funcionario ();

	Conex Conexao = new Conex();

	FunDao dao = new FunDao();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();
		
		
		if (action.equals(("/buscafun"))){
			ListaDados(request, response);
		}
		else if (action.equals("/selecionado")){
			fEdit(request, response);
		}
		else if(action.equals("/excluir")) {
			fDelete(request,response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String action = request.getServletPath();
		if (action.equals("/fSalvar")){
		fSalvar(request, response);}
		
			else if (action.equals("/selecionado"))
			{
				fEdit(request, response);
				
			}else if (action.equals("/novofun")) {
				fcriarfun(request, response);
			}
			
		}
		
	protected void BuscaDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			fun.setFun_id(Integer.parseInt(request.getParameter("fun_id")));
			fun.setNome(request.getParameter("nome"));
			fun.setNome(request.getParameter("data_nasc"));
			fun.setNome(request.getParameter("cpf"));
			fun.setTelefone(request.getParameter("telefone"));
			fun.setNome(request.getParameter("entrada"));
			
			dao.Salvar(fun);
		
		
	}

	protected void ListaDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList <Funcionario> lista = dao.listar();
		request.setAttribute("funs", lista);
		RequestDispatcher rd = request.getRequestDispatcher("funlist.jsp"); 
		rd.forward(request, response); 
		
		System.out.println(lista);
		
		
	}
	
	protected void fEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("fun_id"));
		
		fun.setFun_id(id);
		
		dao.BuscaFun(fun);
		
		request.setAttribute("fun_id", fun.getFun_id());
		request.setAttribute("telefone", fun.getTelefone());
		request.setAttribute("nome", fun.getNome());
		request.setAttribute("endereco", fun.getEndereco());
		request.setAttribute("cpf", fun.getCpf());
		request.setAttribute("entrada", fun.getEntrada());
		request.setAttribute("data_nasc", fun.getData_nasc());

		
	
		RequestDispatcher rd = request.getRequestDispatcher("funedit.jsp");
		rd.forward(request, response); 
	
	
		
	}

	
	protected void fSalvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int fun_id = Integer.parseInt(request.getParameter("fun_id"));
		
		
		fun.setFun_id(fun_id);
		fun.setNome(request.getParameter("nome"));
		fun.setData_nasc(request.getParameter("data_nasc"));
		fun.setCpf(request.getParameter("cpf"));
		fun.setTelefone(request.getParameter("telefone"));
		fun.setEntrada(request.getParameter("entrada"));
		fun.setEndereco(request.getParameter("endereco"));
		
		
		
		dao.Editar(fun);
		
		response.sendRedirect("buscafun");
		
	}

	protected void fDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fun_id = Integer.parseInt(request.getParameter("fun_id"));
		
		fun.setFun_id(fun_id);
		
		dao.Excluir(fun);
		
		response.sendRedirect("buscafun");
	}

	
	protected void funlistt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList <Funcionario> lista = dao.listar();
		request.setAttribute("funs", lista);
		RequestDispatcher rd = request.getRequestDispatcher("funlist.jsp"); 
		rd.forward(request, response);
	
	
		
	}
	
protected void fcriarfun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


		
		
	
		fun.setNome(request.getParameter("nome"));
		fun.setData_nasc(request.getParameter("data_nasc"));
		fun.setCpf(request.getParameter("cpf"));
		fun.setTelefone(request.getParameter("telefone"));
		fun.setEntrada(request.getParameter("entrada"));
		fun.setEndereco(request.getParameter("endereco"));
		
		
		
		dao.Salvar(fun);
		
		response.sendRedirect("buscafun");
		
	}
	
	
	
}

package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Admin;
import Model.AdminDao;
import Model.Config;

@WebServlet(urlPatterns = { "/AdmController", "/login-admin", "/logout" })

public class AdmController extends HttpServlet {

	Admin adm = new Admin();
	AdminDao dao = new AdminDao();
	Config cf = new Config();

	private static final long serialVersionUID = 1L;

	public AdmController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();

		if (action.equals("/login-admin")) {
			validaAdmin(request, response);
		} else if (action.equals("/logout")) {
			logout(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		String action = request.getServletPath();

		if (action.equals("/login-admin")) {
			validaAdmin(request, response);
		}

	}

	protected void validaAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd;

		try {

			String cpf = request.getParameter("cpf");
			String senha = request.getParameter("senha");
			request.setAttribute("cpf", cpf);
			
			if (cpf.isEmpty() || senha.isEmpty()) {
				
				request.setAttribute("status", "empty");

			} else {

				String cpfFormat = cpf.replaceAll("[^0-9]", "");
				adm.setAd_cpf(cpfFormat);
				adm.setAd_senha(cf.encryptString(senha));

				int r;
				r = dao.buscaAdm(adm);

				if (r == 1) {

					HttpSession sessao = request.getSession();

					String admNome[] = adm.getAd_nome().split(" ");
					String admNomeSimples = admNome[0] + " " + admNome[admNome.length - 1];

					sessao.setAttribute("adm_id", adm.getAd_id());
					sessao.setAttribute("adm_nome", admNomeSimples);
					sessao.setMaxInactiveInterval(60 * 60 * 24 * 30);

					rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);

				} else {

					request.setAttribute("status", "error");

					rd = request.getRequestDispatcher("/login.jsp");
					rd.forward(request, response);

				}

			}

		} catch (Exception e) {
			System.out.println(e);

		}

		rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);

	}

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		sessao.invalidate();

		response.sendRedirect("login-admin");

	}

}

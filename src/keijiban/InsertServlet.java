package keijiban;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class SelectServlet
*/
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
  * @see HttpServlet#HttpServlet()
  */
  public InsertServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
  * response)
  */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

  }

  /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
  * response)
  */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");

    Board b = new Board();

    b.setName(request.getParameter("name"));
    b.setContent(request.getParameter("content"));

    BoardDAO boardDAO = new BoardDAO();

    //1件追加
    boardDAO.insertBoard(b);

    //追加後トップページへリダイレクト
    response.sendRedirect(request.getContextPath() + "/toppage");

  }

}
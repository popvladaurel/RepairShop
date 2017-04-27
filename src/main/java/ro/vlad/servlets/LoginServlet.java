package ro.vlad.servlets;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import ro.vlad.security.UserAccountAction;
import static ro.vlad.persistence.JpaListener.PERSISTENCE_FACTORY;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = (EntityManagerFactory)getServletContext().getAttribute(PERSISTENCE_FACTORY);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        if (UserAccountAction.exists(entityManager, req.getParameter("username"), req.getParameter("password"))) {
            HttpSession session = req.getSession(true);
            session.setAttribute("username", req.getParameter("username"));
            resp.sendRedirect("jsp/welcome.jsp");
        }
        else {
            resp.sendRedirect("login.jsp");}
    }
}

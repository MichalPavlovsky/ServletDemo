package sk.pavlovskymiso.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/simpleservlet")
public class SimpleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html> <html><body>");
        out.print("<h1>Som v SimpleServlete</h1>");

        String meno = req.getParameter("meno");
        String priezvisko = req.getParameter("priezvisko");

        out.println("<br>");
        out.printf("meno: %s", meno);
        out.println("<br>");
        out.printf("priezvisko: %s", priezvisko);

        HttpSession session = req.getSession();
        if (meno!=null && !meno.isEmpty()) {
            session.setAttribute("ulozeneMeno", meno);
        }
        out.println("<br>");
        out.printf("ulozene meno: %s", session.getAttribute("ulozeneMeno"));

        out.println("</body> </html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String meno = req.getParameter("meno");
        String stranka = req.getParameter("stranka");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html> <html><body>");

        out.print("<h1>Som v SimpleServlete v POST</h1>");

        out.println("<br>");
        out.printf("meno: %s", meno);
        out.println("<br>");
        out.printf("stranka: %s", stranka);

        String priezvisko = req.getParameter("priezvisko");
        out.println("<br>");
        out.printf("priezvisko: %s", priezvisko);

        String pohlavie = req.getParameter("pohlavie");
        out.println("<br>");
        out.printf("pohlavie: %s", pohlavie);
        out.println("</body> </html>");

        String[] stat = req.getParameterValues("stat");
        out.println("<br>");
        for (int i = 0; i < stat.length; i++) {
            out.printf("%s, ", stat[i]);

        }

    }
}

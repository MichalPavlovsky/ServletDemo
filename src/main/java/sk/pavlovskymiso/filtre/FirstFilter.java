package sk.pavlovskymiso.filtre;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebFilter(urlPatterns = "/*",
        filterName = "FirstFilter name",
        initParams = {@WebInitParam(name = "meno", value = "Michal Pavlovsky")})
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("som vo filtry");
        System.out.println(filterConfig.getFilterName());
        System.out.println(filterConfig.getInitParameter("meno"));
        filterConfig.getServletContext().setAttribute("filter", "First filter kontext upraveny");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        HttpServletRequest req = (HttpServletRequest) request;
        req.getSession().setAttribute("filterAttribute", "presiel som cez first filter");
//        chain.doFilter(req, response);

        HttpServletResponse resp = (HttpServletResponse) response;

        out.println("Ahoj z filtru");

//        resp.sendRedirect("");
        req.getRequestDispatcher("").forward(req,response);
        out.println("Dovidenia z filtru");
    }

    @Override
    public void destroy() {

    }
}

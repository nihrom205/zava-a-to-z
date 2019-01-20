package ru.job4j.items.servlets;

import javax.servlet.*;
import java.io.IOException;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 30.12.2018
 */
public class FilterServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain next) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        next.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}

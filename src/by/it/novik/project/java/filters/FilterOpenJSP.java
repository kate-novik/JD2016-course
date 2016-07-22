package by.it.novik.project.java.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kate Novik.
 */
//@WebFilter(urlPatterns = {"/*.jsp"},
//        initParams = {
//                @WebInitParam(name = "pageLogin", value = "index.jsp", description = "For prohibition jumps without session")})

//<filter>
//        <filter-name>FilterOpenJSP</filter-name>
//        <filter-class>by.it.novik.project.java.filters.FilterOpenJSP</filter-class>
//<init-param>
//<param-name>pageLogin</param-name>
//<param-value>index.jsp</param-value>
//</init-param>
//</filter>
//<filter-mapping>
//<filter-name>FilterOpenJSP</filter-name>
//<url-pattern>/*.jsp</url-pattern>
//    </filter-mapping>

public class FilterOpenJSP implements Filter{
    //Поле, содержащее название страницы для перехода
    private String pageLogin;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        pageLogin = filterConfig.getInitParameter("pageLogin");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String contextPath = request.getContextPath();
        if (request.getSession(false) != null ) {
            //Указываем метод для запуска остальных фильтров и сервлета
            filterChain.doFilter(request, response);
        }
        response.sendRedirect(request.getContextPath() + "/" + pageLogin);
    }

    @Override
    public void destroy() {
    pageLogin = null;
    }
}

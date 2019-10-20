package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        //将父接口强制转换为子接口
        //目的是用子接口新增的方法，HttpServletRequest新增的方法
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //获取客户端所请求的脚本文件的文件路径
        String servletPath = request.getServletPath();
        if (servletPath.equals("/login.jsp") || servletPath.equals("/loginServlet")
                || servletPath.endsWith(".js") || servletPath.endsWith(".css") || servletPath.endsWith(".jpg")
                || servletPath.equals("/regedit.jsp") || servletPath.equals("/regeditServlet")) {

            //放行，让请求去访问登录页面或提交登录请求
            filterChain.doFilter(req, resp);
        } else {
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                //登录过，直接放行
                filterChain.doFilter(req, resp);
            } else {
                request.getSession().setAttribute("login_error", "您尚未登录，请登录");
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        }
    }

    @Override
    public void destroy() {

    }
}

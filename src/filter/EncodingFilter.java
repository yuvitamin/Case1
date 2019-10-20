package filter;

import javax.servlet.*;
import java.io.IOException;
public class EncodingFilter implements Filter {
    private String econding;

    //初始化，只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         econding = filterConfig.getInitParameter("encoding111");
//        System.out.println("EncodingFilter init...");
    }

    //实现过滤功能
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("EncodingFilter doFilter...");
        //设置请求对象的编码
        servletRequest.setCharacterEncoding(econding);
        //设置响应对象的编码
        servletResponse.setContentType("text/html;charset=utf-8");
        //继续执行请求的url
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println();
    }

    //销毁资源
    @Override
    public void destroy() {
//        System.out.println("EncodingFilter destroy..");
    }
}

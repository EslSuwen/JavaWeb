package cookie;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "SysFilter",urlPatterns = "/*")
public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        filterChain.doFilter(new MyRequest(request), response);

    }

    /*
     * 1.写一个类实现与被增强对象相同的接口
     * 2.定义一个变量，记住被增强的对象
     * 3.定义一个构造方法，接受被增强对象
     * 4.覆盖想增强的方法
     * 5.对于不想增强的方法，直接调用被增强对象（目标对象）的方法
     * */
    class MyRequest extends HttpServletRequestWrapper {
        private HttpServletRequest request;

        public MyRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public String getParameter(String name) {
            String value = this.request.getParameter(name);
            if (!request.getMethod().equalsIgnoreCase("get")) {
                return value;
            }
            if (value == null) {
                return null;
            }
            try {
                return new String(value.getBytes("UTF-8"), request.getCharacterEncoding());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void destroy() {

    }
}

//        作者：永恒言诺
//        来源：CSDN
//        原文：https://blog.csdn.net/weixin_41092717/article/details/82755601
//        版权声明：本文为博主原创文章，转载请附上博文链接！
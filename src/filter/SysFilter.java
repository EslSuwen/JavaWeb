package filter;


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
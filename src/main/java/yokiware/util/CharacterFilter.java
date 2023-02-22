package yokiware.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //解决POST请求乱码
        request.setCharacterEncoding("UTF-8");
        //解决响应乱码
        response.setContentType("text/html;charset=utf-8");
        //解决get乱码
        CharacterRequest characterRequest = new CharacterRequest(request);
        filterChain.doFilter(characterRequest, response);

    }

    @Override
    public void destroy() {

    }

    static class CharacterRequest extends HttpServletRequestWrapper {
        private HttpServletRequest request;

        public CharacterRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        //增强原来的方法，在里面修改编码方式
        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            if (value == null) {
                return null;
            } else {
                String method = request.getMethod();
                if ("get".equalsIgnoreCase(method)) {
                    value = new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                }
            }
            return value;
        }
    }
}


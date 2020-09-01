package pl.mg.drive.userweb.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;


@Component
@Slf4j
public class DriveFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("Drive filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.debug("Drive filter - do filter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.debug("Drive filter destroy");
    }
}

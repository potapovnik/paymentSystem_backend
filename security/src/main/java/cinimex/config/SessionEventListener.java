package cinimex.config;

import org.springframework.security.web.session.HttpSessionEventPublisher;
import javax.servlet.http.HttpSessionEvent;

public class SessionEventListener extends HttpSessionEventPublisher {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        super.sessionCreated(event);
        event.getSession().setMaxInactiveInterval(3);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        super.sessionDestroyed(event);
    }

}
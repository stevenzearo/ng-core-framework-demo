package app.cinema.web.handler;

import core.framework.web.ErrorHandler;
import core.framework.web.Request;
import core.framework.web.Response;
import core.framework.web.service.RemoteServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author steve
 */
public class CinemaBoNotFoundErrorHandler implements ErrorHandler {
    private final Logger logger = LoggerFactory.getLogger(CinemaBoNotFoundErrorHandler.class);

    @Override
    public Optional<Response> handle(Request request, Throwable e) {
        if (e instanceof RemoteServiceException) {
            logger.error("REMOTE_SERVICE_ERROR");
            Arrays.stream(e.getStackTrace()).forEach(x -> {
                logger.error(x.toString());
            });
        }
        return Optional.empty();
    }
}

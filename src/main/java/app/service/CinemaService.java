package app.service;

import app.domain.Cinema;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;

/**
 * @author steve
 */
public class CinemaService {
    @Inject
    private Repository<Cinema> cinemaRepository;

    public Cinema getCinemaById(Integer id) {
        return cinemaRepository.get(1).orElseThrow(() -> new NotFoundException("cinema not found, id =" + id));
    }

}

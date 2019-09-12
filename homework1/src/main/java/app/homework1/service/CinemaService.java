package app.homework1.service;

import app.homework1.domain.Cinema;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;

/**
 * @author steve
 */
public class CinemaService {
    @Inject
    Repository<Cinema> cinemaRepository;

    public Cinema getCinemaById(Integer id) {
        return cinemaRepository.get(id).orElseThrow(() -> new NotFoundException("cinema not found, id =" + id));
    }

}

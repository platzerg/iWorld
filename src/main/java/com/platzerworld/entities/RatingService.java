package com.platzerworld.entities;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Kuba Marchwicki
 */

@Stateless
public class RatingService {
    @PersistenceContext(unitName = "iWorld")
    private EntityManager em;

    public List<com.platzerworld.entities.Movie> movieRating(String name) {
        em.flush();
        return em.createNamedQuery(com.platzerworld.entities.Movie.FIND_ALL, com.platzerworld.entities.Movie.class).getResultList();
    }

}

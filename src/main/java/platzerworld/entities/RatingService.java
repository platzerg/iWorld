package platzerworld.entities;


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

    public List<platzerworld.entities.Movie> movieRating(String name) {
        em.flush();
        return em.createNamedQuery(platzerworld.entities.Movie.FIND_ALL, platzerworld.entities.Movie.class).getResultList();
    }

}

package com.platzerworld.entities;

import javax.ejb.EJB;
import javax.persistence.PostLoad;
import java.util.List;

/**
 * @author Kuba Marchwicki
 */
public class MovieListener {


    @PostLoad
    public void loadMovieRating(Movie movie) {
    }
}

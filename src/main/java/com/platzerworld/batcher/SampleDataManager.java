package com.platzerworld.batcher;

import com.platzerworld.dao.BiergartenDAO;
import com.platzerworld.entities.Biergarten;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Startup
@DependsOn({"BiergartenDAO"})
@Singleton
@Lock(LockType.READ)
public class SampleDataManager {
    private static final Logger LOGGER = Logger.getLogger(SampleDataManager.class.getName());

    @PersistenceContext(unitName = "iWorld")
    private EntityManager em;

    @Inject
    private BiergartenDAO biergartenDAO;

    @PostConstruct
    public void createSomeData() {
        //final Biergarten biergarten = biergartenDAO.create("tomee", "tomee", "tomee@apache.org");
    }

    // a bit ugly but at least we clean data
    @Schedule(second = "0", minute = "1", hour = "*", persistent = false)
    private void cleanData() {
        LOGGER.info("Cleaning data");
        deleteAll();
        createSomeData();
        LOGGER.info("Data reset");
    }

    private void deleteAll() {
        List<Biergarten> biergarten = biergartenDAO.getBiergartenByName("platzerworld");
        //biergartenDAO.delete(biergarten.getId());
        //em.createQuery("delete From Biergarten where name = 'platzerworld'").executeUpdate();
    }
}

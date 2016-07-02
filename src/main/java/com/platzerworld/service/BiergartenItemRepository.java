package com.platzerworld.service;

import com.platzerworld.entities.Biergarten;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BiergartenItemRepository
{
  @PersistenceContext(unitName = "iWorld")
  private EntityManager entityManager;

  public void insert(Biergarten biergarten)
  {
    this.entityManager.persist(biergarten);
  }

  public List<Biergarten> findAll()
  {
    return this.entityManager.createQuery("select s from Biergarten s", Biergarten.class).getResultList();
  }
}

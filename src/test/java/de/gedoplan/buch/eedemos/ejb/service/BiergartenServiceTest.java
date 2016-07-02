package de.gedoplan.buch.eedemos.ejb.service;

import com.platzerworld.entities.Biergarten;
import com.platzerworld.service.BiergartenService;
import de.gedoplan.buch.eedemos.ejb.util.LookupHelper;

import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.BeforeClass;
import org.junit.Test;

public class BiergartenServiceTest
{
  private static Context jndiCtx;
  private static String  lookupName;

  @BeforeClass
  public static void beforeClass() throws Exception
  {
    // Anmeldung am JNDI
    jndiCtx = new InitialContext();

    // Lookup-Namen der EJB ermitteln
    lookupName = LookupHelper.getEjbLookupName(BiergartenService.class, false);
  }


  public void testGetSrvDate() throws Exception
  {
    // Lookup der Bean
    BiergartenService biergartenService = (BiergartenService) jndiCtx.lookup(lookupName);

    // Aufruf von Bean-Methoden
    List<Biergarten> biergartenList = biergartenService.getAllBiergarten();

    System.out.println("Date on server: " + biergartenList);
  }
}

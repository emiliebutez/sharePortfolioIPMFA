/*
 * Copyright 2023 Emilie.
 */
package tp04.metier;
import org.junit.jupiter.api.Assertions;
import tp04.metier.Portefeuille;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Emilie
 */
public class InvestisseurTest {
  
  public InvestisseurTest() {
  }
  
  private static final int EXPECTED_CODE = 1;
  private static final String EXPECTED_NOM = "nomTest";
  private static final String EXPECTED_PRENOM = "prenomTest";
  private static final String EXPECTED_EMAIL = "mailTest";
  private static final int NO_EXPECTED_CODE = 2;
  private static final String NO_EXPECTED_NOM = "nomFaux";
  private static final String NO_EXPECTED_PRENOM = "prenomFaux";
  private static final String NO_EXPECTED_EMAIL = "mailFaux";

  @Test
  public void testGetCodeShouldPass() {
    final Investisseur testI = new Investisseur(EXPECTED_CODE, EXPECTED_NOM, EXPECTED_PRENOM, EXPECTED_EMAIL);
    final int result = testI.getCodeI();
    
    Assertions.assertSame(EXPECTED_CODE,
            result,
            "Le codeI doit etre le meme que result"
            );
            
  }
  
  @Test
  public void testGetNomShouldPass() {
    final Investisseur testI = new Investisseur(EXPECTED_CODE, EXPECTED_NOM, EXPECTED_PRENOM, EXPECTED_EMAIL);
    final String result = testI.getNomI();
    
    Assertions.assertSame(EXPECTED_NOM,
            result,
            "Le nomI doit etre le meme que result"
            );
            
  }
  
  @Test
  public void testGetPrenomShouldPass() {
    final Investisseur testI = new Investisseur(EXPECTED_CODE, EXPECTED_NOM, EXPECTED_PRENOM, EXPECTED_EMAIL);
    final String result = testI.getPrenomI();
    
    Assertions.assertSame(EXPECTED_PRENOM,
            result,
            "Le prenomI doit etre le meme que result"
            );
            
  }
  
  @Test
  public void testGetEmailShouldPass() {
    final Investisseur testI = new Investisseur(EXPECTED_CODE, EXPECTED_NOM, EXPECTED_PRENOM, EXPECTED_EMAIL);
    final String result = testI.getEmailI();
    
    Assertions.assertSame(EXPECTED_EMAIL,
            result,
            "Le mailI doit etre le meme que result"
            );
            
  }
  
   @Test
  public void testSetCodeShouldPass() {
    final Investisseur testI = new Investisseur(NO_EXPECTED_CODE, NO_EXPECTED_NOM, NO_EXPECTED_PRENOM, NO_EXPECTED_EMAIL);
    testI.setCodeI(EXPECTED_CODE);
    final int result = testI.getCodeI();
    
    Assertions.assertSame(EXPECTED_CODE,
            result,
            "Le codeI doit etre le meme que result"
            );
            
  }
  
  @Test
  public void testSetNomShouldPass() {
    final Investisseur testI = new Investisseur(NO_EXPECTED_CODE, NO_EXPECTED_NOM, NO_EXPECTED_PRENOM, NO_EXPECTED_EMAIL);
    testI.setNomI(EXPECTED_NOM);
    final String result = testI.getNomI();
    
    Assertions.assertSame(EXPECTED_NOM,
            result,
            "Le nomI doit etre le meme que result"
            );
            
  }
  
  @Test
  public void testSetPrenomShouldPass() {
    final Investisseur testI = new Investisseur(NO_EXPECTED_CODE, NO_EXPECTED_NOM, NO_EXPECTED_PRENOM, NO_EXPECTED_EMAIL);
    testI.setPrenomI(EXPECTED_PRENOM);
    final String result = testI.getPrenomI();
    
    Assertions.assertSame(EXPECTED_PRENOM,
            result,
            "Le nomI doit etre le meme que result"
            );
            
  }
  
  @Test
  public void testSetEmailShouldPass() {
    final Investisseur testI = new Investisseur(NO_EXPECTED_CODE, NO_EXPECTED_NOM, NO_EXPECTED_PRENOM, NO_EXPECTED_EMAIL);
    testI.setEmailI(EXPECTED_EMAIL);
    final String result = testI.getEmailI();
    
    Assertions.assertSame(EXPECTED_EMAIL,
            result,
            "Le mailI doit etre le meme que result"
            );
            
  }
  
  @Test
  public void testEquals() {
    final Investisseur testI1 = new Investisseur(EXPECTED_CODE, EXPECTED_NOM, EXPECTED_PRENOM, EXPECTED_EMAIL);
    final Investisseur testI2 = new Investisseur(EXPECTED_CODE, EXPECTED_NOM, EXPECTED_PRENOM, EXPECTED_EMAIL);
    
    boolean equal = testI1.equals(testI2);
    Assertions.assertTrue(equal);
    Assertions.assertTrue(testI1.hashCode() == testI2.hashCode());
  }
  
}

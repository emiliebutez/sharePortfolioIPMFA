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
    this.portefeuilleI.acheter(this.action, 23);
  }
  
  private static final Action action = new ActionSimple("airbus");
  private static final int codeI = 1;
  private static final String nomI = "nomTest";
  private static final String prenomI = "prenomTest";
  private static final String mailI = "mailTest";
  private static final Portefeuille portefeuilleI = new Portefeuille();

  @Test
  public void testGetCodeShouldPass() {
    final Investisseur testI = new Investisseur(codeI, nomI, prenomI, mailI, portefeuilleI);
    final int result = testI.getCodeI();
    
    Assertions.assertSame(
            codeI,
            result,
            "Le codeI doit etre le meme que result"
            );
            
  }
  
}

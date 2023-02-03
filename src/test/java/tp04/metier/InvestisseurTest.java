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
class InvestisseurTest {
  /**
   * Le code attendu.
   */
  private static final int EXPECTED_CODE = 1;
  /**
   * Le nom attendu.
   */
  private static final String EXPECTED_NOM = "nomTest";
  /**
   * Le prenom attendu.
   */
  private static final String EXPECTED_PRENOM = "prenomTest";
  /**
   * L'email attendu.
   */
  private static final String EXPECTED_EMAIL = "mailTest";
  /**
   * Le code non attendu.
   */
  private static final int NO_EXPECTED_CODE = 2;
  /**
   * Le nom non attendu.
   */
  private static final String NO_EXPECTED_NOM = "nomFaux";
  /**
   * Le prenom non attendu.
   */
  private static final String NO_EXPECTED_PRENOM = "prenomFaux";
  /**
   * L'email non attendu.
   */
  private static final String NO_EXPECTED_EMAIL = "mailFaux";

  /**
   * Constructeur de la classe InvestisseurTest.
   */
  public InvestisseurTest() {
  }

  /**
   * Test de la méthode getCodeI.
   */
  @Test
  final void testGetCodeShouldPass() {
    final Investisseur testI = new Investisseur(EXPECTED_CODE,
            EXPECTED_NOM, EXPECTED_PRENOM, EXPECTED_EMAIL);
    final int result = testI.getCodeI();

    Assertions.assertSame(EXPECTED_CODE,
            result,
            "Le codeI doit etre le meme que result"
    );
  }

  /**
   * Test de la méthode getNomI.
   */
  @Test
  final void testGetNomShouldPass() {
    final Investisseur testI = new Investisseur(EXPECTED_CODE,
            EXPECTED_NOM, EXPECTED_PRENOM, EXPECTED_EMAIL);
    final String result = testI.getNomI();

    Assertions.assertSame(EXPECTED_NOM,
            result,
            "Le nomI doit etre le meme que result"
    );
  }

  /**
   * Test de la méthode getPrenomI.
   */
  @Test
  final void testGetPrenomShouldPass() {
    final Investisseur testI = new Investisseur(EXPECTED_CODE,
            EXPECTED_NOM, EXPECTED_PRENOM, EXPECTED_EMAIL);
    final String result = testI.getPrenomI();

    Assertions.assertSame(EXPECTED_PRENOM,
            result,
            "Le prenomI doit etre le meme que result"
    );
  }

  /**
   * Test de la methode getEmailI.
   */
  @Test
  final void testGetEmailShouldPass() {
    final Investisseur testI = new Investisseur(EXPECTED_CODE,
            EXPECTED_NOM, EXPECTED_PRENOM, EXPECTED_EMAIL);
    final String result = testI.getEmailI();

    Assertions.assertSame(EXPECTED_EMAIL,
            result,
            "Le mailI doit etre le meme que result"
    );
  }

  /**
   * Test de la méthode setCodeI.
   */
   @Test
  final void testSetCodeShouldPass() {
    final Investisseur testI = new Investisseur(NO_EXPECTED_CODE,
            NO_EXPECTED_NOM, NO_EXPECTED_PRENOM, NO_EXPECTED_EMAIL);
    testI.setCodeI(EXPECTED_CODE);
    final int result = testI.getCodeI();

    Assertions.assertSame(EXPECTED_CODE,
            result,
            "Le codeI doit etre le meme que result"
    );
  }

  /**
   * Test de la méthode setNomI.
   */
  @Test
  final void testSetNomShouldPass() {
    final Investisseur testI = new Investisseur(NO_EXPECTED_CODE,
            NO_EXPECTED_NOM, NO_EXPECTED_PRENOM, NO_EXPECTED_EMAIL);
    testI.setNomI(EXPECTED_NOM);
    final String result = testI.getNomI();

    Assertions.assertSame(EXPECTED_NOM,
            result,
            "Le nomI doit etre le meme que result"
    );
  }

  /**
   * Test de la méthode setPrenom.
   */
  @Test
  final void testSetPrenomShouldPass() {
    final Investisseur testI = new Investisseur(NO_EXPECTED_CODE,
            NO_EXPECTED_NOM, NO_EXPECTED_PRENOM, NO_EXPECTED_EMAIL);
    testI.setPrenomI(EXPECTED_PRENOM);
    final String result = testI.getPrenomI();

    Assertions.assertSame(EXPECTED_PRENOM,
            result,
            "Le nomI doit etre le meme que result"
    );
  }

  /**
   * Test de la méthode setEmailI.
   */
  @Test
  final void testSetEmailShouldPass() {
    final Investisseur testI = new Investisseur(NO_EXPECTED_CODE,
            NO_EXPECTED_NOM, NO_EXPECTED_PRENOM, NO_EXPECTED_EMAIL);
    testI.setEmailI(EXPECTED_EMAIL);
    final String result = testI.getEmailI();

    Assertions.assertSame(EXPECTED_EMAIL,
            result,
            "Le mailI doit etre le meme que result"
    );
  }

  /**
   * Test de la méthode equals.
   */
  @Test
  final void testEquals() {
    final Investisseur testI1 = new Investisseur(EXPECTED_CODE,
            EXPECTED_NOM, EXPECTED_PRENOM, EXPECTED_EMAIL);
    final Investisseur testI2 = new Investisseur(EXPECTED_CODE,
            EXPECTED_NOM, EXPECTED_PRENOM, EXPECTED_EMAIL);
    
    boolean equal = testI1.equals(testI2);
    Assertions.assertTrue(equal);
    Assertions.assertSame(testI1.hashCode(), testI2.hashCode(),
            "Le hash code de testI1 doit être le même"
                    + " que le hash code de testI2");
  }

  /**
   * Test de la méthode toString.
   */
  @Test
  final void toStringTest() {
    final Investisseur testI = new Investisseur(EXPECTED_CODE,
            EXPECTED_NOM, EXPECTED_PRENOM, EXPECTED_EMAIL);
    Assertions.assertEquals("Investisseur{" +
              "codeI=" + EXPECTED_CODE +
              ", nomI='" + EXPECTED_NOM + '\'' +
              ", prenomI='" + EXPECTED_PRENOM + '\'' +
              ", emailI='" + EXPECTED_EMAIL + '\'' +
              '}', testI.toString());
  }
}

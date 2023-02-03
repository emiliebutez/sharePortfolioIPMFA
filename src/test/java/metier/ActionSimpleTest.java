/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package metier;

import metier.Entreprise;
import metier.ActionSimple;
import metier.Action;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Emilie
 */
class ActionSimpleTest {
  /**
   * Libelle attendu.
   */
  private static final String EXPECTED_LIBELLE = "action";
  /**
   * Constante Entreprise.
   */
  private static final Entreprise ENTREPRISE = new Entreprise("Apple");
  /**
   * Construteur de la classe ActionSimpleTest.
   */
  public ActionSimpleTest() {
  }

  /**
   * Test de la méthode equals.
   */
  @Test
  final void testEquals() {
    final Action actionPremierResult = new ActionSimple(EXPECTED_LIBELLE,
            ENTREPRISE);
    final Action actionSecondResult = new ActionSimple(EXPECTED_LIBELLE,
            ENTREPRISE);
    
    boolean equal = actionPremierResult.equals(actionSecondResult);
    Assertions.assertTrue(equal);
    Assertions.assertEquals(actionPremierResult.hashCode(),
            actionSecondResult.hashCode(),
            "Le hash code de actionPremierResult doit être le même"
                    + " que le hash code de actionSecondResult");
  }
}

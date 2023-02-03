/*
 * Copyright 2023 Emilie.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tp04.metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Emilie
 */
public class JourTest {
  /**
   * Année attendue.
   */
  private static final int EXPECTED_ANNEE = 2022;
  /**
   * Nombre de jour attendu.
   */
  private static final int EXPECTED_NOJOUR = 3;
  /**
   * Constructeur de la classe JourTest.
   */
  public JourTest() {
  }

   /**
   * Test de la method getNoJour.
   */
  @Test
  final void getNoJourShouldPass() {
    final Jour jour = new Jour(EXPECTED_ANNEE, EXPECTED_NOJOUR);
    final int result = jour.getNoJour();
    
    Assertions.assertSame(EXPECTED_NOJOUR,
        result,
        "EXPECTED_NOJOUR doit etre le meme que result."
    );
  }
  
   /**
   * Test de la method getAnnee.
   */
  @Test
  final void getAnneeShouldPass() {
    final Jour jour = new Jour(EXPECTED_ANNEE, EXPECTED_NOJOUR);
    final int result = jour.getAnnee();
    
    Assertions.assertEquals(EXPECTED_ANNEE,
        result,
        "EXPECTED_ANNEE doit etre le meme que result."
    );
  }
  
  /**
   * Test de la méthode equals.
   */
  @Test
  final void testEquals() {
    final Jour jourPremierResult = new Jour(EXPECTED_ANNEE, EXPECTED_NOJOUR);
    final Jour jourSecondResult = new Jour(EXPECTED_ANNEE, EXPECTED_NOJOUR);
    
    boolean equal = jourPremierResult.equals(jourSecondResult);
    Assertions.assertTrue(equal);
    Assertions.assertEquals(jourPremierResult.hashCode(),
            jourSecondResult.hashCode(),
            "Le hash code de jourPremierResult doit être le même"
                    + " que le hash code de jourSecondResult");
  }
}

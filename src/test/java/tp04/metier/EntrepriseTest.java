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

import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Emilie
 */
public class EntrepriseTest {
  /**
   * Libelle de l'entreprise attendu.
   */
  private static final String EXPECTED_LIBELLE = "Apple";
  /**
   * Libelle de l'entreprise attendue.
   */
  private static final String NO_EXPECTED_LIBELLE = "Samsung";
  /**
   * Libelle de l'action attendue.
   */
  private static final Action EXPECTED_ACTION = new ActionSimple("action");
  /**
   * Libelle de la quantite attendue.
   */
  private static final Integer EXPECTED_QUANTITE = 4;
  /**
   * Libelle de la quantite a ajoute.
   */
  private static final Integer QUANTITE_AJOUTE = 3;

  /**
   * Constructeur de la classe EntrepriseTest.
   */
  public EntrepriseTest() {
  }

  /**
   * Test de la method getLibelle.
   */
  @Test
  public void testGetLibelleShouldPass() {
    final Entreprise testE = new Entreprise(EXPECTED_LIBELLE);
    final String result = testE.getLibelleE();
    
    Assertions.assertSame(EXPECTED_LIBELLE,
            result,
            "Le EXPECTED_LIBELLE doit etre le meme que result"
            );
  }

  /**
   * Test de la method setLibelle.
   */
  @Test
  public void testSetLibelleShouldPass() {
    final Entreprise testE = new Entreprise(NO_EXPECTED_LIBELLE);
    testE.setLibelleE(EXPECTED_LIBELLE);
    final String result = testE.getLibelleE();
    
    Assertions.assertSame(EXPECTED_LIBELLE,
            result,
            "Le EXPECTED_LIBELLE doit etre le meme que result"
            );
  }

  /**
   * Test de la method ajouterActionsE.
   */
  @Test
  public void testAjoutActions() {
    final Entreprise testE = new Entreprise(NO_EXPECTED_LIBELLE);
    testE.ajouterActionsE(EXPECTED_ACTION, EXPECTED_QUANTITE);
    
    Assertions.assertTrue(testE.getActionsE().containsKey(EXPECTED_ACTION));
    final Integer resultQuantite = testE.getActionsE().get(EXPECTED_ACTION);
    Assertions.assertSame(EXPECTED_QUANTITE,
            resultQuantite,
            "La EXPECTED_QUANTITE doit etre la meme que result");
  }

  /**
   * Test de la method ajouterQuantite.
   */  
  @Test
  public void testAjouterQuantite() {
    final Entreprise testE = new Entreprise(NO_EXPECTED_LIBELLE);
    testE.ajouterActionsE(EXPECTED_ACTION, EXPECTED_QUANTITE);
    
    testE.ajouterQuantite(EXPECTED_ACTION, QUANTITE_AJOUTE);
    final Integer result = testE.getActionsE().get(EXPECTED_ACTION);
    
    Assertions.assertSame(EXPECTED_QUANTITE + QUANTITE_AJOUTE,
            result,
            "La somme de EXPECTED_QUANTITE et QUANTITE_AJOUTE doit "
                    + "etre la meme que result");
  }
}





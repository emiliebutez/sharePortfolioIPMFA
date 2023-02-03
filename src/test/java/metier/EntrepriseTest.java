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
package metier;


import metier.Entreprise;
import metier.Portefeuille;
import metier.Jour;
import metier.ActionSimple;
import metier.Investisseur;
import metier.Action;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Emilie
 */
class EntrepriseTest {
  /**
   * Libelle de l'entreprise attendu.
   */
  private static final String EXPECTED_LIBELLE = "Apple";
  /**
   * Libelle de l'entreprise non attendu.
   */
  private static final String NO_EXPECTED_LIBELLE = "Samsung";
  /**
   * La quantite attendue.
   */
  private static final Integer EXPECTED_QUANTITE = 4;
  /**
   * La quantite a ajoute.
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
  final void testGetLibelleShouldPass() {
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
  final void testSetLibelleShouldPass() {
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
  final void testAjoutActions() {
    final Entreprise testE = new Entreprise(NO_EXPECTED_LIBELLE);
    final Action EXPECTED_ACTION = new ActionSimple("action",
            testE);
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
  final void testAjouterQuantite() {
    final Entreprise testE = new Entreprise(NO_EXPECTED_LIBELLE);
    final Action EXPECTED_ACTION = new ActionSimple("action",testE);
    testE.ajouterActionsE(EXPECTED_ACTION, EXPECTED_QUANTITE);
    
    testE.ajouterQuantite(EXPECTED_ACTION, QUANTITE_AJOUTE);
    final Integer result = testE.getActionsE().get(EXPECTED_ACTION);
    
    Assertions.assertSame(EXPECTED_QUANTITE + QUANTITE_AJOUTE,
            result,
            "La somme de EXPECTED_QUANTITE et QUANTITE_AJOUTE doit "
                    + "etre la meme que result");
  }
  
  public void testGetInvestisseursShouldPass(){
    final Entreprise testE = new Entreprise(NO_EXPECTED_LIBELLE);
    final Jour j1 = new Jour(2023, 20);
    final Investisseur investI = new Investisseur(9, "toto", 
            "titi", "mail@test.com");
    final Portefeuille portefeuilleP = new Portefeuille(40000, investI);
    final Action EXPECTED_ACTION = new ActionSimple("action",testE);
    portefeuilleP.acheter(EXPECTED_ACTION,1, j1);
    final ArrayList<Investisseur> result = new ArrayList<>();
    result.add(investI);
    
    Assertions.assertSame(testE.getInvestisseurs(),
            result,
            "La liste des investisseurs de l'entreprise doit etre "
                    + "la meme que celle de result");
  }
}





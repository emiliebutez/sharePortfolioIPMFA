/*
 * Copyright 2023 louis.
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

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author louis
 */
public class ActionComposeeTest {
  static final Entreprise ENTREPRISE = new Entreprise("Entreprise1");

  public ActionComposeeTest() {
  }

  /**
   * Instentiation des paramètres
   */
  @Test
  public void ActionComposeeShouldPass() {
    ActionComposee aC1 = new ActionComposee("GAFAM", ENTREPRISE);

    ActionSimple a1 = new ActionSimple("Google", ENTREPRISE);
    // ActionSimple a2 = new ActionSimple("Facebook");
    //ActionSimple a3 = new ActionSimple("Amazon");

    aC1.enrgComposition(a1, 0.1f);
    // aC1.enrgComposition(a2, 0.16f);
    //aC1.enrgComposition(a3, 0.2f);

    assertEquals(true, aC1.mapPanier.containsKey(a1));
    assertEquals(0.1f, aC1.mapPanier.get(a1));
  }

  @Test
  public void ActionComposeeSommeShouldNotPass() {
    ActionComposee aC1 = new ActionComposee("GAFAM", ENTREPRISE);

    ActionSimple a1 = new ActionSimple("Google", ENTREPRISE);
    ActionSimple a2 = new ActionSimple("Facebook", ENTREPRISE);
    ActionSimple a3 = new ActionSimple("Amazon", ENTREPRISE);

    aC1.enrgComposition(a1, 0.3f);
    aC1.enrgComposition(a2, 0.6f);
    aC1.enrgComposition(a3, 0.3f);
    float sommePourcentage = 0;
    for (Float p : aC1.mapPanier.values())
    {
      sommePourcentage += p;
    }
    assertNotEquals(1.2f, sommePourcentage);
  }

  /**
   * Test on ne peut pas enregistrerplus que 100% d'action
   */
  @Test
  public void ActionComposee100ShouldPass() {
    ActionComposee aC1 = new ActionComposee("GAFAM", ENTREPRISE);

    ActionSimple a1 = new ActionSimple("Google", ENTREPRISE);
    ActionSimple a2 = new ActionSimple("Facebook", ENTREPRISE);

    aC1.enrgComposition(a1, 0.3f);
    aC1.enrgComposition(a2, 0.4f);

    float sommePourcentage = 0;
    for (Float p : aC1.mapPanier.values())
    {
      sommePourcentage += p;
    }
    assertNotEquals(1f, sommePourcentage);
  }

  /**
   * Test connaitre la valeur de l'action compose
   */
  @Test
  public void GetCoursACShouldPass() {
    ActionComposee aC1 = new ActionComposee("GAFAM");

    ActionSimple a1 = new ActionSimple("Google");
    ActionSimple a2 = new ActionSimple("Facebook");

    Jour j1 = new Jour(2023, 20);
    a1.enrgCours(j1, 5f);
    a2.enrgCours(j1, 5f);

    aC1.enrgComposition(a1, 0.3f);
    aC1.enrgComposition(a2, 0.4f);

    assertEquals(3.5f, aC1.getCours(j1));
  }
  private static final float EXPECTED_CODE = 0.70000005f;
  private static final float FIRST_CODE = 0.3f;
  private static final float SECOND_CODE = 0.4f;
  private static final int ANNEE = 2023;
  private static final int noJour = 20;  

  @Test //@auteur test valeur
  
  public void ValueACShouldPass() {
    ActionComposee aC1 = new ActionComposee("GAFAM");

    ActionSimple a1 = new ActionSimple("Google");
    ActionSimple a2 = new ActionSimple("Facebook");

    Jour j1 = new Jour(ANNEE, noJour);

    a1.enrgCours(j1, 1);
    a2.enrgCours(j1, 1);

    aC1.enrgComposition(a1, FIRST_CODE);
    aC1.enrgComposition(a2, SECOND_CODE);
    
    assertEquals(EXPECTED_CODE, aC1.valeur(j1));
  }
}

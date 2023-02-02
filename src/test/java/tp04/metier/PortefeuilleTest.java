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
public class PortefeuilleTest {

  public PortefeuilleTest() {
  }
  /**
   * Acheter une quantité
   */
  @Test
  public void AcheterShouldPass() {
    Jour j1 = new Jour(2023, 20);
    Portefeuille p1 = new Portefeuille();
    ActionSimple a1 = new ActionSimple("Apple");
    a1.enrgCours(j1, 5f);
    p1.acheter(a1, 1);

    assertEquals(5, p1.valeur(j1));
  }

  /**
   * Acheter une quantité négative
   */
  @Test
  public void AcheterShouldNotPass() {
    Jour j1 = new Jour(2023, 20);
    Portefeuille p1 = new Portefeuille();
    ActionSimple a1 = new ActionSimple("Apple");
    a1.enrgCours(j1, 5f);
    p1.acheter(a1, -10);
    assertNotEquals(-50, p1.valeur(j1));
  }

  /**
   * Vendre une quantité égale à celle qui est possédée
   */
  @Test
  public void VendreEqualsShouldPass() {
    Jour j1 = new Jour(2023, 20);
    Portefeuille p1 = new Portefeuille();
    ActionSimple a1 = new ActionSimple("Apple");
    a1.enrgCours(j1, 5f);
    p1.acheter(a1, 1);
    p1.vendre(a1, 1);

    assertEquals(0, p1.valeur(j1));
  }

  /**
   * Vendre une quantité supérieure à celle qui est possédée
   */
  @Test
  public void VendreShouldNotPass() {
    Jour j1 = new Jour(2023, 20);
    Portefeuille p1 = new Portefeuille();
    ActionSimple a1 = new ActionSimple("Apple");
    a1.enrgCours(j1, 5f);
    p1.acheter(a1, 1);
    p1.vendre(a1, 2);

    assertNotEquals(-5, p1.valeur(j1));
  }

  /**
   * Vendre une quantité inférieure à celle qui est possédée
   */
  @Test
  public void VendreShouldPass() {
    Jour j1 = new Jour(2023, 20);
    Portefeuille p1 = new Portefeuille();
    ActionSimple a1 = new ActionSimple("Apple");
    a1.enrgCours(j1, 5f);
    p1.acheter(a1, 2);
    p1.vendre(a1, 1);

    assertEquals(5, p1.valeur(j1));
  }
}

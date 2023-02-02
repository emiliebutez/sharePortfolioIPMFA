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

  public ActionComposeeTest() {
  }

  /**
   * Instentiation des paramètres
   */
  @Test
  public void ActionComposeeShouldPass() {
    ActionComposee aC1 = new ActionComposee("GAFAM");

    ActionSimple a1 = new ActionSimple("Google");
    // ActionSimple a2 = new ActionSimple("Facebook");
    //ActionSimple a3 = new ActionSimple("Amazon");

    aC1.enrgComposition(a1, 0.1f);
    // aC1.enrgComposition(a2, 0.16f);
    //aC1.enrgComposition(a3, 0.2f);

    assertEquals(true, aC1.mapPanier.containsKey(a1));
    assertEquals(0.1f, aC1.mapPanier.get(a1));
  }

}

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
import metier.ActionSimple;
import metier.Action;
import metier.EnvoiMail;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import javax.mail.Transport;
import static org.mockito.Mockito.times;
import org.mockito.stubbing.Answer;

/**
 *
 * @author Emilie
 */
  class EnvoiMailTest {
  /**
   * Adresse mail de reception.
   */
  private static String TO = "emiliebutez.eb@gmail.com";
  /**
   * Entreprise à qui appartient l'action.
   */
  private Entreprise entreprise = new Entreprise("Apple");
  /**
   * Action concerné par le mail.
   */
  private Action action = new ActionSimple("action", entreprise);
  /**
   * Quantite d'action.
   */
  private static int QTE = 1;
  
  public EnvoiMailTest() {
  }

  /**
   * Méthode qui test l'envoi de mail.
   */
  @Test
  final void testMailMethod() {
    try (MockedStatic<Transport> utilities = Mockito.mockStatic(Transport.class)) {
      utilities.when(()-> Transport.send(Mockito.any())).thenAnswer((Answer<Void>) invocation -> null);
      EnvoiMail mail = new EnvoiMail();
      mail.envoyerMail(TO, action, QTE);
      utilities.verify(()->Transport.send(Mockito.any()), times(1));
    }
  }
}

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

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import javax.mail.Transport;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.stubbing.Answer;

/**
 *
 * @author Emilie
 */
public class EnvoiMailTest {
  private static String TO = "emiliebutez.eb@gmail.com";
  private Entreprise entreprise = new Entreprise("Apple");
  private Action action = new ActionSimple("action", entreprise);
  private static int QTE = 1;
  
  public EnvoiMailTest() {
  }

  @Test
  public void testSomeMethod() {
    try (MockedStatic<Transport> utilities = Mockito.mockStatic(Transport.class)) {
      utilities.when(()-> Transport.send(Mockito.any())).thenAnswer((Answer<Void>) invocation -> null);
      EnvoiMail mail = new EnvoiMail();
      mail.envoyerMail(TO, action, QTE);
      utilities.verify(()->Transport.send(Mockito.any()), times(1));
    }
  }
}

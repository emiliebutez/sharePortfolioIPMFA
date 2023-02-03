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


import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author Emilie
 */
public class EnvoiMail {
  /**
   * Host du mail.
   */
  private final String host = "smtp-mail.outlook.com";
  /**
   * Adresse de la boite mail d'envoi.
   */
  private final String user = "devAgile@outlook.fr";
  /**
   * Mot de passe de la boite mail d'envoi.
   */
  private final String mdp = "A123456789b";
  /**
   * Constructeur de la classe EnvoiMAil.
   * @param to Adresse de la boite mail de réception.
   * @param a Action acheté qui correspond à l'envoi.
   * @param qte Quantité d'action acheter.
   */
  public void envoyerMail(String to, Action a, int qte) {
   Properties props = new Properties();
   props.put("mail.smtp.host", this.host);
   props.put("mail.smtp.auth", "true");
   props.put("mail.smtp.starttls.enable", "true");
   Authenticator auth = new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(user, mdp);
      }
    };
    Session session = Session.getInstance(props, auth);
    
    try {
     MimeMessage message = new MimeMessage(session);
     message.setFrom(new InternetAddress(user));
     message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
     message.setSubject("Récapitulatif");
     message.setText("Vous avez acheté "
             + qte
             + " parts de "
             + a.getLibelle()
             + " appartenant à "
             + a.getEntreprise().getLibelleE()
             + ".");
     
    Transport.send(message);
    System.out.println("message sent successfully...");
   
     } catch (MessagingException e) {e.printStackTrace();}
 }
}

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

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Emilie
 */
public class Investisseur {

  /**
   * Code de l'investisseur.
   */
  private int codeI;
  /**
   * Nom de l'investisseur.
   */
  private String nomI;
  /**
   * Prenom de l'investisseur.
   */
  private String prenomI;
  /**
   * Adresse mail de l'investisseur.
   */
  private String emailI;
  /**
   * Portfeuille de l'investisseur.
   */
  private ArrayList<Portefeuille> portefeuilles = new ArrayList<>();

  /**
   * Constructeur de la classe Investisseur.
   *
   * @param codeI Code de l'investisseur.
   * @param nomI Nom de l'investisseur.
   * @param prenomI Prenom de l'investisseur.
   * @param emailI Adresse mail de l'investisseur.
   * @param portefeuilleI Portefeuille de l'investisseur.
   */
  public Investisseur(int codeI, String nomI, String prenomI, String emailI) {
    this.codeI = codeI;
    this.nomI = nomI;
    this.prenomI = prenomI;
    this.emailI = emailI;
  }

  /**
   * Récupère le code de l'investisseur.
   *
   * @return Le code de l'investisseur.
   */
  public int getCodeI() {
    return codeI;
  }

  /**
   * Définit le code de l'investisseur.
   *
   * @param codeI Code de l'investisseur.
   */
  public void setCodeI(int codeI) {
    this.codeI = codeI;
  }

  /**
   * Rècupère le nom de l'investisseur.
   *
   * @return Le nom de l'investisseur.
   */
  public String getNomI() {
    return nomI;
  }

  /**
   * Définit le nom de l'investisseur.
   *
   * @param nomI Le nom de l'investisseur.
   */
  public void setNomI(String nomI) {
    this.nomI = nomI;
  }

  /**
   * Récupère le prenom de l'investisseur.
   *
   * @return Le nom de l'investisseur.
   */
  public String getPrenomI() {
    return prenomI;
  }

  /**
   * Définit le prenom de l'investisseur.
   *
   * @param prenomI Le prenom de l'investisseur.
   */
  public void setPrenomI(String prenomI) {
    this.prenomI = prenomI;
  }

  /**
   * Récupère l'adresse mail de l'investisseur.
   *
   * @return L'adresse mail de l'investisseur.
   */
  public String getEmailI() {
    return emailI;
  }

  /**
   * Définit l'adresse mail de l'investisseur.
   *
   * @param emailI L'adresse mail de l'investisseur.
   */
  public void setEmailI(String emailI) {
    this.emailI = emailI;
  }

  /**
   * Récupère le portefeuille de l'investisseur.
   *
   * @return Le portefeuille de l'investisseur.
   */
  public Portefeuille getPortefeuilleI(int index) {
    return this.portefeuilles.get(index);
  }

  /**
   * Définit le portefeuille de l'investisseur.
   *
   * @param portefeuilleI Le portefeuille de l'investisseur.
   */
  public void setPortefeuilleI(Portefeuille portefeuilleI, int index) {
    this.portefeuilles.set(index, portefeuilleI);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeI, nomI, prenomI, emailI, portefeuilles);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
    {
      return true;
    }
    if (o == null || getClass() != o.getClass())
    {
      return false;
    }
    Investisseur that = (Investisseur) o;
    return codeI == that.codeI && nomI.equals(that.nomI) && prenomI.equals(that.prenomI) && emailI.equals(that.emailI) && Objects.equals(portefeuilles, that.portefeuilles);
  }

  @Override
  public String toString() {
    return "Investisseur{"
            + "codeI=" + codeI
            + ", nomI='" + nomI + '\''
            + ", prenomI='" + prenomI + '\''
            + ", emailI='" + emailI + '\''
            + '}';
  }
}

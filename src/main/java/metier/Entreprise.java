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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Emilie
 */
public class Entreprise {
  /**
   * Libelle de l'entreprise.
   */
  private String libelleE;
  /**
   * Liste des actions avec leurs quantités de l'entreprise.
   */
  private HashMap<Action,Integer> actionsE = new HashMap<>();
  /**
   * Liste des investisseurs.
   */
  private ArrayList<Investisseur> investisseurs = new ArrayList<>();

  /**
   * Constructeur de la classe entreprise.
   * @param libelleE Le libelle.
   */
  public Entreprise(String libelleE) {
    this.libelleE = libelleE;
  }

  /**
   * Recupere le libelle de l'entreprise.
   * @return le libelle de l'entreprise.
   */
  public String getLibelleE() {
    return libelleE;
  }

  /**
   * Definit le libelle de l'entreprise.
   * @param libelleE le libelle de l'entreprise.
   */
  public void setLibelleE(String libelleE) {
    this.libelleE = libelleE;
  }

  /**
   * Récupère les actions de l'entreprise.
   * @return Les actions de l'entreprise.
   */
  public Map<Action, Integer> getActionsE() {
    return actionsE;
  }

  /**
   * Ajout d'une action avec une quantité.
   * @param a action à ajouter.
   * @param qte quantité d'action à ajouter.
   */
  public void ajouterActionsE(Action a, Integer qte) {
    this.actionsE.put(a, qte);
  }

  /**
   * Ajout d'une quantité à une action de l'entreprise.
   * @param a action concerné.
   * @param qte quantité à ajouter.
   */
  public void ajouterQuantite(Action a, Integer qte) {
    Integer qteExistante = this.actionsE.get(a);
    this.actionsE.replace(a, qte + qteExistante);
  }
  
  /**
   * Ajout d'un investisseur.
   * @param i Investisseur à ajouter.
   */
  public void ajouterInvestisseur(Investisseur i) {
    this.investisseurs.add(i);
  }

  /**
   * Récupère la liste des investisseur de l'entreprise.
   * @return La liste des investisseur de l'entreprise.
   */
  public List<Investisseur> getInvestisseurs() {
    return investisseurs;
  }
}
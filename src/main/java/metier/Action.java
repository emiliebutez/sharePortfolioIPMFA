/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author perussel
 */
public abstract class Action {

  /**
   *
   * @param libelle libelle de l'action
   */
  private String libelle;
  /**
   * Entreprise proposant cette action.
   */
  private Entreprise entreprise;

  /**
   * connaitre la valeur du libelle
   *
   * @return la valeur du libelle
   */
  public String getLibelle() {
    return libelle;
  }

  /**
   * Constructeur de l'action.
   *
   * @param libelle libelle de l'action.
   * @param entreprise
   */
  protected Action(String libelle, Entreprise entreprise) {
    this.libelle = libelle;
    this.entreprise = entreprise;
  }

  /**
   * méthode abstraite permettant d'obtenir la valeur d'une action à un jour
   * donné
   *
   * @param j jour de la valeur
   */
  public abstract float valeur(Jour j);

  /**
   * méthode abstraite permettant de récupérer le cours pour un jour donné.
   *
   * @param j
   * @return boolean
   */
  public abstract float getCours(Jour j);

  public abstract boolean verifierPouvoirAchat(Portefeuille p, Action a, Jour j, int qte);

  /**
   * methode equals
   *
   * @param obj
   * @return boolean
   */
  /**
   * Récupère l'entreprise qui fait référence à l'action.
   *
   * @return L'entreprise qui fait référence à l'action.
   */
  public Entreprise getEntreprise() {
    return entreprise;
  }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.Objects;

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
   * connaitre la valeur du libelle
   *
   * @return la valeur du libelle
   */
  public String getLibelle() {
    return libelle;
  }
/**
 * constructeur de l'action
 * @param libelle le libelle de l'action
 */
  public Action(String libelle) {
    this.libelle = libelle;
  }

  /**
 * méthode abstraite permettant d'obtenir la valeur d'une action à un jour donné
 * @param j jour de la valeur
 */
  
  public abstract float valeur(Jour j);

  /**
   * méthode hashcode
   * @return hash
   */
  @Override
  public int hashCode() {
    int hash = 3;
    hash = 53 * hash + Objects.hashCode(this.libelle);
    return hash;
  }
  
  /**
   * méthode abstraite permettant de récupérer le cours pour un jour donné
   * @param j
   * @return boolean
   */
    public abstract float getCours(Jour j);
        public abstract boolean verifierPouvoirAchat(Portefeuille p,Action a, Jour j, int qte);
        
  /**
   * methode equals
   * @param obj
   * @return boolean
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null)
    {
      return false;
    }
       
    if (getClass() != obj.getClass())
    {
      return false;
    }
    final Action other = (Action) obj;
    if (!Objects.equals(this.libelle, other.libelle))
    {
      return false;
    }
    return true;
  }

  public String toString() {
    return this.getLibelle();
  }

}

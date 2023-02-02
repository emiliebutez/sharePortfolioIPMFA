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
    * Libelle de l'action.
    */
  private String libelle;
  /**
    * Entreprise proposant cette action.
    */
  private Entreprise entreprise;

  /**
    * Get the value of libelle.
    *
    * @return the value of libelle.
    */
  public String getLibelle() {
      return libelle;
  }
  
  /**
    * Constructeur de l'action.
    * @param libelle libelle de l'action.
    * @param entreprise 
    */
  public Action(String libelle, Entreprise entreprise) {
      this.libelle = libelle;
      this.entreprise = entreprise;
  }

  public abstract float valeur(Jour j);

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 53 * hash + Objects.hashCode(this.libelle);
    return hash;
  }
    public abstract float getCours(Jour j);

    /**
     * Récupère l'entreprise qui fait référence à l'action.
     * @return L'entreprise qui fait référence à l'action.
     */
  public Entreprise getEntreprise() {
    return entreprise;
  }
    
  public abstract boolean verifierPouvoirAchat(Portefeuille p,Action a, Jour j, int qte);

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

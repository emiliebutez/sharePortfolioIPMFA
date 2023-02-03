/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author perussel
 */
public class ActionSimple extends Action {

    // attribut lien
    private Map<Jour, Cours> mapCours = new HashMap<>();
    
    // constructeur
    public ActionSimple(String libelle, Entreprise entreprise) {
        // Action simple initialisée comme 1 action
        super(libelle, entreprise);
    }

  // enrg possible si pas de cours pour ce jour
  public void enrgCours(Jour j, float v) {
    this.mapCours.computeIfAbsent(j, k -> new Cours(j, v));
  }
  // Recuperer le cours d'une action en fonction d'une action et un jour

  @Override
  public float valeur(Jour j) {
    if (this.mapCours.containsKey(j))
    {
      return this.mapCours.get(j).getValeur();
    } else
    {
      return 0; // definition d'une constante possible
    }
  }

  @Override
  public float getCours(Jour j) {
    return this.mapCours.get(j).getValeur();
  }
/**
 * a partir d'un portefeuille une action un jour et une quantité cette fonction determine si l investisseur peut acheter cette action 
 * @param p portefeuille
 * @param a action
 * @param j jour
 * @param qte Qte
 * @return 
 */
  @Override
  public boolean verifierPouvoirAchat(Portefeuille p, Action a, Jour j, int qte) {
   return p.getSolde() > (a.getCours(j)*qte);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + Objects.hashCode(this.mapCours);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final ActionSimple other = (ActionSimple) obj;
    return Objects.equals(this.mapCours, other.mapCours);
  }
}

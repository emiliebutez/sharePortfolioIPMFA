/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class ActionComposee extends Action {
  // attribut lien
  
  /**
   * paramètres
   * @param mapPanier couple ActionSimple/pourcentage
   */

  Map<ActionSimple, Float> mapPanier;

  public ActionComposee(String libelle, Entreprise entreprise) {
    super(libelle, entreprise);
    this.mapPanier = new HashMap();
  }

  /**
   * récupérer la valeur des couples ActionSimple/pourcentage
   * @return mapPanier
   */
  public Map<ActionSimple, Float> getMapPanier() {
    return mapPanier;
  }

  /**
   * Enrregistre les differents % de chaque Action Simple
   *La somme de ses action ne peut pas dépasser 100%
   * @param as -> pour action Simple
   * @param pourcentage
   */
  public void enrgComposition(ActionSimple a, float pourcentage) {
    float sommePourcentage = 0;

    for (Float p : mapPanier.values())
    {
      sommePourcentage += p;
    }
    if (sommePourcentage + pourcentage <= 1)
    {
      mapPanier.put(a, pourcentage);
    } 
    else
    {
      System.out.println("Le pourcentage demandé est supérieur à 100%");
    }

  }


/**
 * méthode permettant de récupérer la valeur pour un jour donné
 * @param j jour
 * @return valeur
 */
@Override
public float valeur(Jour j) {
    float valeur;

    valeur = 0;
    for (ActionSimple as : this.mapPanier.keySet())
    {
      valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
    }

    return valeur;
  }

/**
 * méthode permettant d'obtenir le cours pour un jour donné
 * @param j jour
 * @return valeur
 */
  @Override
  public float getCours(Jour j) {
    return this.valeur(j);
  }

  /**
   * Méthode boolean permettant de vérifier le pouvoir d'achat
   * @param p
   * @param a
   * @param j
   * @param qte
   * @return boolean
   */
  @Override
  public boolean verifierPouvoirAchat(Portefeuille p, Action a, Jour j, int qte) {
return true;  }
    
    
}

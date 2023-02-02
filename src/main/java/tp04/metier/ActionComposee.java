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
    Map<ActionSimple, Float> mapPanier;

    public ActionComposee(String libelle, Entreprise entreprise) {
        super(libelle,entreprise);
        this.mapPanier = new HashMap();
    }
    
    public void enrgComposition(ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }

    @Override
    public float valeur(Jour j) {
        float valeur;
        
        valeur = 0;
        for(ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
        }
        
        return valeur;
    }

  

  @Override
  public float getCours(Jour j) {
    return this.valeur(j);
  }

  @Override
  public boolean verifierPouvoirAchat(Portefeuille p, Action a, Jour j, int qte) {
return true;  }
    
    
}

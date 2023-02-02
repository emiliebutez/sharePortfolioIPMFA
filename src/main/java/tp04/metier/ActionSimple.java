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
public class ActionSimple extends Action {

    // attribut lien
    private Map<Jour, Cours> mapCours;
    
    // constructeur
    public ActionSimple(String libelle, Entreprise entreprise) {
        // Action simple initialisée comme 1 action
        super(libelle, entreprise);
        // init spécifique
        this.mapCours = new HashMap();
    }
    
    // enrg possible si pas de cours pour ce jour
    public void enrgCours(Jour j, float v) {
        if(this.mapCours.containsKey(j) == false)
            this.mapCours.put(j, new Cours(j, v));
    }
    // Recuperer le cours d'une action en fonction d'une action et un jour
 
   
  
  
  
    
    @Override
    public float valeur(Jour j) {
        if(this.mapCours.containsKey(j) == true)
            return this.mapCours.get(j).getValeur();
        else 
            return 0; // definition d'une constante possible
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
   if ( p.getSolde() > (a.getCours(j)*qte)){
     return true;
   }
   else return false;
  }

 

  
}
  
    


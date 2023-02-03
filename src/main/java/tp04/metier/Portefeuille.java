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

public class Portefeuille {
  
  /**
   * constructeur
   * @param solde solde du portefeuille
   * @param mapLignes couple d'Action/LignePortefeuille
   */
     private float solde;
    Map<Action, LignePortefeuille> mapLignes;
    
  /**
   * constructeur
   * @param solde 
   */
    
    public Portefeuille(float solde) {
        this.mapLignes = new HashMap();
        this.solde = solde;
    }

    /**
     * Liste des actions d'un portefeuille
     */
  private class LignePortefeuille {
    //Parametres de la classe LignePortefeuille
    
    /**
     * 
     */

    private Action action;

    private int qte;
    // Methodes GET & SET 

    public int getQte() {
      return qte;
    }

    public void setQte(int qte) {
      this.qte = qte;
    }

    public Action getAction() {
      return this.action;
    }
    //Constructeur de la classe LignePortefeuille

    public LignePortefeuille(Action action, int qte) {
      this.action = action;
      this.qte = qte;
    }
    //Methode toString() 

    public String toString() {
      return Integer.toString(qte);
    }
  }
  //Methode de la classe Portefeuille

  public Portefeuille() {
    this.mapLignes = new HashMap();
  }

  //Methode d'achat d'une action
  public void acheter(Action a, int q) {
    if (q <= 0)
    {
      System.out.println("on ne peut pas acheter de quantités négatives");
    } else if (this.mapLignes.containsKey(a) == false)
    {
      this.mapLignes.put(a, new LignePortefeuille(a, q));
    } else
    {
      this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
    }
  }

  // méthode permettant de vendre une action
  public void vendre(Action a, int q) {
    if (this.mapLignes.containsKey(a) == true)
    {
      if (this.mapLignes.get(a).getQte() > q)
      {
        this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
      } else if (this.mapLignes.get(a).getQte() == q)
      {
        this.mapLignes.remove(a);
      } else
      {
        System.out.println("on ne peut pas vendre plus que la quantité achetée");
      }
    }
  }
  //Methode toString()

  public String toString() {
    return this.mapLignes.toString();
  }

  //Methode qui permet d'obtenir la valeur du portefeuille à un jour donnée
  public float valeur(Jour j) {
    float total = 0;
    for (LignePortefeuille lp : this.mapLignes.values())
    {
      total = total + (lp.getQte() * lp.getAction().valeur(j));
    }
    return total;
  }

    /**
     * retoune les informations d 'un porte feuille à un jour donné
     * @param j Jour
     * @return 
     */
    public float getMontantPF(Jour j) {
      float valeurTotal = 0;
      float valeur = 0;
      float qte =0;
      float valeurTotalAction = 0;
      for (Map.Entry<Action,LignePortefeuille> mapEntry: mapLignes.entrySet()) {
        valeur = 0;
        valeur = mapEntry.getValue().getAction().getCours(j); 
        qte = +mapEntry.getValue().getQte();
        valeurTotal = valeurTotal + (valeur*qte );
        valeurTotalAction =  valeur * qte;
        System.out.println("Action: "+mapEntry.getKey().getLibelle()+"   qte:"+mapEntry.getValue().getQte()+"   valeur"+mapEntry.getValue().getAction().getCours(j) +"  valeurTotalAction:"+valeurTotalAction);
      }    
    return valeurTotal;
    }
    /**
     * getter pour solde
     */
  public void setSolde() {
            this.solde = solde; 
        }
  /**
   * setter pour solde
   * @return solde
   */
  public float getSolde() {
    return this.solde;
  }
}

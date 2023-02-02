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
     private float solde;
    Map<Action, LignePortefeuille> mapLignes;
    
    private class LignePortefeuille {
        
        private Action action;
        
        private int qte;
        
        
        
        public int getQte() {
            return qte;
        }
        
        public void setQte(int qte) {
            this.qte = qte;
        }
        
        
        
        public Action getAction() {
            return this.action;
        }
        
        
        
        
        public LignePortefeuille(Action action, int qte) {
            this.action = action;
            this.qte = qte;
            
        }

        public String toString() {
            return Integer.toString(qte);
        }
    }
    
    public Portefeuille(float solde) {
        this.mapLignes = new HashMap();
        this.solde = solde;
    }
    
    public void acheter(Action a, int q) {
        if (this.mapLignes.containsKey(a) == false) {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
    }

    public void vendre(Action a, int q) {
        if (this.mapLignes.containsKey(a) == true) {
            if (this.mapLignes.get(a).getQte() > q) {
                this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
            } else if (this.mapLignes.get(a).getQte() == q) {
                this.mapLignes.remove(a);
            }
        }        
    }
    
    public String toString() {
        return this.mapLignes.toString();
    }

    public float valeur(Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total = total + (lp.getQte() * lp.getAction().valeur(j));
        }
        return total;
    }
    
    
    /*** retoune le Montant total des valeur des actions du porte feuille ***/
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
  public void setSolde() {
            this.solde = solde; 
        }
  public float getSolde() {
            return this.solde;
        }
}

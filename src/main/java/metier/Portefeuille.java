/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class Portefeuille {

  /**
   * constructeur
   *
   * @param solde solde du portefeuille
   * @param mapLignes couple d'Action/LignePortefeuille
   */
  private float solde;
  Map<Action, LignePortefeuille> mapLignes = new HashMap<>();
  List<ArrayList<String>> histotab = new ArrayList<>();
  /**
   * Investisseur a qui appartient l'entreprise.
   */
  private Investisseur invest;

  public Portefeuille(float solde, Investisseur invest) {
    this.solde = solde;
    this.invest = invest;
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
  }

  public List<ArrayList<String>> historique(Action a, Jour j, float qte) {
    ArrayList<String> tmp = new ArrayList<>();
    // Ajouter des éléments aux sous-listes
    tmp.add(a.getLibelle());
    tmp.add(Float.toString(a.getCours(j)));
    tmp.add(Float.toString(this.solde));
    tmp.add(Float.toString(qte));
    histotab.add(tmp);
    return histotab;
  }

  /**
   * Définit le solde du portfeuille d'action.
   *
   * @param s Le solde du portefeuille d'action.
   */
  final void setSolde(final float s) {
    this.solde = s;
  }

  //Methode d'achat d'une action
  public void acheter(Action a, int q, Jour j) {
    if (q > 0) {
      if (!this.mapLignes.containsKey(a)){
        if (a.verifierPouvoirAchat(this, a, j, q)){
          this.mapLignes.put(a, new LignePortefeuille(a, q));
          this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
          historique(a, j, q);
          this.setSolde(solde - (a.getCours(j) * q));
          a.getEntreprise().ajouterInvestisseur(this.invest);
        }
      }
      else {
        if (a.verifierPouvoirAchat(this, a, j, q)){
        this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        a.getEntreprise().ajouterInvestisseur(this.invest);
        historique(a, j, q);
        this.setSolde(solde - (a.getCours(j) * q));
        a.getEntreprise().ajouterInvestisseur(this.invest);
        EnvoiMail mail = new EnvoiMail();
        mail.envoyerMail(this.invest.getEmailI(), a, q);
      } else
      {
        this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        a.getEntreprise().ajouterInvestisseur(this.invest);
      }
    }
  }
  }

// méthode permettant de vendre une action
  public void vendre(Action a, int q) {
    if (this.mapLignes.containsKey(a))
    {
      if (this.mapLignes.get(a).getQte() > q)
      {
        this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
      } else if (this.mapLignes.get(a).getQte() == q)
      {
        this.mapLignes.remove(a);
      }
    }
  }
  

//Methode toString()
  public String toString() {
    return this.mapLignes.toString();
  }

  public Map<Action, LignePortefeuille> getMapLignes() {
    return mapLignes;
  }

  public void setMapLignes(Map<Action, LignePortefeuille> mapLignes) {
    this.mapLignes = mapLignes;
  }

  public List<ArrayList<String>> getHistotab() {
    return histotab;
  }

  public void setHistotab(List<ArrayList<String>> histotab) {
    this.histotab = histotab;
  }

/**
 * Methode qui permet d'obtenir la valeur totale du portefeuille à un jour donné
 * @param j Jour
 * @return la valeur totale du portefeuille
 */
  public float valeurPtf(Jour j) {
    float total = 0;
    for (LignePortefeuille lp : this.mapLignes.values())
    {
      total = total + (lp.getQte() * lp.getAction().valeur(j));
    }
    return total;
  }

  /**
   * retoune les informations d 'un porte feuille à un jour donné
   *
   * @param j Jour
   * @return
   */
  public List<ArrayList<String>>  getMontantPF(Jour j) {
    float valeurTotal = 0;
    float valeur = 0;
    float qte = 0;
    float valeurTotalAction = 0;

    List<ArrayList<String>> valeurAction = new ArrayList<>();
    List<String> m = new ArrayList<>();
    m.add(" ");
    m.add(" ");
    m.add("PorteFeuille");
    m.add(" ");
    m.add(" ");
    valeurAction.add((ArrayList<String>) m);
    m.clear();
    m.add("Action");
    m.add(" Quantité");
    m.add("Valeur ");
    m.add(" Valeur totale");
    m.add(" Valeur totale Action");
    valeurAction.add((ArrayList<String>) m);
    m.clear();
    for (Map.Entry<Action,LignePortefeuille> mapEntry: mapLignes.entrySet())
   {
         valeur = mapEntry.getValue().getAction().getCours(j); 
         qte = +mapEntry.getValue().getQte();
         valeurTotal = valeurTotal + (valeur*qte );
         valeurTotalAction =  valeur * qte;
         
         m.add(mapEntry.getKey().getLibelle());
         m.add(Float.toString(mapEntry.getValue().getQte()));
         m.add(Float.toString(mapEntry.getValue().getAction().getCours(j)))  ;
         m.add(Float.toString(valeurTotal));
         m.add(Float.toString(valeurTotalAction));
         valeurAction.add((ArrayList<String>) m);
         m.clear();
   }
    return valeurAction;
  }

  /**
   * Méthode qui retourne l'action qui a le cours le plus faible
   * @param j Jour 
   * @return ret
   */
  public List<String> actionMinValeur (Jour j){
  Map.Entry<Action, LignePortefeuille> firstEntry = mapLignes.entrySet().iterator().next();
  float minvaleur = firstEntry.getKey().getCours(j);
  String minlib = firstEntry.getKey().getLibelle();
  
  for (Map.Entry<Action,LignePortefeuille> mapEntry: mapLignes.entrySet())
  { if( minvaleur> mapEntry.getValue().getAction().getCours(j)){
    minvaleur = mapEntry.getValue().getAction().getCours(j);
    minlib = mapEntry.getValue().getAction().getLibelle();
  }
  }
  List<String> ret = new ArrayList<>();
  ret.add(minlib);
  ret.add(Float.toString(minvaleur));
  return ret;
 }
  
  /**
   * Méthode qui retourne l'action qui a le cours le plus élevé
   * @param j j Jour 
   * @return  ret
   */
  public List<String> actionMaxValeur (Jour j){
  Map.Entry<Action, LignePortefeuille> firstEntry = mapLignes.entrySet().iterator().next();
  float maxvaleur = firstEntry.getKey().getCours(j);
  String maxlib = firstEntry.getKey().getLibelle();
  
  for (Map.Entry<Action,LignePortefeuille> mapEntry: mapLignes.entrySet())
  { if( maxvaleur< mapEntry.getValue().getAction().getCours(j)){
    maxvaleur = mapEntry.getValue().getAction().getCours(j);
    maxlib = mapEntry.getValue().getAction().getLibelle();
  }
  }
  List<String> ret = new ArrayList<>();
  ret.add(maxlib);
  ret.add(Float.toString(maxvaleur));
  return ret;
 }
  

  /**
   * getter pour solde
   *
   * @return solde
   */
  public float getSolde() {
    return this.solde;
  }

  /**
   * Récupère l'investisseur à qui appartient le portefeuille.
   *
   * @return L'investisseur à qui appartient le portefeuille.
   */
  public Investisseur getInvest() {
    return invest;
  }

  
  
}
  

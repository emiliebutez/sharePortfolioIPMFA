/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.exec;

import java.util.ArrayList;
import java.util.Iterator;
import tp04.metier.Action;
import tp04.metier.ActionComposee;
import tp04.metier.ActionSimple;
import tp04.metier.Entreprise;
import tp04.metier.Jour;
import tp04.metier.Portefeuille;

public class Run {

  public static void main(String[] args) {
    ActionSimple bnp, axa;
    ActionComposee bqAss;
    Jour j1, j2;

    // init des objets metiers Jour
    j1 = new Jour(2014, 1);
    j2 = new Jour(2014, 2);
    Entreprise et1 = new Entreprise("BNP");
     Entreprise et2 = new Entreprise("AXA");
    // creation d'actions simples et composée
    bnp = new ActionSimple("BNP",et1);
    axa = new ActionSimple("AXA",et2);
   // bqAss = new ActionComposee("Banque-Assurance");
    // enrg de la composition de l'action composée
    bqAss.enrgComposition(axa, 0.3f);
    bqAss.enrgComposition(bnp, 0.7f);
    // enrg. de 2 cours pour chaque action 
    axa.enrgCours(j1, 200);
    axa.enrgCours(j2, 250);
    bnp.enrgCours(j1, 100);
    bnp.enrgCours(j2, 200);
    Investisseur i1 = new Investisseur();
    // affichage des cours - comme 1 action simple et 1 action
    System.out.println("Action simple *bnp* à j1 : " + bnp.valeur(j1));
    System.out.println("Action *Banque-Assurance* à j2 : " + bqAss.valeur(j2));
    
        Portefeuille p;
        p = new Portefeuille(10000,);
        // init historique 
ArrayList <String> entete = new ArrayList<String>();
ArrayList <String> entete2 = new ArrayList<String>();
// Ajouter des éléments aux sous-listes
entete.add("   ");
entete.add("Historique du PTF");
entete.add("   ");
entete.add("   ");
p.getHistotab().add(entete);

entete2.add("Action");
entete2.add("Cours");
entete2.add("Solde");
entete2.add("qte");
p.getHistotab().add(entete2);
       p.acheter(axa, 10,j1);
        System.out.println("Portefeuille : " + p);
        p.acheter(bnp, 20,j1);
        System.out.println("Portefeuille : " + p);
        p.acheter(bqAss, 5,j1);
        System.out.println("Portefeuille : " + p);
        p.acheter(bqAss, 15,j1);
        System.out.println("Portefeuille : " + p);
        System.out.println("Portefeuille à j1 : " + p.valeurPtf(j1));
        p.vendre(axa, 5);
        System.out.println("Portefeuille : " + p);
        p.vendre(axa, 5);
        System.out.println("Portefeuille : " + p);
        p.vendre(axa, 5);
        System.out.println("Portefeuille : " + p);
        p.vendre(bnp, 50);
        System.out.println("Portefeuille : " + p);
        System.out.println("--------------------------------" );
        System.out.println("valeur Total: " + p.getMontantPF(j1));
        System.out.println("Le solde disponible est : " +p.getSolde() );
        System.out.println(bnp.verifierPouvoirAchat(p, axa, j2, 20));
        
        p.acheter(axa, 2, j2);
        int i=0;
        System.out.println("-------------------------");
        Iterator <ArrayList<String>> itr;
        itr = p.getHistotab().listIterator();
       while(itr.hasNext()){
        System.out.println(itr.next());
         
         
         
         
    }
  }
}


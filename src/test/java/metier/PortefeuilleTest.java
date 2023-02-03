/*
 * Copyright 2023 louis.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package metier;

import metier.Entreprise;
import metier.Portefeuille;
import metier.ActionSimple;
import metier.Jour;
import metier.Investisseur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author louis
 */
public class PortefeuilleTest {
  
  private static final Entreprise testE = new Entreprise("Apple");
  private static final Investisseur INVESTISSEUR = new Investisseur(1, "Butez", "Emilie", "emiliebutez.eb@gmail.com");
  private static final int QTE = 3000;
    private static final Investisseur INVESTISSEUR2 = new Investisseur(1, "Butez", "Emilie", "emiliebutez.eb@gmail.com");
  private static final int QTE2 = 3000;

  public PortefeuilleTest() {
  }

  /**
   * Acheter une quantité.
   */
  
  private static final String NOM_LIBELLE = "Apple";
  private static final float COURS_TEST = 5f;
  private static final Jour JOUR1 = new Jour(2023,20);
  private static final Portefeuille PORTEFEUILLE = new Portefeuille();
  private static final ActionSimple ACTION_TEST = new ActionSimple(NOM_LIBELLE, testE);
  @Test
  final void acheterShouldPass() {
    Jour j1 = new Jour(2023, 20);
    Portefeuille p1 = new Portefeuille(QTE, INVESTISSEUR);
    ActionSimple a1 = new ActionSimple("Apple", testE);
    a1.enrgCours(j1, 5f);
    p1.acheter(a1, 1, j1);

    assertEquals(0, PORTEFEUILLE.valeurPtf(JOUR1));
  }

  /**
   * Acheter une quantité négative.
   */
  @Test
  final void acheterShouldNotPass() {
    Jour j1 = new Jour(2023, 20);
    Portefeuille p1 = new Portefeuille(QTE, INVESTISSEUR);
    ActionSimple a1 = new ActionSimple("Apple", testE);
    a1.enrgCours(j1, 5f);
    p1.acheter(a1, -10, j1);
    assertNotEquals(-50, p1.valeurPtf(j1));
  }
  /**
   * Si les quantité et le pouvoir d'achat est OK
   * Alors je peux acheter
   */
  @Test
  final void acheterInvestShouldPass(){
    ACTION_TEST.enrgCours(JOUR1, COURS_TEST);
    ACTION_TEST.verifierPouvoirAchat(PORTEFEUILLE, ACTION_TEST, JOUR1, 1);
    assertEquals(false,  ACTION_TEST.verifierPouvoirAchat(PORTEFEUILLE, ACTION_TEST, JOUR1, 1));
  
    
  }
  
  
  /**
   * Vendre une quantité égale à celle qui est possédée.
   */
  @Test
  final void vendreEqualsShouldPass() {
    Jour j1 = new Jour(2023, 20);
    Portefeuille p1 = new Portefeuille(QTE, INVESTISSEUR);
    ActionSimple a1 = new ActionSimple("Apple", testE);
    a1.enrgCours(j1, 5f);
    p1.acheter(a1, 1, j1);
    p1.vendre(a1, 1);

    assertEquals(0, PORTEFEUILLE.valeurPtf(JOUR1));
  }

  /**
   * Vendre une quantité supérieure à celle qui est possédée.
   */
  @Test
  final void vendreShouldNotPass() {
    Jour j1 = new Jour(2023, 20);
    Portefeuille p1 = new Portefeuille(QTE, INVESTISSEUR);
    ActionSimple a1 = new ActionSimple("Apple", testE);
    a1.enrgCours(j1, 5f);
    p1.acheter(a1, 1, j1);
    p1.vendre(a1, 2);

    assertNotEquals(-5, PORTEFEUILLE.valeurPtf(JOUR1));
  }

  /**
   * Vendre une quantité inférieure à celle qui est possédée.
   */
  @Test
  final void vendreShouldPass() {
    Jour j1 = new Jour(2023, 20);
    Portefeuille p1 = new Portefeuille(QTE, INVESTISSEUR);
    ActionSimple a1 = new ActionSimple("Apple", testE);
    Investisseur i1= new Investisseur (1,"Nom","Prenom","Prenom@gmail.com");
    a1.enrgCours(j1, 5f);
    p1.acheter(a1, 2, j1);
    p1.vendre(a1, 1);

    assertEquals(15, p1.valeurPtf(j1));
  }

/**
 * Obtenir le montant du portefeuille
 */  
  final void getMontantPFShouldPass(){
    Jour j1 = new Jour(2023, 20);
    Portefeuille p1 = new Portefeuille(QTE, INVESTISSEUR);
    ActionSimple a1 = new ActionSimple("Apple", testE);
    Investisseur i1= new Investisseur (1,"Nom","Prenom","Prenom@gmail.com");
    a1.enrgCours(j1, 5f);
    p1.getMontantPF(j1);
    p1.acheter(a1, 2, j1);
    assertEquals(10f,p1.valeurPtf(j1));
  }

  /**
   * Test de la method getInvest.
   */
  @Test
  final void getInvestShouldPass() {
    final Portefeuille portefeuille = new Portefeuille(4500, INVESTISSEUR);
    final Investisseur result = portefeuille.getInvest();

    Assertions.assertSame(INVESTISSEUR,
            result,
            "INVESTISSEUR doit etre le meme que result"
    );
  }
  
    /**
   * Test de la méthode equals.
   */
  @Test
  final void testEquals() {
    final Portefeuille portefeuillePremierResult = new Portefeuille(QTE, INVESTISSEUR);
    final Portefeuille PortefeuilleSecondResult = new Portefeuille(QTE2, INVESTISSEUR2);
    
    boolean equal = portefeuillePremierResult.equals(PortefeuilleSecondResult);
    Assertions.assertTrue(equal);
    Assertions.assertEquals(portefeuillePremierResult.hashCode(),
            PortefeuilleSecondResult.hashCode(),
            "Le hash code de jourPremierResult doit être le même"
                    + " que le hash code de jourSecondResult");
  }
  
}

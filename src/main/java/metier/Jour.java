/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author perussel
 */
public class Jour {

  private int annee;
  private int noJour;

  /**
   * Get the value of annee
   *
   * @return the value of annee
   */
  public int getAnnee() {
    return annee;
  }

  /**
   * Get the value of noJour
   *
   * @return the value of noJour
   */
  public int getNoJour() {
    return noJour;
  }

  public Jour(int annee, int noJour) {
    this.annee = annee;
    this.noJour = noJour;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 61 * hash + this.annee;
    hash = 61 * hash + this.noJour;
    return hash;
  }

  /**
   * Détermine s'il est égal à l'objet passé en argument.
   * @param obj Objet à comparé.
   * @return True s'il est égal à l'objet passé en argument.
   */
  @Override
  public final boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Jour other = (Jour) obj;
    if (this.annee != other.annee) {
      return false;
    }
    return this.noJour == other.noJour;
  }
}

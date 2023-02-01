/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

 import java.util.HashMap;
import java.util.Objects;

public class

Cours {
    private float numeroCours;

    public Cours(float numeroCours) {
        this.numeroCours = numeroCours;
    }

    public float getNumeroCours() {
        return numeroCours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cours cours = (Cours) o;
        return Float.compare(cours.numeroCours, numeroCours) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCours);
    }

    @Override
    public String toString() {
        return String.valueOf(numeroCours);
    }
}

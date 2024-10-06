/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

/**
 *
 * @author user
 */
public class Manager extends Personne{

    public Manager(String nom, double salaire, Manager manager) {
        super(nom, salaire, manager);
    }

    public Manager(int id, String nom, double salaire, Manager manager) {
        super(id, nom, salaire, manager);
    }
    
    public Manager(String nom, double salaire ) {
        super(nom, salaire);
    }
     public Manager(int id, String nom, double salaire) {
        super(id, nom, salaire);
    }
    @Override
    public String toString() {
        return "Manager{" + "id=" + id + ", Nom=" + nom + ", Salaire=" +salaire +" , Manager=" +manager+ '}';
    }
    
}

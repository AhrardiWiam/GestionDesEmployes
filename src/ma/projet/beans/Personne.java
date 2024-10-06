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
public abstract class Personne {
 
   protected int id;
   protected String nom;
   protected double salaire;
   protected Manager manager;

    public Personne() {
    }

    public Personne(String nom, double salaire) {
        this.nom = nom;
        this.salaire = salaire;
    }
   

    public Personne(String nom, double salaire, Manager manager) {
        this.nom = nom;
        this.salaire = salaire;
        this.manager=manager;
    }

    public Personne(int id, String nom, double salaire, Manager manager) {
        this.id = id;
        this.nom = nom;
        this.salaire = salaire;
        this.manager=manager;
    }
    public Personne(int id, String nom, double salaire) {
        this.id = id;
        this.nom = nom;
        this.salaire = salaire;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public  abstract String toString();
   
    
   
    
    
    
}

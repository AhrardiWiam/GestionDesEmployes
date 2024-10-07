/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import ma.projet.beans.Developpeur;
import ma.projet.beans.Manager;
import ma.projet.service.DeveloppeurService;
import ma.projet.service.ManagerService;

public class Test {

    public static void main(String[] args) {
        DeveloppeurService ds = new DeveloppeurService();
        ManagerService ms = new ManagerService();
        //Création de deux développeurs
        ds.create(new Developpeur("Wiam", 15000));
        ds.create(new Developpeur("LACHGAR", 15000));
        //Créeation du manager qui gère les deux développeurs crées précédemment 
        ms.create(new Manager("RAMI", 25000));
        //Le manager RAMI doit gérer les deux développeurs crées précédemment
        Developpeur d1 = ds.getById(1);
        Developpeur d2 = ds.getById(2);
        d1.setManager(ms.getById(1));
        d2.setManager(ms.getById(1));
        ds.update(d1);
        ds.update(d2);
        //Créeation du 3ème développeur ;
        ds.create(new Developpeur("Ahrardi", 20000));
        //Créer un directeur général qui gère le manager et le 3ème employé 
        ms.create(new Manager("Mohammed", 40000));
        Manager m1 = ms.getById(1);
        Developpeur d3 = ds.getById(3);
        m1.setManager(ms.getById(2));
        d3.setManager(ms.getById(2));
        ms.update(m1);
        ds.update(d3);
        //Afficher les noms et les salaires des employés de haut en bas de la hiérarchie
        ms.entrepriseHierar();
    }
}

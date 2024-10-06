/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.Connexion.Connexion;
import ma.projet.beans.Manager;
import ma.projet.dao.IDao;

/**
 *
 * @author user
 */
public class ManagerService implements IDao<Manager> {
    
    @Override
    public boolean create(Manager m) {
        try {
            String req = "INSERT INTO manager(nom,salaire,manager_id) values(?,?,NULL)";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setString(1, m.getNom());
            st.setDouble(2, m.getSalaire());
            if (st.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    @Override
    public boolean update(Manager m) {
        try {
            String req = "update manager set nom=? ,salaire=?,manager_id=?  where id=?";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setString(1, m.getNom());
            st.setDouble(2, m.getSalaire());
            st.setInt(3, m.getManager().getId());
            st.setInt(4, m.getId());
            if (st.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    

    
    @Override
    public boolean delete(Manager m) {
        try {
            String req = "delete from manager where id=?";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setInt(1, m.getId());
            if (st.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    @Override
    public Manager getById(int id) {
        Manager m = null;
        ManagerService ms = new ManagerService();
        try {
            String req = "select *  from manager where id=?";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                m = new Manager(id, rs.getString(2), rs.getDouble(3), ms.getById(rs.getInt(4)));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return m;
    }
    
    @Override
    public List<Manager> getAll() {
        List<Manager> managers = new ArrayList<>();
        ManagerService ms = new ManagerService();
        try {
            String req = "select *  from manager ";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                managers.add(new Manager(rs.getInt(1), rs.getString(2), rs.getDouble(3), ms.getById(rs.getInt(4))));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return managers;
    }
    
        public Manager getDirecteur() {
    Manager m = null;
    try {
        String req = "select * from manager where manager_id IS NULL";
        PreparedStatement st = Connexion.getCn().prepareStatement(req);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            m = new Manager(rs.getInt(1), rs.getString(2), rs.getDouble(3));
        }     
    } catch (SQLException e) {
        Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, e);
    }
    return m;
    
}
        public void entrepriseHierar() {
        ManagerService ms= new ManagerService();
        try {
            System.out.println("Le directeur: "+ms.getDirecteur().getNom()+" a un salaire de: "+ms.getDirecteur().getSalaire());
            String req = "select *  from developpeur where manager_id=? ";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setInt(1, ms.getDirecteur().getId());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println("Le developpeur:" + rs.getString(2) + " a un salire de :" + rs.getDouble(3));
            }
            req = "SELECT * FROM manager WHERE manager_id IS NOT NULL";
            st = Connexion.getCn().prepareStatement(req);
             rs = st.executeQuery();
            while (rs.next()) {
            System.out.println("Le manager: "+rs.getString(2) +" a un salaire de: "+rs.getDouble(3));
            }
            req = "select *  from developpeur where manager_id<>? ";
            st = Connexion.getCn().prepareStatement(req);
            st.setInt(1, ms.getDirecteur().getId());
            rs = st.executeQuery();
            while (rs.next()) {
            System.out.println("Le developpeur:" + rs.getString(2) + " a un salire de :" + rs.getDouble(3));
            }
        } catch (SQLException e) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, e);
            
        }
    }

    }

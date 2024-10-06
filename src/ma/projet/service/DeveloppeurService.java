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
import ma.projet.beans.Developpeur;
import ma.projet.beans.Manager;
import ma.projet.dao.IDao;

/**
 *
 * @author user
 */
public class DeveloppeurService implements IDao<Developpeur> {

    @Override
    public boolean create(Developpeur d) {
        try {
            String req = "INSERT INTO developpeur(nom,salaire,manager_id) values(?,?,null)";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setString(1, d.getNom());
            st.setDouble(2, d.getSalaire());
            if (st.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean update(Developpeur d) {
        try {
            String req = "update developpeur set nom=? ,salaire=? ,manager_id=? where id=?";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setString(1, d.getNom());
            st.setDouble(2, d.getSalaire());
            st.setInt(3, d.getManager().getId());
            st.setInt(4, d.getId());
            if (st.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean delete(Developpeur d) {
        try {
            String req = "delete from developpeur where id=?";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setInt(1, d.getId());
            if (st.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public Developpeur getById(int id) {
        ManagerService ms= new ManagerService();
        Developpeur d = null;
        try {
            String req = "select *  from developpeur where id=?";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                d = new Developpeur(id, rs.getString(2), rs.getDouble(3),ms.getById(rs.getInt(4)) );
            }

        } catch (SQLException e) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, e);

        }
        return d;
    }

    @Override
    public List<Developpeur> getAll() {
        ManagerService ms= new ManagerService();
        List<Developpeur> developpeurs = new ArrayList<>();
        try {
            String req = "select *  from developpeur ";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                developpeurs.add(new Developpeur(rs.getInt(1), rs.getString(2), rs.getDouble(3), ms.getById(rs.getInt(4))));
            }

        } catch (SQLException e) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, e);

        }
        return developpeurs;
    }

    }

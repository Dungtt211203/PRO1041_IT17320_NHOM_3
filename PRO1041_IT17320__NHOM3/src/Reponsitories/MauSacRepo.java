/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reponsitories;

import DomainModels.MauSac;
import Utilities.DBContext;
import ViewModels.MauSacViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author MyPC
 */
public class MauSacRepo {

    public void insert(MauSac m) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "INSERT INTO MauSac" + "(Ma,Ten)" + "VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, m.getMa());
            ps.setString(2, m.getTen());
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void update(MauSac m, String id) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "UPDATE MauSac SET " + "Ma=?,Ten=?WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, m.getMa());
            ps.setString(2, m.getTen());
            ps.setString(3, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = DBContext.getConnection();
            String sql = "DELETE FROM MauSac WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public ArrayList<MauSacViewModel> all() {
        ArrayList<MauSacViewModel> listM = new ArrayList<>();
        try {
            Connection conn = DBContext.getConnection();
            String sql = "SELECT * FROM MauSac";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");

                MauSacViewModel m = new MauSacViewModel(id, ma, ten);
                listM.add(m);
            }
            System.out.println("Truy vấn thành công");
        } catch (Exception e) {
            e.getMessage();
        }
        return listM;
    }

}

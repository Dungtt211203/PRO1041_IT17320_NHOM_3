/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Models.NhaSanXuat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Util.util;

/**
 *
 * @author MyPC
 */
public class NhaSanXuatRepo {

    public void insert(NhaSanXuat n) {
        try {
            Connection conn = util.getConnection();
            String sql = "INSERT INTO NSX" + "(Ma,Ten)" + "VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, n.getMa());
            ps.setString(2, n.getTen());
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(NhaSanXuat n, String id) {
        try {
            Connection conn = util.getConnection();
            String sql = "UPDATE NhaSanXuat SET " + "Ma=?,Ten=?WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, n.getMa());
            ps.setString(2, n.getTen());
            ps.setString(3, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = util.getConnection();
            String sql = "DELETE FROM NhaSanXuat WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<NhaSanXuat> all() {
        ArrayList<NhaSanXuat> listNSX = new ArrayList<>();
        try {
            Connection conn = util.getConnection();
            String sql = "SELECT * FROM NSX";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");

                NhaSanXuat n = new NhaSanXuat(id, ma, ten);
                listNSX.add(n);
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNSX;
    }
}

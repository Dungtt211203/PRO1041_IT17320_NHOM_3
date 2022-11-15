/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Models.DongSanPham;
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
public class DongSanPhamRepo {

    public void insert(DongSanPham d) {
        try {
            Connection conn = util.getConnection();
            String sql = "INSERT INTO DongSP" + "(Ma,Ten)" + "VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getMa());
            ps.setString(2, d.getTen());
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(DongSanPham d, String id) {
        try {
            Connection conn = util.getConnection();
            String sql = "UPDATE DongSanPham SET " + "Ma=?,Ten=?WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getMa());
            ps.setString(2, d.getTen());
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
            String sql = "DELETE FROM DongSanPham WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<DongSanPham> all() {
        ArrayList<DongSanPham> listD = new ArrayList<>();
        try {
            Connection conn = util.getConnection();
            String sql = "SELECT * FROM DongSP";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");

                DongSanPham d = new DongSanPham(id, ma, ten);
                listD.add(d);
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listD;
    }
}

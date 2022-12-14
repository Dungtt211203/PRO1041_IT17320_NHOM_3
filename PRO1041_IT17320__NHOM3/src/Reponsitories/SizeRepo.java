/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories;

import DomainModels.Size;
import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SizeRepo {

    public void insert(Size s) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO ChucVu" + "(Ma,Ten)" + "VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMa());
            ps.setString(2, s.getTen());
            ps.execute();
            System.out.println("Thêm thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Size s, String id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE ChucVu SET " + "Ma=?,Ten=? WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMa());
            ps.setString(2, s.getTen());
            ps.setString(3, id);
            ps.executeUpdate();
            System.out.println("Sửa thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM ChucVu WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("Xóa thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Size> all() {
        ArrayList<Size> listSize = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM ChucVu";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");

                Size s = new Size(id, ma, ten);
                listSize.add(s);
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSize;
    }
}

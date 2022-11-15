/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Models.SanPham;
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
public class SanPhamRepo {
    public void insert(SanPham s){
        try {
            Connection conn=util.getConnection();
            String sql="INSERT INTO SanPham"+"(Ma,Ten)"+"VALUES(?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, s.getMa());
            ps.setString(2, s.getTen());
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(SanPham s, String id) {
        try {
            Connection conn = util.getConnection();
            String sql = "UPDATE SanPham SET " + "Ma=?,Ten=?WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMa());
            ps.setString(2, s.getTen());
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
            String sql = "DELETE FROM SanPham WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<SanPham> all(){
        ArrayList<SanPham> listSP=new ArrayList<>();
        try {
            Connection conn=util.getConnection();
            String sql="SELECT * FROM SanPham";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while (rs.next()) {                
                String id=rs.getString("Id");
                String ma=rs.getString("Ma");
                String ten=rs.getString("Ten");
                
                SanPham s=new SanPham(id, ma, ten);
                listSP.add(s);
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSP;
    }
}

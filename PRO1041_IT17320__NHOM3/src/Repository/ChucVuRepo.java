/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Models.ChucVu;
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
public class ChucVuRepo {
    public void insert(ChucVu c){
        try {
            Connection conn=util.getConnection();
            String sql="INSERT INTO ChucVu"+"(Ma,Ten)"+"VALUES(?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, c.getMa());
            ps.setString(2, c.getTen());
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(ChucVu c, String id) {
        try {
            Connection conn = util.getConnection();
            String sql = "UPDATE ChucVu SET " + "Ma=?,Ten=?WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getMa());
            ps.setString(2, c.getTen());
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
            String sql = "DELETE FROM ChucVu WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<ChucVu> all(){
        ArrayList<ChucVu> listCV=new ArrayList<>();
        try {
            Connection conn=util.getConnection();
            String sql="SELECT * FROM ChucVu";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while (rs.next()) {                
                String id=rs.getString("Id");
                String ma=rs.getString("Ma");
                String ten=rs.getString("Ten");
                
                ChucVu s=new ChucVu(id, ma, ten);
                listCV.add(s);
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCV;
    }
}

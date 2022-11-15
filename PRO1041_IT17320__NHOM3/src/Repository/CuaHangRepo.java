/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Models.CuaHang;
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
public class CuaHangRepo {
    public void insert(CuaHang ch){
        try {
            Connection conn=util.getConnection();
            String sql="INSERT INTO CuaHang"+"(Ma,Ten,DiaChi,ThanhPho,QuocGia)"+"VALUES(?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, ch.getMa());
            ps.setString(2, ch.getTen());
            ps.setString(3, ch.getDiaChi());
            ps.setString(4, ch.getThanhPho());
            ps.setString(5, ch.getQuocGia());
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(CuaHang ch,String id){
        try {
            Connection conn=util.getConnection();
            String sql="UPDATE CuaHang SET "+"Ma=?,Ten=?,DiaChi=?,ThanhPho=?,QuocGia=? WHERE Id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, ch.getMa());
            ps.setString(2, ch.getTen());
            ps.setString(3, ch.getDiaChi());
            ps.setString(4, ch.getThanhPho());
            ps.setString(5, ch.getQuocGia());
            ps.setString(6, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete (String id){
        try {
            Connection conn=util.getConnection();
            String sql="DELETE FROM CuaHang WHERE Id=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<CuaHang> all(){
        ArrayList<CuaHang> listCH=new ArrayList<>();
        try {
            Connection conn=util.getConnection();
            String sql="SELECT * FROM CuaHang";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while (rs.next()) {                
                String id=rs.getString("Id");
                String ma=rs.getString("Ma");
                String ten=rs.getString("Ten");
                String dc=rs.getString("DiaChi");
                String tt=rs.getString("ThanhPho");
                String qg=rs.getString("QuocGia");
                
                CuaHang ch=new CuaHang(id, ma, ten, dc, tt, qg);
                listCH.add(ch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCH;
    }
}

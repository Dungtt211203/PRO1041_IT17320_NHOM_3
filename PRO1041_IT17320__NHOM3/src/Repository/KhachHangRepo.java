/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Models.KhachHang;
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
public class KhachHangRepo {
    public ArrayList<KhachHang> all(){
        ArrayList<KhachHang> listKH=new ArrayList<>();
        try {
            Connection conn=util.getConnection();
            String sql="SELECT * FROM KhachHang";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while (rs.next()) {                
                String id=rs.getString("Id");
                String ma=rs.getString("Ma");
                String ten=rs.getString("Ten");
                String dem=rs.getString("TenDem");
                String ho=rs.getString("Ho");
                String ns=rs.getString("NgaySinh");
                String sdt=rs.getString("Sdt");
                String dc=rs.getString("DiaChi");
                String tt=rs.getString("ThanhPho");
                String qg=rs.getString("QuocGia");
                String mk=rs.getString("MatKhau");
                
                KhachHang k=new KhachHang(id, ma, ten, dem, ho, ns, sdt, dc, tt, qg, mk);
                listKH.add(k);
                
            }
            System.out.println("Truy vấn thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKH;
    }
}

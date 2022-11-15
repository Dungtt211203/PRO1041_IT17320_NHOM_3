/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.KhachHang;
import Repository.KhachHangRepo;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class KhachHangService {
    private KhachHangRepo kRepo;
    public KhachHangService(){
        this.kRepo=new KhachHangRepo();
    }
    
    public ArrayList<KhachHang> getListKH(){
        return this.kRepo.all();
    }
}

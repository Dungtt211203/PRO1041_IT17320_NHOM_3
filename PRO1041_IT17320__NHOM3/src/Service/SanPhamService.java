/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.SanPham;
import Repository.SanPhamRepo;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class SanPhamService {
    private SanPhamRepo sRepo;
    public SanPhamService(){
        this.sRepo=new SanPhamRepo();
    }
    
    public void insert(SanPham s){
        this.sRepo.insert(s);
    }
    public void update(SanPham s,String id){
        this.sRepo.update(s, id);
    }
    public void delete(String id){
        this.sRepo.delete(id);
    }
    public ArrayList<SanPham> getListSP(){
        return this.sRepo.all();
    }
}

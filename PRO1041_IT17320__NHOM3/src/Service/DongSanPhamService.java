/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.DongSanPham;
import Repository.DongSanPhamRepo;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class DongSanPhamService {
    private DongSanPhamRepo dRepo;
    public DongSanPhamService(){
        this.dRepo=new DongSanPhamRepo();
    }
    public void insert(DongSanPham d){
        this.dRepo.insert(d);
    }
    public void update(DongSanPham d,String id){
        this.dRepo.update(d, id);
    }
    public void delete(String id){
        this.dRepo.delete(id);
    }
    public ArrayList<DongSanPham> getListDSP(){
        return this.dRepo.all();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.NhaSanXuat;
import Repository.NhaSanXuatRepo;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class NhaSanXuatService {
    private NhaSanXuatRepo nRepo;
    public NhaSanXuatService(){
        this.nRepo=new NhaSanXuatRepo();
    }
    public void insert(NhaSanXuat n){
        this.nRepo.insert(n);
    }
    public void update(NhaSanXuat n,String id){
        this.nRepo.update(n, id);
    }
    public void delete(String id){
        this.nRepo.delete(id);
    }
    public ArrayList<NhaSanXuat> getListNSX(){
        return this.nRepo.all();
    }
}

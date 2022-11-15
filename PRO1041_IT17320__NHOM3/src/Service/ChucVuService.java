/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.ChucVu;
import Repository.ChucVuRepo;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class ChucVuService {
    private ChucVuRepo cRepo;
    public ChucVuService(){
        this.cRepo=new ChucVuRepo();
    }
    public void insert(ChucVu c){
        this.cRepo.insert(c);
    }
    public void update(ChucVu c,String id){
        this.cRepo.update(c, id);
    }
    public void delete(String id){
        this.cRepo.delete(id);
    }
    public ArrayList<ChucVu> getListCV(){
        return this.cRepo.all();
    }
}

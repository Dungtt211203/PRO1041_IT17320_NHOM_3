/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.MauSac;
import Repository.MauSacRepo;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class MauSacService {
    private MauSacRepo mRepo;
    public MauSacService(){
        this.mRepo=new MauSacRepo();
    }
    public void insert(MauSac m){
        this.mRepo.insert(m);
    }
    public void update(MauSac m,String d){
        this.mRepo.update(m, d);
    }
    public void delete(String id){
        this.mRepo.delete(id);
    }
    public ArrayList<MauSac> getListMS(){
        return this.mRepo.all();
    }
}

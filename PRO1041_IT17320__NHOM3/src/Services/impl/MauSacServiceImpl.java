/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModels.MauSac;
import Reponsitories.MauSacRepo;
import Services.MauSacService;
import ViewModels.MauSacViewModel;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class MauSacServiceImpl implements MauSacService{
    private MauSacRepo mRepo;
    public MauSacServiceImpl(){
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
    public ArrayList<MauSacViewModel> getListMS(){
        return this.mRepo.all();
    }
}

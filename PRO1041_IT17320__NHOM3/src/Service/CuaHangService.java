/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Models.CuaHang;
import Repository.CuaHangRepo;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public class CuaHangService {
    private CuaHangRepo chRepo;
    public CuaHangService(){
        this.chRepo=new CuaHangRepo();
    }
    public void insert(CuaHang ch){
        this.chRepo.insert(ch);
    }
    public void update(CuaHang ch,String id){
        this.chRepo.update(ch, id);
    }
    public void delete(String id){
        this.chRepo.delete(id);
    }
    public ArrayList<CuaHang> getListCH(){
        return this.chRepo.all();
    }
}

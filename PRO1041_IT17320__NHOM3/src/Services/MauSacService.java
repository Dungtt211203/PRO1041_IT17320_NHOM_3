/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModels.MauSac;
import ViewModels.MauSacViewModel;
import java.util.ArrayList;

/**
 *
 * @author MyPC
 */
public interface MauSacService {
    ArrayList<MauSacViewModel> getListMS();
    
    void insert(MauSac m);
    
    void update(MauSac m,String d);
    void delete(String id);
}

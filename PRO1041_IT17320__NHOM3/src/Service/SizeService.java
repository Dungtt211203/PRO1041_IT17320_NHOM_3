/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Models.Size;
import Repository.SizeRepo;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SizeService {

    private SizeRepo sRepo;

    public SizeService() {
        this.sRepo = new SizeRepo();
    }

    public void insert(Size s) {
        this.sRepo.insert(s);
    }

    public void update(Size s, String id) {
        this.sRepo.update(s, id);
    }

    public void delete(String id) {
        this.sRepo.delete(id);
    }

    public ArrayList<Size> getListSize() {
        return this.sRepo.all();
    }
}

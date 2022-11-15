/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.impl;

import Models.Size;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface SizeImpl {
    
    void insert(Size s);

    void update(Size s, String delete);

    void delete(String id);

    ArrayList<Size> getListSize();
}

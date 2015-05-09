/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt.dao;

import com.mycompany.tapprojekt01.entities.Gosti;
import java.util.List;

/**
 *
 * @author hammond
 */
public interface GostiDao {
    public List<Gosti> getListaSvihGost();
    public Gosti getGostById(Integer id);
    public void dodajGost(Gosti gost);
    public void obrisiGost(Integer id);    
}

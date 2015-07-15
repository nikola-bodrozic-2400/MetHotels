/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the
 */
package com.mycompany.tapprojekt.dao;

import com.mycompany.tapprojekt01.entities.Soba;
import java.util.List;

/**
 *
 * @author Nikola
 */
public interface SobaDao {

    public List<Soba> getListaSobaPoImenu(String ime);
    public List<Soba> getListaSvihSoba();
    public Soba getSobaById(Integer id);
    public void dodajSoba(Soba soba);
    public void obrisiSoba(Integer id);
}

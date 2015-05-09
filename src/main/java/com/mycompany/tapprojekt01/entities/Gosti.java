/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author hammond
 */
@Entity
@Table(name = "gosti")
@NamedQueries({
    @NamedQuery(name = "Gosti.findAll", query = "SELECT g FROM Gosti g")})
public class Gosti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "gost_ime")
    private String gostIme;
    @Basic(optional = false)
    @Column(name = "gost_prezime")
    private String gostPrezime;
    @Basic(optional = false)
    @Column(name = "passport_num")
    private int passportNum;
    
    @Inject
    public Gosti() {
    }

    public Gosti(Integer id) {
        this.id = id;
    }

    public Gosti(Integer id, String gostIme, String gostPrezime, int passportNum) {
        this.id = id;
        this.gostIme = gostIme;
        this.gostPrezime = gostPrezime;
        this.passportNum = passportNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGostIme() {
        return gostIme;
    }

    public void setGostIme(String gostIme) {
        this.gostIme = gostIme;
    }

    public String getGostPrezime() {
        return gostPrezime;
    }

    public void setGostPrezime(String gostPrezime) {
        this.gostPrezime = gostPrezime;
    }

    public int getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(int passportNum) {
        this.passportNum = passportNum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gosti)) {
            return false;
        }
        Gosti other = (Gosti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tapprojekt01.entities.Gosti[ id=" + id + " ]";
    }
    
}

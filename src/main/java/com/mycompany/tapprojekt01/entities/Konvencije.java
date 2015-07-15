/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author hammond
 */
@Entity
@Table(name = "konvencije")
@NamedQueries({
    @NamedQuery(name = "Konvencije.findAll", query = "SELECT k FROM Konvencije k")})
public class Konvencije extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "konvencija_ime")
    private String konvencijaIme;
    @Basic(optional = false)
    @Column(name = "konvencija_tema")
    private String konvencijaTema;
    @Basic(optional = false)
    @Column(name = "konvencija_datum")
    @Temporal(TemporalType.DATE)
    private Date konvencijaDatum;

    public Konvencije() {
    }

    public Konvencije(Integer id) {
        this.id = id;
    }

    public Konvencije(Integer id, String konvencijaIme, String konvencijaTema, Date konvencijaDatum) {
        this.id = id;
        this.konvencijaIme = konvencijaIme;
        this.konvencijaTema = konvencijaTema;
        this.konvencijaDatum = konvencijaDatum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKonvencijaIme() {
        return konvencijaIme;
    }

    public void setKonvencijaIme(String konvencijaIme) {
        this.konvencijaIme = konvencijaIme;
    }

    public String getKonvencijaTema() {
        return konvencijaTema;
    }

    public void setKonvencijaTema(String konvencijaTema) {
        this.konvencijaTema = konvencijaTema;
    }

    public Date getKonvencijaDatum() {
        return konvencijaDatum;
    }

    public void setKonvencijaDatum(Date konvencijaDatum) {
        this.konvencijaDatum = konvencijaDatum;
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
        if (!(object instanceof Konvencije)) {
            return false;
        }
        Konvencije other = (Konvencije) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tapprojekt01.entities.Konvencije[ id=" + id + " ]";
    }
    
}

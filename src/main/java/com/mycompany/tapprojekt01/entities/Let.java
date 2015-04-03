/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author student
 */
@Entity
@Table(name = "let")
@NamedQueries({
    @NamedQuery(name = "Let.findAll", query = "SELECT l FROM Let l")})
public class Let implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CENA_KARTE")
    private BigDecimal cenaKarte;
    @Basic(optional = false)
    @Column(name = "SIFRA_LETA")
    private String sifraLeta;
    @Basic(optional = false)
    @Column(name = "VREME_POLASKA")
    private String vremePolaska;
    @Basic(optional = false)
    @Column(name = "VREME_DOLASKA")
    private String vremeDolaska;
    @Column(name = "DATUM_POLASKA")
    @Temporal(TemporalType.DATE)
    private Date datumPolaska;
    @Column(name = "DATUM_DOLASKA")
    @Temporal(TemporalType.DATE)
    private Date datumDolaska;
    @OneToMany(mappedBy = "letId")
    private List<Rezervacija> rezervacijaList;
    @JoinColumn(name = "AVI_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Avion aviId;
    @JoinColumn(name = "GRA_ID2", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Grad graId2;
    @JoinColumn(name = "GRA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Grad graId;
    @JoinColumn(name = "GRA_ID3", referencedColumnName = "ID")
    @ManyToOne
    private Grad graId3;

    @Inject
    public Let() {
    }

    public Let(Integer id) {
        this.id = id;
    }

    public Let(Integer id, BigDecimal cenaKarte, String sifraLeta, String vremePolaska, String vremeDolaska) {
        this.id = id;
        this.cenaKarte = cenaKarte;
        this.sifraLeta = sifraLeta;
        this.vremePolaska = vremePolaska;
        this.vremeDolaska = vremeDolaska;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCenaKarte() {
        return cenaKarte;
    }

    public void setCenaKarte(BigDecimal cenaKarte) {
        this.cenaKarte = cenaKarte;
    }

    public String getSifraLeta() {
        return sifraLeta;
    }

    public void setSifraLeta(String sifraLeta) {
        this.sifraLeta = sifraLeta;
    }

    public String getVremePolaska() {
        return vremePolaska;
    }

    public void setVremePolaska(String vremePolaska) {
        this.vremePolaska = vremePolaska;
    }

    public String getVremeDolaska() {
        return vremeDolaska;
    }

    public void setVremeDolaska(String vremeDolaska) {
        this.vremeDolaska = vremeDolaska;
    }

    public Date getDatumPolaska() {
        return datumPolaska;
    }

    public void setDatumPolaska(Date datumPolaska) {
        this.datumPolaska = datumPolaska;
    }

    public Date getDatumDolaska() {
        return datumDolaska;
    }

    public void setDatumDolaska(Date datumDolaska) {
        this.datumDolaska = datumDolaska;
    }

    public List<Rezervacija> getRezervacijaList() {
        return rezervacijaList;
    }

    public void setRezervacijaList(List<Rezervacija> rezervacijaList) {
        this.rezervacijaList = rezervacijaList;
    }

    public Avion getAviId() {
        return aviId;
    }

    public void setAviId(Avion aviId) {
        this.aviId = aviId;
    }

    public Grad getGraId2() {
        return graId2;
    }

    public void setGraId2(Grad graId2) {
        this.graId2 = graId2;
    }

    public Grad getGraId() {
        return graId;
    }

    public void setGraId(Grad graId) {
        this.graId = graId;
    }

    public Grad getGraId3() {
        return graId3;
    }

    public void setGraId3(Grad graId3) {
        this.graId3 = graId3;
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
        if (!(object instanceof Let)) {
            return false;
        }
        Let other = (Let) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tapprojekt01.components.Let[ id=" + id + " ]";
    }
    
}

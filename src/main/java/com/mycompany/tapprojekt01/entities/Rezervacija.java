/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author student
 */
@Entity
@Table(name = "rezervacija")
@NamedQueries({
    @NamedQuery(name = "Rezervacija.findAll", query = "SELECT r FROM Rezervacija r")})
public class Rezervacija implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "BROJ_KARATA")
    private int brojKarata;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "UKUPNA_CENA")
    private BigDecimal ukupnaCena;
    @Column(name = "POPUST")
    private BigDecimal popust;
    @Column(name = "DODATNI_OPIS")
    private String dodatniOpis;
    @JoinColumn(name = "KLI_ID", referencedColumnName = "ID")
    @ManyToOne
    private Klijent kliId;
    @JoinColumn(name = "LET_ID", referencedColumnName = "ID")
    @ManyToOne
    private Let letId;

    @Inject
    public Rezervacija() {
    }

    public Rezervacija(Integer id) {
        this.id = id;
    }

    public Rezervacija(Integer id, int brojKarata, BigDecimal ukupnaCena) {
        this.id = id;
        this.brojKarata = brojKarata;
        this.ukupnaCena = ukupnaCena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBrojKarata() {
        return brojKarata;
    }

    public void setBrojKarata(int brojKarata) {
        this.brojKarata = brojKarata;
    }

    public BigDecimal getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(BigDecimal ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public BigDecimal getPopust() {
        return popust;
    }

    public void setPopust(BigDecimal popust) {
        this.popust = popust;
    }

    public String getDodatniOpis() {
        return dodatniOpis;
    }

    public void setDodatniOpis(String dodatniOpis) {
        this.dodatniOpis = dodatniOpis;
    }

    public Klijent getKliId() {
        return kliId;
    }

    public void setKliId(Klijent kliId) {
        this.kliId = kliId;
    }

    public Let getLetId() {
        return letId;
    }

    public void setLetId(Let letId) {
        this.letId = letId;
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
        if (!(object instanceof Rezervacija)) {
            return false;
        }
        Rezervacija other = (Rezervacija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tapprojekt01.components.Rezervacija[ id=" + id + " ]";
    }
    
}

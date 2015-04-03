/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author student
 */
@Entity
@Table(name = "grad")
@NamedQueries({
    @NamedQuery(name = "Grad.findAll", query = "SELECT g FROM Grad g")})
public class Grad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "IME_GRADA")
    private String imeGrada;
    @Basic(optional = false)
    @Column(name = "IME_AERODROMA")
    private String imeAerodroma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "graId2")
    private List<Let> letList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "graId")
    private List<Let> letList1;
    @OneToMany(mappedBy = "graId3")
    private List<Let> letList2;
    @JoinColumn(name = "DRZ_ID", referencedColumnName = "ID")
    @ManyToOne
    private Drzave drzId;
    
    @Inject
    public Grad() {
    }

    public Grad(Integer id) {
        this.id = id;
    }

    public Grad(Integer id, String imeGrada, String imeAerodroma) {
        this.id = id;
        this.imeGrada = imeGrada;
        this.imeAerodroma = imeAerodroma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImeGrada() {
        return imeGrada;
    }

    public void setImeGrada(String imeGrada) {
        this.imeGrada = imeGrada;
    }

    public String getImeAerodroma() {
        return imeAerodroma;
    }

    public void setImeAerodroma(String imeAerodroma) {
        this.imeAerodroma = imeAerodroma;
    }

    public List<Let> getLetList() {
        return letList;
    }

    public void setLetList(List<Let> letList) {
        this.letList = letList;
    }

    public List<Let> getLetList1() {
        return letList1;
    }

    public void setLetList1(List<Let> letList1) {
        this.letList1 = letList1;
    }

    public List<Let> getLetList2() {
        return letList2;
    }

    public void setLetList2(List<Let> letList2) {
        this.letList2 = letList2;
    }

    public Drzave getDrzId() {
        return drzId;
    }

    public void setDrzId(Drzave drzId) {
        this.drzId = drzId;
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
        if (!(object instanceof Grad)) {
            return false;
        }
        Grad other = (Grad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tapprojekt01.components.Grad[ id=" + id + " ]";
    }
    
}

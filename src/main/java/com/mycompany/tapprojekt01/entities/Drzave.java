/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapprojekt01.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "drzave")
@NamedQueries({
    @NamedQuery(name = "Drzave.findAll", query = "SELECT d FROM Drzave d")})
public class Drzave implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "IME_DRZAVE")
    private String imeDrzave;
    @OneToMany(mappedBy = "drzId")
    private List<Grad> gradList;
    
    @Inject
    public Drzave() {
    }

    public Drzave(Integer id) {
        this.id = id;
    }

    public Drzave(Integer id, String imeDrzave) {
        this.id = id;
        this.imeDrzave = imeDrzave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImeDrzave() {
        return imeDrzave;
    }

    public void setImeDrzave(String imeDrzave) {
        this.imeDrzave = imeDrzave;
    }

    public List<Grad> getGradList() {
        return gradList;
    }

    public void setGradList(List<Grad> gradList) {
        this.gradList = gradList;
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
        if (!(object instanceof Drzave)) {
            return false;
        }
        Drzave other = (Drzave) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tapprojekt01.components.Drzave[ id=" + id + " ]";
    }
    
}

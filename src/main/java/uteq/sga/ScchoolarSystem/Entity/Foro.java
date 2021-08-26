/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Entity;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author capur
 */
@Entity
@Table(name = "foro", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Foro.findAll", query = "SELECT f FROM Foro f"),
    @NamedQuery(name = "Foro.findByIdforo", query = "SELECT f FROM Foro f WHERE f.idforo = :idforo")})
public class Foro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idforo")
    private Integer idforo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idforo")
    private Collection<Foroestudiante> foroestudianteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idforo")
    private Collection<Foroprofesor> foroprofesorCollection;
    @JoinColumn(name = "idactividad", referencedColumnName = "idactividad")
    @ManyToOne(optional = false)
    private Actividad idactividad;

    public Foro() {
    }

    public Foro(Integer idforo) {
        this.idforo = idforo;
    }

    public Integer getIdforo() {
        return idforo;
    }

    public void setIdforo(Integer idforo) {
        this.idforo = idforo;
    }

    public Collection<Foroestudiante> getForoestudianteCollection() {
        return foroestudianteCollection;
    }

    public void setForoestudianteCollection(Collection<Foroestudiante> foroestudianteCollection) {
        this.foroestudianteCollection = foroestudianteCollection;
    }

    public Collection<Foroprofesor> getForoprofesorCollection() {
        return foroprofesorCollection;
    }

    public void setForoprofesorCollection(Collection<Foroprofesor> foroprofesorCollection) {
        this.foroprofesorCollection = foroprofesorCollection;
    }

    public Actividad getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(Actividad idactividad) {
        this.idactividad = idactividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idforo != null ? idforo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foro)) {
            return false;
        }
        Foro other = (Foro) object;
        if ((this.idforo == null && other.idforo != null) || (this.idforo != null && !this.idforo.equals(other.idforo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Foro[ idforo=" + idforo + " ]";
    }
    
}

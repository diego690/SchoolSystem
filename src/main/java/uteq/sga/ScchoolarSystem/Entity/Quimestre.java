/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author capur
 */
@Entity
@Table(catalog = "GA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quimestre.findAll", query = "SELECT q FROM Quimestre q"),
    @NamedQuery(name = "Quimestre.findByIdquimestre", query = "SELECT q FROM Quimestre q WHERE q.idquimestre = :idquimestre"),
    @NamedQuery(name = "Quimestre.findByFechainicio", query = "SELECT q FROM Quimestre q WHERE q.fechainicio = :fechainicio"),
    @NamedQuery(name = "Quimestre.findByFechafin", query = "SELECT q FROM Quimestre q WHERE q.fechafin = :fechafin")})
public class Quimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idquimestre;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idquimestre")
    private Collection<Parcial> parcialCollection;
    @JoinColumn(name = "idperiodo", referencedColumnName = "idperiodo")
    @ManyToOne(optional = false)
    private Periodo idperiodo;

    public Quimestre() {
    }

    public Quimestre(Integer idquimestre) {
        this.idquimestre = idquimestre;
    }

    public Quimestre(Integer idquimestre, Date fechainicio, Date fechafin) {
        this.idquimestre = idquimestre;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    public Integer getIdquimestre() {
        return idquimestre;
    }

    public void setIdquimestre(Integer idquimestre) {
        this.idquimestre = idquimestre;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    @XmlTransient
    public Collection<Parcial> getParcialCollection() {
        return parcialCollection;
    }

    public void setParcialCollection(Collection<Parcial> parcialCollection) {
        this.parcialCollection = parcialCollection;
    }

    public Periodo getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(Periodo idperiodo) {
        this.idperiodo = idperiodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idquimestre != null ? idquimestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quimestre)) {
            return false;
        }
        Quimestre other = (Quimestre) object;
        if ((this.idquimestre == null && other.idquimestre != null) || (this.idquimestre != null && !this.idquimestre.equals(other.idquimestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Quimestre[ idquimestre=" + idquimestre + " ]";
    }
    
}

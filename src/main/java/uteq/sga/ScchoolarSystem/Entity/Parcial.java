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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "parcial", catalog = "GA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parcial.findAll", query = "SELECT p FROM Parcial p"),
    @NamedQuery(name = "Parcial.findByIdparcial", query = "SELECT p FROM Parcial p WHERE p.idparcial = :idparcial"),
    @NamedQuery(name = "Parcial.findByFechainicio", query = "SELECT p FROM Parcial p WHERE p.fechainicio = :fechainicio"),
    @NamedQuery(name = "Parcial.findByFechafin", query = "SELECT p FROM Parcial p WHERE p.fechafin = :fechafin")})
public class Parcial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparcial")
    private Integer idparcial;
    @Basic(optional = false)
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @JoinColumn(name = "idquimestre", referencedColumnName = "idquimestre")
    @ManyToOne(optional = false)
    private Quimestre idquimestre;
    @OneToMany(mappedBy = "idparcial")
    private Collection<Tareas> tareasCollection;

    public Parcial() {
    }

    public Parcial(Integer idparcial) {
        this.idparcial = idparcial;
    }

    public Parcial(Integer idparcial, Date fechainicio, Date fechafin) {
        this.idparcial = idparcial;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    public Integer getIdparcial() {
        return idparcial;
    }

    public void setIdparcial(Integer idparcial) {
        this.idparcial = idparcial;
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

    public Quimestre getIdquimestre() {
        return idquimestre;
    }

    public void setIdquimestre(Quimestre idquimestre) {
        this.idquimestre = idquimestre;
    }

    @XmlTransient
    public Collection<Tareas> getTareasCollection() {
        return tareasCollection;
    }

    public void setTareasCollection(Collection<Tareas> tareasCollection) {
        this.tareasCollection = tareasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparcial != null ? idparcial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parcial)) {
            return false;
        }
        Parcial other = (Parcial) object;
        if ((this.idparcial == null && other.idparcial != null) || (this.idparcial != null && !this.idparcial.equals(other.idparcial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Parcial[ idparcial=" + idparcial + " ]";
    }
    
}

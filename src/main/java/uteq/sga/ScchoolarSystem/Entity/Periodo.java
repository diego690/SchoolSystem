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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "periodo", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p"),
    @NamedQuery(name = "Periodo.findByIdperiodo", query = "SELECT p FROM Periodo p WHERE p.idperiodo = :idperiodo"),
    @NamedQuery(name = "Periodo.findByFechainicio", query = "SELECT p FROM Periodo p WHERE p.fechainicio = :fechainicio"),
    @NamedQuery(name = "Periodo.findByFechafin", query = "SELECT p FROM Periodo p WHERE p.fechafin = :fechafin"),
    @NamedQuery(name = "Periodo.findByEstado", query = "SELECT p FROM Periodo p WHERE p.estado = :estado")})
public class Periodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperiodo")
    private Integer idperiodo;
    @Basic(optional = false)
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperiodo")
    private Collection<Periodomatriculacurso> periodomatriculacursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperiodo")
    private Collection<Quimestre> quimestreCollection;

    public Periodo() {
    }

    public Periodo(Integer idperiodo) {
        this.idperiodo = idperiodo;
    }

    public Periodo(Integer idperiodo, Date fechainicio, Date fechafin) {
        this.idperiodo = idperiodo;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    public Integer getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(Integer idperiodo) {
        this.idperiodo = idperiodo;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Periodomatriculacurso> getPeriodomatriculacursoCollection() {
        return periodomatriculacursoCollection;
    }

    public void setPeriodomatriculacursoCollection(Collection<Periodomatriculacurso> periodomatriculacursoCollection) {
        this.periodomatriculacursoCollection = periodomatriculacursoCollection;
    }

    public Collection<Quimestre> getQuimestreCollection() {
        return quimestreCollection;
    }

    public void setQuimestreCollection(Collection<Quimestre> quimestreCollection) {
        this.quimestreCollection = quimestreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperiodo != null ? idperiodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.idperiodo == null && other.idperiodo != null) || (this.idperiodo != null && !this.idperiodo.equals(other.idperiodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Periodo[ idperiodo=" + idperiodo + " ]";
    }
    
}

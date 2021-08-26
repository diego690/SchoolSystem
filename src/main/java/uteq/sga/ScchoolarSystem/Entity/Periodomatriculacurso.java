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
@Table(name = "periodomatriculacurso", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Periodomatriculacurso.findAll", query = "SELECT p FROM Periodomatriculacurso p"),
    @NamedQuery(name = "Periodomatriculacurso.findByIdperiodomatricula", query = "SELECT p FROM Periodomatriculacurso p WHERE p.idperiodomatricula = :idperiodomatricula")})
public class Periodomatriculacurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperiodomatricula")
    private Integer idperiodomatricula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperiodomatricula")
    private Collection<Calificacion> calificacionCollection;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    @ManyToOne
    private Curso idcurso;
    @JoinColumn(name = "idmatricula", referencedColumnName = "idmatricula")
    @ManyToOne(optional = false)
    private Matricula idmatricula;
    @JoinColumn(name = "idperiodo", referencedColumnName = "idperiodo")
    @ManyToOne(optional = false)
    private Periodo idperiodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperiodomatriculacurso")
    private Collection<Pago> pagoCollection;

    public Periodomatriculacurso() {
    }

    public Periodomatriculacurso(Integer idperiodomatricula) {
        this.idperiodomatricula = idperiodomatricula;
    }

    public Integer getIdperiodomatricula() {
        return idperiodomatricula;
    }

    public void setIdperiodomatricula(Integer idperiodomatricula) {
        this.idperiodomatricula = idperiodomatricula;
    }

    public Collection<Calificacion> getCalificacionCollection() {
        return calificacionCollection;
    }

    public void setCalificacionCollection(Collection<Calificacion> calificacionCollection) {
        this.calificacionCollection = calificacionCollection;
    }

    public Curso getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Curso idcurso) {
        this.idcurso = idcurso;
    }

    public Matricula getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(Matricula idmatricula) {
        this.idmatricula = idmatricula;
    }

    public Periodo getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(Periodo idperiodo) {
        this.idperiodo = idperiodo;
    }

    public Collection<Pago> getPagoCollection() {
        return pagoCollection;
    }

    public void setPagoCollection(Collection<Pago> pagoCollection) {
        this.pagoCollection = pagoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperiodomatricula != null ? idperiodomatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodomatriculacurso)) {
            return false;
        }
        Periodomatriculacurso other = (Periodomatriculacurso) object;
        if ((this.idperiodomatricula == null && other.idperiodomatricula != null) || (this.idperiodomatricula != null && !this.idperiodomatricula.equals(other.idperiodomatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Periodomatriculacurso[ idperiodomatricula=" + idperiodomatricula + " ]";
    }
    
}

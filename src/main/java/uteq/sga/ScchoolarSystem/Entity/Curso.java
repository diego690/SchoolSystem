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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "curso", catalog = "GA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByIdcurso", query = "SELECT c FROM Curso c WHERE c.idcurso = :idcurso"),
    @NamedQuery(name = "Curso.findByCantidad", query = "SELECT c FROM Curso c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "Curso.findByParalelo", query = "SELECT c FROM Curso c WHERE c.paralelo = :paralelo")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcurso")
    private Integer idcurso;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private long cantidad;
    @Basic(optional = false)
    @Column(name = "paralelo")
    private Character paralelo;
    @OneToMany(mappedBy = "idcurso")
    private Collection<Periodomatriculacurso> periodomatriculacursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcurso")
    private Collection<Materiacurso> materiacursoCollection;
    @JoinColumn(name = "idnivel", referencedColumnName = "idnivel")
    @ManyToOne(optional = false)
    private Nivel idnivel;
    @JoinColumn(name = "idprofesor", referencedColumnName = "idprofesor")
    @ManyToOne(optional = false)
    private Profesor idprofesor;

    public Curso() {
    }

    public Curso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public Curso(Integer idcurso, long cantidad, Character paralelo) {
        this.idcurso = idcurso;
        this.cantidad = cantidad;
        this.paralelo = paralelo;
    }

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public Character getParalelo() {
        return paralelo;
    }

    public void setParalelo(Character paralelo) {
        this.paralelo = paralelo;
    }

    @XmlTransient
    public Collection<Periodomatriculacurso> getPeriodomatriculacursoCollection() {
        return periodomatriculacursoCollection;
    }

    public void setPeriodomatriculacursoCollection(Collection<Periodomatriculacurso> periodomatriculacursoCollection) {
        this.periodomatriculacursoCollection = periodomatriculacursoCollection;
    }

    @XmlTransient
    public Collection<Materiacurso> getMateriacursoCollection() {
        return materiacursoCollection;
    }

    public void setMateriacursoCollection(Collection<Materiacurso> materiacursoCollection) {
        this.materiacursoCollection = materiacursoCollection;
    }

    public Nivel getIdnivel() {
        return idnivel;
    }

    public void setIdnivel(Nivel idnivel) {
        this.idnivel = idnivel;
    }

    public Profesor getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Profesor idprofesor) {
        this.idprofesor = idprofesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcurso != null ? idcurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idcurso == null && other.idcurso != null) || (this.idcurso != null && !this.idcurso.equals(other.idcurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Curso[ idcurso=" + idcurso + " ]";
    }
    
}

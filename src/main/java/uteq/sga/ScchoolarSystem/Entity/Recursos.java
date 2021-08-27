/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "recursos", catalog = "GA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recursos.findAll", query = "SELECT r FROM Recursos r"),
    @NamedQuery(name = "Recursos.findByIdrecursos", query = "SELECT r FROM Recursos r WHERE r.idrecursos = :idrecursos"),
    @NamedQuery(name = "Recursos.findByDato", query = "SELECT r FROM Recursos r WHERE r.dato = :dato"),
    @NamedQuery(name = "Recursos.findByFecha", query = "SELECT r FROM Recursos r WHERE r.fecha = :fecha")})
public class Recursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrecursos")
    private Integer idrecursos;
    @Basic(optional = false)
    @Column(name = "dato")
    private String dato;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idmateria", referencedColumnName = "idmateriacurso")
    @ManyToOne(optional = false)
    private Materiacurso idmateria;
    @JoinColumn(name = "idtiporecurso", referencedColumnName = "idtiporecurso")
    @ManyToOne(optional = false)
    private Tiporecurso idtiporecurso;

    public Recursos() {
    }

    public Recursos(Integer idrecursos) {
        this.idrecursos = idrecursos;
    }

    public Recursos(Integer idrecursos, String dato, Date fecha) {
        this.idrecursos = idrecursos;
        this.dato = dato;
        this.fecha = fecha;
    }

    public Integer getIdrecursos() {
        return idrecursos;
    }

    public void setIdrecursos(Integer idrecursos) {
        this.idrecursos = idrecursos;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Materiacurso getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Materiacurso idmateria) {
        this.idmateria = idmateria;
    }

    public Tiporecurso getIdtiporecurso() {
        return idtiporecurso;
    }

    public void setIdtiporecurso(Tiporecurso idtiporecurso) {
        this.idtiporecurso = idtiporecurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecursos != null ? idrecursos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recursos)) {
            return false;
        }
        Recursos other = (Recursos) object;
        if ((this.idrecursos == null && other.idrecursos != null) || (this.idrecursos != null && !this.idrecursos.equals(other.idrecursos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Recursos[ idrecursos=" + idrecursos + " ]";
    }
    
}

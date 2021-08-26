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
@Table(name = "tareas", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Tareas.findAll", query = "SELECT t FROM Tareas t"),
    @NamedQuery(name = "Tareas.findByIdtareas", query = "SELECT t FROM Tareas t WHERE t.idtareas = :idtareas"),
    @NamedQuery(name = "Tareas.findByRequiereenvio", query = "SELECT t FROM Tareas t WHERE t.requiereenvio = :requiereenvio"),
    @NamedQuery(name = "Tareas.findByEstado", query = "SELECT t FROM Tareas t WHERE t.estado = :estado"),
    @NamedQuery(name = "Tareas.findByRecurso", query = "SELECT t FROM Tareas t WHERE t.recurso = :recurso")})
public class Tareas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtareas")
    private Integer idtareas;
    @Basic(optional = false)
    @Column(name = "requiereenvio")
    private boolean requiereenvio;
    @Column(name = "estado")
    private String estado;
    @Column(name = "recurso")
    private String recurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtareas")
    private Collection<Calificacion> calificacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtareas")
    private Collection<Tiponotas> tiponotasCollection;
    @JoinColumn(name = "idactividad", referencedColumnName = "idactividad")
    @ManyToOne(optional = false)
    private Actividad idactividad;
    @JoinColumn(name = "idparcial", referencedColumnName = "idparcial")
    @ManyToOne
    private Parcial idparcial;

    public Tareas() {
    }

    public Tareas(Integer idtareas) {
        this.idtareas = idtareas;
    }

    public Tareas(Integer idtareas, boolean requiereenvio) {
        this.idtareas = idtareas;
        this.requiereenvio = requiereenvio;
    }

    public Integer getIdtareas() {
        return idtareas;
    }

    public void setIdtareas(Integer idtareas) {
        this.idtareas = idtareas;
    }

    public boolean getRequiereenvio() {
        return requiereenvio;
    }

    public void setRequiereenvio(boolean requiereenvio) {
        this.requiereenvio = requiereenvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public Collection<Calificacion> getCalificacionCollection() {
        return calificacionCollection;
    }

    public void setCalificacionCollection(Collection<Calificacion> calificacionCollection) {
        this.calificacionCollection = calificacionCollection;
    }

    public Collection<Tiponotas> getTiponotasCollection() {
        return tiponotasCollection;
    }

    public void setTiponotasCollection(Collection<Tiponotas> tiponotasCollection) {
        this.tiponotasCollection = tiponotasCollection;
    }

    public Actividad getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(Actividad idactividad) {
        this.idactividad = idactividad;
    }

    public Parcial getIdparcial() {
        return idparcial;
    }

    public void setIdparcial(Parcial idparcial) {
        this.idparcial = idparcial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtareas != null ? idtareas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tareas)) {
            return false;
        }
        Tareas other = (Tareas) object;
        if ((this.idtareas == null && other.idtareas != null) || (this.idtareas != null && !this.idtareas.equals(other.idtareas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Tareas[ idtareas=" + idtareas + " ]";
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "actividad", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findByIdactividad", query = "SELECT a FROM Actividad a WHERE a.idactividad = :idactividad"),
    @NamedQuery(name = "Actividad.findByTitulo", query = "SELECT a FROM Actividad a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Actividad.findByDescripcion", query = "SELECT a FROM Actividad a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Actividad.findByFechinicio", query = "SELECT a FROM Actividad a WHERE a.fechinicio = :fechinicio"),
    @NamedQuery(name = "Actividad.findByFechafin", query = "SELECT a FROM Actividad a WHERE a.fechafin = :fechafin")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idactividad")
    private Integer idactividad;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fechinicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechinicio;
    @Basic(optional = false)
    @Column(name = "fechafin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafin;
    @JoinColumn(name = "idmateriacurso", referencedColumnName = "idmateriacurso")
    @ManyToOne(optional = false)
    private Materiacurso idmateriacurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactividad")
    private Collection<Tareas> tareasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactividad")
    private Collection<Foro> foroCollection;

    public Actividad() {
    }

    public Actividad(Integer idactividad) {
        this.idactividad = idactividad;
    }

    public Actividad(Integer idactividad, String titulo, String descripcion, Date fechinicio, Date fechafin) {
        this.idactividad = idactividad;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechinicio = fechinicio;
        this.fechafin = fechafin;
    }

    public Integer getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(Integer idactividad) {
        this.idactividad = idactividad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechinicio() {
        return fechinicio;
    }

    public void setFechinicio(Date fechinicio) {
        this.fechinicio = fechinicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Materiacurso getIdmateriacurso() {
        return idmateriacurso;
    }

    public void setIdmateriacurso(Materiacurso idmateriacurso) {
        this.idmateriacurso = idmateriacurso;
    }

    public Collection<Tareas> getTareasCollection() {
        return tareasCollection;
    }

    public void setTareasCollection(Collection<Tareas> tareasCollection) {
        this.tareasCollection = tareasCollection;
    }

    public Collection<Foro> getForoCollection() {
        return foroCollection;
    }

    public void setForoCollection(Collection<Foro> foroCollection) {
        this.foroCollection = foroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactividad != null ? idactividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.idactividad == null && other.idactividad != null) || (this.idactividad != null && !this.idactividad.equals(other.idactividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Actividad[ idactividad=" + idactividad + " ]";
    }
    
}

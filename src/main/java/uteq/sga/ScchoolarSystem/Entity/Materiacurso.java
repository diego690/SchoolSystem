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
@Table(catalog = "GA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiacurso.findAll", query = "SELECT m FROM Materiacurso m"),
    @NamedQuery(name = "Materiacurso.findByIdmateriacurso", query = "SELECT m FROM Materiacurso m WHERE m.idmateriacurso = :idmateriacurso"),
    @NamedQuery(name = "Materiacurso.findByNombre", query = "SELECT m FROM Materiacurso m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Materiacurso.findByDescripcion", query = "SELECT m FROM Materiacurso m WHERE m.descripcion = :descripcion")})
public class Materiacurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idmateriacurso;
    private String nombre;
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmateriacurso")
    private Collection<Actividad> actividadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmateriacurso")
    private Collection<Asistencia> asistenciaCollection;
    @JoinColumn(name = "idcurso", referencedColumnName = "idcurso")
    @ManyToOne(optional = false)
    private Curso idcurso;
    @JoinColumn(name = "idmateria", referencedColumnName = "idmateria")
    @ManyToOne(optional = false)
    private Materia idmateria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmateriacurso")
    private Collection<Horasclase> horasclaseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmateria")
    private Collection<Recursos> recursosCollection;

    public Materiacurso() {
    }

    public Materiacurso(Integer idmateriacurso) {
        this.idmateriacurso = idmateriacurso;
    }

    public Integer getIdmateriacurso() {
        return idmateriacurso;
    }

    public void setIdmateriacurso(Integer idmateriacurso) {
        this.idmateriacurso = idmateriacurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Actividad> getActividadCollection() {
        return actividadCollection;
    }

    public void setActividadCollection(Collection<Actividad> actividadCollection) {
        this.actividadCollection = actividadCollection;
    }

    @XmlTransient
    public Collection<Asistencia> getAsistenciaCollection() {
        return asistenciaCollection;
    }

    public void setAsistenciaCollection(Collection<Asistencia> asistenciaCollection) {
        this.asistenciaCollection = asistenciaCollection;
    }

    public Curso getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Curso idcurso) {
        this.idcurso = idcurso;
    }

    public Materia getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Materia idmateria) {
        this.idmateria = idmateria;
    }

    @XmlTransient
    public Collection<Horasclase> getHorasclaseCollection() {
        return horasclaseCollection;
    }

    public void setHorasclaseCollection(Collection<Horasclase> horasclaseCollection) {
        this.horasclaseCollection = horasclaseCollection;
    }

    @XmlTransient
    public Collection<Recursos> getRecursosCollection() {
        return recursosCollection;
    }

    public void setRecursosCollection(Collection<Recursos> recursosCollection) {
        this.recursosCollection = recursosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmateriacurso != null ? idmateriacurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiacurso)) {
            return false;
        }
        Materiacurso other = (Materiacurso) object;
        if ((this.idmateriacurso == null && other.idmateriacurso != null) || (this.idmateriacurso != null && !this.idmateriacurso.equals(other.idmateriacurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Materiacurso[ idmateriacurso=" + idmateriacurso + " ]";
    }
    
}

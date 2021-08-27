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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "matricula", catalog = "GA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByIdmatricula", query = "SELECT m FROM Matricula m WHERE m.idmatricula = :idmatricula"),
    @NamedQuery(name = "Matricula.findByNumero", query = "SELECT m FROM Matricula m WHERE m.numero = :numero"),
    @NamedQuery(name = "Matricula.findByEvidencia", query = "SELECT m FROM Matricula m WHERE m.evidencia = :evidencia"),
    @NamedQuery(name = "Matricula.findByEstado", query = "SELECT m FROM Matricula m WHERE m.estado = :estado"),
    @NamedQuery(name = "Matricula.findByFechainscripcion", query = "SELECT m FROM Matricula m WHERE m.fechainscripcion = :fechainscripcion"),
    @NamedQuery(name = "Matricula.findByFechamatriculacion", query = "SELECT m FROM Matricula m WHERE m.fechamatriculacion = :fechamatriculacion")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmatricula")
    private Integer idmatricula;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Column(name = "evidencia")
    private String evidencia;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "fechainscripcion")
    @Temporal(TemporalType.DATE)
    private Date fechainscripcion;
    @Column(name = "fechamatriculacion")
    @Temporal(TemporalType.DATE)
    private Date fechamatriculacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmatricula")
    private Collection<Estudiante> estudianteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmatricula")
    private Collection<Periodomatriculacurso> periodomatriculacursoCollection;

    public Matricula() {
    }

    public Matricula(Integer idmatricula) {
        this.idmatricula = idmatricula;
    }

    public Matricula(Integer idmatricula, String numero) {
        this.idmatricula = idmatricula;
        this.numero = numero;
    }

    public Integer getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(Integer idmatricula) {
        this.idmatricula = idmatricula;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(Date fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }

    public Date getFechamatriculacion() {
        return fechamatriculacion;
    }

    public void setFechamatriculacion(Date fechamatriculacion) {
        this.fechamatriculacion = fechamatriculacion;
    }

    @XmlTransient
    public Collection<Estudiante> getEstudianteCollection() {
        return estudianteCollection;
    }

    public void setEstudianteCollection(Collection<Estudiante> estudianteCollection) {
        this.estudianteCollection = estudianteCollection;
    }

    @XmlTransient
    public Collection<Periodomatriculacurso> getPeriodomatriculacursoCollection() {
        return periodomatriculacursoCollection;
    }

    public void setPeriodomatriculacursoCollection(Collection<Periodomatriculacurso> periodomatriculacursoCollection) {
        this.periodomatriculacursoCollection = periodomatriculacursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatricula != null ? idmatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idmatricula == null && other.idmatricula != null) || (this.idmatricula != null && !this.idmatricula.equals(other.idmatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Matricula[ idmatricula=" + idmatricula + " ]";
    }
    
}

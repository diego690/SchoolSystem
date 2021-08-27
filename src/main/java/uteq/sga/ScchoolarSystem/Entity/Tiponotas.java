/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteq.sga.ScchoolarSystem.Entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author capur
 */
@Entity
@Table(name = "tiponotas", catalog = "GA", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiponotas.findAll", query = "SELECT t FROM Tiponotas t"),
    @NamedQuery(name = "Tiponotas.findByIdnotas", query = "SELECT t FROM Tiponotas t WHERE t.idnotas = :idnotas"),
    @NamedQuery(name = "Tiponotas.findByNombre", query = "SELECT t FROM Tiponotas t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tiponotas.findByDescripcion", query = "SELECT t FROM Tiponotas t WHERE t.descripcion = :descripcion")})
public class Tiponotas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnotas")
    private Integer idnotas;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idtareas", referencedColumnName = "idtareas")
    @ManyToOne(optional = false)
    private Tareas idtareas;

    public Tiponotas() {
    }

    public Tiponotas(Integer idnotas) {
        this.idnotas = idnotas;
    }

    public Tiponotas(Integer idnotas, String nombre) {
        this.idnotas = idnotas;
        this.nombre = nombre;
    }

    public Integer getIdnotas() {
        return idnotas;
    }

    public void setIdnotas(Integer idnotas) {
        this.idnotas = idnotas;
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

    public Tareas getIdtareas() {
        return idtareas;
    }

    public void setIdtareas(Tareas idtareas) {
        this.idtareas = idtareas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnotas != null ? idnotas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiponotas)) {
            return false;
        }
        Tiponotas other = (Tiponotas) object;
        if ((this.idnotas == null && other.idnotas != null) || (this.idnotas != null && !this.idnotas.equals(other.idnotas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Tiponotas[ idnotas=" + idnotas + " ]";
    }
    
}

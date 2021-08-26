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

/**
 *
 * @author capur
 */
@Entity
@Table(name = "titulos", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Titulos.findAll", query = "SELECT t FROM Titulos t"),
    @NamedQuery(name = "Titulos.findByIdtitulos", query = "SELECT t FROM Titulos t WHERE t.idtitulos = :idtitulos"),
    @NamedQuery(name = "Titulos.findByTitulacion", query = "SELECT t FROM Titulos t WHERE t.titulacion = :titulacion"),
    @NamedQuery(name = "Titulos.findByDescripcion", query = "SELECT t FROM Titulos t WHERE t.descripcion = :descripcion")})
public class Titulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtitulos")
    private Short idtitulos;
    @Basic(optional = false)
    @Column(name = "titulacion")
    private String titulacion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "idprofesor", referencedColumnName = "idprofesor")
    @ManyToOne
    private Profesor idprofesor;

    public Titulos() {
    }

    public Titulos(Short idtitulos) {
        this.idtitulos = idtitulos;
    }

    public Titulos(Short idtitulos, String titulacion, String descripcion) {
        this.idtitulos = idtitulos;
        this.titulacion = titulacion;
        this.descripcion = descripcion;
    }

    public Short getIdtitulos() {
        return idtitulos;
    }

    public void setIdtitulos(Short idtitulos) {
        this.idtitulos = idtitulos;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idtitulos != null ? idtitulos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titulos)) {
            return false;
        }
        Titulos other = (Titulos) object;
        if ((this.idtitulos == null && other.idtitulos != null) || (this.idtitulos != null && !this.idtitulos.equals(other.idtitulos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Titulos[ idtitulos=" + idtitulos + " ]";
    }
    
}

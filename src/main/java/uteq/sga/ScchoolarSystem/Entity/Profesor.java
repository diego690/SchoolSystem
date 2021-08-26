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
@Table(name = "profesor", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByIdprofesor", query = "SELECT p FROM Profesor p WHERE p.idprofesor = :idprofesor")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofesor")
    private Integer idprofesor;
    @OneToMany(mappedBy = "idprofesor")
    private Collection<Titulos> titulosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesor")
    private Collection<Foroprofesor> foroprofesorCollection;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesor")
    private Collection<Chatprofesor> chatprofesorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesor")
    private Collection<Curso> cursoCollection;

    public Profesor() {
    }

    public Profesor(Integer idprofesor) {
        this.idprofesor = idprofesor;
    }

    public Integer getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Integer idprofesor) {
        this.idprofesor = idprofesor;
    }

    public Collection<Titulos> getTitulosCollection() {
        return titulosCollection;
    }

    public void setTitulosCollection(Collection<Titulos> titulosCollection) {
        this.titulosCollection = titulosCollection;
    }

    public Collection<Foroprofesor> getForoprofesorCollection() {
        return foroprofesorCollection;
    }

    public void setForoprofesorCollection(Collection<Foroprofesor> foroprofesorCollection) {
        this.foroprofesorCollection = foroprofesorCollection;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Collection<Chatprofesor> getChatprofesorCollection() {
        return chatprofesorCollection;
    }

    public void setChatprofesorCollection(Collection<Chatprofesor> chatprofesorCollection) {
        this.chatprofesorCollection = chatprofesorCollection;
    }

    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofesor != null ? idprofesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idprofesor == null && other.idprofesor != null) || (this.idprofesor != null && !this.idprofesor.equals(other.idprofesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Profesor[ idprofesor=" + idprofesor + " ]";
    }
    
}

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

/**
 *
 * @author capur
 */
@Entity
@Table(name = "chatprofesor", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Chatprofesor.findAll", query = "SELECT c FROM Chatprofesor c"),
    @NamedQuery(name = "Chatprofesor.findByIdchatprofesor", query = "SELECT c FROM Chatprofesor c WHERE c.idchatprofesor = :idchatprofesor"),
    @NamedQuery(name = "Chatprofesor.findByMensaje", query = "SELECT c FROM Chatprofesor c WHERE c.mensaje = :mensaje"),
    @NamedQuery(name = "Chatprofesor.findByFecha", query = "SELECT c FROM Chatprofesor c WHERE c.fecha = :fecha")})
public class Chatprofesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchatprofesor")
    private Integer idchatprofesor;
    @Basic(optional = false)
    @Column(name = "mensaje")
    private String mensaje;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idchat", referencedColumnName = "idchat")
    @ManyToOne(optional = false)
    private Chat idchat;
    @JoinColumn(name = "idprofesor", referencedColumnName = "idprofesor")
    @ManyToOne(optional = false)
    private Profesor idprofesor;

    public Chatprofesor() {
    }

    public Chatprofesor(Integer idchatprofesor) {
        this.idchatprofesor = idchatprofesor;
    }

    public Chatprofesor(Integer idchatprofesor, String mensaje, Date fecha) {
        this.idchatprofesor = idchatprofesor;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public Integer getIdchatprofesor() {
        return idchatprofesor;
    }

    public void setIdchatprofesor(Integer idchatprofesor) {
        this.idchatprofesor = idchatprofesor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Chat getIdchat() {
        return idchat;
    }

    public void setIdchat(Chat idchat) {
        this.idchat = idchat;
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
        hash += (idchatprofesor != null ? idchatprofesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chatprofesor)) {
            return false;
        }
        Chatprofesor other = (Chatprofesor) object;
        if ((this.idchatprofesor == null && other.idchatprofesor != null) || (this.idchatprofesor != null && !this.idchatprofesor.equals(other.idchatprofesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Chatprofesor[ idchatprofesor=" + idchatprofesor + " ]";
    }
    
}

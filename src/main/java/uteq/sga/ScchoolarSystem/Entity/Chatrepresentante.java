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
@Table(name = "chatrepresentante", catalog = "GA", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Chatrepresentante.findAll", query = "SELECT c FROM Chatrepresentante c"),
    @NamedQuery(name = "Chatrepresentante.findByIdchatrepresentante", query = "SELECT c FROM Chatrepresentante c WHERE c.idchatrepresentante = :idchatrepresentante"),
    @NamedQuery(name = "Chatrepresentante.findByMensaje", query = "SELECT c FROM Chatrepresentante c WHERE c.mensaje = :mensaje"),
    @NamedQuery(name = "Chatrepresentante.findByFecha", query = "SELECT c FROM Chatrepresentante c WHERE c.fecha = :fecha")})
public class Chatrepresentante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchatrepresentante")
    private Integer idchatrepresentante;
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
    @JoinColumn(name = "idrepresentante", referencedColumnName = "idrepresentante")
    @ManyToOne(optional = false)
    private Representante idrepresentante;

    public Chatrepresentante() {
    }

    public Chatrepresentante(Integer idchatrepresentante) {
        this.idchatrepresentante = idchatrepresentante;
    }

    public Chatrepresentante(Integer idchatrepresentante, String mensaje, Date fecha) {
        this.idchatrepresentante = idchatrepresentante;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public Integer getIdchatrepresentante() {
        return idchatrepresentante;
    }

    public void setIdchatrepresentante(Integer idchatrepresentante) {
        this.idchatrepresentante = idchatrepresentante;
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

    public Representante getIdrepresentante() {
        return idrepresentante;
    }

    public void setIdrepresentante(Representante idrepresentante) {
        this.idrepresentante = idrepresentante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchatrepresentante != null ? idchatrepresentante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chatrepresentante)) {
            return false;
        }
        Chatrepresentante other = (Chatrepresentante) object;
        if ((this.idchatrepresentante == null && other.idchatrepresentante != null) || (this.idchatrepresentante != null && !this.idchatrepresentante.equals(other.idchatrepresentante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Chatrepresentante[ idchatrepresentante=" + idchatrepresentante + " ]";
    }
    
}

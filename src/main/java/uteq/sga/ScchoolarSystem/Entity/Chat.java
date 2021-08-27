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
    @NamedQuery(name = "Chat.findAll", query = "SELECT c FROM Chat c"),
    @NamedQuery(name = "Chat.findByIdchat", query = "SELECT c FROM Chat c WHERE c.idchat = :idchat"),
    @NamedQuery(name = "Chat.findByNombrechat", query = "SELECT c FROM Chat c WHERE c.nombrechat = :nombrechat")})
public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idchat;
    @Basic(optional = false)
    private String nombrechat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idchat")
    private Collection<Chatrepresentante> chatrepresentanteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idchat")
    private Collection<Chatprofesor> chatprofesorCollection;

    public Chat() {
    }

    public Chat(Integer idchat) {
        this.idchat = idchat;
    }

    public Chat(Integer idchat, String nombrechat) {
        this.idchat = idchat;
        this.nombrechat = nombrechat;
    }

    public Integer getIdchat() {
        return idchat;
    }

    public void setIdchat(Integer idchat) {
        this.idchat = idchat;
    }

    public String getNombrechat() {
        return nombrechat;
    }

    public void setNombrechat(String nombrechat) {
        this.nombrechat = nombrechat;
    }

    @XmlTransient
    public Collection<Chatrepresentante> getChatrepresentanteCollection() {
        return chatrepresentanteCollection;
    }

    public void setChatrepresentanteCollection(Collection<Chatrepresentante> chatrepresentanteCollection) {
        this.chatrepresentanteCollection = chatrepresentanteCollection;
    }

    @XmlTransient
    public Collection<Chatprofesor> getChatprofesorCollection() {
        return chatprofesorCollection;
    }

    public void setChatprofesorCollection(Collection<Chatprofesor> chatprofesorCollection) {
        this.chatprofesorCollection = chatprofesorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idchat != null ? idchat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.idchat == null && other.idchat != null) || (this.idchat != null && !this.idchat.equals(other.idchat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uteq.sga.ScchoolarSystem.Entity.Chat[ idchat=" + idchat + " ]";
    }
    
}

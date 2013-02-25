/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthurassuncao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Falcaoi3
 */
@Embeddable
public class AgendaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedico")
    private int idMedico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idExame")
    private int idExame;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPaciente")
    private int idPaciente;

    public AgendaPK() {
    }

    public AgendaPK(Date dataHora, int idMedico, int idExame, int idPaciente) {
        this.dataHora = dataHora;
        this.idMedico = idMedico;
        this.idExame = idExame;
        this.idPaciente = idPaciente;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdExame() {
        return idExame;
    }

    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataHora != null ? dataHora.hashCode() : 0);
        hash += (int) idMedico;
        hash += (int) idExame;
        hash += (int) idPaciente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgendaPK)) {
            return false;
        }
        AgendaPK other = (AgendaPK) object;
        if ((this.dataHora == null && other.dataHora != null) || (this.dataHora != null && !this.dataHora.equals(other.dataHora))) {
            return false;
        }
        if (this.idMedico != other.idMedico) {
            return false;
        }
        if (this.idExame != other.idExame) {
            return false;
        }
        if (this.idPaciente != other.idPaciente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arthurassuncao.model.AgendaPK[ dataHora=" + dataHora + ", idMedico=" + idMedico + ", idExame=" + idExame + ", idPaciente=" + idPaciente + " ]";
    }
    
}

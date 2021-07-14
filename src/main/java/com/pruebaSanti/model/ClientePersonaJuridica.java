package com.pruebaSanti.model;

import javax.persistence.*;
import java.util.Date;
@Entity
public class ClientePersonaJuridica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String razonSocial;
    @Column
    private String tipoDocumento;
    @Column
    private String numeroDocumento;
    @Column
    private String rut;
    @Column
    private String fechaFundacion;

    public ClientePersonaJuridica() {
    }

    public ClientePersonaJuridica(Long id, String razonSocial, String tipoDocumento, String numeroDocumento, String rut, String fechaFundacion) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.rut = rut;
        this.fechaFundacion = fechaFundacion;
    }

    public String getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(String fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }


}

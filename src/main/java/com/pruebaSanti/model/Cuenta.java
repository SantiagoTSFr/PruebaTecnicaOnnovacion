package com.pruebaSanti.model;

import javax.persistence.*;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numeroCuenta;
    @Column
    private String moneda;
    @Column
    private double saldo;
    @Column
    private boolean PersonaNatural;

    public Cuenta() {
    }

    public Cuenta(Long numeroCuenta, String moneda, double saldo, boolean personaNatural) {
        this.numeroCuenta = numeroCuenta;
        this.moneda = moneda;
        this.saldo = saldo;
        PersonaNatural = personaNatural;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isPersonaNatural() {
        return PersonaNatural;
    }

    public void setPersonaNatural(boolean personaNatural) {
        PersonaNatural = personaNatural;
    }
}

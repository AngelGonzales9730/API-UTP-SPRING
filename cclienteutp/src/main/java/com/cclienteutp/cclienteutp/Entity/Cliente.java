package com.cclienteutp.cclienteutp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Cliente {

    @Id
    private Integer idcliente;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private Double saldo;

    public Cliente(){}

    //Listar
    public Cliente(Integer idcliente, String nombre, String apellido, String email, String telefono, Double saldo) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }

    //Insertar

    public Cliente(String nombre, String apellido, String email, String telefono, Double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }
}

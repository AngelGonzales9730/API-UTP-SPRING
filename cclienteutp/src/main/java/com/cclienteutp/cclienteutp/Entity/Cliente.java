package com.cclienteutp.cclienteutp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Cliente {

    @Id
    private Integer id_cliente;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private Double saldo;

    public Cliente(){}

    //Listar
    public Cliente(Integer id_cliente, String nombre, String apellido, String email, String telefono, Double saldo) {
        this.id_cliente = id_cliente;
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

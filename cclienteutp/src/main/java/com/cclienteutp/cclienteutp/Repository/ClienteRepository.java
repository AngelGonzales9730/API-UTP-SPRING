package com.cclienteutp.cclienteutp.Repository;

import com.cclienteutp.cclienteutp.DTO.responseDTO;
import com.cclienteutp.cclienteutp.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value="{CALL ListarClientes()}", nativeQuery = true)
    List<Cliente> ListarClientes();

    @Query(value = "{CALL BuscarClienteTXT(:_Texto)}", nativeQuery = true)
    List<Cliente> BuscarClienteTXT(
            @Param("_Texto") String busqueda
    );
    @Query(value = "{CALL InsertarCliente(:_Nombre,:_Apellido,:_Email,:_Telefono,:_Saldo)}", nativeQuery = true)
    responseDTO InsertarCliente(
        @Param("_Nombre") String nombre,
        @Param("_Apellido") String apellido,
        @Param("_Email") String email,
        @Param("_Telefono") String telefono,
        @Param("_Saldo") double saldo
    );

    @Query(value = "{CALL EliminarCliente(:_Idcliente)}", nativeQuery = true)
    responseDTO EliminarCliente(
            @Param("_Idcliente") Integer idcliente
    );

    @Query(value = "{CALL BuscarCliente(:_Idcliente)}", nativeQuery = true)
    List<Cliente>  BuscarCliente(
            @Param("_Idcliente") Integer busqueda
    );

    @Query(value = "{CALL ActualizarCliente(:_Idcliente,:_Nombre,:_Apellido,:_Email,:_Telefono,:_Saldo)}", nativeQuery = true)
    responseDTO ActualizarCliente(
            @Param("_Idcliente") Integer idcliente,
            @Param("_Nombre") String nombre,
            @Param("_Apellido") String apellido,
            @Param("_Email") String email,
            @Param("_Telefono") String telefono,
            @Param("_Saldo") double saldo
    );
}

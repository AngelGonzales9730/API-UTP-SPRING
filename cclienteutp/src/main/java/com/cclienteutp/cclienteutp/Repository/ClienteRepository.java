package com.cclienteutp.cclienteutp.Repository;

import com.cclienteutp.cclienteutp.DTO.responseDTO;
import com.cclienteutp.cclienteutp.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value="{CALL SP_ListarCliente()}", nativeQuery = true)
    List<Cliente> ListarCliente();

    @Query(value = "{CALL SP_BuscarClienteText(:_Texto)}", nativeQuery = true)
    List<Cliente> BuscarClienteTXT(
            @Param("_Texto") String busqueda
    );
    @Query(value = "{CALL SP_InsertarCliente(:_Nombre,:_Apellido,:_Email,:_Telefono,:_Saldo)}", nativeQuery = true)
    responseDTO InsertarCliente(
        @Param("_Nombre") String nombre,
        @Param("_Apellido") String apellido,
        @Param("_Email") String email,
        @Param("_Telefono") String telefono,
        @Param("_Saldo") double saldo
    );

    @Query(value = "{CALL SP_EliminarCliente(:_IDCliente)}", nativeQuery = true)
    responseDTO EliminarCliente(
            @Param("_IDCliente") String eliminar
    );

    @Query(value = "{CALL SP_ActualizarCliente(:_IDCliente,:_Nombre,:_Apellido,:_Email,:_Telefono,:_Saldo)}",nativeQuery = true)
    responseDTO ActualizarCliente(
            @Param("_IDCliente") int id_cliente,
            @Param("_Nombre") String nombre,
            @Param("_Apellido") String apellido,
            @Param("_Email") String email,
            @Param("_Telefono") String telefono,
            @Param("_Saldo") double saldo
    );


}

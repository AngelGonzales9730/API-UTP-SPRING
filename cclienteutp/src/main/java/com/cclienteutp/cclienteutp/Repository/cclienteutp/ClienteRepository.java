package com.cclienteutp.cclienteutp.Repository.cclienteutp;

import com.cclienteutp.cclienteutp.DTO.ResponseDTO;
import com.cclienteutp.cclienteutp.Entity.Cliente;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value="{CALL SP_ListarCliente()}", nativeQuery = true)
    List<Cliente> ListarCliente();

    //Parametros de entrada de mi BD
    @Query(value="{CALL SP_BuscarClienteText(:_Texto)}", nativeQuery = true)
    List<Cliente> BuscarClienteText(
            @Param("_Texto") String busqueda
    );

    @Query(value="{CALL SP_InsertarCliente(:_Nombre,:_Apellido,:_Email,:_Telefono,:_Saldo)}", nativeQuery = true)
    ResponseDTO InsertarCliente(
            @Param("_Nombre") String nombre,
            @Param("_Apellido") String apellido,
            @Param("_Email") String email,
            @Param("_Telefono") String telefono,
            @Param("_Saldo") Double saldo

    );

    @Query(value="{CALL SP_EliminarCliente(:_IdCliente)}", nativeQuery = true)
    ResponseDTO EliminarCliente(
            @Param("_IdCliente") int id_cliente
            /*@Param("_IdCliente") String eliminar*/
    );

}

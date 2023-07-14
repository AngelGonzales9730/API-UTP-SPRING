package com.cclienteutp.cclienteutp.Service;

import com.cclienteutp.cclienteutp.DTO.ResponseDTO;
import com.cclienteutp.cclienteutp.Entity.Cliente;
import com.cclienteutp.cclienteutp.Repository.cclienteutp.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService {
    //PARA QUE EXISTA UNA CONEXION ENTRE MI CONTROLLER Y REPOSITORY
    //primero el autowired
    @Autowired

    private ClienteRepository clienteRepository;


    public List<Cliente> ListarCliente()
    {

        return  clienteRepository.ListarCliente();
    }

    public List<Cliente> BuscarClienteText(String texto)
    {
        return  clienteRepository.BuscarClienteText(texto);

    }

    public ResponseDTO InsertarCliente(Cliente cliente)
    {
        return  clienteRepository.InsertarCliente(cliente.getNombre(), cliente.getApellido(), cliente.getEmail(), cliente.getTelefono(), cliente.getSaldo());
    }

    public ResponseDTO EliminarCliente(int IdCliente)
    {
        return  clienteRepository.EliminarCliente(IdCliente);

    }

}

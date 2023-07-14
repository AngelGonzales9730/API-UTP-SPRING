package com.cclienteutp.cclienteutp.Controller;

import com.cclienteutp.cclienteutp.DTO.ResponseDTO;
import com.cclienteutp.cclienteutp.Entity.Cliente;
import com.cclienteutp.cclienteutp.Service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/APIUTP")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/Saludo")
    public String Saludo(){
        return "Hola desde mi API";
    }

    @GetMapping("/ListarCliente")
    public ResponseEntity<List<Cliente>> ListarCliente(){
        List<Cliente> lista = clienteService.ListarCliente();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/BuscarClienteText")
    public ResponseEntity<List<Cliente>> BuscarClienteText(@RequestParam("texto") String texto){
        return new ResponseEntity<>(clienteService.BuscarClienteText(texto), HttpStatus.OK);
    }

    @PostMapping("/InsertarCliente")
    public ResponseDTO InsertarCliente(@RequestBody Cliente cliente){
        return clienteService.InsertarCliente(cliente);
    }

    @PostMapping("/EliminarCliente")
    public ResponseDTO EliminarCliente(@RequestParam("idCliente") int idCliente){
        return clienteService.EliminarCliente(idCliente);
    }

    @PostMapping("/ActualizarCliente")
    public ResponseDTO ActualizarCliente(@RequestBody Cliente cliente){
        return clienteService.ActualizarCliente(cliente);
    }

    @PostMapping("/BuscarClienteID")
    public Cliente BuscarClienteID(@RequestParam("idCliente") int idCliente){
        return clienteService.BuscarClienteId(idCliente);
    }
}

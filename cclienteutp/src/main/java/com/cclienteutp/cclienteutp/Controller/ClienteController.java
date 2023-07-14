package com.cclienteutp.cclienteutp.Controller;

import com.cclienteutp.cclienteutp.DTO.responseDTO;
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

    @PostMapping("/BuscarClienteTXT")
    public ResponseEntity<List<Cliente>> BuscarClienteTXT(@RequestParam("texto") String texto){
        return new ResponseEntity<>(clienteService.BuscarClienteTXT(texto), HttpStatus.OK);
    }
    @PostMapping("/InsertarCliente")
    public responseDTO InsertarCliente(@RequestBody Cliente cliente){
        return clienteService.InsertarCliente(cliente);
    }

    @PostMapping("/ElminarCliente")
    public responseDTO EliminarCliente(@RequestParam ("idcliente") String idcliente){
        return clienteService.EliminarCliente(idcliente);
    }
}

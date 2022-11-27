package br.com.dio.store.controller;

import br.com.dio.store.entity.Pedido;
import br.com.dio.store.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @PostMapping("/save")
    public ResponseEntity<Pedido> save(@RequestBody Pedido pedido){
        LocalDateTime DataAtual = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        pedido.setDataPedido(DataAtual);
        return ResponseEntity.ok().body(service.save(pedido));
    }

    @GetMapping("/busca-pedidos")
    public List<Pedido> PedidosAll(){
        return service.findAll();
    }

    @GetMapping("/pedidosId/{id}")
    public ResponseEntity<Pedido> PedidosId(@PathVariable Long id){
        Pedido pedido = service.findById(id);
        return ResponseEntity.ok().body(pedido);
    }
}


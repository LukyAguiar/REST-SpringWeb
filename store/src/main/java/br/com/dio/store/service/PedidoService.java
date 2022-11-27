package br.com.dio.store.service;

import br.com.dio.store.entity.Pedido;
import br.com.dio.store.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido save(@RequestBody Pedido pedido){
       return repository.save(pedido);
    }

    public List<Pedido> findAll(){
        return repository.findAll();
    }

    public Pedido findById(Long id){
        return repository.findById(id).orElse(null);
    }
}

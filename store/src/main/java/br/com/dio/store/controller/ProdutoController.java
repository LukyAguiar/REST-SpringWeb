package br.com.dio.store.controller;

import br.com.dio.store.entity.Produto;
import br.com.dio.store.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping(value="/produtos")
    public List<Produto> buscaProduto(){
        return service.findAll();
    }

    @GetMapping(value = "/produtoId/{id}")
    public ResponseEntity<Produto> buscaProdutoId(@PathVariable Long id){
        Produto produto = service.findById(id);
      return ResponseEntity.ok().body(produto);
    }

    @PostMapping(value= "/save")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto){
        return  ResponseEntity.ok().body(service.save(produto));
    }


}

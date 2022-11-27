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

    @GetMapping(value = "/produtoId")
    public List<Produto> buscaProdutoId(@PathVariable Long id){
        return (List<Produto>) service.findById(id);
    }

    @PostMapping(value= "/save")
    public ResponseEntity<Produto> salvaProduto(Produto produto){
        produto = service.save(produto);
        return  ResponseEntity.ok().body(produto);
    }


}

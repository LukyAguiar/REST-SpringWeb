package br.com.dio.store.controller;

import br.com.dio.store.entity.Produto;
import br.com.dio.store.exception.ProductIdNullException;
import br.com.dio.store.exception.ProductNullException;
import br.com.dio.store.exception.ProductPriceException;
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

    @GetMapping(value="/busca-todos")
    public List<Produto> buscaProduto(){
        return service.findAll();
    }

    @GetMapping(value = "/produtoId/{id}")
    public ResponseEntity<Produto> buscaProdutoId(@PathVariable Long id){
        Produto produto = service.findById(id);
        if(produto == null){
            throw new ProductIdNullException();
        }
      return ResponseEntity.ok().body(produto);
    }

    @PostMapping(value= "/save")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) throws Exception{
        if(produto.getNome() == null || produto.getPreco() == null)
            throw new ProductNullException();
        if(produto.getPreco() < 0)
            throw new ProductPriceException();
        return  ResponseEntity.ok().body(service.save(produto));
    }


}

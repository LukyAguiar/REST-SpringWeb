package br.com.dio.store;


import br.com.dio.store.entity.Produto;
import br.com.dio.store.service.ProdutoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProdutoTest {

    private ProdutoService service;

    @Test
    public void testeFalse(){

        Produto produto = new Produto();
        Produto produto1 = new Produto();
        produto.setId(1L);
        produto.setNome("Batata");
        produto.setDescricao("Batatas");
        produto.setPreco(80.1);
        produto1.setId(1L);
        produto1.setNome("Batata");
        produto1.setDescricao("Batatas");
        produto1.setPreco(80.1);
        assertEquals(produto.getNome(),produto1.getNome());
    }
}

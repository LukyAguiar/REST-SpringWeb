package br.com.dio.store;


import br.com.dio.store.entity.Produto;
import br.com.dio.store.exception.ProductPriceException;
import br.com.dio.store.repository.ProdutoRepository;
import br.com.dio.store.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class ProdutTestSpring {

    @Autowired
    private ProdutoService produtoService;


    @Test
    public void verificaValorNegativoNoProduto(){
        Produto produto = new Produto();

        produto.setNome("Teste");
        produto.setPreco(10.0);
        produto.setDescricao("Pão");
        assertThrows(ProductPriceException.class, () -> produtoService.save(produto));
    }

    @Test
    public void verificaValorNoProduto(){
        Produto produto = new Produto();

        produto.setNome("Teste");
        produto.setPreco(10.0);
        produto.setDescricao("Pão");

        produtoService.save(produto);
    }
}

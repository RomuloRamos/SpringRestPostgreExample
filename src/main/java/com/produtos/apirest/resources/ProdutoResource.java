package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.cache.annotation.CacheEvict;
// import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class ProdutoResource {
    
    @Autowired
    ProdutoRepository produtoRepository;


    @GetMapping("/produtos")
    // @Cacheable("produtos")
    public List<Produto> listaProdutos(){
        System.out.println("Called listaProdutos route");
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    // @Cacheable("produtos")
    public Produto listaProdutos_ById(@PathVariable(value = "id") long id){
        System.out.println("Called listaProdutos_ById route");
        return produtoRepository.findById(id);
    }

    @PostMapping("/produtos")
    public Produto salvaProduto(@RequestBody Produto produto){
        System.out.println("Called salvaProduto route");
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produtos")
    public void deleteProduto(@RequestBody Produto produto){
        System.out.println("Called deleteProduto route");
        produtoRepository.delete(produto);

    }

    @PutMapping("/produtos")
    public Produto updateProduto(@RequestBody Produto produto){
        System.out.println("Called updateProduto route");
        return produtoRepository.save(produto);
    }

    // @GetMapping("produtos/clear-cache")
    // @CacheEvict("produtos*")
    // public void clearCache(){
    //     System.out.println("Called clearCache route");
    //     return;
    // }
}

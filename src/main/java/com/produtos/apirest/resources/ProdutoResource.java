package com.produtos.apirest.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
public class ProdutoResource {
    
    @Autowired
    ProdutoRepository produtoRepository;

    @ApiOperation(value = "Retorna uma lista de produtos")
    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @ApiOperation(value = "Retorna um produto de acordo com o Id passado")
    @GetMapping("/produtos/{id}")
    public Produto listaProdutos_ById(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);
    }

    @ApiOperation(value = "Salva um novo produto no banco")
    @PostMapping("/produtos")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @ApiOperation(value = "Deleta o produto passado como parâmetro")
    @DeleteMapping("/produtos")
    public void deleteProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);

    }

    @ApiOperation(value = "Atualiza o produto passado como parâmetro")
    @PutMapping("/produtos")
    public Produto updateProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}

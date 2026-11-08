package lojinha.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lojinha.model.Produtos;
import lojinha.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produtos> listarTodos() {
        return produtoRepository.findAll();
    }

    public void cadastrar(Produtos produto) {

        if (produto.getnomeProduto().isBlank() || produto.getnomeProduto().length() >= 100) {
            return;
        }

        if (produto.getquantidade() < 0) {
            return;
        }

        if (produto.getvalorCompra() < 0 || produto.getvalorVenda() < 0) {
            return;
        }

        produtoRepository.save(produto);
    }
}

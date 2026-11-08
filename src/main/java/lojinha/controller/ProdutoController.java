package lojinha.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lojinha.model.Produtos;
import lojinha.service.ProdutoService;

@RestController
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos")
    public List<Produtos> listar() {
        return produtoService.listarTodos();
    }

    @PostMapping("/produtos")
    public ResponseEntity<Void> cadastrar(
            @RequestParam("nomeProduto") String nomeProduto,
            @RequestParam("quantidade") int quantidade,
            @RequestParam("valorVenda") String valorVenda,
            @RequestParam("valorCompra") String valorCompra) {

        double venda = converterValor(valorVenda);
        double compra = converterValor(valorCompra);

        produtoService.cadastrar(new Produtos(nomeProduto, quantidade, venda, compra));

        return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/").build();
    }

    private double converterValor(String valor) {
        return Double.parseDouble(valor.trim().replace(",", "."));
    }

    @GetMapping(
            value = "/produtos/lista",
            produces = "text/html;charset=UTF-8"
    )
    public String lista() throws IOException {

        ClassPathResource arquivo = new ClassPathResource("templates/produtos.html");

        String html = StreamUtils.copyToString(
                arquivo.getInputStream(),
                StandardCharsets.UTF_8
        );

        List<Produtos> produtos = produtoService.listarTodos();

        String lista = "";

        if (produtos.isEmpty()) {

            lista += "<p>Nenhum Produto cadastrado.</p>";

        } else {

            lista += "<ul>";

            for (Produtos produto : produtos) {

                lista += "<li>";
                lista += produto.getnomeProduto();
                lista += " - Qtd: ";
                lista += produto.getquantidade();
                lista += " - Venda: R$ ";
                lista += produto.getvalorVenda();
                lista += " - Compra: R$ ";
                lista += produto.getvalorCompra();
                lista += "</li>";
            }

            lista += "</ul>";
        }

        return html.replace("{{PRODUTOS}}", lista);
    }
}

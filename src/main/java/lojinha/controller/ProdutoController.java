package lojinha.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lojinha.model.Produtos;

@RestController
public class ProdutoController {

    private ArrayList<Produtos> produtos = new ArrayList<>();
    @GetMapping("/produtos")
    public String listarAlunos() {

        String html = "<h1>Produtos cadastrados</h1>";

        for (Produtos produtos : produtos) {
            html += "<p>";
            html += produtos.getnomeProduto() + " - ";
            html += produtos.getquantidade();
            html += produtos.getvalorVenda();
            html += "</p>";
        }

        return html;
    }
    
@PostMapping("/produtos")
public String cadastrar(
        @RequestParam("nomeProduto") String nomeProduto,
        @RequestParam("quantidade") int quantidade,
        @RequestParam("valorVenda") String valorVenda,
        @RequestParam("valorCompra") String valorCompra) {

    double venda = converterValor(valorVenda);
    double compra = converterValor(valorCompra);

    produtos.add(new Produtos(nomeProduto, quantidade, venda, compra));

    return "Produto salvo";
}

private double converterValor(String valor) {
    return Double.parseDouble(valor.trim().replace(",", "."));
}
    @GetMapping("/produtos/lista")
    public String lista() {

        String html = """
                <!DOCTYPE html>
                <html lang="pt-BR">

                <head>
                    <meta charset="UTF-8">
                    <title>Produtos cadastrados</title>
                    <link rel="stylesheet" href="/style.css">
                </head>

                <body>

                    <main class="container">

                        <h1>Produtos cadastrados</h1>

                        <div class="card">

                """;

        if (produtos.isEmpty()) {

            html += """
                        <p>Nenhum Produto cadastrado.</p>
                    """;

        } else {

            html += "<ul>";

            for (Produtos produtos : produtos) {

                html += "<li>";
                html += produtos.getnomeProduto();
                html += " - ";
                html += produtos.getquantidade();
                html += " - ";
                html += produtos.getvalorVenda();
                html += " - ";
                html += produtos.getvalorCompra();
                html += "</li>";
            }

            html += "</ul>";
        }

        html += """
                        </div>

                        <a href="/">
                            Voltar para cadastro
                        </a>

                    </main>

                </body>

                </html>
                """;

        return html;
    }
}

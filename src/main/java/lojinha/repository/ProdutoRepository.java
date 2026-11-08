package lojinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lojinha.model.Produtos;

public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
}

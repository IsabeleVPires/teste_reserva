package br.com.bookly.sistema_reserva.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.bookly.sistema_reserva.entity.Livro;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    // Buscar todos os livros disponíveis
    List<Livro> findByDisponivelTrue();
}

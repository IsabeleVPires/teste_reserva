package br.com.bookly.sistema_reserva.service;

import br.com.bookly.sistema_reserva.repository.LivroRepository;
import br.com.bookly.sistema_reserva.entity.Livro;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro salvarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id).orElse(null);
    }
}
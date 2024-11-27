package br.com.bookly.sistema_reserva.controller;

import br.com.bookly.sistema_reserva.entity.Livro;
import br.com.bookly.sistema_reserva.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/")
    public String home() {
        return "index"; // Página inicial
    }

    @GetMapping("/pesquisar")
    public String pesquisarLivrosDisponiveis(Model model) {
        model.addAttribute("livros", livroRepository.findByDisponivelTrue());
        return "pesquisar"; // Tela de livros disponíveis
    }

    @GetMapping("/reservar/{id}")
    public String reservarLivro(@PathVariable Long id, Model model) {
        Optional<Livro> livroOpt = livroRepository.findById(id);
        if (livroOpt.isPresent()) {
            model.addAttribute("livro", livroOpt.get());
            return "reservar"; // Tela para reservar livro
        }
        return "livroNaoEncontrado"; // Caso o livro não seja encontrado
    }

    @PostMapping("/reservar/{id}")
    public String concluirReserva(@PathVariable Long id) {
        Optional<Livro> livroOpt = livroRepository.findById(id);
        if (livroOpt.isPresent()) {
            Livro livro = livroOpt.get();
            livro.setDisponivel(false); // Marca o livro como reservado
            livroRepository.save(livro);
            return "agradecimento"; // Página de agradecimento
        }
        return "livroNaoEncontrado"; // Caso o livro não seja encontrado
    }
}

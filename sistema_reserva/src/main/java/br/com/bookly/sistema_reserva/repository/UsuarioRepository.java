package br.com.bookly.sistema_reserva.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.bookly.sistema_reserva.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}

package br.com.bookly.sistema_reserva.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.bookly.sistema_reserva.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {}
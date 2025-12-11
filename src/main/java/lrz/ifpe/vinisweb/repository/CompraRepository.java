package lrz.ifpe.vinisweb.repository;

import lrz.ifpe.vinisweb.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findByClienteId(Long clienteId);
    List<Compra> findByClienteCpf(String cpf);
    
    @Query("SELECT COUNT(c) > 0 FROM Compra c JOIN c.itens i WHERE i.vinil.id = :vinilId")
    boolean existsByItensVinilId(Long vinilId);
}


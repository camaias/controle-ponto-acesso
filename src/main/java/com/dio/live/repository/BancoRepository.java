package com.dio.live.repository;

        import com.dio.live.model.BancoHoras;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepository extends JpaRepository<BancoHoras, Long> {
}

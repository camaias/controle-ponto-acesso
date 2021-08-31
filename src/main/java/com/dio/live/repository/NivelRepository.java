package com.dio.live.repository;

import com.dio.live.model.NivelAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelRepository extends JpaRepository<NivelAcesso, Long> {
}

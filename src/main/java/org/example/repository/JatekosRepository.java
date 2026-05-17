package org.example.repository;

import org.example.model.Jatekos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JatekosRepository extends JpaRepository<Jatekos, Long> {
}

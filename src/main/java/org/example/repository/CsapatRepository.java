package org.example.repository;

import org.example.model.Csapat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsapatRepository extends JpaRepository<Csapat, Long> {
}
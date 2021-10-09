package com.example.mandatory_1.Repository;

import com.example.mandatory_1.Model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoRepository extends JpaRepository<Crypto,Long> {
}

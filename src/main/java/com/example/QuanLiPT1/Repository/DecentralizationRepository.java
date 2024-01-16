package com.example.QuanLiPT1.Repository;

import com.example.QuanLiPT1.Entity.Decentralization;
import com.example.QuanLiPT1.Enum.QuyenHanEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface DecentralizationRepository extends JpaRepository<Decentralization, Integer> {
    @Query(value = "SELECT * FROM phanquyen WHERE tenquyenhan = :name", nativeQuery = true)
    Optional<Decentralization> findByAuthorityName(@Param("name") String name);
}

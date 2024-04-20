package dev.alexsoft.figueroayuler.repository;

import dev.alexsoft.figueroayuler.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {

    @Modifying
    @Query("UPDATE EmpresaEntity e SET e.estado = :estado, e.usuaDelet = :usua_delet, e.dateDelet = CURRENT_TIMESTAMP WHERE e.id = :id")
    void softDelete(@Param("id") Long id, @Param("estado") Integer estado,  @Param("usua_delet") String usua_delet);


    @Query("SELECT e FROM EmpresaEntity e WHERE e.estado = 1 order by e.id desc")
    List<EmpresaEntity> findAllNotDeleted();

    @Query("SELECT e FROM EmpresaEntity e WHERE e.id = :id AND e.estado = 1")
    Optional<EmpresaEntity> findByIdNotDeleted(@Param("id") Long id);
}

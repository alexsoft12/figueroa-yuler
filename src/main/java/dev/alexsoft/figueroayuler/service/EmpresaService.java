package dev.alexsoft.figueroayuler.service;

import dev.alexsoft.figueroayuler.constants.Constants;
import dev.alexsoft.figueroayuler.dto.EmpresaDto;
import dev.alexsoft.figueroayuler.entity.EmpresaEntity;
import dev.alexsoft.figueroayuler.repository.EmpresaRepository;
import dev.alexsoft.figueroayuler.request.EmpresaRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@AllArgsConstructor

public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    private Timestamp getActualTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    //CRUD methods
    public EmpresaDto save(EmpresaRequest empresaRequest) {
        EmpresaEntity empresaEntity = new EmpresaEntity();
        empresaEntity.setRazonSocial(empresaRequest.getRazonSocial());
        empresaEntity.setTipoDocumento(empresaRequest.getTipoDocumento());
        empresaEntity.setNumeroDocumento(empresaRequest.getNumeroDocumento());
        empresaEntity.setCondicion(empresaRequest.getCondicion());
        empresaEntity.setDireccion(empresaRequest.getDireccion());
        empresaEntity.setDistrito(empresaRequest.getDistrito());
        empresaEntity.setProvincia(empresaRequest.getProvincia());
        empresaEntity.setDepartamento(empresaRequest.getDepartamento());
        empresaEntity.setEsAgenteRetencion(empresaRequest.getEsAgenteRetencion());
        empresaEntity.setUsuaCrea(Constants.USU_ADMIN);
        empresaEntity.setEstado(Constants.STATUS_ACTIVE);
        empresaEntity.setDateCreate(getActualTimestamp());
        return EmpresaDto.fromEntity(empresaRepository.save(empresaEntity));
    }

    public EmpresaDto update(Long id, EmpresaRequest empresaRequest) {

        EmpresaEntity empresaEntity = empresaRepository.findByIdNotDeleted(id).orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        empresaEntity.setRazonSocial(empresaRequest.getRazonSocial());
        empresaEntity.setTipoDocumento(empresaRequest.getTipoDocumento());
        empresaEntity.setNumeroDocumento(empresaRequest.getNumeroDocumento());
        empresaEntity.setCondicion(empresaRequest.getCondicion());
        empresaEntity.setDireccion(empresaRequest.getDireccion());
        empresaEntity.setDistrito(empresaRequest.getDistrito());
        empresaEntity.setProvincia(empresaRequest.getProvincia());
        empresaEntity.setDepartamento(empresaRequest.getDepartamento());
        empresaEntity.setEsAgenteRetencion(empresaRequest.getEsAgenteRetencion());
        empresaEntity.setUsuaModif(Constants.USU_MANAGER);
        empresaEntity.setDateModif(getActualTimestamp());
        return EmpresaDto.fromEntity(empresaRepository.save(empresaEntity));
    }

    @Transactional
    public void delete(Long id) {
        EmpresaEntity empresaEntity = empresaRepository.findByIdNotDeleted(id).orElseThrow(() -> new RuntimeException("Empresa no encontrada"));
        empresaRepository.softDelete(empresaEntity.getId(), Constants.STATUS_INACTIVE, Constants.USU_ADMIN);
    }

    public EmpresaDto findById(Long id) {
        return EmpresaDto.fromEntity(empresaRepository.findById(id).orElseThrow(() -> new RuntimeException("Empresa no encontrada")));
    }

    public List<EmpresaDto> findAll() {
        return EmpresaDto.fromListEntity(empresaRepository.findAllNotDeleted());
    }

}

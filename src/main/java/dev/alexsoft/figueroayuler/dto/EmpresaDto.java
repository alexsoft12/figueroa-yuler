package dev.alexsoft.figueroayuler.dto;

import dev.alexsoft.figueroayuler.entity.EmpresaEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class EmpresaDto {
    private Long id;
    private String razonSocial;
    private String tipoDocumento;
    private String numeroDocumento;
    private String condicion;
    private String direccion;
    private String distrito;
    private String provincia;
    private String departamento;
    private Boolean esAgenteRetencion;
    private Integer estado;
    private String usuaCrea;
    private Timestamp dateCreate;
    private String usuaModif;
    private Timestamp dateModif;
    private String usuaDelet;
    private Timestamp dateDelet;

    public static EmpresaDto fromEntity(EmpresaEntity empresa){
        EmpresaDto dto = new EmpresaDto();
        dto.setId(empresa.getId());
        dto.setRazonSocial(empresa.getRazonSocial());
        dto.setTipoDocumento(empresa.getTipoDocumento());
        dto.setNumeroDocumento(empresa.getNumeroDocumento());
        dto.setCondicion(empresa.getCondicion());
        dto.setDireccion(empresa.getDireccion());
        dto.setDistrito(empresa.getDistrito());
        dto.setProvincia(empresa.getProvincia());
        dto.setDepartamento(empresa.getDepartamento());
        dto.setEsAgenteRetencion(empresa.getEsAgenteRetencion());
        dto.setEstado(empresa.getEstado());
        dto.setUsuaCrea(empresa.getUsuaCrea());
        dto.setDateCreate(empresa.getDateCreate());
        dto.setUsuaModif(empresa.getUsuaModif());
        dto.setDateModif(empresa.getDateModif());
        dto.setUsuaDelet(empresa.getUsuaDelet());
        dto.setDateDelet(empresa.getDateDelet());
        return dto;
    }
    public static List<EmpresaDto> fromListEntity(List<EmpresaEntity> empresas){
        return empresas.stream().map(EmpresaDto::fromEntity).toList();
    }
}

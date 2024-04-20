package dev.alexsoft.figueroayuler.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "empresa")
@Getter
@Setter
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "razon_social", nullable = false)
    private String razonSocial;
    @Column(name = "tipo_documento", nullable = false, length = 1)
    private String tipoDocumento;
    @Column(name = "numero_documento", nullable = false, length = 11)
    private String numeroDocumento;
    @Column(name = "condicion", nullable = false, length = 11)
    private String condicion;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "distrito", nullable = false)
    private String distrito;
    @Column(name = "provincia", nullable = false)
    private String provincia;
    @Column(name = "departamento", nullable = false)
    private String departamento;
    @Column(name = "es_agente_retencion")
    private Boolean esAgenteRetencion;
    @Column(name = "estado", nullable = false, length = 1)
    private Integer estado;
    @Column(name = "usua_crea", length = 50)
    private String usuaCrea;
    @Column(name = "date_create")
    private Timestamp dateCreate;
    @Column(name = "usua_modif", length = 50)
    private String usuaModif;
    @Column(name = "date_modif")
    private Timestamp dateModif;
    @Column(name = "usua_delet", length = 50)
    private String usuaDelet;
    @Column(name = "date_delet")
    private Timestamp dateDelet;
}

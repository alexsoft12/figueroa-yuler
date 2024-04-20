package dev.alexsoft.figueroayuler.controller;

import dev.alexsoft.figueroayuler.dto.EmpresaDto;
import dev.alexsoft.figueroayuler.request.EmpresaRequest;
import dev.alexsoft.figueroayuler.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/empresas")
@AllArgsConstructor
@Tag(name = "Api de Empresa", description = "Esta api te permite gestionar las empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping
    @Operation(
            summary = "Crear Empresa",
            description = "Crea una empresa"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP STATUS 200 significa registro exitoso"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP STATUS 500 significa que hubo un error en el servidor"
            )
    })
    public ResponseEntity<EmpresaDto> create(@RequestBody EmpresaRequest empresaRequest) {
        return ResponseEntity.ok(empresaService.save(empresaRequest));
    }

    @GetMapping
    @Operation(
            summary = "Obtener todas las empresas",
            description = "Obtiene todas las empresas"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP STATUS 200 significa que se obtuvieron todas las empresas"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP STATUS 500 significa que hubo un error en el servidor"
            )
    })
    public ResponseEntity<List<EmpresaDto>> getAll() {
        return ResponseEntity.ok(empresaService.findAll());
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar Empresa",
            description = "Actualiza una empresa"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP STATUS 200 significa actualización exitosa"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP STATUS 404 significa que no se encontraron empresas"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP STATUS 500 significa que hubo un error en el servidor"
            )
    })
    public ResponseEntity<EmpresaDto> update(@PathVariable Long id, @RequestBody EmpresaRequest empresaRequest) {
        try {
            return ResponseEntity.ok(empresaService.update(id, empresaRequest));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar Empresa",
            description = "Elimina una empresa"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "HTTP STATUS 204 significa eliminación exitosa"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP STATUS 404 significa que no se encontraron empresas"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP STATUS 500 significa que hubo un error en el servidor"
            )
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            empresaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Obtener Empresa",
            description = "Obtiene una empresa"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP STATUS 200 significa que se obtuvo la empresa"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "HTTP STATUS 404 significa que no se encontró la empresa"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP STATUS 500 significa que hubo un error en el servidor"
            )
    })
    public ResponseEntity<EmpresaDto> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(empresaService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}

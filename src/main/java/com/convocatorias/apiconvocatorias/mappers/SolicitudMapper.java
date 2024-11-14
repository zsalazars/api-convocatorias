package com.convocatorias.apiconvocatorias.mappers;


import com.convocatorias.apiconvocatorias.dto.SolicitudDTO;
import com.convocatorias.apiconvocatorias.models.Solicitud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SolicitudMapper {
    private final CargoMapper cargoMapper;
    private final DependenciaMapper dependenciaMapper;

    public SolicitudDTO convertToDTO(Solicitud solicitud) {
        SolicitudDTO solicitudDTO = new SolicitudDTO();

        solicitudDTO.setId(solicitud.getId());
        solicitudDTO.setNombreDocumento(solicitud.getNombreDocumento());
        solicitudDTO.setProveido(solicitud.getProveido());
        solicitudDTO.setFechaSolicitud(solicitud.getFechaSolicitud());
        solicitudDTO.setEstado(solicitud.getEstado());
        solicitudDTO.setDependencia(dependenciaMapper.convertToDTO(solicitud.getDependencia()));
        solicitudDTO.setCargo(cargoMapper.convertToDTO(solicitud.getCargo()));
        return solicitudDTO;
    }

    public Solicitud convertToEntity(SolicitudDTO solicitudDTO) {
        Solicitud solicitud = new Solicitud();

        solicitud.setId(solicitudDTO.getId());
        solicitud.setNombreDocumento(solicitudDTO.getNombreDocumento());
        solicitud.setProveido(solicitudDTO.getProveido());
        solicitud.setFechaSolicitud(solicitudDTO.getFechaSolicitud());
        solicitud.setEstado(solicitudDTO.getEstado());
        solicitud.setCargo(cargoMapper.convertToEntity(solicitudDTO.getCargo()));
        solicitud.setDependencia(dependenciaMapper.convertToEntity(solicitudDTO.getDependencia()));
        return solicitud;
    }
}

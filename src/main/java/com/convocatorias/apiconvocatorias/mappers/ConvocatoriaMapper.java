package com.convocatorias.apiconvocatorias.mappers;

import com.convocatorias.apiconvocatorias.dto.ConvocatoriaDTO;
import com.convocatorias.apiconvocatorias.models.Convocatoria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConvocatoriaMapper {
    private final SolicitudMapper solicitudMapper;

    public ConvocatoriaDTO convertToDTO(Convocatoria convocatoria) {
        ConvocatoriaDTO convocatoriaDTO = new ConvocatoriaDTO();
        convocatoriaDTO.setId(convocatoria.getId());
        convocatoriaDTO.setNumeroConvocatoria(convocatoria.getNumeroConvocatoria());
        convocatoriaDTO.setTipoConvocatoria(convocatoria.getTipoConvocatoria());
        convocatoriaDTO.setTipoRegion(convocatoria.getTipoRegion());
        convocatoriaDTO.setFechaPublicacion(convocatoria.getFechaPublicacion());
        convocatoriaDTO.setFechaEnvioDocumentos(convocatoria.getFechaEnvioDocumentos());
        convocatoriaDTO.setFechaCalificacionDocumentos(convocatoria.getFechaCalificacionDocumentos());
        convocatoriaDTO.setFechaPublicacionAptos(convocatoria.getFechaPublicacionAptos());
        convocatoriaDTO.setFechaHorariosEntrevistas(convocatoria.getFechaHorariosEntrevistas());
        convocatoriaDTO.setFechaEntrevistaPersonal(convocatoria.getFechaEntrevistaPersonal());
        convocatoriaDTO.setFechaPublicacionResultados(convocatoria.getFechaPublicacionResultados());
        convocatoriaDTO.setFechaInicioFunciones(convocatoria.getFechaInicioFunciones());
        convocatoriaDTO.setEstado(convocatoria.getEstado());
        convocatoriaDTO.setSolicitud(solicitudMapper.convertToDTO(convocatoria.getSolicitud()));
        return convocatoriaDTO;
    }

    public Convocatoria convertToEntity(ConvocatoriaDTO convocatoriaDTO) {
        Convocatoria convocatoria = new Convocatoria();
        convocatoria.setId(convocatoriaDTO.getId());
        convocatoria.setNumeroConvocatoria(convocatoriaDTO.getNumeroConvocatoria());
        convocatoria.setTipoConvocatoria(convocatoriaDTO.getTipoConvocatoria());
        convocatoria.setTipoRegion(convocatoriaDTO.getTipoRegion());
        convocatoria.setFechaPublicacion(convocatoriaDTO.getFechaPublicacion());
        convocatoria.setFechaEnvioDocumentos(convocatoriaDTO.getFechaEnvioDocumentos());
        convocatoria.setFechaCalificacionDocumentos(convocatoriaDTO.getFechaCalificacionDocumentos());
        convocatoria.setFechaPublicacionAptos(convocatoriaDTO.getFechaPublicacionAptos());
        convocatoria.setFechaHorariosEntrevistas(convocatoriaDTO.getFechaHorariosEntrevistas());
        convocatoria.setFechaEntrevistaPersonal(convocatoriaDTO.getFechaEntrevistaPersonal());
        convocatoria.setFechaPublicacionResultados(convocatoriaDTO.getFechaPublicacionResultados());
        convocatoria.setFechaInicioFunciones(convocatoriaDTO.getFechaInicioFunciones());
        convocatoria.setEstado(convocatoriaDTO.getEstado());
        convocatoria.setSolicitud(solicitudMapper.convertToEntity(convocatoriaDTO.getSolicitud()));
        return convocatoria;
    }
}

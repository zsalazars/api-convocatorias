package com.convocatorias.apiconvocatorias.mappers;

import com.convocatorias.apiconvocatorias.dto.CalificacionDocumentosDTO;
import com.convocatorias.apiconvocatorias.models.CalificacionDocumentos;
import org.springframework.stereotype.Component;

@Component
public class CalificacionDocumentosMapper {
    public CalificacionDocumentosDTO convertToDTO(CalificacionDocumentos calificacionDocumentos) {
        CalificacionDocumentosDTO calificacionDocumentosDTO = new CalificacionDocumentosDTO();

        calificacionDocumentosDTO.setId(calificacionDocumentos.getId());
        calificacionDocumentosDTO.setDatosGenerales(calificacionDocumentos.getDatosGenerales());
        calificacionDocumentosDTO.setTitulosCertificados(calificacionDocumentos.getTitulosCertificados());
        calificacionDocumentosDTO.setReporteSunedu(calificacionDocumentos.getReporteSunedu());
        calificacionDocumentosDTO.setCursosEspecializacion(calificacionDocumentos.getCursosEspecializacion());
        calificacionDocumentosDTO.setExperienciaLaboral(calificacionDocumentos.getExperienciaLaboral());
        calificacionDocumentosDTO.setDeclaracionJuradaHorario(calificacionDocumentos.getDeclaracionJuradaHorario());
        calificacionDocumentosDTO.setDeclaracionJuradaParentesco(calificacionDocumentos.getDeclaracionJuradaParentesco());
        calificacionDocumentosDTO.setDeclaracionJuradaAntecedentes(calificacionDocumentos.getDeclaracionJuradaAntecedentes());
        calificacionDocumentosDTO.setCertiadulto(calificacionDocumentos.getCertiadulto());
        calificacionDocumentosDTO.setCarnetVacunacion(calificacionDocumentos.getCarnetVacunacion());
        calificacionDocumentosDTO.setVoucherPago(calificacionDocumentos.getVoucherPago());
        calificacionDocumentosDTO.setObservaciones(calificacionDocumentos.getObservaciones());

        return calificacionDocumentosDTO;
    }

    public CalificacionDocumentos convertToEntity(CalificacionDocumentosDTO calificacionDocumentosDTO) {
        CalificacionDocumentos calificacionDocumentos = new CalificacionDocumentos();

        calificacionDocumentos.setId(calificacionDocumentosDTO.getId());
        calificacionDocumentos.setDatosGenerales(calificacionDocumentosDTO.getDatosGenerales());
        calificacionDocumentos.setTitulosCertificados(calificacionDocumentosDTO.getTitulosCertificados());
        calificacionDocumentos.setReporteSunedu(calificacionDocumentosDTO.getReporteSunedu());
        calificacionDocumentos.setCursosEspecializacion(calificacionDocumentosDTO.getCursosEspecializacion());
        calificacionDocumentos.setExperienciaLaboral(calificacionDocumentosDTO.getExperienciaLaboral());
        calificacionDocumentos.setDeclaracionJuradaHorario(calificacionDocumentosDTO.getDeclaracionJuradaHorario());
        calificacionDocumentos.setDeclaracionJuradaParentesco(calificacionDocumentosDTO.getDeclaracionJuradaParentesco());
        calificacionDocumentos.setDeclaracionJuradaAntecedentes(calificacionDocumentosDTO.getDeclaracionJuradaAntecedentes());
        calificacionDocumentos.setCertiadulto(calificacionDocumentosDTO.getCertiadulto());
        calificacionDocumentos.setCarnetVacunacion(calificacionDocumentosDTO.getCarnetVacunacion());
        calificacionDocumentos.setVoucherPago(calificacionDocumentosDTO.getVoucherPago());
        calificacionDocumentos.setObservaciones(calificacionDocumentosDTO.getObservaciones());

        return calificacionDocumentos;
    }
}

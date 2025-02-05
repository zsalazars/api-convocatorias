package com.convocatorias.apiconvocatorias.mappers;

import com.convocatorias.apiconvocatorias.dto.PostulacionDTO;
import com.convocatorias.apiconvocatorias.models.Postulacion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostulacionMapper {
    private final ConvocatoriaMapper convocatoriaMapper;
    private final CalificacionDocumentosMapper calificacionDocumentosMapper;
    private final CalificacionRequisitosMapper calificacionRequisitosMapper;

    public PostulacionDTO convertToDTO(Postulacion postulacion) {
        PostulacionDTO postulacionDTO = new PostulacionDTO();

        postulacionDTO.setId(postulacion.getId());
        postulacionDTO.setNombres(postulacion.getNombres());
        postulacionDTO.setApellidoPaterno(postulacion.getApellidoPaterno());
        postulacionDTO.setApellidoMaterno(postulacion.getApellidoMaterno());
        postulacionDTO.setNumeroCelular(postulacion.getNumeroCelular());
        postulacionDTO.setCorreoElectronico(postulacion.getCorreoElectronico());
        postulacionDTO.setDocumentoRuta(postulacion.getDocumentoRuta());
        postulacionDTO.setObservaciones(postulacion.getObservaciones());
        postulacionDTO.setPuntuacion(postulacion.getPuntuacion());
        postulacionDTO.setEsApto(postulacion.isEsApto());
        postulacionDTO.setConvocatoria(convocatoriaMapper.convertToDTO(postulacion.getConvocatoria()));
        /*
        postulacionDTO.setCalificacionDocumentos(calificacionDocumentosMapper.convertToDTO(postulacion.getCalificacionDocumentos()));
        postulacionDTO.setCalificacionRequisitos(calificacionRequisitosMapper.convertToDTO(postulacion.getCalificacionRequisitos()));
        */

        if (postulacion.getCalificacionDocumentos() != null) {
            postulacionDTO.setCalificacionDocumentos(calificacionDocumentosMapper.convertToDTO(postulacion.getCalificacionDocumentos()));
        }

        if (postulacion.getCalificacionRequisitos() != null) {
            postulacionDTO.setCalificacionRequisitos(calificacionRequisitosMapper.convertToDTO(postulacion.getCalificacionRequisitos()));
        }

        return postulacionDTO;
    }

    public Postulacion convertToEntity(PostulacionDTO postulacionDTO) {
        Postulacion postulacion = new Postulacion();

        postulacion.setId(postulacionDTO.getId());
        postulacion.setNombres(postulacionDTO.getNombres());
        postulacion.setApellidoPaterno(postulacionDTO.getApellidoPaterno());
        postulacion.setApellidoMaterno(postulacionDTO.getApellidoMaterno());
        postulacion.setNumeroCelular(postulacionDTO.getNumeroCelular());
        postulacion.setCorreoElectronico(postulacionDTO.getCorreoElectronico());
        postulacion.setDocumentoRuta(postulacionDTO.getDocumentoRuta());
        postulacion.setObservaciones(postulacionDTO.getObservaciones());
        postulacion.setPuntuacion(postulacionDTO.getPuntuacion());
        postulacion.setEsApto(postulacionDTO.isEsApto());
        postulacion.setConvocatoria(convocatoriaMapper.convertToEntity(postulacionDTO.getConvocatoria()));

        if (postulacionDTO.getCalificacionDocumentos() != null) {
            postulacion.setCalificacionDocumentos(calificacionDocumentosMapper.convertToEntity(postulacionDTO.getCalificacionDocumentos()));
        }

        if (postulacionDTO.getCalificacionRequisitos() != null) {
            postulacion.setCalificacionRequisitos(calificacionRequisitosMapper.convertToEntity(postulacionDTO.getCalificacionRequisitos()));
        }

        return postulacion;
    }
}

package com.convocatorias.apiconvocatorias.services.impl;

import com.convocatorias.apiconvocatorias.dto.PostulacionDTO;
import com.convocatorias.apiconvocatorias.mappers.CalificacionDocumentosMapper;
import com.convocatorias.apiconvocatorias.mappers.CalificacionRequisitosMapper;
import com.convocatorias.apiconvocatorias.mappers.PostulacionMapper;
import com.convocatorias.apiconvocatorias.models.*;
import com.convocatorias.apiconvocatorias.repositories.*;
import com.convocatorias.apiconvocatorias.services.PostulacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.DocumentFilter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostulacionServiceImpl implements PostulacionService {

    private final PostulacionRepository postulacionRepository;
    private final ConvocatoriaRepository convocatoriaRepository;
    private final CargoRepository cargoRepository;
    private final CalificacionDocumentosRepository calificacionDocumentosRepository;
    private final CalificacionRequisitosRepository calificacionRequisitosRepository;

    private final PostulacionMapper postulacionMapper;
    private final CalificacionDocumentosMapper calificacionDocumentosMapper;
    private final CalificacionRequisitosMapper calificacionRequisitosMapper;

    private final FileStorageService fileStorageService;

    @Override
    public List<PostulacionDTO> getAllPostulaciones() {
        return postulacionRepository.findAll().stream()
                .map(postulacionMapper::convertToDTO)
                .toList();
    }

    @Override
    public PostulacionDTO getPostulacionById(Long id) {
        Postulacion postulacion = postulacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Postulacion no encontrado"));
        return postulacionMapper.convertToDTO(postulacion);
    }

    @Override
    public PostulacionDTO createPostulacion(PostulacionDTO postulacionDTO) {
        // Recuperar la convocatoria existente
        Convocatoria convocatoria = convocatoriaRepository.findById(postulacionDTO.getConvocatoria().getId())
                .orElseThrow(() -> new RuntimeException("Convocatoria no encontrada"));

        Cargo cargo = cargoRepository.findById(postulacionDTO.getConvocatoria().getSolicitud().getCargo().getId())
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado"));

        // Convertir DTO a entidad
        Postulacion postulacion = postulacionMapper.convertToEntity(postulacionDTO);
        postulacion.setConvocatoria(convocatoria);

        if (postulacion.getCalificacionDocumentos() == null) {
            postulacion.setCalificacionDocumentos(new CalificacionDocumentos());
        }

        if (postulacion.getCalificacionRequisitos() == null) {
            CalificacionRequisitos calificacionRequisitos = new CalificacionRequisitos();

            // Asignar los requisitos no cumplidos desde el cargo
            calificacionRequisitos.setRequisitosEstudiosNoCumplidos(cargo.getRequisitosEstudios());
            calificacionRequisitos.setRequisitosExperienciaNoCumplidos(cargo.getRequisitosExperiencia());

            postulacion.setCalificacionRequisitos(calificacionRequisitos);
        }

        // Manejar el documento si existe
        MultipartFile documento = postulacionDTO.getDocumento();
        if (documento != null && !documento.isEmpty()) {
            String fileName = fileStorageService.storeFile(documento);
            postulacion.setDocumentoRuta(fileName);
        }

        // Guardar la postulacion
        Postulacion savedPostulacion = postulacionRepository.save(postulacion);
        return postulacionMapper.convertToDTO(savedPostulacion);
    }

    @Override
    public PostulacionDTO updatePostulacion(Long id, PostulacionDTO postulacionDTO) {
        Postulacion postulacion = postulacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Postulacion no encontrada"));

        // Actualizar campos básicos
        postulacion.setNombres(postulacionDTO.getNombres());
        postulacion.setApellidoPaterno(postulacionDTO.getApellidoPaterno());
        postulacion.setApellidoMaterno(postulacionDTO.getApellidoMaterno());
        postulacion.setNumeroCelular(postulacionDTO.getNumeroCelular());
        postulacion.setCorreoElectronico(postulacionDTO.getCorreoElectronico());
        postulacion.setObservaciones(postulacionDTO.getObservaciones());
        postulacion.setEsApto(postulacionDTO.isEsApto());

        // Actualizar la convocatoria si se proporciona
        if (postulacionDTO.getConvocatoria() != null) {
            Convocatoria convocatoria = convocatoriaRepository.findById(postulacionDTO.getConvocatoria().getId())
                    .orElseThrow(() -> new RuntimeException("Convocatoria no encontrada"));
            postulacion.setConvocatoria(convocatoria);
        }

        // Actualizar calificacionDocumentos si se proporciona
        if (postulacionDTO.getCalificacionDocumentos() != null) {
            CalificacionDocumentos calificacionDocumentos = calificacionDocumentosMapper.convertToEntity(postulacionDTO.getCalificacionDocumentos());
            postulacion.setCalificacionDocumentos(calificacionDocumentos);
        }

        // Actualizar calificacionDocumentos si se proporciona
        if (postulacionDTO.getCalificacionRequisitos() != null) {
            CalificacionRequisitos calificacionRequisitos = calificacionRequisitosMapper.convertToEntity(postulacionDTO.getCalificacionRequisitos());
            postulacion.setCalificacionRequisitos(calificacionRequisitos);
        }

        // Manejar el documento si existe
        MultipartFile documento = postulacionDTO.getDocumento();
        if (documento != null && !documento.isEmpty()) {
            String fileName = fileStorageService.storeFile(documento);
            postulacion.setDocumentoRuta(fileName);
        }

        // Guardar la postulación actualizada
        Postulacion updatedPostulacion = postulacionRepository.save(postulacion);

        // Devolver el DTO actualizado
        return postulacionMapper.convertToDTO(updatedPostulacion);
    }


    @Override
    public void deletePostulacion(Long id) { postulacionRepository.deleteById(id); }

    @Override
    public boolean existsById(Long id) { return postulacionRepository.existsById(id); }

    public List<PostulacionDTO> getPostulacionesByConvocatoria(Long convocatoriaId) {
        // Obtiene la lista de postulaciones de la convocatoria
        List<Postulacion> postulacions = postulacionRepository.findByConvocatoriaId(convocatoriaId);

        // Convierte cada postulacion a su DTO correspondiente
        return postulacions.stream()
                .map(postulacionMapper::convertToDTO)
                .toList();
    }
}

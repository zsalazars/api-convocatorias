package com.convocatorias.apiconvocatorias.services;

import com.convocatorias.apiconvocatorias.dto.PostulacionDTO;

import java.util.List;

public interface PostulacionService {
    List<PostulacionDTO> getAllPostulaciones();
    PostulacionDTO getPostulacionById(Long id);
    PostulacionDTO createPostulacion(PostulacionDTO postulacionDTO);
    PostulacionDTO updatePostulacion(Long id, PostulacionDTO postulacionDTO);
    void deletePostulacion(Long id);
    boolean existsById(Long id);
    List<PostulacionDTO> getPostulacionesByConvocatoria(Long convocatoriaId);
}

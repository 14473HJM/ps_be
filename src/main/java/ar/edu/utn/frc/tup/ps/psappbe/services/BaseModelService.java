package ar.edu.utn.frc.tup.ps.psappbe.services;

import java.util.List;

public interface BaseModelService<M, E> {

    M getById(Long id, Boolean includeDeletes);

    List<M> getAll(Boolean includeDeletes);

    M create(M model);

    List<M> createAll(List<M> modelList);

    M update(M model);

    void delete(M model);

    M createUpdateOrDelete(M model);
}

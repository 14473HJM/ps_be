package ar.edu.utn.frc.tup.ps.psappbe.services;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseModelServiceImpl<M, E> implements BaseModelService<M, E> {

    private final Class<M> modelClass;
    private final ParameterizedType modelParameterizedType;

    private final Class<E> entityClass;
    private final ParameterizedType entityParameterizedType;

    protected abstract JpaRepository<E, Long> getJpaRepository();

    protected abstract ModelMapper getModelMapper();

    protected BaseModelServiceImpl() {
        this.modelParameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        this.modelClass = (Class) modelParameterizedType.getActualTypeArguments()[0];
        this.entityParameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class) modelParameterizedType.getActualTypeArguments()[1    ];
    }

    @Override
    public M getById(Long id) {
        /**
         * I search by list because the method findById return duplicated information
         * if processing a unique primary element
         */
        List<E> list = getJpaRepository().findAllById(Arrays.asList(id));
        if(!list.isEmpty()) {
            return getModelMapper().map(list.get(0), modelClass);
        } else {
            throw new EntityNotFoundException(String.format("%s id %s not found", modelClass.getName(), id));
        }
    }

    @Override
    public List<M> getAll() {
        List<E> entityList = getJpaRepository().findAll();
        return entityList.stream()
                .map(entity -> getModelMapper().map(entity, modelClass))
                .collect(Collectors.toList());
    }

    @Override
    public M create(M model) {
        E entity = getModelMapper().map(model, entityClass);
        entity = getJpaRepository().save(entity);
        return getModelMapper().map(entity, modelClass);
    }

    @Override
    public List<M> createAll(List<M> modelList) {
        List<E> entityList = modelList.stream()
                .map(model -> getModelMapper().map(model, entityClass))
                .collect(Collectors.toList());
        entityList = getJpaRepository().saveAll(entityList);
        return entityList.stream()
                .map(entity -> getModelMapper().map(entity, modelClass))
                .collect(Collectors.toList());
    }


    @Override
    public M update(M model) {
        E entity = getModelMapper().map(model, entityClass);
        entity = getJpaRepository().save(entity);
        return getModelMapper().map(entity, modelClass);
    }
}

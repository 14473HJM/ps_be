package ar.edu.utn.frc.tup.ps.psappbe.services;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import ar.edu.utn.frc.tup.ps.psappbe.services.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseModelServiceImpl<M extends CommonFields, E extends CommonFieldsEntity> implements BaseModelService<M, E> {

    protected static final String DELETE = "DELETE";
    protected static final String UPDATE = "UPDATE";
    protected static final String INSERT = "INSERT";
    protected static final String DELETED_STATUS = "DELETED";

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
        E entity = setCommonFields(
                getModelMapper().map(model, entityClass), INSERT, model.getObjectTypeName()
        );
        entity = getJpaRepository().save(entity);
        return getModelMapper().map(entity, modelClass);
    }

    @Override
    public List<M> createAll(List<M> modelList) {
        String objectType = modelList.get(0).getObjectType();
        List<E> entityList = modelList.stream()
                .map(model -> getModelMapper().map(model, entityClass))
                .collect(Collectors.toList()).stream()
                .map(entity -> setCommonFields(entity, INSERT, objectType))
                .collect(Collectors.toList());
        entityList = getJpaRepository().saveAll(entityList);
        return entityList.stream()
                .map(entity -> getModelMapper().map(entity, modelClass))
                .collect(Collectors.toList());
    }


    @Override
    public M update(M model) {
        E entity = setCommonFields(
                getModelMapper().map(model, entityClass), UPDATE, model.getObjectTypeName()
        );
        entity = getJpaRepository().save(entity);
        return getModelMapper().map(entity, modelClass);
    }

    protected E setCommonFields(E entity, String operation, String objectType) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        LocalDateTime operationDateTime = LocalDateTime.now();
        switch (operation) {
            case INSERT:
                entity.setObjectType(objectType);
                entity.setCreatedUser(user);
                entity.setCreatedDate(operationDateTime);
                entity.setLastUpdatedUser(user);
                entity.setLastUpdatedDate(operationDateTime);
                break;
            case UPDATE:
                entity.setLastUpdatedUser(user);
                entity.setLastUpdatedDate(operationDateTime);
                break;
            case DELETE:
                entity.setDeletedUser(user);
                entity.setLastUpdatedDate(operationDateTime);
                entity.setLastUpdatedUser(user);
                entity.setLastUpdatedDate(operationDateTime);
                entity.setRecordStatus(DELETED_STATUS);
                break;
            default:
                break;
        }
        return entity;
    }

    protected List<M> mapList(List<E> entityList) {
        return entityList.stream()
                .map(entity -> getModelMapper().map(entity, modelClass))
                .collect(Collectors.toList());
    }

    protected M map(E entity) {
        return getModelMapper().map(entity, modelClass);
    }
}

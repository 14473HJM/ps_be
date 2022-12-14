package ar.edu.utn.frc.tup.ps.psappbe.services;

import ar.edu.utn.frc.tup.ps.psappbe.domain.common.CommonFields;
import ar.edu.utn.frc.tup.ps.psappbe.entities.common.CommonFieldsEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;

import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
    public M getById(Long id, Boolean includeDeletes) {
        /**
         * I search by list because the method findById return duplicated information
         * if processing a unique primary element
         */
        List<E> list = getJpaRepository().findAllById(Arrays.asList(id));
        if(!list.isEmpty()) {
            M modelObject = getModelMapper().map(list.get(0), modelClass);
            if(includeDeletes) {
                return modelObject;
            } else {
                if(modelObject.getRecordStatus() != DELETED_STATUS) {
                    return modelObject;
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
    }

    @Override
    public List<M> getAll(Boolean includeDeletes) {
        List<E> entityList = getJpaRepository().findAll();
        List<M> modelList = entityList.stream()
                .map(entity -> getModelMapper().map(entity, modelClass))
                .collect(Collectors.toList());
        if(includeDeletes) {
            return modelList;
        } else {
            return modelList.stream()
                    .filter(m -> m.getRecordStatus() == DELETED_STATUS)
                    .collect(Collectors.toList());
        }
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
        String objectType = modelList.get(0).getObjectTypeName();
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

    @Override
    public void delete(M model) {
        E entity = setCommonFields(
                getModelMapper().map(model, entityClass), DELETE, model.getObjectTypeName()
        );
        getJpaRepository().save(entity);
    }

    @Override
    public M createUpdateOrDelete(M model) {
        if(model != null) {
            M modelDB;
            if(model.getId() != null) {
                modelDB = getById(model.getId(), true);
                if(model.getRecordStatus() == DELETED_STATUS && modelDB.getRecordStatus() != DELETED_STATUS) {
                    delete(model);
                } else {
                    modelDB = update(model);
                }
            } else {
                modelDB = create(model);
            }
            return getById(modelDB.getId(), false);
        } else {
            return null;
        }
    }

    protected E setCommonFields(E entity, String operation, String objectType) {
        String user = "anonymousUser";
        try{
            user = SecurityContextHolder.getContext().getAuthentication().getName();
        } catch(Exception e) {
            log.warn("Error al obtener el nombre de usuario del contexto.", e);
        }
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
                entity.setDeletedDate(operationDateTime);
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

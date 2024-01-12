/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public abstract class AbstractMapper<E, D> implements Mapper<E, D> {

    @Autowired
    protected ModelMapper mapper;

    private Class<E> entityClass;
    private Class<D> dtoClass;

    protected AbstractMapper(Class<E> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }


    @Override
    public E toEntity(D dto) {
        return Objects.isNull(dto)
                ? null
                : mapper.map(dto, entityClass);
    }

    @Override
    public D toDto(E entity) {
        return Objects.isNull(entity)
                ? null
                : mapper.map(entity, dtoClass);
    }


    public Converter<E, D> toDtoConverter() {
        return context -> {
            E source = context.getSource();
            D destination = context.getDestination();
            mapSpecificFieldsEntityToDto(source, destination);
            return context.getDestination();
        };
    }

    public Converter<D, E> toEntityConverter() {
        return context -> {
            D source = context.getSource();
            E destination = context.getDestination();
            mapSpecificFieldsDtoToEntity(source, destination);
            return context.getDestination();
        };
    }

    void mapSpecificFieldsEntityToDto(E source, D destination) {
        System.out.println("Hey mapSpecificFieldsDtoToEntity");
    }

    void mapSpecificFieldsDtoToEntity(D source, E destination) {
        System.out.println("Hey mapSpecificFieldsDtoToEntity");
    }
}

/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 12.01.2024
 */

package org.crystal.qrserviceinventarization.database.dto;

import org.crystal.qrserviceinventarization.database.mapper.AbstractMapper;
import org.crystal.qrserviceinventarization.database.model.AbstractInventarizedEntity;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractInventarizedObjectMapper
        <E extends AbstractInventarizedEntity, D extends AbstractInventarizedDTO>
        extends AbstractMapper<E, D> {

    private final CabinetRepository cabinetRepository;

    @Autowired
    protected AbstractInventarizedObjectMapper(Class<E> entityClass, Class<D> dtoClass, CabinetRepository cabinetRepository) {
        super(entityClass, dtoClass);
        this.cabinetRepository = cabinetRepository;
    }


    @Override
    protected void mapSpecificFieldsEntityToDto(E source, D destination) {
        destination.setCabinetId(source.getCabinet().getId());
    }

    @Override
    protected void mapSpecificFieldsDtoToEntity(D source, E destination) {
        destination.setCabinet(
                cabinetRepository.findById(source.getCabinetId()).orElseThrow(
                        () -> new ResourceNotFoundException(STR."Cabinet with id = \{source.getCabinetId()} not found")));
    }

}

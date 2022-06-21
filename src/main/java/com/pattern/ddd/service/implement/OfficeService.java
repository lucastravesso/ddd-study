package com.pattern.ddd.service.implement;

import com.pattern.ddd.entity.Office;
import com.pattern.ddd.repository.OfficeRepository;
import com.pattern.ddd.service.OfficeServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class OfficeService implements OfficeServiceInterface {

    private OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository){
        this.officeRepository = officeRepository;
    }

    @Override
    public Office officeCreate(Office officeDTO) {
        officeDTO.setIsActive(true);
        officeRepository.saveAndFlush(officeDTO);

        return officeDTO;
    }

    @Override
    public Office officeUpdate(Office officeDTO) {
        officeRepository.saveAndFlush(officeDTO);

        return officeDTO;
    }

    @Override
    public Office officeDelete(Office officeDTO) {
        officeDTO.setIsActive(false);
        officeRepository.saveAndFlush(officeDTO);

        return officeDTO;
    }

    @Override
    public Office officeFindById(Office officeDTO) {
        return officeRepository.findById(officeDTO.getId()).get();
    }

    @Override
    public Page<Office> officeFindAll(Pageable pageable) {
        return officeRepository.findAll(pageable);
    }
}

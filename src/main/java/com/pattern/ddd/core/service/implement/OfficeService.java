package com.pattern.ddd.core.service.implement;

import com.pattern.ddd.core.entity.Office;
import com.pattern.ddd.core.repository.OfficeRepository;
import com.pattern.ddd.core.service.OfficeServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfficeService implements OfficeServiceInterface {

    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository){
        this.officeRepository = officeRepository;
    }

    @Override
    public Office officeCreate(Office office) {
        office.setIsActive(true);
        officeRepository.saveAndFlush(office);

        return office;
    }

    @Override
    public Office officeUpdate(Office office, Integer id) {
        officeRepository.saveAndFlush(office);
        return office;
    }

    @Override
    public Office officeDelete(Integer id) {
        Office office = officeRepository.findById(id).orElse(new Office());
        office.setIsActive(false);
        return officeRepository.saveAndFlush(office);
    }

    @Override
    public Office officeFindById(Integer officeId) {
        return officeRepository.findById(officeId).orElse(null);
    }

    @Override
    public Page<Office> officeFindAll(Pageable pageable) {
        return officeRepository.findAll(pageable);
    }
}

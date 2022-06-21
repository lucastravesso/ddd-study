package com.pattern.ddd.core.service.implement;

import com.pattern.ddd.core.entity.Office;
import com.pattern.ddd.core.repository.OfficeRepository;
import com.pattern.ddd.core.service.OfficeServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class OfficeService implements OfficeServiceInterface {

    private OfficeRepository officeRepository;

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
    public Office officeUpdate(Office office) {
        officeRepository.saveAndFlush(office);

        return office;
    }

    @Override
    public Office officeDelete(Office office) {
        office.setIsActive(false);
        officeRepository.saveAndFlush(office);

        return office;
    }

    @Override
    public Office officeFindById(Office office) {
        return officeRepository.findById(office.getId()).get();
    }

    @Override
    public Page<Office> officeFindAll(Pageable pageable) {
        return officeRepository.findAll(pageable);
    }
}

package com.pattern.ddd.core.service.implement;

import com.pattern.ddd.core.entity.Office;
import com.pattern.ddd.core.repository.OfficeRepository;
import com.pattern.ddd.core.service.OfficeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    public OfficeServiceImpl(OfficeRepository officeRepository){
        this.officeRepository = officeRepository;
    }

    @Override
    public Office officeCreate(Office office) {
        office.setIsActive(true);
        return officeRepository.saveAndFlush(office);
    }

    @Override
    public Office officeUpdate(Office office, Integer id) {
        Office optOffice = officeRepository.findById(id).orElse(null);
        if(optOffice != null){
            aplicarDiferencas(office, optOffice);
            return officeRepository.saveAndFlush(optOffice);
        }
        return null;
    }

    private void aplicarDiferencas(Office office, Office optOffice) {
        if(office.getIsActive() == null){optOffice.setIsActive(optOffice.getIsActive());}
        else{optOffice.setIsActive(office.getIsActive());}
        if(office.getOfficeName() == null){optOffice.setOfficeName(optOffice.getOfficeName());}
        else{optOffice.setOfficeName(office.getOfficeName());}
        if(office.getOfficeSalary() == null){optOffice.setOfficeSalary(optOffice.getOfficeSalary());}
        else{optOffice.setOfficeSalary(office.getOfficeSalary());}
    }

    @Override
    public Office officeDelete(Integer id) {
        Optional<Office> optOffice = officeRepository.findById(id);
        if(optOffice.isPresent()) {
            Office office = optOffice.get();
            office.setIsActive(!office.getIsActive());
            return officeRepository.saveAndFlush(office);
        }
        return null;
    }

    @Override
    public Office officeFindById(Integer officeId) {
        return officeRepository.findById(officeId).orElse(new Office());
    }

    @Override
    public Page<Office> officeFindAll(Pageable pageable) {
        return officeRepository.findAll(pageable);
    }
}

package com.pattern.ddd.inbound.facade.interfaces;

import com.pattern.ddd.inbound.facade.dto.OfficeDTO;
import com.pattern.ddd.inbound.facade.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserFacadeInterface {

    UserDTO create(UserDTO userDTO, OfficeDTO officeDTO);

    UserDTO update(UserDTO userDTO);

    UserDTO userDelete(UserDTO user);

    UserDTO userFindById(Integer userId);

    Page<UserDTO> userFindAll(Pageable pageable);

}

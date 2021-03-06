package com.pattern.ddd.inbound.facade.interfaces;

import com.pattern.ddd.inbound.facade.dto.OfficeDTO;
import com.pattern.ddd.inbound.facade.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserFacadeInterface {

    UserDTO create(UserDTO userDTO);

    UserDTO update(UserDTO userDTO, Integer id);

    UserDTO userDelete(Integer id);

    UserDTO userFindById(Integer userId);

    Page<UserDTO> userFindAll(Pageable pageable);

}

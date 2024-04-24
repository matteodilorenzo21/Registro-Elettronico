package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.entity.UserType;
import it.pi.registro.registro.repository.UserTypeRepository;
import it.pi.registro.registro.service.UserTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceTypeImpl implements UserTypeService {

    private UserTypeRepository userTypeRepository;


    @Override
    public UserType createUserType(UserType userType) {
        return userTypeRepository.save(userType);
    }

    @Override
    public UserType getUserTypeById(Long UserTypeId) {
        return null;
    }

    @Override
    public List<UserType> getAllUserTypes() {
        return userTypeRepository.findAll();
    }

    @Override
    public UserType updateUserType(UserType UserType) {
        return null;
    }

    @Override
    public void deleteUserType(Long UserTypeId) {

    }
}

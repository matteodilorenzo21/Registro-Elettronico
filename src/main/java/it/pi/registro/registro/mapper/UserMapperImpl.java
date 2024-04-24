package it.pi.registro.registro.mapper;

import it.pi.registro.registro.dto.UserDTO;
import it.pi.registro.registro.dto.UserSubjectDTO;
import it.pi.registro.registro.dto.response.UserDataResponseDTO;
import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserDetail;
import it.pi.registro.registro.entity.UserSubjects;

import java.util.ArrayList;

public class UserMapperImpl implements UserMapper{
    @Override
    public UserDTO toDTO(User user) {

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());

        UserDetail userDetail = new UserDetail();
        userDetail.setAddress(user.getUserDetail().getAddress());
        userDetail.setCity(user.getUserDetail().getCity());
        userDetail.setId(user.getUserDetail().getId());
        dto.setUserDetail(userDetail);

        return dto;
    }

    @Override
    public UserDataResponseDTO toDataResponseDTO(User user) {
        UserDataResponseDTO userDataResponseDTO =  new UserDataResponseDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUserDetail()!=null && user.getUserDetail().getAddress() != null ? user.getUserDetail().getAddress() : "NO ADDRESS",
                user.getUserDetail()!=null && user.getUserDetail().getCity() != null ? user.getUserDetail().getCity() : "NO CITY",
                user.getUserType()!=null && user.getUserType().getDescription()!=null ? user.getUserType().getDescription() : "NO DESCR",
                new ArrayList<>()
        );

        user.getUserSubjects()
                .forEach(userSubjects -> {
                    userDataResponseDTO
                            .getVotes()
                            .add(
                                    new UserSubjectDTO(
                                            userSubjects.getSubject().getName(),
                                            userSubjects.getSubject().getDescription(),
                                            userSubjects.getTeacher().getFirstName() + " " +
                                                    userSubjects.getTeacher().getLastName() + " " +
                                                    userSubjects.getTeacher().getEmail(),
                                            userSubjects.getVote(),
                                            userSubjects.getNotes(),
                                            userSubjects.getVote_date()
                                    )
                            );
        });



        return userDataResponseDTO;
    }
}

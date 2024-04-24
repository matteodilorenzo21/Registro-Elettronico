package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.dto.request.VoteAssignRequestDTO;
import it.pi.registro.registro.dto.response.VoteAssignResponseDTO;
import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserSubjects;
import it.pi.registro.registro.enums.UserSubjectEnum;
import it.pi.registro.registro.enums.UserTypeEnum;
import it.pi.registro.registro.repository.SubjectRepository;
import it.pi.registro.registro.repository.UserRepository;
import it.pi.registro.registro.repository.UserSubjectRepository;
import it.pi.registro.registro.service.VoteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class VoteServiceImpl implements VoteService {

        private UserRepository userRepository;
        private SubjectRepository subjectRepository;
        private UserSubjectRepository userSubjectRepository;

    @Override
    public VoteAssignResponseDTO assignVote(VoteAssignRequestDTO voteAssignRequestDTO) throws Exception {
        User student = userRepository.findByEmailAndType(
                voteAssignRequestDTO.getStudentEmail(),
                String.valueOf(UserTypeEnum.STUDENT)
        );

        User teacher = userRepository.findByEmailAndType(
                voteAssignRequestDTO.getTeacherEmail(),
                String.valueOf(UserTypeEnum.TEACHER)
        );

        Subject subject = subjectRepository.findByName(voteAssignRequestDTO.getSubjectName());

        if(student == null || teacher == null || subject == null) {
            throw new Exception("Student, teacher, or subject not found.");
        }

        UserSubjects userSubjects = new UserSubjects();

        userSubjects.setUser(student);
        userSubjects.setTeacher(teacher);
        userSubjects.setSubject(subject);
        userSubjects.setVote(voteAssignRequestDTO.getVote());
        userSubjects.setNotes(voteAssignRequestDTO.getNotes());
        userSubjects.setVote_date(LocalDateTime.now());
        userSubjectRepository.save(userSubjects);

        return new VoteAssignResponseDTO(
                String.valueOf(userSubjects.getVote()), userSubjects.getVote_date()
        );
    }
}

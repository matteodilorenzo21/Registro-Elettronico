package it.pi.registro.registro.controller;

import it.pi.registro.registro.dto.request.SubjectCreateRequestDTO;
import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.service.SubjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/subjects")
public class SubjectController {

    private SubjectService subjectService;

    /**
     * Create simple Subject
     */
    @PostMapping
    public ResponseEntity<Subject> createSubject(@Valid @RequestBody SubjectCreateRequestDTO subjectCreateDTO){
        return new ResponseEntity<>(subjectService.createSubject(subjectCreateDTO), HttpStatus.CREATED);

    }


}

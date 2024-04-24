package it.pi.registro.registro.controller;

import it.pi.registro.registro.dto.request.UserCreateRequestDTO;
import it.pi.registro.registro.dto.request.UserInfoRequestDTO;
import it.pi.registro.registro.dto.request.VoteAssignRequestDTO;
import it.pi.registro.registro.dto.response.UserDataResponseDTO;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.mapper.UserMapper;
import it.pi.registro.registro.service.UserService;
import it.pi.registro.registro.service.VoteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/votes")
public class VoteController {

    private VoteService voteService;

    @PostMapping
    public ResponseEntity<?> assignVote(@Valid @RequestBody VoteAssignRequestDTO voteAssignRequestDTO){
        try {
            return new ResponseEntity<>(voteService.assignVote(voteAssignRequestDTO), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}

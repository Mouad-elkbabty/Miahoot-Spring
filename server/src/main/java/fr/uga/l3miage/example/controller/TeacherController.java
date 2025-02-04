package fr.uga.l3miage.example.controller;

import fr.uga.l3miage.example.endpoint.TeacherEndpoint;
import fr.uga.l3miage.example.exception.technical.TeacherAlreadyExistsException;
import fr.uga.l3miage.example.request.CreateTeacherRequest;
import fr.uga.l3miage.example.response.MiahootDTO;
import fr.uga.l3miage.example.response.TeacherDTO;
import fr.uga.l3miage.example.service.ServiceTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherController implements TeacherEndpoint {
    private final ServiceTeacher serviceTeacher;
    @Override
    public TeacherDTO getTeacher(String id){return serviceTeacher.getTeacher(id);}
    @Override
    public TeacherDTO createTeacher(CreateTeacherRequest request) {
        try {
            return serviceTeacher.createTeacher(request);
        } catch (TeacherAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void deleteTeacher(String  id){serviceTeacher.deleteTeacher(id);}

    @Override
    public List<MiahootDTO> getMiahoots(String id){return serviceTeacher.getMiahoots(id);}
}

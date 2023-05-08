package fr.uga.l3miage.example.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TeacherDTO {
     Long id;
     // id de fireBase
     String fireBaseId ;
     String nom;
}
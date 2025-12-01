package com.transport.coop.mapper;

import com.transport.coop.entity.StudentEntity;
import com.transport.coop.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "id", source = "studentId")
    StudentEntity toEntity(Student dto);

    @Mapping(target = "studentId", source = "id")
    Student toDto(StudentEntity entity);

    void updateEntityFromDto(Student dto, @MappingTarget StudentEntity entity);
}

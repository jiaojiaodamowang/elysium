package com.kiddz.elysium.demo.service.impl;

import com.kiddz.elysium.demo.domain.Student;
import com.kiddz.elysium.demo.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public Student getStudent(int id) {
        Student student = new Student();
        student.setId(id);
        student.setName("student" + id);
        return student;
    }
}

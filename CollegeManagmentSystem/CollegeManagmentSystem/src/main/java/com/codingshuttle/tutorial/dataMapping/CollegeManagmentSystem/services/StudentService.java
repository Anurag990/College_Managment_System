package com.codingshuttle.tutorial.dataMapping.CollegeManagmentSystem.services;import com.codingshuttle.tutorial.dataMapping.CollegeManagmentSystem.entites.Student;import com.codingshuttle.tutorial.dataMapping.CollegeManagmentSystem.entites.Subject;import com.codingshuttle.tutorial.dataMapping.CollegeManagmentSystem.repositories.StudentRepo;import com.codingshuttle.tutorial.dataMapping.CollegeManagmentSystem.repositories.SubjectRepo;import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Service;import java.util.Optional;@Servicepublic class StudentService {    private final StudentRepo studentRepo;    private final SubjectRepo subjectRepo;    public  StudentService(StudentRepo studentRepo, SubjectRepo subjectRepo)    {        this.studentRepo = studentRepo;        this.subjectRepo = subjectRepo;    }    public Student createNewStudent(Student student) {        return studentRepo.save(student);    }    public Optional<Student> getStudentById(Long studentId) {        Optional<Student> RequiredStudent = studentRepo.findById(studentId);        return RequiredStudent;    }    public ResponseEntity<Student> assignSubjectToStudent(Long studentId, Long subjectId) {        Optional<Student>student = studentRepo.findById(studentId);        Optional<Subject> subject = subjectRepo.findById(subjectId);        if(student.isPresent() && subject.isPresent())        {            Student studentEntity = student.get();            Subject subjectEntity = subject.get();            studentEntity.getSubjects().add(subjectEntity);            subjectEntity.getStudent().add(studentEntity);            subjectRepo.save(subjectEntity);            Student UpdatedStudent = studentRepo.save(studentEntity);            return ResponseEntity.ok(UpdatedStudent);        }        else        {            return  ResponseEntity.notFound().build();        }    }}
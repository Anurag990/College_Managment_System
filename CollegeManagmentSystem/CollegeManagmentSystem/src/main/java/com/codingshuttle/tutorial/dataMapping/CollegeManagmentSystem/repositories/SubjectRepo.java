package com.codingshuttle.tutorial.dataMapping.CollegeManagmentSystem.repositories;import com.codingshuttle.tutorial.dataMapping.CollegeManagmentSystem.entites.Subject;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.stereotype.Repository;@Repositorypublic interface SubjectRepo extends JpaRepository<Subject,Long> {}
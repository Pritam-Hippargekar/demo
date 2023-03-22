package com.elastic.data.repository;

import com.elastic.data.domain.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends ElasticsearchRepository<Student, String> {
}

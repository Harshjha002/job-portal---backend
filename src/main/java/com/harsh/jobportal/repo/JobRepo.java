package com.harsh.jobportal.repo;

import com.harsh.jobportal.modal.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface JobRepo extends JpaRepository<JobPost , Integer> {

        List<JobPost> findByPostProfileContainingOrPostDescContaining(String keyword ,  String postDesc);

    }



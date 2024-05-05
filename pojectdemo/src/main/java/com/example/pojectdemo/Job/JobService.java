package com.example.pojectdemo.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<Job> findall();

     public void createjob(Job job);


     public boolean deleteidreq(Long id);

    boolean updatejob(Long id, Job updatejob);


     public Job getId(Long id);
}

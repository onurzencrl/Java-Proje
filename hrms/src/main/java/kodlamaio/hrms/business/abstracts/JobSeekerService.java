package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.results.DataResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekers;

import java.util.List;


public interface JobSeekerService {
    Result add(JobSeekers jobSeekers);
    public DataResult<List<JobSeekers>> findAll();
}

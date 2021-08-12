package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerCheckService;
import kodlamaio.hrms.core.results.ErrorResult;
import kodlamaio.hrms.core.results.Result;
import kodlamaio.hrms.core.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class JobSeekerCheckManager implements JobSeekerCheckService {

    private JobSeekerDao jobSeekerDao;



    @Autowired
    public JobSeekerCheckManager(JobSeekerDao jobSeekerDao) {
        super();
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public Result checkFirstName(JobSeekers jobSeeker) {
        if (jobSeeker.getFirstname().isEmpty()) {
            System.out.println("İsim alanı boş bırakılamaz.");
            return new ErrorResult();
        } else {
            if (jobSeeker.getFirstname().length() < 4) {
                System.out.println("İsim alanı 4 karakterden büyük olmalıdır.");
                return new ErrorResult();
            }
        }
        return new SuccessResult();
    }

    @Override
    public Result checkLastName(JobSeekers jobSeeker) {
        if (jobSeeker.getLastname().isEmpty()) {
            System.out.println("Soyisim alanı boş bırakılamaz.");
            return new ErrorResult();
        } else {
            if (jobSeeker.getLastname().length() < 4) {
                System.out.println("Soyisim alanı 4 karakterden büyük olmalıdır.");
                return new ErrorResult();
            }
        }
        return new SuccessResult();
    }

    @Override
    public Result checkNationalityId(JobSeekers jobSeeker) {
        if (jobSeeker.getTcno().isEmpty()) {
            System.out.println("Vatandaşlık kimlik numarası alanı boş bırakılamaz.");
            return new ErrorResult();
        } else {
            if (jobSeeker.getTcno().length() < 11 || jobSeeker.getTcno().length() > 11) {
                System.out.println("Vatandaşlık kimlik numarası 11 karakter olmalıdır.");
                return new ErrorResult();
            }
        }
        return new SuccessResult();
    }

    @Override
    public Result checkBirthYear(JobSeekers jobSeeker) {
        if (jobSeeker.getBirthdate() > 1930 && jobSeeker.getBirthdate() < 2021) {
            return new SuccessResult();
        } else {
            System.out.println("1930 - 2021 aralığında tarih giriniz.");
            return new ErrorResult();
        }

    }

    @Override
    public Result checkEmail(JobSeekers jobSeeker) {
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        if (jobSeeker.getEmail().isEmpty()) {
            System.out.println("Email alanı boş bırakılamaz.");
            return new ErrorResult();
        } else {
            if (pattern.matcher(jobSeeker.getEmail()).find() == false) {
                System.out.println("Girilen email adresi formata uygun değil. Örnek: ornek@ornek.com");
                return new ErrorResult();
            }
        }
        return new SuccessResult();
    }

    @Override
    public Result checkPassword(JobSeekers jobSeeker) {
        if (jobSeeker.getPassword().isEmpty()) {
            System.out.println("Soyisim alanı boş bırakılamaz.");
            return new ErrorResult();
        } else {
            if (jobSeeker.getPassword().length() < 6) {
                System.out.println("Parola 6 karakterden daha küçük olamaz.");
                return new ErrorResult();
            }
        }
        return new SuccessResult();
    }

    @Override
    public Result checkRepeatPassword(JobSeekers jobSeeker) {
        if (jobSeeker.getPasswordCheck().isEmpty()) {
            return new ErrorResult("Parola doğrulama alanı boş bırakılamaz.");
        } else {
            if (jobSeeker.getPassword() == jobSeeker.getPasswordCheck()) {
                return new ErrorResult("Girilen parolalar eşleşmiyor.");
            }
        }
        return new SuccessResult();
    }

    @Override
    public Result uniqueEmail(JobSeekers jobSeeker) {
        if (jobSeekerDao.findByEmail(jobSeeker.getEmail()) != null) {
            return new ErrorResult();
        }
        return new SuccessResult();
    }

    @Override
    public Result uniqueNationalityId(JobSeekers jobSeeker) {
        if (jobSeekerDao.findByEmail(jobSeeker.getTcno()) != null) {
            return new ErrorResult();
        }
        return new SuccessResult();
    }
}

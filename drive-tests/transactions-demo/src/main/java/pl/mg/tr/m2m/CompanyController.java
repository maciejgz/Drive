package pl.mg.tr.m2m;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mg.tr.user.service.UserException;
import pl.mg.tr.user.service.UsernameException;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
@Slf4j
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping(value = "")
    public ResponseEntity<Void> getCompany() throws UserException, UsernameException {
        try {
            List<Company> all = companyRepository.findAll();
            System.out.println(all.size());
            for (Company company : all) {
                company.getEmployees().forEach(employee -> System.out.println(employee.toString()));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return ResponseEntity.ok().build();
    }
}

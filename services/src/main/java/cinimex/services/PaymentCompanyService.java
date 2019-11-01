package cinimex.services;


import cinimex.DTO.CompanyDto;
import cinimex.DTO.PaymentCompanyDto;
import cinimex.JPArepository.CompanyRepository;
import cinimex.JPArepository.PaymentCompanyRepository;
import cinimex.mapper.CompanyMapper;
import cinimex.mapper.PaymentCompanyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentCompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final PaymentCompanyRepository paymentCompanyRepository;
    private final PaymentCompanyMapper paymentCompanyMapper;

    public List<CompanyDto> findAllCompany(){
        return companyMapper.toDto(companyRepository.findAll());
    }

    public List<PaymentCompanyDto> findAllPaymentOfCompany(Long idCompany){
        return paymentCompanyMapper.toDto(paymentCompanyRepository.findByCompanyId(idCompany));
    }

}

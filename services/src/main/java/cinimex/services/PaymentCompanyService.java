package cinimex.services;


import cinimex.DTO.CompanyDto;
import cinimex.DTO.PaymentCompanyDto;
import cinimex.DTO.PaymentDto;
import cinimex.DTO.PaymentUserDto;
import cinimex.JPArepository.CompanyRepository;
import cinimex.JPArepository.PaymentCompanyRepository;
import cinimex.JPArepository.PaymentUserRepository;
import cinimex.entity.PaymentUserEntity;
import cinimex.mapper.CompanyMapper;
import cinimex.mapper.PaymentCompanyMapper;
import cinimex.mapper.PaymentUserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentCompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final PaymentCompanyRepository paymentCompanyRepository;
    private final PaymentCompanyMapper paymentCompanyMapper;
    private final PaymentUserMapper paymentUserMapper;
    private final PaymentUserRepository paymentUserRepository;
    private final TransferService transferService;

    public List<CompanyDto> findAllCompany() {
        return companyMapper.toDto(companyRepository.findAll());
    }

    public List<PaymentCompanyDto> findAllPaymentOfCompany(Long idCompany) {
        return paymentCompanyMapper.toDto(paymentCompanyRepository.findByCompanyId(idCompany));
    }

    @Transactional
    public boolean paymentFromBalance(PaymentDto paymentDto) throws Exception {
        PaymentUserEntity paymentUserEntity = paymentUserMapper.fromDto(paymentDto.getPaymentUser());
        boolean isTransfered = transferService.transferBalanceToBalance(paymentDto.getTransfer());
        paymentUserEntity.setPaid(isTransfered);
        paymentUserRepository.save(paymentUserEntity);

        return isTransfered;
    }

    @Transactional
    public boolean paymentFromCard(PaymentDto paymentDto) throws Exception {
        PaymentUserEntity paymentUserEntity = paymentUserMapper.fromDto(paymentDto.getPaymentUser());
        boolean isTransfered = transferService.transferOnBalance(paymentDto.getTransfer());
        paymentUserEntity.setPaid(isTransfered);
        paymentUserRepository.save(paymentUserEntity);

        return isTransfered;
    }
}

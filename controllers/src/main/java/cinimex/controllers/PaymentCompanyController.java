package cinimex.controllers;


import cinimex.DTO.CompanyDto;
import cinimex.DTO.PaymentCompanyDto;
import cinimex.services.PaymentCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paymentCompany")
@AllArgsConstructor
public class PaymentCompanyController {
    private final PaymentCompanyService service;

    @GetMapping("allCompany")
    public List<CompanyDto> getAllCompany() {
        return service.findAllCompany();
    }

    @GetMapping("allPaymentOfCompany")
    public List<PaymentCompanyDto> getAllPaymentCompany(@RequestParam Long idCompany) {
        return service.findAllPaymentOfCompany(idCompany);
    }
}

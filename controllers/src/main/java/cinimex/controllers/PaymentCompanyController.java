package cinimex.controllers;


import cinimex.DTO.CompanyDto;
import cinimex.DTO.PaymentCompanyDto;
import cinimex.DTO.PaymentDto;
import cinimex.services.PaymentCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("fromBalance")
    public boolean addPaymentFromBalance(@RequestBody PaymentDto payment){
        return service.paymentFromBalance(payment);
    }
    @PostMapping("fromCard")
    public boolean addPaymentFromCard(@RequestBody PaymentDto payment){
        return service.paymentFromCard(payment);
    }
}

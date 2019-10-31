package cinimex.controllers;


import cinimex.DTO.TransferDto;
import cinimex.services.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer")
@AllArgsConstructor
public class TransferController {
    private final TransferService transferService;

    @PostMapping("/withdrawOnBalance")
    public Boolean withdrawOnBalance(@RequestBody TransferDto transfer) {
        return transferService.transferBalanceToBalance(transfer);
    }
    @PostMapping("/withdrawOnCard")
    public Boolean withdrawOnCard(@RequestBody TransferDto transfer) {
        return transferService.transferOnCard(transfer);
    }
    @PostMapping("/replenishOnBalance")
    public Boolean replenishOnBalance(@RequestBody TransferDto transfer) {
        return transferService.transferOnBalance(transfer);
    }

    @GetMapping("/journalOfUser")
    public List<TransferDto> journalOfUser(@RequestParam Long id) throws Exception {
        return transferService.allTransferAndJournalOfUser(id);
    }
}

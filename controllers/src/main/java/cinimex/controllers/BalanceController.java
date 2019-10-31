package cinimex.controllers;

import cinimex.DTO.BalanceDto;
import cinimex.services.BalanceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
@AllArgsConstructor
public class BalanceController {
    private final BalanceService balanceService;

    @PutMapping("lock")
    public boolean lockBalance(@RequestParam Long id) {
        return balanceService.lockBalance(id, true);
    }
    @PutMapping("unlock")
    public boolean unlockBalance(@RequestParam Long id) {
        return balanceService.lockBalance(id, false);
    }



    @GetMapping()
    public BalanceDto getBalanceByIdUser(@RequestParam Long idUser) throws Exception {
        return balanceService.getBalanceByIdUser(idUser);
    }
}

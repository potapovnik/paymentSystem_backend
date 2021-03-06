package cinimex.enums;

import java.util.Arrays;

public enum  OperationType {
    BALANCE_TO_BALANCE(1L),
    TRANSFER_FROM_CARD(2L),
    TRANSFER_TO_CARD(3L),
    PAYMENT_FROM_BALANCE_TO_BALANCE(4L),
    PAYMENT_FROM_CARD_TO_BALANCE(5L),
    PAYMENT_FROM_CARD_AND_BALANCE_TO_BALANCE(6L);
    private final Long id;

    OperationType(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static OperationType byId(Long id) {
        return Arrays.stream(OperationType.values())
                .filter(operation -> operation.id.equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Не существует операции с id = " + id));
    }
}

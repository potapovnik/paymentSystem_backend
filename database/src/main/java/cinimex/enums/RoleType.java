package cinimex.enums;

import java.util.Arrays;

public enum RoleType {
    ADMIN(1L),
    USER(2L);
    private final Long id;

    RoleType(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public static RoleType byId(Long id) {
        return Arrays.stream(RoleType.values())
                .filter(role -> role.id.equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Не существует роли с id = " + id));
    }
}

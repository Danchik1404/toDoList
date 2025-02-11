package todolist.project.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {

    ADMIN("Администратор"),
    MANAGER("Манаджер"),
    USER("Пользователь"),
    ANON("Ждет потверждения");

    private final String role;
}

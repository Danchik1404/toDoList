package todolist.project.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TaskStatus {

    NOT_STARTED("Не начато"),
    IN_PROGRESS("В процессе"),
    COMPLETED("Завершено");

    private final String status;
}

package todolist.project.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExceptionMessage {

    USER_NOT_FOUND("Пользователь не найден"),
    PROJECT_NOT_FOUND("Проект не найден"),
    TASK_NOT_FOUND("Проект не найден"),
    TASK_COMMENT_NOT_FOUND("Комментарии не найдены");

    private final String message;
}

package ru.university.journal;

public record Student(
        Long id,
        String fullName,
        String groupName
) {
    public Student {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(
                    "ID должен быть положительным"
            );
        }

        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException(
                    "ФИО не может быть пустым"
            );
        }

        if (groupName == null || groupName.isBlank()) {
            throw new IllegalArgumentException(
                    "Группа не может быть пустой"
            );
        }
    }
}

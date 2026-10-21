package edu.estudoapi.demo.service.validate;

public class ValidateInput {

    public static boolean validateTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                "O título é obrigatório"
            );
        }
        if (title.length() > 100) {
            throw new IllegalArgumentException(
                "O título não pode ter mais de 100 caracteres"
            );
        }
        if (title.contains("gaster")) {
            throw new IllegalArgumentException(
                "Dark, dark, still darker..."
            );
        }
        return true;
    }
}
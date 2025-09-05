package com.example.demo.exception;

import java.util.List;
import lombok.Data;

@Data
public class ErrorMessage {
    private List<String> messages; // comienza con minúscula
}

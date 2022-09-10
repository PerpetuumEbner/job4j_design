package ru.job4j.lambok;

import lombok.*;

import java.util.List;

@Builder(builderMethodName = "of")
@ToString
@Getter
public class Permission {
    private int id;

    private String name;

    @Singular("rules")
    private List<String> rules;
}
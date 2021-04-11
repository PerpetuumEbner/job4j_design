package ru.job4j.lsp;

class Data {
    public String loading(String text) {
        return text;
    }
}

class Repository extends Data {
    public String loading(String text) {
        return null;
    }
}
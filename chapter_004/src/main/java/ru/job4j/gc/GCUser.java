package ru.job4j.gc;

public class GCUser {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long userMemory = totalMemory - freeMemory;
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Size: %d%n", userMemory / MB);
    }

    public static void main(String[] args) {
        info();
        for (int index = 0; index < 10000; index++) {
            new User("Name" + index, index);
        }
        info();
    }
}
package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte b = 127;
        short s = 32767;
        char c = 'c';
        int i = 0;
        long l = 9223372036854775807L;
        float f = 3.4e+38f;
        double d = 1.7e+308;
        boolean boo = true;

        LOG.debug("Output of variables: "
                        + System.lineSeparator() + "byte - {}"
                        + System.lineSeparator() + "short - {}"
                        + System.lineSeparator() + "char - {}"
                        + System.lineSeparator() + "int - {}"
                        + System.lineSeparator() + "long - {}"
                        + System.lineSeparator() + "float - {}"
                        + System.lineSeparator() + "double - {}"
                        + System.lineSeparator() + "boolean - {}",
                b, s, c, i, l, f, d, boo);
    }
}
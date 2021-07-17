package ru.job4j.io.cmd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ShellTest {

    @Test
    public void whenCdBack() {
        Shell shell = new Shell();
        String[] path1 = "/user".split("/");
        String[] path2 = "../root".split("/");
        shell.cd(path1);
        shell.cd(path2);
        assertThat(
                shell.pwd(), is("/root")
        );
    }

    @Test
    public void whenAbsolutePath() {
        Shell shell = new Shell();
        String[] path1 = "/path/to/file".split("/");
        String[] path2 = "/new/path/to/my/file".split("/");
        shell.cd(path1);
        shell.cd(path2);
        assertThat(shell.pwd(), is("/new/path/to/my/file"));
    }

    @Test
    public void whenCdRoot() {
        Shell shell = new Shell();
        String[] path = new String[1];
        path[0] = "/";
        shell.cd(path);
        assertThat(
                shell.pwd(), is("/")
        );
    }

    @Test
    public void whenCdUserLocal() {
        Shell shell = new Shell();
        String[] pat1 = new String[1];
        String[] pat2 = new String[1];
        pat1[0] = "user";
        pat2[0] = "local";
        shell.cd(pat1);
        shell.cd(pat2);
        assertThat(
                shell.pwd(), is("/user/local")
        );
    }

    @Test
    public void whenCdUserBack() {
        Shell shell = new Shell();
        String[] pat1 = new String[1];
        String[] pat2 = new String[1];
        pat1[0] = "user";
        pat2[0] = "..";
        shell.cd(pat1);
        shell.cd(pat2);
        assertThat(
                shell.pwd(), is("/")
        );
    }
}
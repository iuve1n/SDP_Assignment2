package com.aitu.sdp;

import com.aitu.sdp.startup.ConsoleLauncher;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new ConsoleLauncher(scanner).start();
        }
    }
}

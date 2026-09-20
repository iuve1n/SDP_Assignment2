package com.aitu.sdp.startup;

import com.aitu.sdp.app.DeliveryApplication;
import com.aitu.sdp.logistics.Logistics;
import com.aitu.sdp.logistics.RoadLogistics;
import com.aitu.sdp.logistics.SeaLogistics;
import com.aitu.sdp.ui.GUIFactory;
import com.aitu.sdp.ui.macos.MacOSFactory;
import com.aitu.sdp.ui.windows.WindowsFactory;
import java.util.Scanner;

public class ConsoleLauncher {

    private static final String ROAD = "ROAD";
    private static final String SEA = "SEA";
    private static final String WINDOWS = "WINDOWS";
    private static final String MACOS = "MACOS";

    private static final String CARGO = "laboratory equipment";
    private static final String DESTINATION = "Aktau warehouse";

    private final Scanner scanner;

    public ConsoleLauncher(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        String mode = askForValue("Choose delivery mode (ROAD or SEA): ");
        String platform = askForValue("Choose platform (WINDOWS or MACOS): ");

        if (!isSupportedMode(mode)) {
            System.out.println("Unsupported delivery mode. Please start again and enter ROAD or SEA.");
            return;
        }
        if (!isSupportedPlatform(platform)) {
            System.out.println("Unsupported platform. Please start again and enter WINDOWS or MACOS.");
            return;
        }

        DeliveryApplication application =
                new DeliveryApplication(createGuiFactory(platform), createLogistics(mode));
        application.run(CARGO, DESTINATION);
    }

    private String askForValue(String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            System.out.println();
            return "";
        }
        return scanner.nextLine().trim().toUpperCase();
    }

    private boolean isSupportedMode(String mode) {
        return ROAD.equals(mode) || SEA.equals(mode);
    }

    private boolean isSupportedPlatform(String platform) {
        return WINDOWS.equals(platform) || MACOS.equals(platform);
    }

    private Logistics createLogistics(String mode) {
        switch (mode) {
            case ROAD:
                return new RoadLogistics();
            case SEA:
                return new SeaLogistics();
            default:
                throw new IllegalArgumentException("Unsupported delivery mode: " + mode);
        }
    }

    private GUIFactory createGuiFactory(String platform) {
        switch (platform) {
            case WINDOWS:
                return new WindowsFactory();
            case MACOS:
                return new MacOSFactory();
            default:
                throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
    }
}

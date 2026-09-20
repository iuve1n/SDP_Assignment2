package com.aitu.sdp.ui.macos;

import com.aitu.sdp.ui.Checkbox;

public class MacOSCheckbox implements Checkbox {

    @Override
    public void paint() {
        System.out.println("UI: rendering a macOS style checkbox.");
    }
}

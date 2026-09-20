package com.aitu.sdp.ui.macos;

import com.aitu.sdp.ui.Button;

public class MacOSButton implements Button {

    @Override
    public void paint() {
        System.out.println("UI: rendering a macOS style button.");
    }
}

package com.aitu.sdp.ui.windows;

import com.aitu.sdp.ui.Button;

public class WindowsButton implements Button {

    @Override
    public void paint() {
        System.out.println("UI: rendering a Windows style button.");
    }
}

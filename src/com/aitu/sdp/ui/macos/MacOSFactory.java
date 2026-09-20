package com.aitu.sdp.ui.macos;

import com.aitu.sdp.ui.Button;
import com.aitu.sdp.ui.Checkbox;
import com.aitu.sdp.ui.GUIFactory;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

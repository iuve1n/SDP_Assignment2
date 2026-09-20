package com.aitu.sdp.ui.windows;

import com.aitu.sdp.ui.Button;
import com.aitu.sdp.ui.Checkbox;
import com.aitu.sdp.ui.GUIFactory;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

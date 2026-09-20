package com.aitu.sdp.app;

import com.aitu.sdp.logistics.Logistics;
import com.aitu.sdp.ui.Button;
import com.aitu.sdp.ui.Checkbox;
import com.aitu.sdp.ui.GUIFactory;

public class DeliveryApplication {

    private final GUIFactory guiFactory;
    private final Logistics logistics;

    public DeliveryApplication(GUIFactory guiFactory, Logistics logistics) {
        this.guiFactory = guiFactory;
        this.logistics = logistics;
    }

    public void run(String cargo, String destination) {
        renderUserInterface();
        logistics.planDelivery(cargo, destination);
    }

    private void renderUserInterface() {
        Button button = guiFactory.createButton();
        Checkbox checkbox = guiFactory.createCheckbox();
        button.paint();
        checkbox.paint();
    }
}

package hu.modeldriven.cameo.action;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.ui.browser.actions.DefaultBrowserAction;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BrowserAction extends DefaultBrowserAction {

    public BrowserAction(String id, String name) {
        super(id, name, null, null);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        var project = Application.getInstance().getProject();
        var activeDiagram = project.getActiveDiagram();

        var result = new StringBuffer();

        for (var selectedElement : activeDiagram.getSelected()) {

            var modelElement = selectedElement.getElement();

            if (modelElement instanceof Class) {
                var umlClass = (Class) modelElement;

                result.append(umlClass.getName());
                result.append("\n");

                for (var attribute : umlClass.getOwnedAttribute()) {
                    result.append(attribute.getName());
                    result.append(" : ");
                    result.append(attribute.getType().getName());
                    result.append("\n");
                }
            }
        }

        JOptionPane.showMessageDialog(null,
                result.toString());

        try {
            Files.writeString(new File("C:/home/test.txt").toPath(), result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

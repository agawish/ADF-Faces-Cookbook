package com.adffaces.chapter7.view.beans;

import java.util.Arrays;

import javax.faces.component.UIComponent;

import oracle.adf.view.rich.datatransfer.DataFlavor;
import oracle.adf.view.rich.datatransfer.Transferable;
import oracle.adf.view.rich.dnd.DnDAction;
import oracle.adf.view.rich.event.DropEvent;

public class DragAndDropBean {
    public DragAndDropBean() {
    }
    
    public String[] getDrinks() {
        return new String[] { "Orange Juice", "Apple Juice", "Tomato Juice" };
    }

    public DnDAction handleDrop(DropEvent dropEvent) {
        Transferable dropTransferable = dropEvent.getTransferable();
        System.out.println(dropTransferable);
        Object[] drinks = dropTransferable.getData(DataFlavor.OBJECT_ARRAY_FLAVOR);
        if (drinks != null) {
            UIComponent dropComponent = dropEvent.getDropComponent();
            // Update the specified property of the drop component with the Object[] dropped
            dropComponent.getAttributes().put("text", Arrays.toString(drinks));
            return DnDAction.COPY;
        } else {
            return DnDAction.NONE;
        }
    }
}

package com.adffaces.chapter8.view.converters;

import java.util.Collection;
import java.util.Collections;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.apache.myfaces.trinidad.convert.ClientConverter;

public class XmlConverter extends ClobConverter implements ClientConverter {
    public XmlConverter() {
        super();
    }

    @Override
    public String getClientLibrarySource(FacesContext facesContext) {
        return facesContext.getExternalContext().getRequestContextPath() + "/resources/js/XmlConverter.js";
    }

    @Override
    public Collection<String> getClientImportNames() {
        // TODO Implement this method
        return Collections.emptySet();
    }

    @Override
    public String getClientScript(FacesContext facesContext, UIComponent uIComponent) {
        // TODO Implement this method
        return null;
    }

    @Override
    public String getClientConversion(FacesContext facesContext, UIComponent uIComponent) {
        return "new XmlConverter()";
    }
}

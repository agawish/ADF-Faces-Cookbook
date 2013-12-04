
package com.adffacescookbook.chapter4.view.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class FileUploadConverter implements Converter {
    public FileUploadConverter() {
        super();
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null) {
            return null;
        }

        try {
            UploadedFile file = (UploadedFile)facesContext.getExternalContext().getRequestMap().get(string);
            System.out.println(file.getFilename() + " that will be saved");
            //Save the file physically in here
            return file.getFilename();
        } catch (Exception ex) {
            final String message =
                String.format("Unable to convert String value \"%s\" into a UploadedFile", string);
            throw new ConverterException(message, ex);
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object instanceof UploadedFile) {
            UploadedFile file = (UploadedFile) object;
            return file.getFilename();
        }

        return object.toString();
    }
}

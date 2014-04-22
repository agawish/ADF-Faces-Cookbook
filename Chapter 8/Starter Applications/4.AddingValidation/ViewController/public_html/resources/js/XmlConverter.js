//Acts as a constructor
function XmlConverter() {}
//Tells that XmlConverter extends the TrConverter
XmlConverter.prototype = new TrConverter();

//Implements the getAsString function just like server side
XmlConverter.prototype.getAsString = function (value, label) {
    return value;
}
//Implements the getAsObject function just like server side
XmlConverter.prototype.getAsObject = function (value, label) {
    if (!value) {return null;} //Sanity Check
    try {
        var parser = new DOMParser();
        var xmlDoc = parser.parseFromString(value, "application/xml");
        if (xmlDoc.getElementsByTagName("parsererror").length > 0) {
            sendError(label);
        }
        return value;
    }
    catch (err) { sendError(label);}
}

function sendError(label) {
    var fm = new TrFacesMessage("Convertion Error", label + " is not in XML format", TrFacesMessage.SEVERITY_ERROR);
    throw new TrConverterException(fm);
}
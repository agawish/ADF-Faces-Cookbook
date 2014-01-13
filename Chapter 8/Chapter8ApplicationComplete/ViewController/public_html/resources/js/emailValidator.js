function EmailValidator(field) {
    this.firstNameField = field;
}
EmailValidator.prototype = new TrValidator();
EmailValidator.prototype.validate = function (value, label, converter) {
    var compareAgainst = AdfPage.PAGE.findComponent(this.firstNameField);
    if (value.indexOf(compareAgainst.getValue().toUpperCase().charAt(0)) != 0) {
        var fm = new TrFacesMessage("Validation Error", "Email address should start with First Letter of the First Name", TrFacesMessage.SEVERITY_ERROR);
        throw new TrValidatorException(fm);
    }

}
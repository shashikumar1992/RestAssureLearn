package pojoClass;

import java.util.List;

public class ConsumerInfo {

    private String emailAddress;
    private String firstName;
    private String lastName;
    private String pin;
    private String partnerId;
    private String mobilePhoneNumber;
    private List<String> consumerDefinedFields;

    // Getters and Setters

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public List<String> getConsumerDefinedFields() {
        return consumerDefinedFields;
    }

    public void setConsumerDefinedFields(List<String> consumerDefinedFields) {
        this.consumerDefinedFields = consumerDefinedFields;
    }
}

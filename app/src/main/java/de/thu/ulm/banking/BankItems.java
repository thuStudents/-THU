package de.thu;

public class BankItems {

    String bank_name, bank_phone, bank_email, bank_address;
    int bank_logo;
    boolean expanded;

    public BankItems(String bank_name, String bank_phone, String bank_email, String bank_address, int bank_logo) {
        this.bank_name = bank_name;
        this.bank_phone = bank_phone;
        this.bank_email = bank_email;
        this.bank_logo = bank_logo;
        this.bank_address = bank_address;
        this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_phone() {
        return bank_phone;
    }

    public void setBank_phone(String bank_phone) {
        this.bank_phone = bank_phone;
    }

    public String getBank_email() {
        return bank_email;
    }

    public void setBank_email(String bank_email) {
        this.bank_email = bank_email;
    }

    public String getBank_address() {
        return bank_address;
    }

    public void setBank_address(String bank_address) {
        this.bank_address = bank_address;
    }

    public int getBank_logo() {
        return bank_logo;
    }

    public void setBank_logo(int bank_logo) {
        this.bank_logo = bank_logo;
    }

    @Override
    public String toString() {
        return "BankItems{" +
                "bank_name='" + bank_name + '\'' +
                ", bank_phone='" + bank_phone + '\'' +
                ", bank_email='" + bank_email + '\'' +
                ", bank_address='" + bank_address + '\'' +
                ", bank_logo=" + bank_logo +
                '}';
    }
}

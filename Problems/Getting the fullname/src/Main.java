class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if(firstName != null) {
            this.firstName = firstName;
        } else {
            this.firstName = "";
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null) {
            this.lastName = lastName;
        } else {
            this.lastName = "";
        }
    }

    public String getFullName() {
        if((firstName == null || firstName.isEmpty() ) && (lastName == null || lastName.isEmpty())) {
            return "Unknown";
        } else if (firstName == null || firstName.isEmpty()) {
            return lastName;
        } else if (lastName == null || lastName.isEmpty()) {
            return firstName;
        } else {
            return firstName.concat(" " + lastName);
        }
    }
}
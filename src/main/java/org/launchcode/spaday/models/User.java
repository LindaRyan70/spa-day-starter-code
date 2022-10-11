package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

    @NotNull
    @NotBlank(message = "Username is required.")
    @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters long.")
    private String username;

    @NotNull
    @Email(message = "Please provide a valid email address.")
    private String email;

    @NotNull
    @NotBlank(message = "Password is required.")
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    private String password;

    @NotNull(message = "Passwords do not match.")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword(password);  // This seems to work with no parameter in the 2 password setters and the method below! //
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword(password);   // This seems to work with no parameter in the 2 password setters and the method below! //
    }


    private void checkPassword(String password) {   // This seems to work with no parameter here and in the 2 password setters above! //
        if (this.password != null && this.verifyPassword != null && !this.password.equals(this.verifyPassword)) {
            this.verifyPassword = null;
        }
    }
}

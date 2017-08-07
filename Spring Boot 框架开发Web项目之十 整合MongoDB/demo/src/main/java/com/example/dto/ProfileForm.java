package com.example.dto;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Document(collection = "profile")
public class ProfileForm {
    @Id
    private String id;

    @Size(min = 2)
    private String twitterHandle;

    @Email
    @NotNull
    private String email;

    @NotNull
    private LocalDate birthDate;

    public ProfileForm() {
    }

    public ProfileForm(String id, String twitterHandle, String email, LocalDate birthDate) {
        this.id = id;
        this.twitterHandle = twitterHandle;
        this.email = email;
        this.birthDate = birthDate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "ProfileForm{" +
                "id=" + id +
                ", twitterHandle='" + twitterHandle + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

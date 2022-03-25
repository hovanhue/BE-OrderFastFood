package com.example.hue.common.request;

import com.example.hue.common.enums.SocialProvider;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private SocialProvider socialProvider;

    public SignupRequest(@NotBlank @Size(min = 3, max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
                         @NotBlank @Size(min = 6, max = 40) String password, SocialProvider socialProvider) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.socialProvider = socialProvider;
    }

    public SocialProvider getSocialProvider() {
        return socialProvider;
    }

    public void setSocialProvider(SocialProvider socialProvider) {
        this.socialProvider = socialProvider;
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

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String email;
        private String username;
        private String password;
        private SocialProvider socialProvider;


        public Builder addEmail(final String email) {
            this.email = email;
            return this;
        }
        public Builder addUsername(final String username) {
            this.username = username;
            return this;
        }

        public Builder addPassword(final String password) {
            this.password = password;
            return this;
        }

        public Builder addSocialProvider(final SocialProvider socialProvider) {
            this.socialProvider = socialProvider;
            return this;
        }

        public SignupRequest build() {
            return new SignupRequest(username, email, password, socialProvider);
        }
    }

}

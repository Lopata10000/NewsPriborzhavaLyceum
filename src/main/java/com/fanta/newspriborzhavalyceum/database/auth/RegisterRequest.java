package com.fanta.newspriborzhavalyceum.database.auth;

import com.fanta.newspriborzhavalyceum.database.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String name;
  private String email;
  private String password;
  private String dateOfBirth;
  private Role role;
}

package com.example.authenticator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRoleModel {

    private Long id;

    private Long userId;

    private Long roleId;

}

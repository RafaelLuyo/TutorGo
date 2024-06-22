package com.platform.tutorgo.security.domain.model.entities;

import com.platform.tutorgo.security.domain.model.valueobjects.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@With
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles name;

    public Role(Roles name) {
        this.name = name;
    }

    public static Role getDefaultRole() {
        return new Role(Roles.ROLE_USER);
    }

    public String getStringName() {
        return name.name();
    }

    public static Role toRoleFromName(String name){
        return new Role(Roles.valueOf(name));
    }

    public static List<Role> validateRoleSet(List<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return List.of(getDefaultRole());
        }
        return roles;
    }
}

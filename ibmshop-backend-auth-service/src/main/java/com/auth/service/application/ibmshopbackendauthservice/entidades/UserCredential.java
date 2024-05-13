package com.auth.service.application.ibmshopbackendauthservice.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.lang.model.element.Name;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_user_credential")
@SequenceGenerator(name="tb_user_credential",sequenceName = "sq_users_credentials",allocationSize = 1)
public class UserCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_user_credential")
    @Column(name = "id_user_credential", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private Role role;
    @Column(nullable = false)
    private boolean ativo;

}

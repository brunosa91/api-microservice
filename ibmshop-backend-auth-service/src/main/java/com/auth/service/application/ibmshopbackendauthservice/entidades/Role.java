package com.auth.service.application.ibmshopbackendauthservice.entidades;


import jakarta.ws.rs.HttpMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;


@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    ADMIN(Map.of(org.springframework.http.HttpMethod.GET, Set.of("/**"), org.springframework.http.HttpMethod.POST,
            Set.of("/**"), org.springframework.http.HttpMethod.PUT, Set.of("/**"),
            org.springframework.http.HttpMethod.DELETE, Set.of("/**"), org.springframework.http.HttpMethod.PATCH,
            Set.of("/**"))),
    USER(Map.of(org.springframework.http.HttpMethod.GET, Set.of("/user/{id}", "/product/**","/address/**",
                    "/address/{id}",
                    "/address/user/{id}",
                    "/pedidos/**"), org.springframework.http.HttpMethod.POST,
            Set.of("/address/**", "/pedidos/**"),
            org.springframework.http.HttpMethod.PUT,
            Set.of("/user/**", "/address/**"),
            org.springframework.http.HttpMethod.PATCH, Set.of("/user/**", "/auth/**"),
            org.springframework.http.HttpMethod.DELETE,
            Set.of("/user/{id}", "/address/{id}", "/pedidos/**"))),
    ANONYMOUS(Map.of(org.springframework.http.HttpMethod.GET, Set.of("/product/**"),
            org.springframework.http.HttpMethod.POST, Set.of("/user/**", "/auth/**")));
    private final Map<org.springframework.http.HttpMethod, Set<String>> permissions;
    public static Role getRole(String name) {
        return Stream.of(values()).filter(r ->
                r.name().equalsIgnoreCase(name)).findFirst().orElseGet(() -> ANONYMOUS);
    }
    public Set<String> getPermissions(org.springframework.http.HttpMethod method) {
        return permissions.getOrDefault(method, Collections.emptySet());
    }

    @Override
    public String getAuthority() {
        return null;
    }
}

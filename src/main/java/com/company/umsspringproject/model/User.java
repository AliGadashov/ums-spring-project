package com.company.umsspringproject.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    long id;
    String name;
    String surname;
    String age;
    @Builder.Default
    Boolean isActive = true;
    String role;
}

package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Entity //Tells this is an entity - a table need to be created for this class
@Builder
@Data
public class User extends BaseModel{
        private String name;
        private String email;
        private String password;
}

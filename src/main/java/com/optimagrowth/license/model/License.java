package com.optimagrowth.license.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "licenses")
@NoArgsConstructor
@AllArgsConstructor
public class License extends RepresentationModel<License> { // RepresentationModel это для реализации HATEOAS

    @Id
    @Column(name = "license_id", nullable = false)
    private String licenseId;
    private String description;
    @Column(name = "organization_id", nullable = false)
    private String organizationId;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "license_type", nullable = false)
    private String licenseType;
    @Column(name = "comment")
    private String comment;
    @Transient
    private String organizationName;
    @Transient
    private String contactName;
    @Transient
    private String contactPhone;
    @Transient
    private String contactEmail;

    public License withComments(String comment) {
        this.setComment(comment);
        return this;
    }

}

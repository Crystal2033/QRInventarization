/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;

@MappedSuperclass
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractInventarizedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    @JdbcTypeCode(Types.VARBINARY)
    private byte[] image;

    @NotNull(message = "Inventory number can not be null")
    private String inventoryNumber;

    @NotNull(message = "Name can not be null")
    @NotBlank
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cabinet_id")
    private Cabinet cabinet;


//    @Column(name = "created", updatable = false)
//    private LocalDateTime created;
//
//    @Column(name = "updated", insertable = false)
//    private LocalDateTime updated;
//
//
//    @Column(name = "created", updatable = false)
//    public LocalDateTime getCreated() {
//        return created;
//    }
//
//    @Column(name = "updated", insertable = false)
//    public LocalDateTime getUpdated() {
//        return updated;
//    }
//
//    @PrePersist
//    public void toCreate() {
//        setCreated(LocalDateTime.now());
//    }
//
//    @PreUpdate
//    public void toUpdate() {
//        setUpdated(LocalDateTime.now());
//    }
}

package fr.quentin.portfolio.portfolioback.files;

import fr.quentin.portfolio.portfolioback.core.generic.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "files")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class File extends BaseEntity {
    @Lob
    private byte[] data;

    private String name;

    private String type;
}

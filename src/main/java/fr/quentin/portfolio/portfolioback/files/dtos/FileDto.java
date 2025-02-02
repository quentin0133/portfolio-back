package fr.quentin.portfolio.portfolioback.files.dtos;

import fr.quentin.portfolio.portfolioback.core.generic.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FileDto extends BaseDto {
    private String data;

    private String type;

    private String name;
}

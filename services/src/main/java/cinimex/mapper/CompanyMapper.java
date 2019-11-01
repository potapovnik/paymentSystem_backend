package cinimex.mapper;


import cinimex.DTO.CompanyDto;
import cinimex.entity.CompanyEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyEntity fromDto(CompanyDto balanceDto);

    CompanyDto toDto(CompanyEntity balanceEntity);

    List<CompanyEntity> fromDto(List<CompanyDto> balanceDtos);

    List<CompanyDto> toDto(List<CompanyEntity> balanceEntities);
}

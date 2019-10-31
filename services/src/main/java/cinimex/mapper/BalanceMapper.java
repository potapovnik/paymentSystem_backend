package cinimex.mapper;


import cinimex.DTO.BalanceDto;
import cinimex.entity.BalanceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BalanceMapper {

    BalanceEntity fromDto(BalanceDto balanceDto);

    BalanceDto toDto(BalanceEntity balanceEntity);

    List<BalanceEntity> fromDto(List<BalanceDto> balanceDtos);

    List<BalanceDto> toDto(List<BalanceEntity> balanceEntities);
}

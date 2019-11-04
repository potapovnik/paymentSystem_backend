package cinimex.mapper;


import cinimex.DTO.PaymentUserDto;
import cinimex.entity.PaymentUserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentUserMapper {

    PaymentUserEntity fromDto(PaymentUserDto paymentUserDto);

    PaymentUserDto toDto(PaymentUserEntity paymentUserEntity);

    List<PaymentUserEntity> fromDto(List<PaymentUserDto> paymentUserDtos);

    List<PaymentUserDto> toDto(List<PaymentUserEntity> paymentUserEntities);
}

package cinimex.mapper;


import cinimex.DTO.PaymentCompanyDto;
import cinimex.entity.PaymentCompanyEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentCompanyMapper {

    PaymentCompanyEntity fromDto(PaymentCompanyDto paymentCompanyDto);

    PaymentCompanyDto toDto(PaymentCompanyEntity paymentCompanyEntity);

    List<PaymentCompanyEntity> fromDto(List<PaymentCompanyDto> paymentCompanyDtos);

    List<PaymentCompanyDto> toDto(List<PaymentCompanyEntity> paymentCompanyEntities);
}

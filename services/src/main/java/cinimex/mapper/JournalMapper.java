package cinimex.mapper;

import cinimex.DTO.JournalDto;
import cinimex.entity.JournalEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JournalMapper {

    JournalEntity fromDto(JournalDto journalDto);

    JournalDto toDto(JournalEntity journalEntity);

    List<JournalEntity> fromDto(List<JournalDto> journalDtos);

    List<JournalDto> toDto(List<JournalEntity> journalEntities);
}

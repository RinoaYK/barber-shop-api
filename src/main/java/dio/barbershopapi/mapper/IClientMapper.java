package dio.barbershopapi.mapper;

import dio.barbershopapi.controller.request.SaveClientRequest;
import dio.barbershopapi.controller.request.UpdateClientRequest;
import dio.barbershopapi.controller.response.ClientDetailResponse;
import dio.barbershopapi.controller.response.ListClientResponse;
import dio.barbershopapi.controller.response.SaveClientResponse;
import dio.barbershopapi.controller.response.UpdateClientResponse;
import dio.barbershopapi.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final long id, final UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);

}

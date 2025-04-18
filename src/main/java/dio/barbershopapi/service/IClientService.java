package dio.barbershopapi.service;

import dio.barbershopapi.entity.ClientEntity;

public interface IClientService {

    ClientEntity save(final ClientEntity entity);
    ClientEntity update(final ClientEntity entity);
    void delete(final long id);
}

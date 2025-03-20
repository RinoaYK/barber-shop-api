package dio.barbershopapi.service.query.impl;

import dio.barbershopapi.entity.ClientEntity;
import dio.barbershopapi.exception.NotFoundException;
import dio.barbershopapi.exception.PhoneInUseException;
import dio.barbershopapi.repository.IClientRepository;
import dio.barbershopapi.service.query.IClientQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import org.springframework.data.domain.Sort;

@Service
@AllArgsConstructor
public class ClientQueryService implements IClientQueryService {

    private final IClientRepository repository;

    @Override
    public ClientEntity findById(final long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Não foi encontrado o cliente de id " + id)
        );
    }

    @Override
    public List<ClientEntity> list() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public void verifyPhone(final String phone) {
        if (repository.existsByPhone(phone)) {
            var message = "O telefone " + phone + " já está em uso";
            throw new PhoneInUseException(message);
        }
    }

    @Override
    public void verifyPhone(final long id, final String phone) {
        var optional = repository.findByPhone(phone);
        if (optional.isPresent() && !Objects.equals(optional.get().getPhone(), phone)) {
            var message = "O telefone " + phone + " já está em uso";
            throw new PhoneInUseException(message);
        }
    }

    @Override
    public void verifyEmail(final String email) {
        if (repository.existsByEmail(email)) {
            var message = "O e-mail " + email + " já está em uso";
            throw new PhoneInUseException(message);
        }
    }

    @Override
    public void verifyEmail(final long id, final String email) {
        var optional = repository.findByEmail(email);
        if (optional.isPresent() && !Objects.equals(optional.get().getEmail(), email)) {
            var message = "O e-mail " + email + " já está em uso";
            throw new PhoneInUseException(message);
        }
    }
}
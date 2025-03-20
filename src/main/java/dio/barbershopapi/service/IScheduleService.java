package dio.barbershopapi.service;

import dio.barbershopapi.entity.ScheduleEntity;

public interface IScheduleService {

    ScheduleEntity save(final ScheduleEntity entity);
    void delete(final long id);
}

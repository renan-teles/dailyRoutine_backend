package com.dailyroutine.dailyroutine.service.dailyroutine;

import com.dailyroutine.dailyroutine.exception.resource.ResourceNotFoundException;
import com.dailyroutine.dailyroutine.repository.DailyRoutineRepository;
import com.dailyroutine.dailyroutine.domain.valueobject.number.ID;
import com.dailyroutine.dailyroutine.service.ServiceInterface;

public class DeleteDailyRoutine implements ServiceInterface<Void> {
    private final DailyRoutineRepository repository;
    private final Integer id;

    public DeleteDailyRoutine(Integer id, DailyRoutineRepository repository){
        this.id = id;
        this.repository = repository;
    }

    @Override
    public Void execute() {
        ID.validate(this.id, false);

        if(!this.repository.existsById(id)){
            throw new ResourceNotFoundException("Não foi possível deletar. Rotina não encontrada.");
        }

        this.repository.deleteById(id);
        return null;
    }
}

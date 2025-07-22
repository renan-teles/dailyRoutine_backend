package com.dailyroutine.dailyroutine.domain.valueobject.number;

import com.dailyroutine.dailyroutine.domain.valueobject.ValueObject;

public abstract class PositiveInteger extends ValueObject<Integer> {
    protected boolean considerZero;

    public PositiveInteger(Integer value){
        super(value);
        this.considerZero = false;
    }

    public PositiveInteger(Integer value, boolean considerZero){
        super(value);
        this.considerZero = considerZero;
    }

    public Integer getValue(){
        return super.getValue();
    }

    @Override
    protected abstract void internalValidate(Integer value);
}

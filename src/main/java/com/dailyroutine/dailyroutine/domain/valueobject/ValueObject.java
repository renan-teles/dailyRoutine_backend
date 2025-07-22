package com.dailyroutine.dailyroutine.domain.valueobject;

public abstract class ValueObject<T>{
    protected T value;

    public ValueObject(T value){
        this.internalValidate(value);
        this.value = value;
    }

    protected T getValue(){
        return this.value;
    }

    protected abstract void internalValidate(T value);
}

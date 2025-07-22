package com.dailyroutine.dailyroutine.domain.valueobject.number;

public class ID extends PositiveInteger{
    private static final String EXCEPTION_MESSAGE = "ID inválido.";

    public ID(Integer id){
        super(id);
    }

    public ID(Integer id, boolean considerZero){
        super(id, considerZero);
    }

    @Override
    protected void internalValidate(Integer value) {
        if(value < 0 && super.considerZero){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }

        if(value <= 0 && !super.considerZero){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public static void validate(Integer value, boolean considerZero){
        if(value < 0 && considerZero){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }

        if(value <= 0 && !considerZero){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
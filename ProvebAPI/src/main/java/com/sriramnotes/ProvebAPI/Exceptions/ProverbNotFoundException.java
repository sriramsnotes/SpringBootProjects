package com.sriramnotes.ProvebAPI.Exceptions;

public class ProverbNotFoundException extends RuntimeException{

    public ProverbNotFoundException(Long id) {
            super("Could not find proverb " + id);
        }
    }


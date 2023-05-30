package com.axpal.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public interface AxpalPkInterface<T> extends Serializable {
    @JsonIgnore
    T getUniqueValue();

}

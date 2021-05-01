package com.bluecc.api;

import com.bluecc.api.models.party.party.Person;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.ofbiz.service.GenericServiceException;

import java.util.Map;

public abstract class AbstractServiceAdapter implements ServiceProcessor {
    ObjectMapper mapper = new ObjectMapper();

    public AbstractServiceAdapter() {
        this.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    public <T extends OutputObject> ServiceResult<T> runSync(String serviceName, InputObject input) {
        Map<String, Object> map = mapper.convertValue(input, Map.class);

        Map<String, Object> result = this.runSyncImpl(serviceName, map);
        TypeReference<T> ref = new TypeReference<T>() {
        };
        T p = mapper.convertValue(result, ref);
        return new ServiceResult<T>(p);

    }

    public abstract Map<String, Object> runSyncImpl(
            String serviceName, Map<String, ? extends Object> context);
}


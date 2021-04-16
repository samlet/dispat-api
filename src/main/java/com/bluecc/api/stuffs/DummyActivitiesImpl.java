package com.bluecc.api.stuffs;

import com.bluecc.api.ActivitiesImplBase;
import com.bluecc.api.InputObject;
import com.bluecc.api.ServiceProcessor;
import com.bluecc.api.ServiceResult;

public class DummyActivitiesImpl extends ActivitiesImplBase implements DummyActivities{
    public DummyActivitiesImpl(ServiceProcessor processor) {
        super(processor);
    }

    @Override
    public ServiceResult<SimpleResp> simpleReq(SimpleInput input) {
        return this.processor.runSync("test", input);
    }
}

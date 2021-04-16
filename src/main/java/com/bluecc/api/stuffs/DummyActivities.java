package com.bluecc.api.stuffs;

import com.bluecc.api.ServiceResult;

public interface DummyActivities {
    ServiceResult<SimpleResp> simpleReq(SimpleInput input);
}

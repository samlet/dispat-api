package com.bluecc.api;

import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.JinjavaConfig;
import com.hubspot.jinjava.LegacyOverrides;
import org.junit.Before;

public abstract class BaseJinjavaTest {
  public Jinjava jinjava;

  @Before
  public void baseSetup() {
    jinjava =
      new Jinjava(
        JinjavaConfig
          .newBuilder()
          .withLegacyOverrides(
            LegacyOverrides.newBuilder().withUsePyishObjectMapper(true).build()
          )
          .build()
      );
  }
}

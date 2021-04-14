package com.bluecc.api;

import com.hubspot.jinjava.lib.filter.TitleFilter;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TitleFilterTest {

  @Test
  public void testTitleCase() {
    assertThat(new TitleFilter().filter("this is string", null))
      .isEqualTo("This Is String");
  }
}

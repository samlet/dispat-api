package com.bluecc.api;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;

public class TemplateTest extends BaseJinjavaTest {

    @Test
    public void itSlicesLists() throws Exception {
        Document dom = Jsoup.parseBodyFragment(
                jinjava.render(
                        Resources.toString(
                                Resources.getResource("filter/slice-filter.jinja"),
                                StandardCharsets.UTF_8
                        ),
                        ImmutableMap.of(
                                "items",
                                (Object) Lists.newArrayList("a", "b", "c", "d", "e", "f", "g")
                        )
                )
        );

        assertThat(dom.select(".columwrapper ul")).hasSize(3);
        assertThat(dom.select(".columwrapper .column-1 li")).hasSize(3);
        assertThat(dom.select(".columwrapper .column-2 li")).hasSize(3);
        assertThat(dom.select(".columwrapper .column-3 li")).hasSize(1);
    }
}

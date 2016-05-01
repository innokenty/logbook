package org.zalando.logbook;

/*
 * #%L
 * Logbook: Test
 * %%
 * Copyright (C) 2015 - 2016 Zalando SE
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ListMultimap;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;

public final class MockHttpMessageTest {

    private final MockHttpMessage unit = spy(MockHttpMessage.class);

    @Test
    public void shouldSelectNonEmptyMultimap() {
        final ImmutableListMultimap<Object, Object> expected = ImmutableListMultimap.of("foo", "bar");
        final ListMultimap<Object, Object> actual = unit.firstNonNullNorEmpty(expected, ImmutableListMultimap.of());
        assertThat(actual, is(expected));
    }

}
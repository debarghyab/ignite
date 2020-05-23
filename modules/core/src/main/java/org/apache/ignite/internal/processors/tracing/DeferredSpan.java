/*
 * Copyright 2019 GridGain Systems, Inc. and Contributors.
 *
 * Licensed under the GridGain Community Edition License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.gridgain.com/products/software/community-edition/gridgain-community-edition-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.tracing;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Encapsulates concept of a deferred-initialized span. It's used to overcome OpenCensus span implementation, that starts
 * span immediately after deserialization.
 */
public class DeferredSpan implements Span{
    /** */
    private byte[] serializedSpan;

    /**
     * Constructor.
     *
     * @param serializedSpan Serialized span bytes.
     */
    public DeferredSpan(byte[] serializedSpan) {
        this.serializedSpan = serializedSpan;
    }

    /**
     * @return Serialized span.
     */
    public byte[] serializedSpan() {
        return serializedSpan;
    }

    /** {@inheritDoc} */
    @Override public Span addTag(String tagName, String tagVal) {
        return this;
    }

    /** {@inheritDoc} */
    @Override public Span addTag(String tagName, long tagVal) {
        return this;
    }

    /** {@inheritDoc} */
    @Override public Span addLog(String logDesc) {
        return this;
    }

    /** {@inheritDoc} */
    @Override public Span addLog(String logDesc, Map<String, String> attrs) {
        return this;
    }

    /** {@inheritDoc} */
    @Override public Span setStatus(SpanStatus spanStatus) {
        return this;
    }

    /** {@inheritDoc} */
    @Override public Span end() {
        return this;
    }

    /** {@inheritDoc} */
    @Override public boolean isEnded() {
        return false;
    }

    /** {@inheritDoc} */
    @Override public SpanType type() {
        return null;
    }

    /** {@inheritDoc} */
    @Override public Set<Scope> includedScopes() {
        return Collections.emptySet();
    }

    /** {@inheritDoc} */
    @Override public boolean isChainable(Scope scope) {
        return false;
    }
}
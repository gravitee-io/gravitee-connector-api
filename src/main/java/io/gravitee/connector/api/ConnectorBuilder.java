/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.connector.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.gravitee.node.api.configuration.Configuration;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
public class ConnectorBuilder {

    private final ConnectorContext context;

    private final ObjectMapper mapper;

    private final Configuration configuration;

    public ConnectorBuilder(ConnectorContext context, ObjectMapper mapper, Configuration configuration) {
        this.context = context;
        this.mapper = mapper;
        this.configuration = configuration;
    }

    public ConnectorContext getContext() {
        return context;
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public static ConnectorBuilder.Builder create() {
        return new Builder();
    }

    public static class Builder {

        private ConnectorContext context;

        private ObjectMapper mapper;

        private Configuration configuration;

        private Builder() {}

        public Builder context(ConnectorContext context) {
            this.context = context;
            return this;
        }

        public Builder mapper(ObjectMapper mapper) {
            this.mapper = mapper;
            return this;
        }

        public Builder configuration(Configuration configuration) {
            this.configuration = configuration;
            return this;
        }

        public ConnectorBuilder build() {
            return new ConnectorBuilder(context, mapper, configuration);
        }
    }
}

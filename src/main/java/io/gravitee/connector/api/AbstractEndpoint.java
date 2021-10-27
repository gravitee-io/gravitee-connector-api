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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
public abstract class AbstractEndpoint implements Endpoint {

    @JsonProperty("type")
    private final String type;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("target")
    private String target;

    protected AbstractEndpoint(String type, String name, String target) {
        this.type = type;
        this.name = name;
        this.target = target;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String target() {
        return target;
    }

    public void target(String target) {
        this.target = target;
    }

    @Override
    public String type() {
        return type;
    }
}

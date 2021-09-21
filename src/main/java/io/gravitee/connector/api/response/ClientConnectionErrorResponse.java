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
package io.gravitee.connector.api.response;

import io.gravitee.common.http.HttpStatusCode;
import io.gravitee.gateway.api.processor.ProcessorFailure;
import java.util.Map;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
public class ClientConnectionErrorResponse extends StatusResponse implements ProcessorFailure {

    static final String GATEWAY_CLIENT_CONNECTION_ERROR = "GATEWAY_CLIENT_CONNECTION_ERROR";

    public ClientConnectionErrorResponse() {
        super(HttpStatusCode.BAD_GATEWAY_502);
    }

    @Override
    public boolean connected() {
        return false;
    }

    @Override
    public int statusCode() {
        return this.status();
    }

    @Override
    public String message() {
        return null;
    }

    @Override
    public String key() {
        return GATEWAY_CLIENT_CONNECTION_ERROR;
    }

    @Override
    public Map<String, Object> parameters() {
        return null;
    }

    @Override
    public String contentType() {
        return null;
    }
}

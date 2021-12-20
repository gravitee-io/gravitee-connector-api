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

import io.gravitee.common.http.HttpHeadersValues;
import io.gravitee.gateway.api.buffer.Buffer;
import io.gravitee.gateway.api.http.HttpHeaderNames;
import io.gravitee.gateway.api.http.HttpHeaders;
import io.gravitee.gateway.api.stream.ReadStream;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
public class StatusResponse extends AbstractResponse {

    private final HttpHeaders httpHeaders = HttpHeaders.create();

    private final int statusCode;
    private String reason;

    public StatusResponse(int statusCode) {
        this.statusCode = statusCode;
        this.reason = null;
        httpHeaders.set(HttpHeaderNames.CONNECTION, HttpHeadersValues.CONNECTION_CLOSE);
    }

    public StatusResponse(int statusCode, String reason) {
        this(statusCode);
        this.reason = reason;
        httpHeaders.set(HttpHeaderNames.CONNECTION, HttpHeadersValues.CONNECTION_CLOSE);
    }

    @Override
    public int status() {
        return statusCode;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public HttpHeaders headers() {
        return httpHeaders;
    }

    @Override
    public ReadStream<Buffer> resume() {
        endHandler.handle(null);
        return this;
    }

    @Override
    public boolean connected() {
        return false;
    }
}

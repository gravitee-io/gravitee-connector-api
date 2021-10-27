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

import io.gravitee.gateway.api.handler.Handler;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
public abstract class AbstractConnection implements Connection {

    protected Handler<Response> responseHandler;
    protected Handler<Void> cancelHandler;

    @Override
    public Connection responseHandler(Handler<Response> responseHandler) {
        this.responseHandler = responseHandler;
        return this;
    }

    @Override
    public Connection cancelHandler(Handler<Void> cancelHandler) {
        this.cancelHandler = cancelHandler;
        return null;
    }
}

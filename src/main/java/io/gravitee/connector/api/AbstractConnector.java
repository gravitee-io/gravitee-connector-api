/*
 * Copyright © 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.connector.api;

import io.gravitee.common.component.AbstractLifecycleComponent;
import io.gravitee.gateway.api.proxy.ProxyRequest;

/**
 * Abstract base implementation of the {@link Connector} interface.
 *
 * <p>This class provides a skeletal implementation of the {@link Connector} interface,
 * extending {@link AbstractLifecycleComponent} to support lifecycle management.
 * Concrete connector implementations should extend this class and implement the
 * {@link Connector#request(io.gravitee.gateway.api.ExecutionContext, ProxyRequest, io.gravitee.gateway.api.handler.Handler)}
 * method to handle proxy requests.</p>
 *
 * <p>By default, the lifecycle methods {@link #doStart()} and {@link #doStop()} are
 * no-op implementations. Subclasses can override these methods to perform initialization
 * and cleanup operations as needed.</p>
 *
 * @param <C> the type of connection this connector creates, must extend {@link Connection}
 * @param <R> the type of proxy request this connector handles, must extend {@link ProxyRequest}
 *
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
public abstract class AbstractConnector<C extends Connection, R extends ProxyRequest>
    extends AbstractLifecycleComponent<Connector<C, R>>
    implements Connector<C, R> {

    @Override
    protected void doStart() throws Exception {}

    @Override
    protected void doStop() throws Exception {}
}

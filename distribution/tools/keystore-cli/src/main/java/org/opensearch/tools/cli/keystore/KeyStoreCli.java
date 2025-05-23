/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.tools.cli.keystore;

import org.opensearch.cli.Terminal;
import org.opensearch.common.cli.LoggingAwareMultiCommand;

/**
 * A CLI tool for managing secrets in the OpenSearch keystore.
 */
public class KeyStoreCli extends LoggingAwareMultiCommand {

    private KeyStoreCli() {
        super("A tool for managing settings stored in the opensearch keystore");
        subcommands.put("create", new CreateKeyStoreCommand());
        subcommands.put("list", new ListKeyStoreCommand());
        subcommands.put("add", new AddStringKeyStoreCommand());
        subcommands.put("add-file", new AddFileKeyStoreCommand());
        subcommands.put("remove", new RemoveSettingKeyStoreCommand());
        subcommands.put("upgrade", new UpgradeKeyStoreCommand());
        subcommands.put("passwd", new ChangeKeyStorePasswordCommand());
        subcommands.put("has-passwd", new HasPasswordKeyStoreCommand());
    }

    /**
     * Main entry point for the OpenSearch Keystore CLI tool.
     *
     * @param args  CLI commands for managing secrets.
     * @throws Exception if an exception was encountered executing the command.
     */
    public static void main(String[] args) throws Exception {
        exit(new KeyStoreCli().main(args, Terminal.DEFAULT));
    }

}

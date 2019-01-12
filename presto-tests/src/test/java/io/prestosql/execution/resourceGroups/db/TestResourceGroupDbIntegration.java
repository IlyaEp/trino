/*
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
package io.prestosql.execution.resourceGroups.db;

import io.prestosql.tests.DistributedQueryRunner;
import org.testng.annotations.Test;

import static io.prestosql.execution.resourceGroups.TestResourceGroupIntegration.waitForGlobalResourceGroup;
import static io.prestosql.execution.resourceGroups.db.H2TestUtil.getSimpleQueryRunner;

public class TestResourceGroupDbIntegration
{
    @Test
    public void testMemoryFraction()
            throws Exception
    {
        try (DistributedQueryRunner queryRunner = getSimpleQueryRunner()) {
            queryRunner.execute("SELECT COUNT(*), clerk FROM orders GROUP BY clerk");
            waitForGlobalResourceGroup(queryRunner);
        }
    }
}

/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.tasks.persistence;

import java.util.Map;
import java.util.Optional;

import com.google.common.collect.ImmutableMap;
import org.terasology.persistence.typeHandling.PersistedData;
import org.terasology.persistence.typeHandling.PersistedDataMap;
import org.terasology.persistence.typeHandling.PersistedDataSerializer;
import org.terasology.persistence.typeHandling.RegisterTypeHandler;
import org.terasology.persistence.typeHandling.TypeHandler;
import org.terasology.tasks.TimeConstraintTask;

@RegisterTypeHandler
public class TimedTaskTypeHandler extends TypeHandler<TimeConstraintTask> {

    @Override
    public PersistedData serializeNonNull(TimeConstraintTask task, PersistedDataSerializer context) {
        Map<String, PersistedData> data = ImmutableMap.of(
                "targetTime", context.serialize(task.getTargetTime()));

        return context.serialize(ImmutableMap.of(
                "data", context.serialize(data),
                "id", context.serialize(task.getId())));
    }

    @Override
    public Optional<TimeConstraintTask> deserialize(PersistedData data) {
        PersistedDataMap root = data.getAsValueMap();
        String id = root.get("id").getAsString();
        PersistedDataMap taskData = root.get("data").getAsValueMap();
        return Optional.of(new TimeConstraintTask(id,
                taskData.get("targetTime").getAsFloat()));
    }

}

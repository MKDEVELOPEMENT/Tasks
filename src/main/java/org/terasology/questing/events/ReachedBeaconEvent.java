/*
 * Copyright 2013 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.questing.events;

import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.entitySystem.event.Event;
import org.terasology.network.FieldReplicateType;
import org.terasology.network.OwnerEvent;
import org.terasology.network.Replicate;

@OwnerEvent
public class ReachedBeaconEvent implements Event {
    private EntityRef beacon;
    private EntityRef instigator;

    public ReachedBeaconEvent() {

    }

    public ReachedBeaconEvent(EntityRef instagatorEntity, EntityRef beaconReached) {
        this.beacon = beaconReached;
        this.instigator = instagatorEntity;
    }

    public EntityRef getBeaconEntity() {
        return beacon;
    }

    public EntityRef getInstigatorEntity() {
        return instigator;
    }
}
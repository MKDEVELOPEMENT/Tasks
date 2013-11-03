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

package org.terasology.questing.systems;

import com.google.common.collect.Lists;
import org.terasology.engine.CoreRegistry;
import org.terasology.entitySystem.entity.EntityManager;
import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.entitySystem.event.ReceiveEvent;
import org.terasology.entitySystem.systems.*;
import org.terasology.logic.location.LocationComponent;
import org.terasology.logic.players.LocalPlayer;
import org.terasology.logic.players.PlayerFactory;
import org.terasology.physics.components.TriggerComponent;
import org.terasology.physics.events.CollideEvent;
import org.terasology.questing.components.QuestBeaconComponent;
import org.terasology.questing.events.ReachedBeaconEvent;

import javax.vecmath.Vector3f;
import java.util.List;

/**
 * This class is used for the quest beacons, to see where
 */
@RegisterSystem(RegisterMode.REMOTE_CLIENT)
public class QuestBeaconSystem implements ComponentSystem {

    @Override
    public void initialise() {}

    @Override
    public void shutdown() {}

    @ReceiveEvent(components = {TriggerComponent.class})
    public void onCollision(CollideEvent event, EntityRef entity) {
        if(entity.hasComponent(QuestBeaconComponent.class)) {
            event.getOtherEntity().send(new ReachedBeaconEvent(event.getOtherEntity(), entity)); //Send the event
        }
    }
}

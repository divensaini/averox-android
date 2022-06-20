/*
 * Copyright (c) 2022 New Vector Ltd
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

package im.vector.app.features.location.live

import androidx.lifecycle.asFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.matrix.android.sdk.api.session.Session
import org.matrix.android.sdk.api.session.getRoom
import org.matrix.android.sdk.api.session.room.model.livelocation.LiveLocationShareAggregatedSummary
import javax.inject.Inject

class GetLiveLocationShareSummariesUseCase @Inject constructor(
        private val session: Session,
) {

    fun execute(roomId: String, eventIds: List<String>): Flow<List<LiveLocationShareAggregatedSummary>> {
        return session.getRoom(roomId)
                ?.locationSharingService()
                ?.getLiveLocationShareSummaries(eventIds)
                ?.asFlow()
                ?: emptyFlow()
    }
}

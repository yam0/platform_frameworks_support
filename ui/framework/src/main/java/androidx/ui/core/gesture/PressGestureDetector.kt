/*
 * Copyright 2019 The Android Open Source Project
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

package androidx.ui.core.gesture

import androidx.ui.core.Position
import androidx.ui.core.PxPosition
import com.google.r4a.Children
import com.google.r4a.Composable
import com.google.r4a.composer

@Composable
fun PressGestureDetector(
    onPress: ((PxPosition) -> Unit)? = null,
    onRelease: (() -> Unit)? = null,
    onCancel: (() -> Unit)? = null,
    @Children children: () -> Unit
) {
    <PressIndicatorGestureDetector onStart=onPress onCancel>
        <PressReleasedGestureDetector onRelease consumeDownOnStart=false>
            <children />
        </PressReleasedGestureDetector>
    </PressIndicatorGestureDetector>
}
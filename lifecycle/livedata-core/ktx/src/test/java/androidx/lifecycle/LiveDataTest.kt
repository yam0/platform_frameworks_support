/*
 * Copyright 2018 The Android Open Source Project
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

package androidx.lifecycle

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test

@SmallTest
class LiveDataTest {

    @get:Rule
    val mInstantTaskExecutorRule = InstantTaskExecutorRule()

    @Test fun observe() {
        val lifecycleOwner = object : LifecycleOwner {
            private val registry = LifecycleRegistry(this)
            init {
                registry.handleLifecycleEvent(Lifecycle.Event.ON_START)
            }
            override fun getLifecycle() = registry
        }

        val liveData = MutableLiveData<String>()
        var value = ""
        liveData.observe(lifecycleOwner) { newValue ->
            value = newValue
        }

        liveData.value = "261"
        assertThat(value).isEqualTo("261")
    }
}

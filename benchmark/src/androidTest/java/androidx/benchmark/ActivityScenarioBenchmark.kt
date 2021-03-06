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

package androidx.benchmark

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.filters.LargeTest
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class ActivityScenarioBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    private lateinit var activityScenario: ActivityScenario<Activity>

    @Before
    fun setup() {
        activityScenario = ActivityScenario.launch(Activity::class.java)
    }

    @Test
    fun activityScenario() {
        activityScenario.onActivity {
            // isolation activity *not* on top
            assertFalse(IsolationActivity.singleton.get()!!.resumed)

            var i = 0
            benchmarkRule.measureRepeated {
                i++
            }
        }
    }
}

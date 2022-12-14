/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.neotica.dicoding2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.neotica.lazylist.data.model.PersonEntity
import com.neotica.dicoding2.ui.theme.MyTheme
import com.neotica.lazylist.ProfileScreen

class ProfileActivity : ComponentActivity() {

    private val puppy: PersonEntity by lazy {
        intent?.getSerializableExtra(PUPPY_ID) as PersonEntity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                ProfileScreen(puppy)
            }
        }
    }

    companion object {
        private const val PUPPY_ID = "puppy_id"
        fun newIntent(context: Context, personEntity: PersonEntity) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(PUPPY_ID, personEntity)
            }
    }
}


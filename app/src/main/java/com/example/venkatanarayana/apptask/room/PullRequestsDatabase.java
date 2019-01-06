/*
 * Copyright (C) 2017 The Android Open Source Project
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

package com.example.venkatanarayana.apptask.room;


import android.content.Context;

import com.example.venkatanarayana.apptask.model.PullRequest;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * The Room database that contains the Users table
 */
@Database(entities = {PullRequestEntity.class}, version = 2, exportSchema = false)
public abstract class PullRequestsDatabase extends RoomDatabase {

    private static volatile PullRequestsDatabase INSTANCE;

    public abstract PullRequestDao pullRequestDao();

    public static PullRequestsDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (PullRequestsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PullRequestsDatabase.class, "PullRequests.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
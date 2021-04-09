package com.pavel2309.mytodo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pavel2309.mytodo.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider


@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {


    abstract fun taskDao(): TaskDao

    class Callback @Inject constructor(
        private val database: Provider<TaskDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().taskDao()

            applicationScope.launch {
                dao.insert(Task("First simple task"))
                dao.insert(Task("Second simple task"))
                dao.insert(Task("Third simple task", important = true))
                dao.insert(Task("Fourth simple task", completed = true))
                dao.insert(Task("Fifth simple task", important = true))
                dao.insert(Task("Sixth simple task"))
            }

        }

    }
}
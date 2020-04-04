package com.test.pos.database

import android.content.Context
import android.view.View
import android.widget.EditText
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.test.pos.dao.RegisterDAO
import com.test.pos.entity.Register
import kotlinx.android.synthetic.main.layout_register.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Register::class), version = 1)

abstract class RegisterDatabase : RoomDatabase() {
    abstract fun registerDAO(): RegisterDAO

    companion object {
        private var INSTANCE: RegisterDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): RegisterDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RegisterDatabase::class.java,
                    "register_database"
                )
                    .addCallback(RegisterDatabaseCallback(scope))
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }

    private class RegisterDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)

            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.registerDAO())
                }
            }

        }

        suspend fun populateDatabase(registerDAO: RegisterDAO) {

            registerDAO.deleteAll()

        }
    }
}


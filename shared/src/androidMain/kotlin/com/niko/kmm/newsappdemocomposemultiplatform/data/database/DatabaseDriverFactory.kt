package com.niko.kmm.newsappdemocomposemultiplatform.data.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.niko.kmm.newsappdemocomposemultiplatform.data.database.NewsAppDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(NewsAppDatabase.Schema, context, "newsapp.db")
    }
}
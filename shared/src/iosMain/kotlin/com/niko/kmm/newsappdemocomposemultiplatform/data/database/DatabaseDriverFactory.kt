package com.niko.kmm.newsappdemocomposemultiplatform.data.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.niko.kmm.newsappdemocomposemultiplatform.data.database.NewsAppDatabase

actual class DatabaseDriverFactory{
   actual fun createDriver(): SqlDriver {
       return NativeSqliteDriver(NewsAppDatabase.Schema, "newsapp.db")
   }
}
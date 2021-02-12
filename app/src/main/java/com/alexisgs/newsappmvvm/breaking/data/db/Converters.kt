package com.alexisgs.newsappmvvm.breaking.data.db

import androidx.room.TypeConverter
import com.alexisgs.newsappmvvm.breaking.data.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}
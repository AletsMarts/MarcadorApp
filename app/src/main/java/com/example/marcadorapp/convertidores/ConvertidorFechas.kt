package com.example.marcadorapp.convertidores

import androidx.room.TypeConverter
import java.util.Date

class ConvertidorFechas {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}

package com.nhathuy.orderdogclient.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Period
import java.time.ZonedDateTime

data class Pet (
    val id:String,
    val name:String,
    val description:String,
    val imageUrl:String,
    val gender:Gender,
    val weigthKg:String,
    val breed:String,
    val location:String,
    val dateOfBirth:ZonedDateTime,
    val label:PetLabel
)
@RequiresApi(Build.VERSION_CODES.O)
fun ZonedDateTime.age():String{
    val period=Period.between(this.toLocalDate(),ZonedDateTime.now().toLocalDate())
    if(period.years>0){
        return period.years.toString()+" years"
    }
    return period.months.toString()+" months"
}
enum class PetLabel{
    Puppy,Adult
}
enum class Gender{
    Male,FeMale,NotSpecified
}
package com.example.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.DecimalFormat

@Parcelize

data class MyItem(val aIcon:Int, val aTitle:String, val aReason:String, val aNickname:String, val aPrice:String, val aAdress:String, var aLike:Int, val aReply:Int, var heart:Boolean) : Parcelable
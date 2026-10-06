package com.jayvijay.scottie.core.ui.xelauikit.models

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jayvijay.scottie.R

val fontFamily =
  FontFamily(
    Font(R.font.nunitosansextralight, FontWeight.ExtraLight),
    Font(R.font.nunitosanslight, FontWeight.Light),
    Font(R.font.nunitosansregular, FontWeight.Normal),
    Font(R.font.nunitosanssemibold, FontWeight.SemiBold),
    Font(R.font.nunitosansbold, FontWeight.Bold),
    Font(R.font.nunitosansextrabold, FontWeight.ExtraBold),
    Font(R.font.nunitosansblack, FontWeight.Black),
    Font(R.font.nunitosansextralightitalic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.nunitosanslightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.nunitosansitalic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.nunitosanssemibolditalic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.nunitosansbolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.nunitosansextrabolditalic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.nunitosansblackitalic, FontWeight.Black, FontStyle.Italic),
  )

val xelaTitle1 =
  TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 60.sp,
  )

val xelaTitle2 =
  TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 48.sp,
  )

val xelaTitle3 =
  TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Black,
    fontSize = 34.sp,
  )

val xelaHeadline =
  TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
  )

val xelaSubheadline =
  TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 18.sp,
  )

val xelaBody =
  TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
  )

val xelaBodyBold =
  TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
  )

val xelaSmallBody =
  TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
  )

val xelaSmallBodyBold =
  TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
  )

val xelaCaption =
  TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 12.sp,
  )

val xelaButtonLarge =
  TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
  )

val xelaButtonMedium =
  TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 14.sp,
  )

val xelaButtonSmall =
  TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
  )
